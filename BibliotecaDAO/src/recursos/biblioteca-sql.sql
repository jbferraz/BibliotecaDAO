create table clientes (
	matricula int primary key,
	nome varchar (60),
	telefone varchar(11));

create table livros (
	id serial primary key,
	isbn varchar(10) unique,
	nome varchar(60),
	autores varchar(60),
	editora varchar(60),
	ano int);

create table exemplares (
        id serial primary key,
        idLivro int References livros(id) on delete cascade,
        exemplares int check(exemplares>0),
        exempDisponiveis int check(exempDisponiveis>=0));

create table retiradas(
        idRet serial primary key,
        matricula int References clientes(matricula),
        dtRet date);

create table itensRet(
        idItensRet serial primary key,
        idLivro int References livros(id),
        idRet int References retiradas(idRet),
        qtd int check(qtd>0),
        status varchar(1));

create table devolucoes(
        idDev serial primary key,
        idItensRet int References itensRet(idItensRet),
        dtDev date,
        idLivro int References livros(id),
        qtd int check(qtd>0));

----Testes
select e.id,e.idlivro,e.exemplares,e.exempDisponiveis,l.isbn
    from exemplares e, livros l where e.idLivro=l.id;

select * from retiradas where idRet>=(select max(idRet) from retiradas);

select * from livros

select * from clientes 

select * from exemplares
drop table exemplares

select * from retiradas

select * from itensRet

select * from devolucoes

--retorna disp de livro
select exempDisponiveis from exemplares where idLivro=123321 and exempDisponiveis<=exemplares

--mostra itens de retiradas
select * from itensRet where idRet=1

--mostra itensRet
select * from itensRet as iR, retiradas as r, clientes as c where iR.idRet=r.idRet and r.matricula=c.matricula and c.matricula=123

--devolucoes
--valida devolucoes
select idItensRet, idLivro, itensRet.idRet as idRet, qtd, status from itensRet, retiradas, clientes 
    where itensRet.idRet=retiradas.idRet 
        and retiradas.matricula=clientes.matricula 
        and clientes.matricula=123 
        and itensRet.status='A'
        and itensRet.idLivro=1;

--::relatórios::--
--

select * from pg_tables where schemaname='public'

drop table itensret;
drop table devolucoes;
drop table exemplares;
drop table livros;
drop table retiradas;
drop table clientes;

----Inserts
insert into exemplares values
    (1,1,10,10),
    (2,2,10,10),
    (3,3,10,10),
    (4,4,10,10);

insert into retiradas values
    (1,123,'2015-11-12');

insert into itensRet values
    (1,1,1,2);

insert into devolucoes values
    (1,1,'2015-11-13',1,1);

insert into exemplares (idLivro,exemplares,exempDisponiveis) values ((select max(id) from livros),10,10);

----Function & Trigger
--trigger pra controle de retiradas nos exemplares
CREATE  or REPLACE FUNCTION itens_retiradas_gatilho() 
         RETURNS TRIGGER AS $itens_retiradas_gatilho$
    BEGIN
	IF (TG_OP = 'INSERT') THEN
		UPDATE exemplares set exempDisponiveis=(exempDisponiveis-NEW.qtd) where idLivro=NEW.idLivro;
		RETURN NEW;
	End if;
	IF (TG_OP = 'UPDATE') THEN
		UPDATE exemplares set exempDisponiveis=(exempDisponiveis-OLD.qtd+NEW.qtd) where idLivro=NEW.idLivro;
		RETURN NEW;
	end if;
	IF (TG_OP = 'DELETE') THEN
		UPDATE exemplares set exempDisponiveis=(exempDisponiveis+OLD.qtd) where idLivro=OLD.idLivro;
		RETURN OLD;
	END IF;
        RETURN NULL;
    END;
  $itens_retiradas_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER itens_retiradas_gatilho BEFORE INSERT OR UPDATE OR DELETE ON itensRet
    FOR EACH ROW EXECUTE PROCEDURE itens_retiradas_gatilho();

select * from livros


--trigger pra controle de devoluções nos exemplares
CREATE  or REPLACE FUNCTION devolucoes_gatilho() 
         RETURNS TRIGGER AS $devolucoes_gatilho$
    BEGIN
	IF (TG_OP = 'INSERT') THEN
		UPDATE exemplares set exempDisponiveis=(exempDisponiveis+NEW.qtd) where idLivro=NEW.idLivro;
                UPDATE itensRet set status='F' where idItensRet=NEW.idItensRet; 
		RETURN NEW;
	End if;
	IF (TG_OP = 'UPDATE') THEN
		UPDATE exemplares set exempDisponiveis=(exempDisponiveis+OLD.qtd-NEW.qtd) where idLivro=NEW.idLivro;
		RETURN NEW;
	end if;
	IF (TG_OP = 'DELETE') THEN
		UPDATE exemplares set exempDisponiveis=(exempDisponiveis-OLD.qtd) where idLivro=OLD.idLivro;
                UPDATE itensRet set status='A' where idItensRet=NEW.idItensRet; 
		RETURN OLD;
	END IF;
        RETURN NULL;
    END;
  $devolucoes_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER devolucoes_gatilho BEFORE INSERT OR UPDATE OR DELETE ON devolucoes
    FOR EACH ROW EXECUTE PROCEDURE devolucoes_gatilho();

----verificar a possibilidade de criar triger pra alimentar as movimentacoes nos livros a cada retirada e devolução.