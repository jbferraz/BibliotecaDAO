package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Devolucao;
import model.Livro;

/**
 *
 * @author Jair Ferraz
 */
public class DevolucaoDAOBD implements DevolucaoDAO {

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void adicionar(Devolucao d) {
        try {
            try {
                String sql = "insert into devolucoes (idRet, dtDev,idLivro,qtd) VALUES(?,?,?,?)";
                conectar(sql);
                comando.setInt(1, d.getIdRet());
                String dataStr = d.getDtDev();
                Date data;
                data = util.DateUtil.stringToDate(dataStr);
                java.sql.Date dataSQL = (java.sql.Date) data;
                comando.setDate(2, (java.sql.Date) data);
                
                //comando.setInt(3, x);
                comando.setInt(4, d.getQuant());
                //comando.setInt(1, d.getCli().getMatricula());
                //comando.setDate(2, dataSQL);
                comando.executeUpdate();

                fechar();
            } catch (ParseException ex) {
                Logger.getLogger(DevolucaoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Devolucao> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Devolucao d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Devolucao procurarPorIdRet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Devolucao d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void conectar(String sql) {
        try {
            conexao = ConnectionFactory.getConnection();
            comando = conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAOBD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RetiradaDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
