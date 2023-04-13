package Rubrica_Gruppo_B.src;


import java.io.IOException;

/**
 * Scrivi un programma Java che simuli una rubrica. L'utente deve essere in grado di aggiungere, cercare, visualizzare e cancellare contatti dalla rubrica.
 */
public class Main {

    public static void main(String[] args) {

        try {
            Rubrica rubrica = new Rubrica();
            rubrica.start();
        }catch (IOException e){
            System.out.println("Non posso scrivere sul disco!!");
            System.exit(0);
        }catch (Exception e){
            System.err.println("ERRORE Generico");
            e.printStackTrace(); // riepilogo degli errori
            System.exit(0);
        }

    }
}

