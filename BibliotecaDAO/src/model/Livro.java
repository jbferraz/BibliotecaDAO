
package model;

/**
 *
 * @author Jair Ferraz
 */
public class Livro {
    private String ISBN, nome, autores, editora;
    private int ano, idLivro;
    private Exemplares exemp;

    public Livro() {
    }

    public Livro(String ISBN, String nome, String autores, String editora, int ano, int idLivro) {
        this.ISBN = ISBN;
        this.nome = nome;
        this.autores = autores;
        this.editora = editora;
        this.ano = ano;
        this.idLivro = idLivro;
    }

    public Livro(String ISBN, String nome, String autores, String editora, int ano) {
        this.ISBN = ISBN.toUpperCase();
        this.nome = nome.toUpperCase();
        this.autores = autores.toUpperCase();
        this.editora = editora.toUpperCase();
        this.ano = ano;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN.toUpperCase();
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public void setAutores(String autores) {
        this.autores = autores.toUpperCase();
    }

    public void setEditora(String editora) {
        this.editora = editora.toUpperCase();
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getNome() {
        return nome;
    }

    public String getAutores() {
        return autores;
    }

    public String getEditora() {
        return editora;
    }

    public int getAno() {
        return ano;
    }

    public int getIdLivro() {
        return idLivro;
    }

}
