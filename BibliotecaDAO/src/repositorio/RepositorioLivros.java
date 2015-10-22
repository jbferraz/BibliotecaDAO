package repositorio;

import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author Jair Ferraz
 */
public class RepositorioLivros {
    private ArrayList<Livro> listaLivros;
    
    public RepositorioLivros(){
        listaLivros= new ArrayList<Livro>();        
    }
    public void adicionar(Livro livro){
        listaLivros.add(livro);
    }
    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }
    public Livro buscarLivroPorISBN(String isbn)
    {
        for(Livro l: listaLivros)
        {
            if(l.getISBN().equals(isbn))
            {
                return(l);
            }
        }
        return(null);
    }
    public boolean existeLivro(String isbn){
        if(this.buscarLivroPorISBN(isbn)!=null)
            return true;
        else
            return false;
    }
    public Livro buscarLivroPorNomeLivro(String NomeLivro)
    {
        for(Livro l: listaLivros)
        {
            if(l.getNome().equals(NomeLivro))
            {
                return(l);
            }
        }
        return(null);
    }
    public boolean temLivros(){
        return !listaLivros.isEmpty();
    }
}
