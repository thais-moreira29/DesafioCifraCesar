/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografiajuliocesar;

import static criptografiajuliocesar.Comunicacao.dados;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Thais Moreira da Silva
 * E-mail: thais_moreira@hotmail.com.br
 * Github: https://github.com/thais-moreira29
 */

public class CriptografiaJulioCesar {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        
        //Instanciando as classes que serão utilizadas para resolver o desafio
        Comunicacao comunica = new Comunicacao();
        Descriptografia desc = new Descriptografia();
        Scanner sc = new Scanner(System.in);
        
        //Variáveis que serão setadas pelo usuário durante a execução do programa
        String caminhoArquivo;
        String token;

        System.out.print("Digite aqui o seu token: ");
        token = sc.next();
        
        //Chamada do método de comunicação entre o programa e a API
        comunica.MetodoGetHttp(token);
        
        //Chamada do método que decifra o texto cifrado enviado pela API
        desc.Decifra(dados.cifrado, dados.numero_casas);
        
        //Mostrando ao usuário o resultado esperado
        System.out.println("O seu texto cifrado é: " + dados.cifrado);
        System.out.println("A chave utilizada para descriptografar é: " + dados.numero_casas);
        System.out.println("O seu texto decifrado é: " + dados.decifrado);
        
        //Chamada do método que gera um resumo criptografico em criptografia HASH SHA-1
        desc.ResumoCriptografiaSHA1(dados.decifrado);
        
        //Mostrando ao usuário o resultado esperado da criptografia
        System.out.println("O resumo criptografico do seu texto decifrado é: " + dados.resumo_criptografico);
        
        //Solicita o caminho em que deve ser salvo o arquivo resposta
        //O caminho deve ser nessa estrutura: \caminho\do\arquivo\, caso contrario não funcionará.
        //Cuidado com a manipulação das barras dependendo do sistema operacional e linguagem que estiver usando
        System.out.print("Digite aqui o caminho da pasta onde você deseja armazenar seu arquivo de resposta: ");
        caminhoArquivo = sc.next();
        
        //Chamada do metodo que salva o arquivo resposta
        dados.SalvaArquivoJSON(caminhoArquivo);
        
        //Mensagem final ao usuário
        System.out.println("Pronto! Agora é só submeter o seu desafio na API via POSTMAN!");

    }

    
 
}

