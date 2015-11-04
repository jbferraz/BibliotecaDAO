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
import model.Cliente;

/**
 *
 * @author Jair Ferraz
 */
public class ClienteDAOBD implements ClienteDAO {

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
            
            System.out.println("Cliente cadastrado com sucesso!!!");

            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> listarCliente() {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            String sql = "select * from clientes";
            conectar(sql);
            ResultSet resultado;
            resultado = comando.executeQuery();

            while (resultado.next()) {
                int matricula = resultado.getInt("matricula");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");

                Cliente c = new Cliente(matricula, nome, telefone);
                listaClientes.add(c);

            }//fim while
            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    /**
     *
     * @param c
     */
    @Override
    public void atualizarCliente(Cliente c) {
        try {
            String sql = "update clientes set nome=?, telefone=? where matricula=?";
            conectar(sql);
            comando.setInt(3, c.getMatricula());
            comando.setString(1, c.getNome());
            comando.setString(2, c.getTelefone());
            comando.executeUpdate();
            
            System.out.println("Cliente atualizado com sucesso!!!");

            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente procurarPorMatricula(int mat) {
        try {
            String sql = "select * from clientes where matricula=?";
            conectar(sql);
            comando.setInt(1, mat);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                String nome=resultado.getString("nome");
                String telefone=resultado.getString("telefone");
                
                Cliente c=new Cliente(mat, nome, telefone);
                return c;
            }
            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void excluirCliente(Cliente c) {
        try {
            String sql = "delete from clientes where matricula=?";
            conectar(sql);
            comando.setInt(1, c.getMatricula());
            comando.executeUpdate();
            
            System.out.println("Cliente exluido com sucesso!!!");

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
