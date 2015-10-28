/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

/**
 *
 * @author Jair Ferraz
 */
public class UILivroMenu {
    public static final int OP_CADASTRAR = 1;
    public static final int OP_ATUALIZAR = 2;
    public static final int OP_EXCLUIR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_VOLTAR = 0;
    
    public static void MostrarMenuLivro(){
        System.out.println("\n.: Menu Livro :.\n"
                + "1 - Cadastrar\n"
                + "2 - Atualizar\n"
                + "3 - Excluir\n"
                + "4 - Listar Livros\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }
}
