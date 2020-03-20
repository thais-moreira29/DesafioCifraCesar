/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografiajuliocesar;

import static criptografiajuliocesar.Comunicacao.dados;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Thais Moreira da Silva
 * E-mail: thais_moreira@hotmail.com.br
 * Github: https://github.com/thais-moreira29
 */

public class Descriptografia {
    
    //Método publico statico que retorna uma String e recebe um parametro char e um parametro int
    public static String MetodoDecifra(char[] texto, int chave){
        
        //Variáveis de manipulação para decifrar o texto recebido
        String codigo="";
        int i, j;
        
        //Variável de vetor char que converte o alfabeto em um vetor
        char[] alfabeto="abcdefghijklmnopqrstuvwxyz".toCharArray(); 
        
        //Loop que percorre cada palavra do texto
        for(i=0; i<texto.length;i++)
        { 
            //Loop que percorre o alfabeto
            for(j=0; j<alfabeto.length;j++)
            { 
                //Condicional que compara letra atual da palavra com a atual do texto
                if(alfabeto[j]==texto[i])
                { 
                    //Condicional em que se o valor vetorial do alfabeto subtraido pela chave for menor que zero
                    if(j-chave<0)
                    {
                        //Realiza troca de letra
                        texto[i]=alfabeto[j-chave+26];     
                    }
                    
                    //Caso contrário
                    else
                    {   
                        //Realiza troca de letra           
                        texto[i]=alfabeto[j-chave];
                    }
                    
                    //Reinicia o alfabeto
                    j=0; 
                    
                    break;
                }

            }
            
            //Concatena letra para retornar valor
            codigo+=texto[i]; 

        }
        
        //Retorna o resultado decifrado
        return codigo;
    }
    
    //Método publico sem retorno que faz a chamada do método anterior, recebendo o texto a ser decifrado e a chave para decifrar
    public void Decifra (String texto, int chave){
        
        //Variáveis Locais de manipulação
        char[] textoCifrado;
        int key=0;
        
        textoCifrado = texto.toCharArray();
        key = chave;

        //Váriavel de manipulação do JSON recebe o texto decifrado
        dados.decifrado = MetodoDecifra(textoCifrado, key);
        
    }
    
    //Método publico sem retorno que recebe o texto decifrado e faz a criptografia SHA1
    public void ResumoCriptografiaSHA1(String textoDecifrado) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
        //Setando o tipo de criptografia para realizar o resumo
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(textoDecifrado.getBytes("utf8"));
        
        //Armazenando o resumo criptografico na variável de manipulação do JSON
        dados.resumo_criptografico = String.format("%040x", new BigInteger(1, digest.digest()));
        
    
    }
    
    
}
