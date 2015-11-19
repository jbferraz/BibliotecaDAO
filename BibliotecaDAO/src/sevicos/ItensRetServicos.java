/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevicos;

import dao.ItensRetDAOBD;
import java.util.List;
import model.ItensRet;
import model.Livro;

/**
 *
 * @author marcela
 */
public class ItensRetServicos {
    public void addRetirada(ItensRet iR){
        new ItensRetDAOBD().adicionar(iR);
    }
    public List<ItensRet> listarClientes(){
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
