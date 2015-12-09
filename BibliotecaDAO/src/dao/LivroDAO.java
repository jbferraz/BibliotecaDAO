/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Livro;
import model.Exemplares;

/**
 *
 * @author Jair Ferraz
 */
public interface LivroDAO {
    public void adicionar(Livro l,int quant);
    public List<Livro> listarLivros();
    public void atualizarLivro(Livro l);
    public Livro procurarPorISBN(String isbn);
    public void excluirLivro(Livro l);
    public List<Exemplares> listarExempLivros();
}
