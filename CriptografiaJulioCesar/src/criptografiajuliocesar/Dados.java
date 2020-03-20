/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografiajuliocesar;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author Thais Moreira da Silva
 * E-mail: thais_moreira@hotmail.com.br
 * Github: https://github.com/thais-moreira29
 */

public class Dados {

    //Variáveis publicas que manipulam o JSON
    public int numero_casas;
    public String token;
    public String cifrado;
    public String decifrado;
    public String resumo_criptografico;
    public JSONObject jsonObject;
    public FileWriter writeFile = null;

    //Construtor de classe sobrecarregado
    public Dados(int numero_casas, String token, String cifrado, String decifrado, String resumo_criptografico) {
        this.numero_casas = numero_casas;
        this.token = token;
        this.cifrado = cifrado;
        this.decifrado = decifrado;
        this.resumo_criptografico = resumo_criptografico;
    }

    //Construtor de classe vazio
    public Dados() {
        
    }

    //Método publico sem retorno, que recebe a String de resultado e armazena em um json objeto e nas variáveis locais
    public void InsereDadosJSON(StringBuilder result) throws IOException{
        jsonObject = new JSONObject(result.toString());
        numero_casas = (Integer) jsonObject.get("numero_casas");
        token = (String) jsonObject.get("token");
        cifrado = (String) jsonObject.get("cifrado");
    }
    
    //Método publico sem retorno, que recebe uma string indicando o caminho a ser salvo o arquivo manipulado, com a resposta do desafio
    public void SalvaArquivoJSON(String caminhoArquivo) throws IOException{
        
        jsonObject.put("numero_casas", numero_casas);
        jsonObject.put("token", token);
        jsonObject.put("cifrado", cifrado);
        jsonObject.put("decifrado", decifrado);
        jsonObject.put("resumo_criptografico", resumo_criptografico);
        
        writeFile = new FileWriter(caminhoArquivo + "answer.json");
        writeFile.write(jsonObject.toString());
        writeFile.flush();
        writeFile.close();
    }
    

}
