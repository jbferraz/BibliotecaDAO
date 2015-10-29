/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Livro;

/**
 *
 * @author 771400163
 */
public interface LivroDAO {
    public void adicionar(Livro l);
    public List<Livro> listarLivros();
    public void atualizarLivro(Livro l);
    public Livro procurarPorISBN(String isbn);
}
