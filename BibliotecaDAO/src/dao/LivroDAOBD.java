/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Livro;

/**
 *
 * @author Jair Ferraz
 */
public class LivroDAOBD implements LivroDAO{

    private Connection conexao;
    private PreparedStatement comando;
    
    @Override
    public void adicionar(Livro l) {
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
