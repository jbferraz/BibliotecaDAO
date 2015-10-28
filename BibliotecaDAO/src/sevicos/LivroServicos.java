/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevicos;

import dao.LivroDAOBD;
import model.Livro;

/**
 *
 * @author Jair Ferraz
 */
public class LivroServicos {
    public void addLivro(Livro l){
        new LivroDAOBD().adicionar(l);
    }
}
