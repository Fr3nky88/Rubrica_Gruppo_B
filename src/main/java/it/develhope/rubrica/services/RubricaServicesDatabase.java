package it.develhope.rubrica.services;

import it.develhope.rubrica.models.Contatto;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaServicesDatabase implements IRubricaService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/rubricab";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public RubricaServicesDatabase() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    }

    @Override
    public void init() {

    }

    @Override
    public List<Contatto> getContatti() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Contatto> res = new ArrayList<>();
        try {

            String query = "SELECT * FROM Contatto";

            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }

            while (rs.next()) {
                Contatto c = new Contatto();
                c.setId(BigInteger.valueOf(rs.getInt("id")));
                c.setNome(rs.getString("nome"));
                c.setCognome(rs.getString("cognome"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                res.add(c);
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

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
        return res;
    }

    @Override
    public void salvaContatto(Contatto c) {
        // TODO: sviluppare con l'insert
        // https://www.tutorialspoint.com/jdbc/jdbc-insert-records.htm

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
