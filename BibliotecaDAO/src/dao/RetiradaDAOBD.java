
package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Retirada;

/**
 *
 * @author Jair Ferraz
 */
public class RetiradaDAOBD implements RetiradaDAO{

    private Connection conexao;
    private PreparedStatement comando;
    
    @Override
    public void adicionar(Retirada r) {
        try {
            String sql = "insert into clientes (matricula, dtRet) VALUES(?,?)";
            conectar(sql);
            String dateStr=r.getData();
            try {
                Date data=(Date) util.DateUtil.stringToDate(dateStr);
                comando.setInt(1, r.getCli().getMatricula());
                comando.setDate(2, data);

                comando.executeUpdate();
            } catch (ParseException ex) {
                Logger.getLogger(RetiradaDAOBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            System.out.println("Retirada cadastrado com sucesso!!!");

            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Retirada> listarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarCliente(Retirada r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retirada procurarPorMatricula(int idRet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirCliente(Retirada r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
