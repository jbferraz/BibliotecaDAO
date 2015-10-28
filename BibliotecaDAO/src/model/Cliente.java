
package model;

/**
 *
 * @author Jair Ferraz
 */
public class Cliente {
    private int matricula;
    private String nome, telefone;

    public Cliente() {
    }

    public Cliente(int matricula, String nome, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
}
