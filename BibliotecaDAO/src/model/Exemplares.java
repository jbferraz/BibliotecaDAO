
package model;

/**
 *
 * @author Jair Ferraz
 */
public class Exemplares {
    private int idExemp;
    private Livro livro;
    private int exemp;
    private int exempDisp;

    public Exemplares() {
    }

    public Exemplares(int idExemp, Livro livro, int exemp, int exempDisp) {
        this.idExemp = idExemp;
        this.livro = livro;
        this.exemp = exemp;
        this.exempDisp = exempDisp;
    }

    public Exemplares(Livro livro, int exemp, int exempDisp) {
        this.livro = livro;
        this.exemp = exemp;
        this.exempDisp = exempDisp;
    }

    public void setIdExemp(int idExemp) {
        this.idExemp = idExemp;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setExemp(int exemp) {
        this.exemp = exemp;
    }

    public void setExempDisp(int exempDisp) {
        this.exempDisp = exempDisp;
    }

    public int getIdExemp() {
        return idExemp;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getExemp() {
        return exemp;
    }

    public int getExempDisp() {
        return exempDisp;
    }
    
}
