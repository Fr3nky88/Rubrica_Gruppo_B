package it.develhope.rubrica.dao;

import it.develhope.rubrica.models.Contatto;
import it.develhope.rubrica.models.Indirizzo;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContattoDao implements IContattoDao{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/rubricab";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "salvopelle88";
    public ContattoDao() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    }

    @Override
    public List<Contatto> getAllContatto() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Contatto> res = new ArrayList<>();
        try {

            String query = "SELECT * FROM Contatto c LEFT JOIN indirizzo i on c.id = i.id";

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }

            while (rs.next()) {
                Contatto c = new Contatto();

                c.setId(BigInteger.valueOf(rs.getInt(1)));
                c.setNome(rs.getString("nome"));
                c.setCognome(rs.getString("cognome"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                if (rs.getBigDecimal(6) != null) {
                    Indirizzo i = new Indirizzo();
                    i.setId(BigInteger.valueOf(rs.getInt(6)));
                    i.setVia(rs.getString("via"));
                    i.setNumeroCivico(rs.getString("numero_civico"));
                    i.setCitta(rs.getString("citta"));
                    i.setCap(rs.getString("cap"));
                    i.setProvincia(rs.getString("provincia"));
                    c.setIndirizzo(i);
                }
                res.add(c);
            }
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {


            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) { } // ignore

                conn = null;
            }
        }
        return res;    }

    @Override
    public Contatto getContatto(Integer id) {
        return null;
    }

    @Override
    public void salvaContatto(Contatto c) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();

            String sql = "INSERT INTO Contatto " +
                    "(nome, cognome, telefono, email)" +
                    "VALUES(?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, c.getNome());
            preparedStatement.setString(2, c.getCognome());
            preparedStatement.setString(3, c.getTelefono());
            preparedStatement.setString(4, c.getEmail());

            int numRigheAggiornate = preparedStatement.executeUpdate();


            // Now do something with the ResultSet ....
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ex.printStackTrace();
        }
        finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {

                } // ignore

                stmt = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) { } // ignore

                conn = null;
            }

        }

    }

    @Override
    public void deleteContatto(Integer id) {

    }
}
