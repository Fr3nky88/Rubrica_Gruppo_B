package it.develhope.rubrica.services;

import it.develhope.rubrica.models.Contatto;

import java.io.IOException;
import java.util.List;

public interface IRubricaService {

    public void init() throws Exception;

    public List<Contatto> getContatti() throws Exception;

    public void salvaContatto(Contatto c);

}
