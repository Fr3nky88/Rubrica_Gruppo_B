package it.develhope.rubrica.models;



import it.develhope.rubrica.IListaOrdinata;

import java.util.*;

public class ListaContatti implements IListaOrdinata, Iterable<Contatto> {
    private List<Contatto> listaFinal;
    private Comparator<Contatto> comparator;

    public ListaContatti() {
        this.listaFinal = new ArrayList<>();
        this.comparator = new Comparator<Contatto>() {
            @Override
            public int compare(Contatto o1, Contatto o2) {
                if (o1.getCognome().equals(o2.getCognome())) {
                    return 0;
                }
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.getCognome().compareTo(o2.getCognome());
            }
        };
    }

    @Override

    public Integer lunghezza() {
        return listaFinal.size();
    }

    @Override
    public void add(Contatto contatto) {
        listaFinal.add(contatto);
        listaFinal.sort(comparator);
    }

    @Override
    public void remove(Contatto contatto) {
        listaFinal.remove(contatto);
        listaFinal.sort(comparator);
    }

    @Override
    public void addAll(List<Contatto> contatti) {
        listaFinal.addAll(contatti);
    }


    @Override
    public Iterator<Contatto> iterator() {
        return listaFinal.iterator();
    }


    @Override
    public Contatto find(String cont1) {
        for (Contatto contatto1 : listaFinal) {
            if (cont1.toLowerCase().equals(contatto1.getNome().toLowerCase())
                    || cont1.toLowerCase().equals(contatto1.getCognome().toLowerCase())
                    || cont1.toLowerCase().equals(contatto1.getTelefono().toLowerCase())) {
                return contatto1;
            }
        }
        return null;
    }
}
