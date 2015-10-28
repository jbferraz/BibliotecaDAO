package view;

import util.Console;
import view.menu.UIClienteMenu;
import java.util.InputMismatchException;
import model.Cliente;
import sevicos.ClienteServicos;

public class UICliente {

    private ClienteServicos clienteS;

    public UICliente() {
        clienteS = new ClienteServicos();
    }

    public void executar() {
        int opcao = 0;
        do {
            UIClienteMenu.MostrarMenuCliente();
            try {
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case UIClienteMenu.OP_CADASTRAR:
                        cadastrarCliente();
                        break;
                    case UIClienteMenu.OP_ATUALIZAR:
                        
                        break; 
                    case UIClienteMenu.OP_EXCLUIR:
                        
                        break; 
                    case UIClienteMenu.OP_LISTAR:
                        mostrarClientes();
                        break;
                    case UIClienteMenu.OP_VOLTAR:
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
        } while (opcao != UIClienteMenu.OP_VOLTAR);
    }

    public void cadastrarCliente() {
        int matricula = Console.scanInt("Matricula: ");
        String nome = Console.scanString("Nome: ");
        String telefone = Console.scanString("Telefone: ");

        clienteS.addCliente(new Cliente(matricula, nome, telefone));
    }

    public void mostrarClientes() {
        for (Cliente c: clienteS.listarClientes()){
            System.out.println("----------");
            System.out.println("Matricula: "+c.getMatricula());
            System.out.println("Nome: "+c.getNome());
            System.out.println("Telefone: "+c.getTelefone());
        }
    }
}
