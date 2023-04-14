
package model.bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.util.Arquivo;

/**
 *
 * @author Pedro Citadin Coelho
 */
public class Buscador {
        public List<File> listaArquivos;

    public List<File> getListaArquivos() {
        return listaArquivos;
    }

    public void setListaArquivos(List<File> listaArquivos) {
        this.listaArquivos = listaArquivos;
    }

    public Buscador() {
    }

    public Buscador(List<File> listaArquivos) {
        this.listaArquivos = listaArquivos;
    }
    
    public void pesquisaNome(String nome, File diretorio) throws IOException, InterruptedException{
        
        listaArquivos = Arquivo.pegaTodosOsArquivos(diretorio);
        if (listaArquivos.size()<=4) {
            for (File f : listaArquivos) {
            Nomes n = new Nomes(new Arquivo(f), nome);
            new Thread(n).start();
           
            
            
            }
        }else{
            int aux=0;
            List<Arquivo> listaArquivos1 = new ArrayList<Arquivo>();
            List<Arquivo> listaArquivos2 = new ArrayList<Arquivo>();
            List<Arquivo> listaArquivos3 = new ArrayList<Arquivo>();
            List<Arquivo> listaArquivos4 = new ArrayList<Arquivo>();
            Stack<File> lista = new Stack<File>();
            lista.addAll(listaArquivos);
            while(!lista.isEmpty()){
                if (aux==0) {
                    listaArquivos1.add(new Arquivo(lista.pop()));
                    aux = 1;
                }else if(aux==1){
                    listaArquivos2.add(new Arquivo(lista.pop()));
                    aux = 2;
                }else if(aux==2){
                    listaArquivos3.add(new Arquivo(lista.pop()));
                    aux = 3;
                }else if(aux==3){
                    listaArquivos4.add(new Arquivo(lista.pop()));
                    aux = 0;
                }
            }
            
            Nomes n1 = new Nomes(listaArquivos1, nome);
            new Thread(n1).start();
           
            
            
            
           
            Nomes n2 = new Nomes(listaArquivos2, nome);
            new Thread(n2).start();
           
            
            
            
            
            Nomes n3 = new Nomes(listaArquivos3, nome);
            new Thread(n3).start();
           
            
            
            
            
            Nomes n4 = new Nomes(listaArquivos4, nome);
            new Thread(n4).start();
           
            
            
            
        }
        
        
        
        
    }
        
        
        
        
        
        
}
