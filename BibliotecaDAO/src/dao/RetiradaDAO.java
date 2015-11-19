/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Retirada;

/**
 *
 * @author 771400163
 */
public interface RetiradaDAO {
    public void adicionar(Retirada r);
    public List<Retirada> listar();
    public void atualizar(Retirada r);
    public Retirada procurarPorIdRet();
    public void excluir(Retirada r);
}
