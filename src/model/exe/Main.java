

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
        //dialog para pegar o nome da busca    
        nome = JOptionPane.showInputDialog(null, "Digite o nome desejado");
        }catch(NullPointerException e){
            nome = "nulo";
        }
        //// objeto criado para rodar o dialog do file chooser e consequentemente pegar o diretório desejado
        Main obj = new Main();
        
        File f = obj.run(args);
        ///marcação de tempo no inicio da busca
        long inicio = System.currentTimeMillis();
        ///metodo para buscar o nome no diretório
        busc.pesquisaNome(nome, f);
        
        ///laço de repetição que verifica se todas as threads (com excessão da thread principal) ja completaram a execução
        while(Thread.activeCount()>1){
            
        }
        
        //marcação do tempo final pós busca
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo decorrido: "+tempo+" milissegundos");
        
        
    }
    
    
    public File run(String args[]){
        
        ////método apenas para rodar o File Chooser como dialog
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

