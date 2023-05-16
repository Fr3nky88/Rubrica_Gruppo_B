package it.develhope.rubrica.services;

import it.develhope.rubrica.models.Contatto;
import it.develhope.rubrica.models.Indirizzo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RubricaServicesFile implements IRubricaService {

    private final Path RUBRICA_FILE_PATH = Path.of(System.getProperty("user.home"), "Rubrica", "Rubrica.csv");

    @Override
    public void init() throws IOException {
        createDirectory();
    }

    @Override
    public List<Contatto> getContatti() throws IOException {
        List<Contatto> res = new ArrayList<>();
        List<String> listaContatti = Files.readAllLines(RUBRICA_FILE_PATH);
        for (String st : listaContatti) {
            String[] arrCont = st.split(",");
            Indirizzo indirizzo = null;
            if (arrCont.length == 8) {
                indirizzo = new Indirizzo(arrCont[3],arrCont[4],arrCont[5],arrCont[6],arrCont[7]);
            }
            Contatto cont1 = new Contatto(arrCont[0], arrCont[1], arrCont[2], indirizzo);
            res.add(cont1);
        }
        return res;
    }

    @Override
    public void salvaContatto(Contatto c) {

        String cont = c.toString1();
        String percorso = RUBRICA_FILE_PATH.toString();
        try {
            FileWriter file = new FileWriter(percorso, true);
            file.append(cont);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
