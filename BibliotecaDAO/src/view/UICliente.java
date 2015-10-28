package view;

import model.Cliente;
import repositorio.RepositorioClientes;
import util.Console;
import view.menu.UIClienteMenu;
import java.util.InputMismatchException;

public class UICliente {

    private RepositorioClientes listaClientes;

    public UICliente(RepositorioClientes listaClientes) {
        this.listaClientes = listaClientes;
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
                    case UIClienteMenu.OP_LISTAR:
                        //mostrarClientes();
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
        if (listaClientes.existeCliente(matricula)) {
            System.out.println("\nRG já existente no cadastro");
        } //else if (matricula.replace(" ", "").isEmpty() /*testando se é vazio*/) {
//            System.out.println("\nErro: RG VAZIO");            
//        } else if (matricula.matches("\\d{10,10}")) {
//            String nome = Console.scanString("Escreva seu nome completo: ");
//            if (nome.matches("\\s*")) {//testar com \s para ver se é vazio
//                System.out.println(" \nErro: NOME VAZIO");                
//            } else if (nome.matches("[A-Za-z]+(\\s[A-Za-z]+)*")) {
//                String telefone = Console.scanString("Telefone para Contato: (xxxx-xxxx 4 números separado por hífem)");
//                if (!telefone.matches("\\d{4,4}-\\d{4,4}")) {
//                    System.out.println("\nErro: Telefone digitado diferente do formato indicado!!!");                    
//                } else {
//                    listaClientes.addClientes(new Cliente(nome, rg, telefone));
//                    System.out.println("\nCliente " + nome + " \ncadastrado com sucesso!\n");
//                }
//            }else {
//                System.out.println("\nErro: O nome não pode conter números, caracteres especiais, ou começa em espaço ou ter mais de um espaço");              
//            }
//        } else {
//            System.out.println("\nErro:O RG não pode conter letras, espaços e no máximo 10 dígitos");            
        }
    }

//   public void mostrarClientes() {
//        System.out.println("-----------------------------\n");
//        System.out.println(String.format("%-40s", "NOME") + "\t"
//                + String.format("%-20s", "|RG") + "\t"
//                + String.format("%-20s", "|TELEFONE"));
//        for (Cliente Cliente : listaClientes.getListaClientes()) {
//            System.out.println(String.format("%-40s", Cliente.getNome()) + "\t"
//                    + String.format("%-20s", "|" + Cliente.getRG()) + "\t"
//                    + String.format("%-20s", "|" + Cliente.getTelefone()));
//        }
//    }

