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

select * from livros

select * from clientes 

