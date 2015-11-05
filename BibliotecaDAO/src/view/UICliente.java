package view;

import util.Console;
import view.menu.UIClienteMenu;
import java.util.InputMismatchException;
import model.Cliente;
import sevicos.ClienteServicos;
import util.Validador;

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
                        atualizarCliente();
                        break;
                    case UIClienteMenu.OP_EXCLUIR:
                        excluirCliente();
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
        if (clienteS.procurarPorMatricula(matricula) != null) {
            System.out.println("Cliente já cadastrado!!!");
        } else {
            String nome = Validador.removerAcentos(Console.scanString("Nome: "));
            if (Validador.validarCadastro(nome) && nome != " ") {
                String telefone = Console.scanString("Telefone: ");
                if (Validador.validarCadastroFone(telefone) && telefone!=" "){
                    clienteS.addCliente(new Cliente(matricula, nome, telefone));
                }else{
                    System.err.print("Caracter invalido no telefone\n");
                }
            }else{
                System.err.print("Caracter invalido no nome.\n");
            }
        }
    }

    public void mostrarClientes() {
        for (Cliente c : clienteS.listarClientes()) {
            System.out.println("----------");
            System.out.println("Matricula: " + c.getMatricula());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Telefone: " + c.getTelefone());
        }
    }

    private void atualizarCliente() {
        int mat = Console.scanInt("informe a matricula: ");
        if (clienteS.procurarPorMatricula(mat) == null) {
            System.out.println("Não ha dados com essa matricula");
        } else {
            System.out.println("----------");
            System.out.println("Informe os dados a serem atualizados:");
            String nome = Console.scanString("Nome: ");
            String telefone = Console.scanString("Telefone: ");
            clienteS.atualizarCliente(new Cliente(mat, nome, telefone));
        }
    }

    private void excluirCliente() {
        int mat = Console.scanInt("informe a matricula: ");
        if (clienteS.procurarPorMatricula(mat) == null) {
            System.out.println("Não ha dados com essa matricula");
        } else {
            clienteS.excluirCliente(new Cliente(mat, "", ""));
        }
    }
}
