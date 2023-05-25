package it.develhope.rubrica.services;

import it.develhope.rubrica.dao.IContattoDao;
import it.develhope.rubrica.dao.ContattoDao;
import it.develhope.rubrica.models.Contatto;

import java.sql.*;
import java.util.List;

public class RubricaServicesDatabase implements IRubricaService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/rubricab";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private IContattoDao contattoDao;
    public RubricaServicesDatabase() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        this.contattoDao = new ContattoDao();
    }



    @Override
    public void init() {

    }

    @Override
    public List<Contatto> getContatti() {
        return this.contattoDao.getAllContatto();
    }

    @Override
    public void salvaContatto(Contatto c) {
        this.contattoDao.salvaContatto(c);

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
