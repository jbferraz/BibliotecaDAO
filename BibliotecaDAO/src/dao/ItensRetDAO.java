/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ItensRet;
import model.Livro;

/**
 *
 * @author marcela
 */
public interface ItensRetDAO {
    public void adicionar(ItensRet iR);
    public List<ItensRet> listar();
    public void atualizar(ItensRet iR);
    public ItensRet procurarPorIdItemRet(int idItemRet);
    public void excluir(ItensRet iR);
    public int verificaExempDisp(Livro l);
}
