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
import model.Cliente;

/**
 *
 * @author 771400163
 */
public class ClienteDAOBD implements ClienteDAO{

    private Connection conexao;
    private PreparedStatement comando;
    
    @Override
    public void adicionar(Cliente c) {
         try {

            String sql = "insert into clientes (matricula, nome, telefone) VALUES(?,?,?)";

            conectar(sql);
            comando.setInt(1, c.getMatricula());
            comando.setString(2, c.getNome());
            comando.setString(3, c.getTelefone());

            comando.executeUpdate();

            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void conectar(String sql) {

        try {
            conexao = ConnectionFactory.getConnection();
            comando = conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
