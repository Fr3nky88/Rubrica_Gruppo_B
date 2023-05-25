package it.develhope.rubrica.dao;

import it.develhope.rubrica.models.Contatto;

import java.util.List;

public interface IContattoDao {
    public List<Contatto> getAllContatto();
    public Contatto getContatto(Integer id);
    public void salvaContatto(Contatto c);
    public void deleteContatto(Integer id);
}
