package com.gabriel;

import java.io.IOException;
import java.util.*;
import java.io.IOException;

import static java.lang.System.exit;

public class Main {

    public static int verifyChar( String chave_in, String chave_cor )
    {
        char c = chave_in.charAt(0);

        for ( int i = 0; i < chave_cor.length(); i++)
        {
            if ( chave_cor.charAt(i) == c )
            {
                return i;
            }
        }

        return 10;
    }

    public static String pegarDica( String senha )
    {
        switch (senha)
        {
            case "chave":
                return ("Sua dica é: 'É impossível entrar na sua casa sem'");

            case "lapis":
                return ("Sua dica é: 'É proibido de usar na prova do ENEM.'");

            default:
                System.out.println("Sua dica é: É proibido de usar na prova do ENEM.");
                break;
        }

        return "1";
    }


    //|-----|
    //|    \o/
    //|     |
    //|     /\

    public static void main(String[] args) throws IOException {

        String[] arr = {};
        List<String> listID = new ArrayList<>(Arrays.asList(arr));

        String[] perguntas = { "O que você usa para abrir sua casa?", "O que você usa para escrever no caderno? (que possuí grafite)" };
        String[] respostas = { "chave", "lapis" };
        boolean teste = true;
        Scanner ler = new Scanner(System.in);
        System.out.println("~ JOGO DA FORCA ~ \n\nDigite 'dica' para pegar uma das duas que você possui no total.\nBom jogo!");

        // Vars
        int acertos = 0;
        int tent = 0;
        int x = 0;
        StringBuilder encrypted = new StringBuilder("");
        String y = "10";
        // Vars

        while(teste)
        {
            tent++;

            if(tent == 1){
                for ( int i = 0; i < respostas[x].length() ; i++ ) {
                    encrypted.append("_");
                }
            }


            if( y != "10" )
            {
                encrypted.setCharAt(Integer.parseInt(y), respostas[x].charAt(Integer.parseInt(y)));
            }

            System.out.print("\nPergunta " + (x+1) + "\n\n" + perguntas[x] + "\n\nPalavra: "+ encrypted + "\n\ndigite sua letra: ");
            String resp = ler.nextLine();

            if(resp.contains("dica"))
            {
                System.out.println("\n\n"+pegarDica(respostas[x]));
                continue;
            }

            if(verifyChar(resp, respostas[x]) != 10)
            {
                System.out.println("\nVoce acertou!\nNumeros restantes de tentativas: " + (10 - tent));
                acertos++;
                y = Integer.toString((verifyChar(resp, respostas[x])));
            } else {
                System.out.println("Ops! Voce errou essa letra, so tem mais " + (10-tent) + " chances");
            }

            if(acertos == 5){

                for(int clear = 0; clear < 1000; clear++) {System.out.println("\b");}

                System.out.println("winner winner chicken dinner\n\n");

                System.out.print("\nPergunta: " + perguntas[x] + "\nResposta: "+ respostas[x]);
                System.out.print("\n\nVoce venceu a primeira rodada, parabens!\nDeseja jogar com outra palavra? [s/N] ");
                resp = ler.nextLine();
                if(resp.contains("s")){
                    acertos, 
					tent = 0;
                    x++;
                    y = "10";
                    encrypted.delete(0, respostas[x].length());
                    continue;
                }
                exit(0);
            }

            if(tent == 10)
            {
                for(int clear = 0; clear < 1000; clear++) {System.out.println("\b");}
                System.out.print("\nPergunta: " + perguntas[x] + "\nResposta: "+ respostas[x]);
                System.out.print("\n\nVoce perdeu o jogo :( ");
                exit(0);
            }

        }

    }

}
