
package sevicos;

import dao.ClienteDAOBD;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Jair Ferraz
 */
public class ClienteServicos {
    public void addCliente (Cliente c){
        new ClienteDAOBD().adicionar(c);
    }
    public List<Cliente> listarClientes(){
        return new ClienteDAOBD().listarCliente();
    }
    public void atualizarCliente(Cliente c){
        new ClienteDAOBD().atualizarCliente(c);
    }
    public Cliente procurarPorMatricula(int mat) {
        return new ClienteDAOBD().procurarPorMatricula(mat);
    }
    public void excluirCliente(Cliente c){
        new ClienteDAOBD().excluirCliente(c);
    }
}
