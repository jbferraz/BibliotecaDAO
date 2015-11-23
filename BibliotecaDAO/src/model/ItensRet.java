
package model;

/**
 *
 * @author Jair Ferraz
 */
public class ItensRet {
    private int idItensRet;
    private int idLivro;
    private int idRet;
    private int quant;
    private String status;

    public ItensRet() {
    }

    public ItensRet(int idItensRet, int idLivro, int idRet, int quant, String status) {
        this.idItensRet = idItensRet;
        this.idLivro = idLivro;
        this.idRet = idRet;
        this.quant = quant;
        this.status = status;
    }

    public ItensRet(int idLivro, int idRet, int quant) {
        this.idLivro = idLivro;
        this.idRet = idRet;
        this.quant = quant;
        this.status = "A";
    }

    public void setIdItensRet(int idItensRet) {
        this.idItensRet = idItensRet;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public void setIdRet(int idRet) {
        this.idRet = idRet;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdItensRet() {
        return idItensRet;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public int getIdRet() {
        return idRet;
    }

    public int getQuant() {
        return quant;
    }

    public String getStatus() {
        return status;
    }
    
}
