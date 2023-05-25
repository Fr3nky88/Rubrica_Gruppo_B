package it.develhope.rubrica.models;

import java.util.List;

public class Indirizzo {
    private String via;
    private String citta;
    private String numeroCivico;
    private String cap;
    private String provincia;

    public Indirizzo() {
    }

    public Indirizzo(String via, String citta, String numeroCivico, String cap, String provincia) {
        this.via = via;
        this.citta = citta;
        this.numeroCivico = numeroCivico;
        this.cap = cap;
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return via + " " + citta + " n° " + numeroCivico + " " + cap + " (" + provincia+")";
    }
    public String toString1() {
        return via + "," + citta + "," + numeroCivico + "," + cap + ","+ provincia;
    }
}
