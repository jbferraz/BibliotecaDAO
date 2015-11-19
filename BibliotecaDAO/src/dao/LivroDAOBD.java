/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Livro;

/**
 *
 * @author Jair Ferraz
 */
public class LivroDAOBD implements LivroDAO {

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void adicionar(Livro l, int quant) {
        try {

            String sql = "insert into livros (isbn, nome, autores, editora, ano) VALUES(?,?,?,?,?)";

            conectar(sql);
            comando.setString(1, l.getISBN());
            comando.setString(2, l.getNome());
            comando.setString(3, l.getAutores());
            comando.setString(4, l.getEditora());
            comando.setInt(5, l.getAno());

            comando.executeUpdate();

            fechar();

            sql = "insert into exemplares (idLivro,exemplares,exempDisponiveis) values ((select max(id) from livros),?,?)";
            conectar(sql);
            comando.setInt(1, quant);
            comando.setInt(2, quant);

            comando.executeUpdate();
            fechar();

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Livro> listarLivros() {
        List<Livro> listaLivros = new ArrayList<>();
        try {
            String sql = "select * from livros";
            conectar(sql);
            ResultSet resultado;
            resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String isbn = resultado.getString("isbn");
                String nome = resultado.getString("nome");
                String autores = resultado.getString("autores");
                String editora = resultado.getString("editora");
                int ano = resultado.getInt("ano");

                Livro l = new Livro(isbn, nome, autores, editora, ano);
                listaLivros.add(l);

            }//fim while
            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaLivros;
    }

    @Override
    public void atualizarLivro(Livro l) {
        try {
            String sql = "update livros set nome=?, autores=?, editora=?, ano=? where isbn=?";
            conectar(sql);
            comando.setString(5, l.getISBN());
            comando.setString(1, l.getNome());
            comando.setString(2, l.getAutores());
            comando.setString(3, l.getEditora());
            comando.setInt(4, l.getAno());

            comando.executeUpdate();

            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Livro procurarPorISBN(String isbn) {
        try {
            String sql = "select * from livros where isbn=?";
            conectar(sql);
            comando.setString(1, isbn);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                int idLivro = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String autores = resultado.getString("autores");
                String editora = resultado.getString("editora");
                int ano = resultado.getInt("ano");

                Livro l = new Livro(isbn, nome, autores, editora, ano, idLivro);
                return l;
            }
            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void excluirLivro(Livro l) {
        try {
            String sql = "delete from livros where isbn=?";
            conectar(sql);
            comando.setString(1, l.getISBN());
            comando.executeUpdate();

            System.out.println("Livro exluido com sucesso!!!");

            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar(String sql) {

        try {
            conexao = ConnectionFactory.getConnection();
            comando = conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fechar() {

        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
