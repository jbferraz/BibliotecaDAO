
package sevicos;

import dao.RetiradaDAOBD;
import java.util.List;
import model.Retirada;

/**
 *
 * @author Jair Ferraz
 */
public class RetiradaServicos {
    public void addRetirada(Retirada r){
        new RetiradaDAOBD().adicionar(r);
    }
    public List<Retirada> listarClientes(){
        return new RetiradaDAOBD().listarCliente();
    }
    public void atualizarCliente(Retirada r){
        new RetiradaDAOBD().atualizarCliente(r);
    }
    public Retirada procurarPorMatricula(int mat) {
        return new RetiradaDAOBD().procurarPorMatricula(mat);
    }
    public void excluirCliente(Retirada r){
        new RetiradaDAOBD().excluirCliente(r);
    }
}
