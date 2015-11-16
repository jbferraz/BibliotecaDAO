/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.InputMismatchException;
import model.Livro;
import sevicos.LivroServicos;
import util.Console;
import view.menu.UILivroMenu;

/**
 *
 * @author Jair Ferraz
 */
public class UILivro {    

    private LivroServicos livroS;

    public UILivro() {
        livroS = new LivroServicos();
    }

    public void executar() {
        int opcao = 0;
        do {
            UILivroMenu.MostrarMenuLivro();
            try {
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case UILivroMenu.OP_CADASTRAR:
                        cadastrarLivro();
                        break;
                    case UILivroMenu.OP_ATUALIZAR:
                        atualizarLivro();
                        break;
                    case UILivroMenu.OP_EXCLUIR:
                        excluirLivro();
                        break;
                    case UILivroMenu.OP_LISTAR:
                        mostrarLivros();
                        break;
                    case UILivroMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ex) {
                System.out.println("\nColoque apenas dígitos...");
                opcao = 100;
            } catch (Exception ex) {
                System.out.println("\nHouve algum erro inesperado...");
                opcao = 100;
            }
        } while (opcao != UILivroMenu.OP_VOLTAR);
    }

    private void cadastrarLivro() {
        String ISBN = Console.scanString("ISBN: ");
        String nome = Console.scanString("Nome: ");
        String autores = Console.scanString("Autores: ");
        String editora = Console.scanString("Editora: ");
        int ano = Console.scanInt("Ano: ");
        int quant=Console.scanInt("Nº de exemplares: ");
        
        livroS.addLivro(new Livro(ISBN, nome, autores, editora, ano),quant);
    }

    private void mostrarLivros() {
        for (Livro l : livroS.listarLivros()) {
            System.out.println("----------");
            System.out.println("ISBN: " + l.getISBN());
            System.out.println("Titulo: " + l.getNome());
            System.out.println("Autores: " + l.getAutores());
            System.out.println("Editora: " + l.getEditora());
            System.out.println("Ano lançamento: " + l.getAno());
        }
    }

    private void atualizarLivro() {
        String isbn = Console.scanString("Informe o ISBN: ");
        if (livroS.procurarPorISBN(isbn) == null) {
            System.out.println("Não da dados com esse ISBN");
        } else {
            System.out.println("----------");
            System.out.println("Informe os dados a serem atualizados:");
            String nome = Console.scanString("Nome: ");
            String autores = Console.scanString("Autores: ");
            String editora = Console.scanString("Editora: ");
            int ano = Console.scanInt("Ano: ");
            livroS.atualizarLivro(new Livro(isbn, nome, autores, editora, ano));
        }
    }

    private void excluirLivro() {
        String isbn=Console.scanString("Informe a ISBN: ");
        if (livroS.procurarPorISBN(isbn)==null){
            System.out.println("Não ha dados com esse ISBN");
        }else{
            int ano=livroS.procurarPorISBN(isbn).getAno();
            try {
                livroS.excluirLivro(new Livro(isbn, "", "", "", ano));
            } catch (Exception e) {
                System.out.println("Livro não pode ser exclído!");
            }

        }
    }
}
