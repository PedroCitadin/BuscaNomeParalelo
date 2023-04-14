
package model.bean;

import model.util.Arquivo;

/**
 *
 * @author Pedro Citadin Coelho
 */
public class Linha {
    private Arquivo arquivo;
    private String linha;
    private int numero;
    

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Linha(Arquivo arquivo, String linha, int numero) {
        this.arquivo = arquivo;
        this.linha = linha;
        this.numero = numero;
    }
    
    
}
