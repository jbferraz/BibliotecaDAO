
package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
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
            java.sql.Date dataSQL = new Date(System.currentTimeMillis());
            comando.setInt(1, r.getCli().getMatricula());
            comando.setDate(2, dataSQL);
            comando.executeUpdate();

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
    public Retirada procurarPorIdRet() {
        try {
            String sql = "select * from retiradas where idRet>=(select max(idRet) from retiradas)";
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                int id=resultado.getInt("idRet");
                java.sql.Date dataSQL=resultado.getDate("dtRet", null);
                String data=util.DateUtil.dateToString(dataSQL);
                int mat=resultado.getInt("matricula");
                Cliente c=new Cliente(mat, "", "");
                Retirada r=new Retirada(id, c, data);
                return r;
            }
            fechar();
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
