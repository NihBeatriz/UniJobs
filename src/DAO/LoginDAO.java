package DAO;

import Model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nick_
 */
public class LoginDAO {
    private final Connection connection;
    
    public LoginDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void cadastrarLogin(Login l) throws SQLException {
        String sql = "INSERT INTO login(usuario, senha)" 
                   + "VALUES('"+l.getUsuario()+"', '"+l.getSenha()+"')";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.execute();
    } 

    public boolean autenticacao(Login l) throws SQLException {
        String sql = "SELECT * FROM login WHERE usuario = '"+l.getUsuario()+"' AND senha = '"+l.getSenha()+"'"; 
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.execute();
        ResultSet resultSet = pstm.getResultSet();
        return resultSet.next();
    }
}