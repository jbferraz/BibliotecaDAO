package view;

import repositorio.RepositorioClientes;
import repositorio.RepositorioLivros;
import util.Console;
import view.UIMenuPrincipal;

public class UIPrincipal {

    private RepositorioClientes listaClientes;
    private RepositorioLivros listaLivros;

    public UIPrincipal() {
        listaClientes = new RepositorioClientes();
        listaLivros = new RepositorioLivros();
    }

    public void executar() {
        int opcao = 0;
        do {
            UIMenuPrincipal.mostrarMenu();
            try {
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case UIMenuPrincipal.OP_Menu_CRUDLivros:
                        //new UICliente(listaLivros).executar();
                        break;
                    case UIMenuPrincipal.OP_Menu_CRUDClientes:
                        new UICliente(listaClientes).executar();
                        break;
                    case UIMenuPrincipal.OP_Menu_RetLivros:
                        //new UIvoo(listaAvioes, listaVoos).executar();
                        break;
                    case UIMenuPrincipal.OP_Menu_DevLivros:
                        //new UIpassagem(listaClientes, listaPassagens, listaVoos).executar();
                        break;
                    case UIMenuPrincipal.OP_Menu_Relatorios:
                        //new UIrelatorios(listaPassagens).executar();
                        break;
                    case UIMenuPrincipal.OP_SAIR:
                        System.out.println("Aplicação finalizada!!!");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (Exception ex) {
                System.out.println("Informe opção válido...");
                opcao = 100;
            }
        } while (opcao != UIMenuPrincipal.OP_SAIR);
    }
}
