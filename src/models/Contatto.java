package Rubrica_Gruppo_B.src.models;

public class Contatto {
    private String nome;
    private String cognome;
    private String telefono;
    private Indirizzo indirizzo;

    public Contatto() {
    }

    public Contatto(String nome, String cognome, String telefono, Indirizzo indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
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

    public Indirizzo getIndirizzo() {
        return indirizzo;
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

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        if (indirizzo == null) {
            return "\n☻ "+nome + " " + cognome + "\n☎ " + telefono + "\n";
        }
        return "\n☻ "+nome + " " + cognome + "\n☎ " + telefono + "\n☗ " + indirizzo;
    }
}
