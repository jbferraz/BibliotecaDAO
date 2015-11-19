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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItensRet;
import model.Livro;

/**
 *
 * @author marcela
 */
public class ItensRetDAOBD implements ItensRetDAO{
    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void adicionar(ItensRet iR) {
        try {
            
            String sql = "insert into itensRet (idLivro, idRet, qtd) VALUES(?,?,?)";
            conectar(sql);
            comando.setInt(1, iR.getIdLivro());
            comando.setInt(2, iR.getIdRet());
            comando.setInt(3, iR.getQuant());
            comando.executeUpdate();

            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ItensRet> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(ItensRet iR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItensRet procurarPorIdItemRet(int idItemRet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(ItensRet iR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int verificaExempDisp(int idLivro) {
        try {
            String sql = "select * from exemplares where idLivro=? and exempDisponiveis<=exemplares";
            conectar(sql);
            comando.setInt(1, idLivro);
            ResultSet resultado;
            resultado = comando.executeQuery();

            while (resultado.next()) {
                int exempDispo = resultado.getInt("exempDisponiveis");
                return exempDispo;
            }//fim while
            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public void conectar(String sql) {

        try {
            conexao = ConnectionFactory.getConnection();
            comando = conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ItensRetDAOBD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ItensRetDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
