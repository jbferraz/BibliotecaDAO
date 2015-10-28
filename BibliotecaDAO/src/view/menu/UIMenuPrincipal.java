/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

/**
 *
 * @author kako__000
 */
public class UIMenuPrincipal {
    public static final int OP_Menu_CRUDLivros = 1;
    public static final int OP_Menu_CRUDClientes = 2;
    public static final int OP_Menu_RetLivros = 3;
    public static final int OP_Menu_DevLivros = 4;
    public static final int OP_Menu_Relatorios = 5;
    public static final int OP_SAIR = 0;
    
    public static void mostrarMenu(){
        System.out.println("\n.: Biblioteca - Menu :.\n"
                + "1 - Cadastro de Livros\n"
                + "2 - Cadastro de Clientes\n"
                + "3 - Retirada de Livro\n"
                + "4 - Devolução de Livro\n"
                + "5 - Relatórios\n"
                + "0 - Sair da Aplicação"
                + "\n--------------------------------------");
    }
    
}
