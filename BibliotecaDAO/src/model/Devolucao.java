
package model;

import java.util.Date;

/**
 *
 * @author Jair Ferraz
 */
public class Devolucao {
    private int idDev, idRet,quant;
    private String dtDev;
    private Livro l;

    public Devolucao() {
    }

    public Devolucao(int idDev, int idRet, int quant, String dtDev, Livro l) {
        this.idDev = idDev;
        this.idRet = idRet;
        this.quant = quant;
        this.dtDev = dtDev;
        this.l = l;
    }

    public Devolucao(int idRet, int quant, String dtDev, Livro l) {
        this.idRet = idRet;
        this.quant = quant;
        this.dtDev = dtDev;
        this.l = l;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }

    public void setIdRet(int idRet) {
        this.idRet = idRet;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void setDtDev(String dtDev) {
        this.dtDev = dtDev;
    }

    public void setL(Livro l) {
        this.l = l;
    }

    public int getIdDev() {
        return idDev;
    }

    public int getIdRet() {
        return idRet;
    }

    public int getQuant() {
        return quant;
    }

    public String getDtDev() {
        return dtDev;
    }

    public Livro getL() {
        return l;
    }
    
    
}
