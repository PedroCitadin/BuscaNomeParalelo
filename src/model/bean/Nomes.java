
package model.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.util.Arquivo;

/**
 *
 * @author Pedro Citadin Coelho
 */
public class Nomes extends Thread{
    private List<Arquivo> arc;
    private String nome;
    
    public Nomes() {
    }

    public Nomes(List<Arquivo> arc, String nome) {
        this.arc = arc;
        this.nome =  nome;
    }
    public Nomes(Arquivo arc, String nome) {
        this.arc = new ArrayList<Arquivo>();
        this.arc.add(arc);
        this.nome =  nome;
    }
    
   
    public void run(){
         for (Arquivo a: arc) {
            List<String> listaLinhas =null;
        try {
            listaLinhas = a.pegalistaLinhas(a);
        } catch (IOException ex) {
            Logger.getLogger(Nomes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            int contador = 0;
            for (String linha : listaLinhas) {
                String[] palavras = linha.split(" ");
                contador++;
                for (int i = 0; i < palavras.length; i++) {
                   
                    if (palavras[i].equalsIgnoreCase(nome)) {
                    System.out.println("Encontrado no arquivo: "+a.getNome()+" na linha: "+contador);
                    }
                }
            }
        }
        
    }
    
}
