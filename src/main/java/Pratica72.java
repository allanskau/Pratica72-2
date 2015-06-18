
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
        
        String ocorrencias_palavras;
        List<String> lista = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : palavras.entrySet()){
            ocorrencias_palavras = entry.getValue().toString().concat(",").concat(entry.getKey());
            System.out.println(ocorrencias_palavras);
            lista.add(ocorrencias_palavras);
        }
        Collections.sort(lista);
        Collections.reverse(lista);
        System.out.println("criou arquivo");
        BufferedWriter arquivo = new BufferedWriter(new FileWriter(pathname.concat(".out")));
        for(String list: lista){
            System.out.println(list);
            arquivo.write(list);
            arquivo.newLine();
        }
        arquivo.close();
        
    }
}

