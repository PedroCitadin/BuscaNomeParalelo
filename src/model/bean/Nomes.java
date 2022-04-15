
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
            BuscaNomes b1 = new BuscaNomes(listaLinhas.subList(0, listaLinhas.size()/4), nome, 0, a);
            BuscaNomes b2 = new BuscaNomes(listaLinhas.subList(listaLinhas.size()/4, listaLinhas.size()/2), nome, listaLinhas.size()/4, a);
            BuscaNomes b3 = new BuscaNomes(listaLinhas.subList(listaLinhas.size()/2, listaLinhas.size()*3/4), nome, listaLinhas.size()/2, a);
            BuscaNomes b4 = new BuscaNomes(listaLinhas.subList(listaLinhas.size()*3/4, listaLinhas.size()), nome, listaLinhas.size()*3/4, a);
            new Thread(b1).start();
            new Thread(b2).start();
            new Thread(b3).start();
            new Thread(b4).start();
        }
        
    }
    
}
