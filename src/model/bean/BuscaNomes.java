package model.bean;

import java.util.List;
import model.util.Arquivo;

/**
 *
 * @author Pedro Citadin Coelho
 */
public class BuscaNomes extends Thread {

    private List<Linha> linhas;
    private String nome;
    private int contador;
    private Arquivo a;

    public List<Linha> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Linha> linhas) {
        this.linhas = linhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BuscaNomes(List<Linha> linhas, String nome) {
        this.linhas = linhas;
        this.nome = nome;

    }
    public void run() {

        for (Linha l : linhas) {

            if (l.getLinha().equalsIgnoreCase(nome)) {
                System.out.println("Encontrado no arquivo: " + l.getArquivo().getNome() + " na linha: " + l.getNumero());
                Thread[] threads = new Thread[Thread.activeCount()];
                Thread.enumerate(threads);

                for (Thread t : threads) {
                    t.interrupt();
                }
            }
        }
    }

}
