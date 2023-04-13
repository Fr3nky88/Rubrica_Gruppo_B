package Rubrica_Gruppo_B.src.models;

import java.util.List;

public class Indirizzo {
    private String via;
    private String citta;
    private String numeroCivico;
    private String cap;
    private List<String> tutteProvince = Province.getProvince();
    private String proScelta;


    public Indirizzo() {
    }

    public Indirizzo(String via, String citta, String numeroCivico, String cap, String proScelta) {
        this.via = via;
        this.citta = citta;
        this.numeroCivico = numeroCivico;
        this.cap = cap;
        this.proScelta = proScelta;
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

    public List<String> getTutteProvince() {
        return tutteProvince;
    }

    public void setTutteProvince(List<String> tutteProvince) {
        this.tutteProvince = tutteProvince;
    }

    public String getProScelta() {
        return proScelta;
    }

    public void setProScelta(String proScelta) {
        this.proScelta = proScelta;
    }

    @Override
    public String toString() {
        return via + " " + citta + " n° " + numeroCivico + " " + cap + " (" + proScelta+")";
    }
    public String toString1() {
        return via + "," + citta + "," + numeroCivico + "," + cap + ","+ proScelta;
    }
}
