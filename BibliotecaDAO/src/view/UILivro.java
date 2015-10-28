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
import view.menu.UIClienteMenu;
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
                    case UILivroMenu.OP_LISTAR:
                        //mostrarClientes();
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
        
        livroS.addLivro(new Livro(ISBN, nome, autores, editora, ano));

    }

}
