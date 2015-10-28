
package view.menu;

public class UIClienteMenu {
    public static final int OP_CADASTRAR = 1;
    public static final int OP_ATUALIZAR = 2;
    public static final int OP_EXCLUIR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_VOLTAR = 0;
    
    public static void MostrarMenuCliente(){
        System.out.println("\n.: Menu Cliente :.\n"
                + "1 - Cadastrar\n"
                + "2 - Atualizar\n"
                + "3 - Excluir\n"
                + "4 - Listar Clientes\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }
    
}
