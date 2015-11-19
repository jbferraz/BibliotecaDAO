
package model;

/**
 *
 * @author Jair Ferraz
 */
public class Devolucao {
    private int idDev, quant;
    private String dtDev;
    private ItensRet i;
    private Livro l;

    public Devolucao() {
    }

    public Devolucao(int idDev, int quant, String dtDev, ItensRet i, Livro l) {
        this.idDev = idDev;
        this.quant = quant;
        this.dtDev = dtDev;
        this.i = i;
        this.l = l;
    }

    public Devolucao(int quant, String dtDev, ItensRet i, Livro l) {
        this.quant = quant;
        this.dtDev = dtDev;
        this.i = i;
        this.l = l;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void setDtDev(String dtDev) {
        this.dtDev = dtDev;
    }

    public void setI(ItensRet i) {
        this.i = i;
    }

    public void setL(Livro l) {
        this.l = l;
    }

    public int getIdDev() {
        return idDev;
    }

    public int getQuant() {
        return quant;
    }

    public String getDtDev() {
        return dtDev;
    }

    public ItensRet getI() {
        return i;
    }

    public Livro getL() {
        return l;
    }
    
}
