
package dao;

import java.util.List;
import model.Devolucao;

/**
 *
 * @author Jair Ferraz
 */
public interface DevolucaoDAO {
    public void adicionar(Devolucao d);
    public List<Devolucao> listar();
    public void atualizar(Devolucao d);
    public Devolucao procurarPorIdRet();
    public void excluir(Devolucao d);
}
