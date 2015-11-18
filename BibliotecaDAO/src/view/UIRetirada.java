package view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import model.Cliente;
import model.Livro;
import model.Retirada;
import sevicos.ClienteServicos;
import sevicos.LivroServicos;
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
    private LivroServicos livroS;

    public UIRetirada() {
        retiradaS = new RetiradaServicos();
        clienteS = new ClienteServicos();
        livroS = new LivroServicos();
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
        UILivro l = new UILivro();
        int op = 10, cont = 0;
        int idRet=0,quant=0;
        int mat = Console.scanInt("Informe matricula: ");
        if (clienteS.procurarPorMatricula(mat) == null) {
            System.out.println("Cliente não existe");
        } else {
            Cliente cli = clienteS.procurarPorMatricula(mat);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            GregorianCalendar calendar = new GregorianCalendar();
            Date date = calendar.getTime();
            String data = dateFormat.format(date);
            retiradaS.addRetirada(new Retirada(cli, data));
            do {
                String isbn = Console.scanString("Informe o ISBN: ");
                if (livroS.procurarPorISBN(isbn) == null) {
                    System.out.println("Livro não encontrado!");
                } else {
                    Livro livro = livroS.procurarPorISBN(isbn);
                    Retirada r = new Retirada();
                    idRet= r.getIdRet();
                    quant=Console.scanInt("Informe quant. de livros: ");
                    
                    //itensRetS.addItensRet(new itensRet(????????));
                    cont++;
                    if (cont <= 3) {
                        op = Console.scanInt("Quer retirar mais " + cont + ", se sim/n digite 1 ou 0 pra finalizar");
                    } else {
                        op = 0;
                    }
                }

            } while (op != 0);
        }

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