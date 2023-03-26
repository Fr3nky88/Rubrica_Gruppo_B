package Rubrica_Gruppo_B.src;

import Rubrica_Gruppo_B.src.models.Contatto;
import Rubrica_Gruppo_B.src.models.Indirizzo;
import Rubrica_Gruppo_B.src.models.Province;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Scrivi un programma Java che simuli una rubrica. L'utente deve essere in grado di aggiungere, cercare, visualizzare e cancellare contatti dalla rubrica.
 */
public class Rubrica {

    public static void main(String[] args) {
        List<Contatto> rubrica = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Province soloPerImport = new Province();


        boolean running = true;

        while (running) {
            System.out.println("Seleziona un'operazione:");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Cerca contatto");
            System.out.println("3. Visualizza tutti i contatti");
            System.out.println("4. Cancella contatto");
            System.out.println("0. Esci");

            int scelta = input.nextInt();
            // next line vuoto necessario se no fa partire subito l'inserimento del cognome saltando il nome;
            input.nextLine();

            switch (scelta) {
                case 1: // Aggiungi contatto;

                    // modificato next() con nextLine() per permettere d'inserire il secondo nome
                    // o anche per evitare l'errore scrivendo il numero con degli spazi (.trim() non funziona con lo scanner);
                    Contatto c1 = new Contatto();
                    System.out.println("Inserisci il NOTO: ");
                    String nome1 = input.nextLine();
                    c1.setNome(nome1);

                    System.out.println("Inserisci il COGNOME: ");
                    String cognome1 = input.nextLine();
                    c1.setCognome(cognome1);

                    System.out.println("Inserisci il NUMERO di TELEFONO: ");
                    String numero1 = input.nextLine();
                    c1.setTelefono(numero1);

                    System.out.println("Vuoi aggiungere anche L'INDIRIZZO?");
                    System.out.println("Premi 1: SI");
                    System.out.println("Premi 2: NO");
                    String scelta1 = input.next();
                    if (scelta1.equals("1")) {

                        Indirizzo ind1 = aggiungiIndirizzo(input);
                        c1.setIndirizzo(ind1);
                        System.out.println("Contatto importato: " + c1);
                        rubrica.add(c1);
                        break;
                    }

                    if (scelta1.equals("2")) {
                        System.out.println("Contatto importato: " + c1);
                        rubrica.add(c1);
                        break;
                    }


                case 2: // Cerca contatto;

                    System.out.println("Inserisci il NOME o il COGNOME o il NUMERO del contatto da cercare: ");
                    String cont1 = input.nextLine();

                    for (Contatto contatto1 : rubrica) {
                        if (cont1.equals(contatto1.getNome())
                                || cont1.equals(contatto1.getCognome())
                                || cont1.equals(contatto1.getTelefono())) {
                            System.out.println("Il contatto: " + cont1 + " è:\n" + contatto1);
                        }
                    }
                    break;

                case 3: // Visualizza tutti i contatti;

                    int i = 1;
                    for (Contatto contatto1 : rubrica) {
                        System.out.println("Contatto n° " + i + ", " + contatto1);
                        i++;
                    }
                    break;

                case 4: // Cancella contatto;

                    System.out.println("Seleziona il contatto da cancellare");
                    int j = 1;
                    for (Contatto contatto1 : rubrica) {
                        System.out.println("Contatto n° " + j + ", " + contatto1);
                        j++;
                    }

                    int select = input.nextInt();
                    int k = 1;
                    for (Contatto contatto1 : rubrica) {
                        if (select == k) {
                            rubrica.remove(contatto1);
                            System.out.println("Contatto " + contatto1 + " è stato rimosso");
                        }
                        k++;
                    }
                    break;

                case 0: // Esci
                    running = false;
                    System.out.println("Grazie per aver utilizzato la nostra rubrica!");
                    break;

                default: // messaggio di errore
                    System.out.println("Errore! non hai selezionato una voce del menu valida!");
            }
        }
    }

    /**
     * Metodo che permette di aggiungere un
     * indirizzo al contatto
     *
     * @param input
     */
    public static Indirizzo aggiungiIndirizzo(Scanner input) {

        Indirizzo ind1 = new Indirizzo();
        // next line vuoto necessario se no fa partire subito l'inserimento della città saltando la via;
        input.nextLine();
        //via
        System.out.println("Inserisci la VIA");
        ind1.setVia(input.nextLine());
        // città
        System.out.println("Inserisci la CITTÀ");
        ind1.setCitta(input.nextLine());
        // n° civico
        System.out.println("Inserisci il NUNERO CIVICO");
        ind1.setNumeroCivico(input.nextLine());
        // CAP
        System.out.println("Inserisci il CAP");
        ind1.setCap(input.nextLine());
        // provincia proveniente da una classe
        System.out.println("Inserisci il numero corrispondente alla PROVINCIA");
        int n = 1;
        for (int i = 0; i < ind1.getTutteProvince().size(); i++) {
            System.out.println(n + " " + ind1.getTutteProvince().get(i));
            n++;
        }

        int seleProv = input.nextInt();
        for (int i = 0; i < ind1.getTutteProvince().size(); i++) {
            if (seleProv == (i + 1)) {
                ind1.setProScelta(ind1.getTutteProvince().get(i));
            }
        }


        return ind1;
    }
}


/**
 * Classe che rappresenta il contatto nella nostra rubrica
 */

