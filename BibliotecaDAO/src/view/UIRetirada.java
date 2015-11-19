package view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import model.Cliente;
import model.ItensRet;
import model.Retirada;
import sevicos.ClienteServicos;
import sevicos.ItensRetServicos;
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
    private ItensRetServicos itensRetS;
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
        int op = 10, cont = 0;
        int idRet=0,quant=0;
        int mat = Console.scanInt("Informe matricula: ");
        if (clienteS.procurarPorMatricula(mat) == null) {
            System.out.println("Cliente não existe");
        } else {
            Cliente cli = clienteS.procurarPorMatricula(mat);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            String data = dateFormat.format(date);
            retiradaS.addRetirada(new Retirada(cli, data));
            //cadastra itens de retirada
            do {
                String isbn = Console.scanString("Informe o ISBN: ");
                if (livroS.procurarPorISBN(isbn) == null) {
                    System.out.println("Livro não encontrado!");
                } else {
                    int idLivro = livroS.procurarPorISBN(isbn).getIdLivro();
                    int id=retiradaS.procurarPorIdRet().getIdRet();
                    quant=Console.scanInt("Informe quant. de livros: ");
                    itensRetS.addRetirada(new ItensRet(idLivro, id, quant));
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
