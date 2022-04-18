
package model.bean;

import java.util.List;
import model.util.Arquivo;

/**
 *
 * @author Pedro Citadin Coelho
 */
public class BuscaNomes extends Thread{
    private List<String> linhas;
    private String nome;
    private int contador;
    private Arquivo a;
    public List<String> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<String> linhas) {
        this.linhas = linhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BuscaNomes(List<String> linhas, String nome, int contador, Arquivo a) {
        this.linhas = linhas;
        this.nome = nome;
        this.contador = contador;
        this.a = a;
    }
    
    
     public void run(){
         ///aqui é feita a verificação das linhas recebidas do Objeto Nomes, o contador representa a linha atual, caso o nome presente na linha selecionada seja igual o nome buscado
         ///o sistema solta uma mensagem no console informando o nome do arquivo atual e a linha
         for (String l: linhas) {
             contador++;
             if (l.equalsIgnoreCase(nome)) {
                 System.out.println("Encontrado no arquivo: "+a.getNome()+" na linha: "+contador);
             }
         }
     }

    
}
