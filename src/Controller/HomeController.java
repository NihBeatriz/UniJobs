package Controller;

import Controller.Helper.HomeHelper;
import DAO.Conexao;
import DAO.VagasDAO;
import Model.Vagas;
import View.JFHome;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nick_
 */
public class HomeController {
    private JFHome view;
    private HomeHelper tabela;

    public HomeController(JFHome view) {
        this.view = view;
        this.tabela = new HomeHelper(view);
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