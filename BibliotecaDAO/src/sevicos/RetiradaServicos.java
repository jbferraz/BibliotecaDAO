
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
    public List<Retirada> listar(){
        return new RetiradaDAOBD().listar();
    }
    public void atualizar(Retirada r){
        new RetiradaDAOBD().atualizar(r);
    }
    public Retirada procurarPorIdRet(int idRet) {
        return new RetiradaDAOBD().procurarPorIdRet(idRet);
    }
    public void excluir(Retirada r){
        new RetiradaDAOBD().excluir(r);
    }
}
