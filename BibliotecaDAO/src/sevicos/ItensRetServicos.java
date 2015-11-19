
package sevicos;

import dao.ItensRetDAOBD;
import java.util.List;
import model.ItensRet;

/**
 *
 * @author Jair Ferraz
 */
public class ItensRetServicos {
    public void addRetirada(ItensRet iR){
        new ItensRetDAOBD().adicionar(iR);
    }
    public List<ItensRet> listarItensRet(){
        return new ItensRetDAOBD().listar();
    }
    public void atualizar(ItensRet iR){
        new ItensRetDAOBD().atualizar(iR);
    }
    public ItensRet procurarPoridItensRet(int idItensRet) {
        return new ItensRetDAOBD().procurarPorIdItemRet(idItensRet);
    }
    public void excluir(ItensRet iR){
        new ItensRetDAOBD().excluir(iR);
    }
    public int verificaExempDisp(int idLivro){
        return new ItensRetDAOBD().verificaExempDisp(idLivro);
    }
}
