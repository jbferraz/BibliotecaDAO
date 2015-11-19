
package sevicos;

import dao.DevolucaoDAOBD;
import java.util.List;
import model.Devolucao;

/**
 *
 * @author Jair Ferraz
 */
public class DevolucaoServicos {
    public void addCliente (Devolucao d){
        new DevolucaoDAOBD().adicionar(d);
    }
    public List<Devolucao> listarDevolucoes(){
        return new DevolucaoDAOBD().listar();
    }
    public void atualizarCliente(Devolucao d){
        new DevolucaoDAOBD().atualizar(d);
    }
    public Devolucao procurarPorIdDev(int idDev) {
        return new DevolucaoDAOBD().procurarPorIdDev(idDev);
    }
    public void excluirCliente(Devolucao d){
        new DevolucaoDAOBD().excluir(d);
    }
}
