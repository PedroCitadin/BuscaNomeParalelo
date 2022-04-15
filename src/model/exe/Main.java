
package model.exe;

import java.io.File;
import java.io.IOException;
import java.util.List;
import model.bean.Buscador;
import model.util.Arquivo;

/**
 *
 * @author Pedro Citadin Coelho
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Buscador busc = new Buscador();
        
        long inicio = System.currentTimeMillis();
        busc.pesquisaNome("Margaret Lane", "lista");
        while(Thread.activeCount()>1){
            
        }
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo decorrido: "+tempo+" milissegundos");
        
        
    }
}
