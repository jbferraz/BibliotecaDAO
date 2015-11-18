
package model;

/**
 *
 * @author Jair Ferraz
 */
public class Retirada {
    private int idRet;
    private Cliente cli;
    private String data;

    public Retirada() {
    }

    public Retirada(int idRet, Cliente cli, String data) {
        this.idRet = idRet;
        this.cli = cli;
        this.data = data;
    }

    public Retirada(Cliente cli, String data) {
        this.cli = cli;
        this.data = data;
    }

    public void setIdRet(int idRet) {
        this.idRet = idRet;
    }

    public void setMatricula(Cliente cli) {
        this.cli = cli;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdRet() {
        return idRet;
    }

    public Cliente getCli() {
        return cli;
    }

    public String getData() {
        return data;
    }
    
    
}

