
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
            String sql = "insert into retiradas (matricula, dtRet) VALUES(?,?)";
            conectar(sql);
            String dateStr=r.getData();
            try {
                java.util.Date data= util.DateUtil.stringToDate(dateStr);
                comando.setInt(1, r.getCli().getMatricula());
                comando.setDate(2, (Date) data);

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
    public List<Retirada> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Retirada r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retirada procurarPorIdRet(int idRet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Retirada r) {
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
