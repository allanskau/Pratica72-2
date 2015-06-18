/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import static java.lang.System.exit;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author allan
 */
public class ContadorPalavras {

    private String pathname;
    private BufferedReader reader;
    private FileReader file;
    
    public ContadorPalavras() {
    }

    public ContadorPalavras(String pathname) throws FileNotFoundException, UnsupportedEncodingException {
        this.pathname = pathname;
        if (pathname == null) { 
            System.err.println("ERRO: eh preciso especificar o nome do arquivo"); 
            System.err.println("Uso: java ContaPalavras arquivo_texto"); 
            System.exit(1); 
        }
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathname), "UTF-8"));
        }
        catch(FileNotFoundException e){
            System.out.println("Arquivo nao encontrado, tente novamente. Erro:  " + e);
            exit(0);
        }
    }
    
    public Map<String, Integer> getPalavras() throws IOException{
        Map<String, Integer> mapPalavras = new HashMap<>(); // Map< Palavra, Frequencia >
        String currentline; // recebe cada linha do arquivo de texto
        currentline = this.reader.readLine(); // le uma linha
        while (currentline != null) {
            Pattern p = Pattern.compile("\\w+"); // padrao = todas as palavras: "\w" = tudo que for palavras. "+" = repetidas vezes
            Matcher m = p.matcher(currentline);
            while(m.find()){
                String token = m.group(); //pega um token = palavra
                Integer freq = mapPalavras.get(token); //verifica se esse token já está no mapa
                if (freq != null) { //se palavra existe
                    mapPalavras.put(token, freq+1);
                }else{
                    mapPalavras.put(token,1);
                }
            }
            currentline = reader.readLine();
        }
        reader.close();        
        return mapPalavras;
    }
}
