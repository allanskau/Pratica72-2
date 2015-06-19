
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author allan
 */
public class Pratica72 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String pathname;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Testando contador de palavras.");
        System.out.println("Digite o caminho para o arquivo no formato: 'C:\\Users\\allan\\Desktop\\palavras.txt'");
        pathname = scanner.next();
        
        ContadorPalavras contador = new ContadorPalavras(pathname);
        Map<String, Integer> palavras = contador.getPalavras();
//////////////////////////////////////////////////////////////////////////////////
        class PalavrasOcorrencias{
            String palavra;
            Integer ocorrencia;

            public PalavrasOcorrencias() {
            }

            public PalavrasOcorrencias(String palavra, Integer ocorrencia) {
                this.palavra = palavra;
                this.ocorrencia = ocorrencia;
            }
            

            public String getPalavra() {
                return palavra;
            }

            public void setPalavra(String palavra) {
                this.palavra = palavra;
            }

            public Integer getOcorrencia() {
                return ocorrencia;
            }

            public void setOcorrencia(Integer ocorrencia) {
                this.ocorrencia = ocorrencia;
            }            
        }
//////////////////////////////////////////////////////////////////////////////////
        
        
        List<PalavrasOcorrencias> lista = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : palavras.entrySet()){
            PalavrasOcorrencias word = new PalavrasOcorrencias(){};
            word.setOcorrencia(entry.getValue());
            word.setPalavra(entry.getKey());
            //System.out.println(ocorrencias_palavras);
            lista.add(word);
        }
        
//////////////////////////////////////////////////////////////////////////////////
        class Comparador implements Comparator<PalavrasOcorrencias>{

            public Comparador() {
            }

            private int comparaOcorrencia(PalavrasOcorrencias p1, PalavrasOcorrencias p2) {
                return -(p1.getOcorrencia() - p2.getOcorrencia());
            }

            private int comparaPalavra(PalavrasOcorrencias p1, PalavrasOcorrencias p2) {
                return p1.getPalavra().compareTo(p2.getPalavra());
            }
            
            public int compare(PalavrasOcorrencias p1, PalavrasOcorrencias p2) {
                int comp;
                comp = comparaOcorrencia(p1, p2);
                if (comp == 0) 
                    comp = comparaPalavra(p1, p2);
                return comp;
            }
        }
//////////////////////////////////////////////////////////////////////////////////
        Comparador comparador = new Comparador();
        //Collections.sort(lista);
        //Collections.reverse(lista);
        Collections.sort(lista, comparador);
        //Collections.reverse(lista);
        System.out.println("criou arquivo");
        BufferedWriter arquivo = new BufferedWriter(new FileWriter(pathname.concat(".out")));
        for(PalavrasOcorrencias list: lista){
            //System.out.println(list);
            arquivo.write(list.getPalavra() + "," + list.getOcorrencia());
            arquivo.newLine();
        }
        arquivo.close();
        
    }
}

