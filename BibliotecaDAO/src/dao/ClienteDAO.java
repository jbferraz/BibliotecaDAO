/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author 771400163
 */
public interface ClienteDAO {
    public void adicionar(Cliente c);
    public List<Cliente> listarCliente();
    public void atualizarCliente(Cliente c);
    public Cliente procurarPorMatricula(int mat);
    public void excluirCliente(Cliente C);
}
