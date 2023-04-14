
package model.exe;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.bean.Buscador;
import model.util.Arquivo;

/**
 *
 * @author Pedro Citadin Coelho
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Buscador busc = new Buscador();
        String nome;
         
        try{
        nome = JOptionPane.showInputDialog(null, "Digite o nome desejado");
        }catch(NullPointerException e){
            nome = "nulo";
        }
        Main obj = new Main();
        File f = obj.run(args);
        
        long inicio = System.currentTimeMillis();
        
        busc.pesquisaNome(nome, f);
        while(Thread.activeCount()>1){
            
            
        }
        

        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo decorrido: "+tempo+" milissegundos");
        
        
    }
    
    
    public File run(String args[]){
        JFileChooser dc = new JFileChooser();
        dc.setMultiSelectionEnabled(false);
        dc.setCurrentDirectory(new File(""));
        dc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        try{
             dc.showDialog(null, "Selecione o diretório");
             return dc.getSelectedFile();
        }catch(NullPointerException e){
            return null;
        }
       
    }
}
