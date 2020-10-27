package DAO;

import java.sql.*;

/**
 *
 * @author nick_
 */
public class Conexao {
    public Connection getConnection() throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/unijobs", "postgres", "2247");
        return conexao;
    }
}