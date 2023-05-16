package it.develhope.rubrica;

import it.develhope.rubrica.models.Contatto;

import java.util.Iterator;
import java.util.List;

public interface IListaOrdinata {

    public Integer lunghezza();

    public void add(Contatto contatto);

    public void remove(Contatto contatto);
    public void addAll(List<Contatto> contatti);

    public Iterator<Contatto> iterator();

    public Contatto find(String str);
}
