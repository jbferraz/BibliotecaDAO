package view;

import java.util.InputMismatchException;
import model.Cliente;
import sevicos.ClienteServicos;
import sevicos.RetiradaServicos;
import util.Console;
import view.menu.UIRetiradaMenu;

/**
 *
 * @author Jair Ferraz
 */
public class UIRetirada {

    private RetiradaServicos retiradaS;
    private ClienteServicos clienteS;

    public UIRetirada() {
        retiradaS = new RetiradaServicos();
        clienteS = new ClienteServicos();
    }
    
    public void executar() {
        int opcao = 0;
        do {
            UIRetiradaMenu.MostrarMenuRetirada();
            try {
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case UIRetiradaMenu.OP_CADASTRAR:
                        cadastrarRetirada();
                        break;
                    case UIRetiradaMenu.OP_ATUALIZAR:
                        atualizarRetirada();
                        break;
                    case UIRetiradaMenu.OP_EXCLUIR:
                        excluirRetirada();
                        break;
                    case UIRetiradaMenu.OP_LISTAR:
                        mostrarRetiradas();
                        break;
                    case UIRetiradaMenu.OP_VOLTAR:
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
        } while (opcao != UIRetiradaMenu.OP_VOLTAR);
    }

    private void cadastrarRetirada() {
        UICliente c= new UICliente();
        
        int mat=Console.scanInt("Informe matricula: ");
        Cliente cli = clienteS.procurarPorMatricula(mat);
        
        
        
        
    }

    private void atualizarRetirada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void excluirRetirada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarRetiradas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
