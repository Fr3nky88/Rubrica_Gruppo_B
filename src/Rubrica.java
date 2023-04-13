package Rubrica_Gruppo_B.src;

import Rubrica_Gruppo_B.src.models.Contatto;
import Rubrica_Gruppo_B.src.models.Indirizzo;
import Rubrica_Gruppo_B.src.models.ListaContatti;
import Rubrica_Gruppo_B.src.models.Province;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
public class Rubrica {
    private final Path RUBRICA_FILE_PATH = Path.of(System.getProperty("user.home"), "Rubrica", "Rubrica.csv");
    private ListaContatti rubrica;

    public Rubrica() throws IOException {
        this.rubrica = new ListaContatti();
        createDirectory();
        caricaContatti();
    }

    /**
     * Metodo che permette la scrittura del contatto nel file csv
     */
    public void salvaContatto(Contatto contatto) {
        String cont = contatto.toString1();
        String percorso = RUBRICA_FILE_PATH.toString();
        try {
            FileWriter file = new FileWriter(percorso, true);
            file.append(cont);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void caricaContatti() throws IOException {
        List<String> listaContatti = Files.readAllLines(RUBRICA_FILE_PATH);
        for (String st : listaContatti) {
            String[] arrCont = st.split(",");
            Indirizzo indirizzo = null;
            if (arrCont.length == 8) {
                indirizzo = new Indirizzo(arrCont[3],arrCont[4],arrCont[5],arrCont[6],arrCont[7]);
            }
            Contatto cont1 = new Contatto(arrCont[0], arrCont[1], arrCont[2], indirizzo);
            rubrica.add(cont1);
        }

    }

    /**
     * Metodo che permette di aggiungere un
     * indirizzo al contatto
     *
     * @param input
     */
    public Indirizzo aggiungiIndirizzo(Scanner input) {

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
        for (int i = 0; i < Province.getProvince().size(); i++) {
            System.out.println(n + " " + Province.getProvince().get(i));
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

    /**
     * Avvio della rubrica
     */
    public void start() {
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
                    System.out.println("Inserisci il NOME: ");
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
                        salvaContatto(c1);
                        break;
                    }

                    if (scelta1.equals("2")) {
                        System.out.println("Contatto importato: " + c1);
                        rubrica.add(c1);
                        salvaContatto(c1);
                        break;
                    }


                case 2: // Cerca contatto;

                    System.out.println("Inserisci il NOME o il COGNOME o il NUMERO del contatto da cercare: ");
                    String cont1 = input.nextLine();

                    for (Contatto contatto1 : rubrica) {
                        if (cont1.toLowerCase().equals(contatto1.getNome().toLowerCase())
                                || cont1.toLowerCase().equals(contatto1.getCognome().toLowerCase())
                                || cont1.toLowerCase().equals(contatto1.getTelefono().toLowerCase())) {
                            System.out.println("Il contatto: " + cont1 + " è:\n" + contatto1);
                        }
                    }
                    break;

                case 3: // Visualizza tutti i contatti;

                    int i = 1;
                    for (Contatto contatto1 : rubrica) {
                        System.out.println("Contatto n° " + i + ", " + contatto1 + "\n");
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
     * Metodo che permetta la creazione della directory e del file che serve
     *
     * @throws IOException
     */
    private void createDirectory() throws IOException {

        String userHome = System.getProperty("user.home");

        // creazione cartella
        try {
            Files.createDirectory(Path.of(userHome, "Rubrica"));
        } catch (FileAlreadyExistsException e) {
        }

        // creazione file
        try {
            Files.createFile(RUBRICA_FILE_PATH);
        } catch (FileAlreadyExistsException e) {
        }

    }
}
