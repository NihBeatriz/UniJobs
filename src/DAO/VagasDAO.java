package DAO;

import Model.Vagas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nick_
 */
public class VagasDAO {
    private final Connection connection;
    
    public VagasDAO(Connection connection) {
        this.connection = connection;
    }
    
    //Função para persistir cadastro de vagas no banco - OK
    public void cadastrarVagas(Vagas v) throws SQLException {
        String sql = "INSERT INTO vagas(codigo, titulo, descricao, empresa, area, numvagas, localizacao, telefone, email)" 
                    + "VALUES('"+v.getCodigo()+"', '"+v.getTitulo()+"', '"+v.getDescricao()+"', '"+v.getEmpresa()+"', '"+v.getArea()+"', "
                    + "'"+v.getNumVagas()+"', '"+v.getLocalizacao()+"', '"+v.getTelefone()+"', '"+v.getEmail()+"')";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.execute();
    }
    
    //Função para persistir a edição das vagas no banco - OK
    public void editarVagas(Vagas v) throws SQLException {
        String sql = "UPDATE vagas SET titulo = ?, descricao = ?, empresa = ?, area = ?, numvagas = ?, localizacao = ?, telefone = ?, email = ? "
                    + "WHERE codigo = ?"; 
                    
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, v.getTitulo());
        pstm.setString(2, v.getDescricao());
        pstm.setString(3, v.getEmpresa());
        pstm.setString(4, v.getArea());
        pstm.setString(5, v.getNumVagas());
        pstm.setString(6, v.getLocalizacao());
        pstm.setString(7, v.getTelefone());
        pstm.setString(8, v.getEmail());
        pstm.setString(9, v.getCodigo());
        pstm.execute();
    }
    
    //Função para persistir a exclusão de vagas no banco - OK
    public void excluirVagas(Vagas v) throws SQLException {
        String sql = "DELETE FROM vagas WHERE codigo = ?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, v.getCodigo());
        pstm.execute();
    }

    //Função para buscar todas as vagas no banco - OK
    public ArrayList<Vagas> buscarTodos() throws SQLException {
        String sql = ("SELECT * FROM vagas");
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pesquisa(pstm);
    }
    
    //Função para pesquisa de vagas no banco - OK
    private ArrayList<Vagas> pesquisa(PreparedStatement pstm) throws SQLException {
        ArrayList<Vagas> uList = new ArrayList<>();
        pstm.execute();
        while(pstm.getResultSet().next()){
            uList.add(new Vagas(pstm.getResultSet().getString("codigo"),
                    pstm.getResultSet().getString("titulo"),
                    pstm.getResultSet().getString("descricao"),
                    pstm.getResultSet().getString("empresa"),
                    pstm.getResultSet().getString("area"),
                    pstm.getResultSet().getString("numvagas"),
                    pstm.getResultSet().getString("localizacao"),
                    pstm.getResultSet().getString("telefone"),
                    pstm.getResultSet().getString("email")
                )
            );
        }
        return uList;
    }
}