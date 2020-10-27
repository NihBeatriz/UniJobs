package DAO;

import Model.Vagas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nick_
 */
public class HomeDAO {
    private final Connection connection;
    
    public HomeDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void pesquisarVagas(Vagas v) throws SQLException {
        String sql = "SELECT FROM vagas WHERE codigo = ?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, v.getCodigo());
        pstm.executeQuery();
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            v.setArea(rs.getString("area"));
            v.setCodigo(rs.getString("codigo"));
            v.setDescricao(rs.getString("descricao"));
            v.setEmail(rs.getString("email"));
            v.setEmpresa(rs.getString("empresa"));
            v.setLocalizacao(rs.getString("localizacao"));
            v.setNumVagas(rs.getString("numVagas"));
            v.setTelefone(rs.getString("telefone"));
            v.setTitulo(rs.getString("titulo"));
        }
        
        rs.close();
        pstm.close();
        connection.close();
    }
}