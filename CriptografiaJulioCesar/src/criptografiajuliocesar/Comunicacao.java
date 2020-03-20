/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografiajuliocesar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author Thais Moreira da Silva
 * E-mail: thais_moreira@hotmail.com.br
 * Github: https://github.com/thais-moreira29
 */
public class Comunicacao {
    
    public static Dados dados = new Dados();
    
    public void MetodoGetHttp(String token) throws MalformedURLException, IOException{
    
        //Variável que armazena a URL da API
        String urlToRead = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" + token;
        
        //Variável que armazena o resultado gerado pela URL da API
        StringBuilder result = new StringBuilder();
        
        //Variável URL que recebe a URL da API
        URL url = new URL(urlToRead);
        
        //Estabelecendo conexão com a API
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        //Setando o metodo da request como GET
        conn.setRequestMethod("GET");

        //Leitura a partir da conexão efetuada
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        //Variável de auxilio na leitura do resultado
        String line;
        
        //Condicional para leitura até o final do arquivo gerado, e armazenamento do resultado na variável result
        while ((line = rd.readLine()) != null) {
            result.append(line);
            
            //Chama método publico da Classe Dados passando como parametro o resultado da requisição
            dados.InsereDadosJSON(result);
        }
    }

}
