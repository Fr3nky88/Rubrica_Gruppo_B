package it.develhope.rubrica.services;

import it.develhope.rubrica.models.Contatto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface IRubricaService {

    public void createDatabase();

    public void init() throws Exception;

    public List<Contatto> getContatti() throws Exception;

    public void salvaContatto(Contatto c);

    public void visualizzaContatto(Integer i) throws Exception;

}
