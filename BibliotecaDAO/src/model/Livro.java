/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 771400163
 */
public class Livro {
    private String ISBN, nome, autores, editora;
    private int ano;

    public Livro(String ISBN, String nome, String autores, String editora, int ano) {
        this.ISBN = ISBN;
        this.nome = nome;
        this.autores = autores;
        this.editora = editora;
        this.ano = ano;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAno(int ano) {
        this.ano = ano;
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

}
