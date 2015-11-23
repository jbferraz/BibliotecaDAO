package view;

import java.util.InputMismatchException;
import model.Cliente;
import model.Livro;
import sevicos.ClienteServicos;
import sevicos.ItensRetServicos;
import sevicos.LivroServicos;
import util.Console;
import view.menu.UIRetiradaMenu;

/**
 *
 * @author Jair Ferraz
 */
public class UIDevolucao {

    private ItensRetServicos itensRetS;
    private LivroServicos livroS;
    private ClienteServicos clienteS;

    public UIDevolucao() {
        livroS = new LivroServicos();
        itensRetS = new ItensRetServicos();
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
                        cadastrar();
                        break;
                    case UIRetiradaMenu.OP_ATUALIZAR:
                        atualizar();
                        break;
                    case UIRetiradaMenu.OP_EXCLUIR:
                        excluir();
                        break;
                    case UIRetiradaMenu.OP_LISTAR:
                        mostrar();
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

    private void cadastrar() {
        //idItensRet, dtDev,idLivro,qtd
        int mat = Console.scanInt("Informe o matricula: ");
        Cliente c = clienteS.procurarPorMatricula(mat);
        if (c == null) {
            System.out.println("Cliente não fez retirada!");
        } else {
            String isbn = Console.scanString("Informe ISBN a ser devolvido: ");
            Livro l = livroS.procurarPorISBN(isbn);
            if (l == null) {
                System.out.println("Livro não foi retirado!");
            }else{
                
            }
        }

    }

    private void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
