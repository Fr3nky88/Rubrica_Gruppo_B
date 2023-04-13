package Rubrica_Gruppo_B.src;

import Rubrica_Gruppo_B.src.models.Contatto;

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
