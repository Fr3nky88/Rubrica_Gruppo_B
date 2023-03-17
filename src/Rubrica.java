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
                    System.out.println("Inserisci il nome: ");
                    String nome1 = input.nextLine();
                    c1.setNome(nome1);
                    System.out.println("Inserisci il cognome: ");
                    String cognome1 = input.nextLine();
                    c1.setCognome(cognome1);
                    System.out.println("Inserisci il numero di telefono: ");
                    String numero1 = input.nextLine();
                    c1.setTelefono(numero1);
                    System.out.println("Contatto importato: " + c1);
                    rubrica.add(c1);
                    break;

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
}

/**
 * Classe che reappresenta il contatto nella nostra rubrica
 */
class Contatto {
    private String nome;
    private String cognome;
    private String telefono;

    public Contatto() {
    }

    public Contatto(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo che imposta il nome del contatto
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
        return nome + " " + cognome + ": " + telefono;
    }

}
