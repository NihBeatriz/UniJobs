package Controller;

import Controller.Helper.VagasHelper;
import DAO.Conexao;
import DAO.VagasDAO;
import Model.Vagas;
import View.JFVagas;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nick_
 */
public class VagasController {
    private JFVagas view;
    private VagasHelper tabela;

    public VagasController(JFVagas view) {
        this.view = view;
        this.tabela = new VagasHelper(view);
    }
    
    //Função para cadastrar vagas - OK
    public void cadastrarVagas() {
        String codigo = view.getTxtCodigo().getText();
        String titulo = view.getTxtTitulo().getText(); 
        String descricao = view.getTxtDescricao().getText();
        String empresa = view.getTxtEmpresa().getText();
        String area = view.getTxtArea().getText();
        String numVagas = view.getTxtNumVagas().getText();
        String localizacao = view.getTxtLocalizacao().getText();
        String telefone = view.getTxtTelefone().getText();
        String email = view.getTxtEmail().getText();
        
        Vagas v = new Vagas(codigo, titulo, descricao, empresa, area, numVagas, localizacao, telefone, email);
        
        if(area.equals("") || codigo.equals("") || descricao.equals("") || email.equals("") || empresa.equals("") || localizacao.equals("") || numVagas.equals("") || telefone.equals("") || titulo.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            try {
                Connection conexao = new Conexao().getConnection();
                VagasDAO vdao = new VagasDAO(conexao);
                vdao.cadastrarVagas(v);
                JOptionPane.showMessageDialog(null, "Vaga cadastrada com sucesso!");
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar vaga!" + ex);
            }
        }
    }
    
    //Função para editar vagas - OK
    public void editarVagas() {
        String codigo = view.getTxtCodigo().getText();
        String titulo = view.getTxtTitulo().getText(); 
        String descricao = view.getTxtDescricao().getText();
        String empresa = view.getTxtEmpresa().getText();
        String area = view.getTxtArea().getText();
        String numVagas = view.getTxtNumVagas().getText();
        String localizacao = view.getTxtLocalizacao().getText();
        String telefone = view.getTxtTelefone().getText();
        String email = view.getTxtEmail().getText();
        
        Vagas v = new Vagas(codigo, titulo, descricao, empresa, area, numVagas, localizacao, telefone, email);
 
        try {
            Connection conexao = new Conexao().getConnection();
            VagasDAO vdao = new VagasDAO(conexao);
            vdao.editarVagas(v);
            JOptionPane.showMessageDialog(null, "Dados da vaga editados com sucesso!");
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar dados da vaga!" + ex);
        } 
    }
    
    //Função para excluir vagas - OK
    public void excluirVagas() {
        String codigo = view.getTxtCodigo().getText();
        String titulo = view.getTxtTitulo().getText(); 
        String descricao = view.getTxtDescricao().getText();
        String empresa = view.getTxtEmpresa().getText();
        String area = view.getTxtArea().getText();
        String numVagas = view.getTxtNumVagas().getText();
        String localizacao = view.getTxtLocalizacao().getText();
        String telefone = view.getTxtTelefone().getText();
        String email = view.getTxtEmail().getText();
        
        Vagas v = new Vagas(codigo, titulo, descricao, empresa, area, numVagas, localizacao, telefone, email);
        
        try {
            Connection conexao = new Conexao().getConnection();
            VagasDAO vdao = new VagasDAO(conexao);
            vdao.excluirVagas(v);
            JOptionPane.showMessageDialog(null, "Vaga excluída com sucesso!");
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir vaga!" + ex);
        }
    }

    //Função para atualizar dados da tabela - OK
    public void atualizarTabela() throws SQLException{
        try {
            VagasDAO vdao = new VagasDAO(new Conexao().getConnection());
            ArrayList<Vagas> vagas = vdao.buscarTodos();
            tabela.preencherTabela(vagas);
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela!" + ex);
        }
    }
}