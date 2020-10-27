package Controller;

import DAO.Conexao;
import DAO.LoginDAO;
import Model.Login;
import View.JFLoginCadastro;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nick_
 */
public class LoginCadastroController {
    private JFLoginCadastro view;
    
    public LoginCadastroController(JFLoginCadastro view) {
        this.view = view;
    }
    
    //Função para cadastrar um login - OK
    public void cadastrarLogin() {
        String usuario = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
        
        Login l = new Login(usuario, senha);
        
        if(usuario.equals("") || senha.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            try {
                Connection conexao = new Conexao().getConnection();
                LoginDAO ldao = new LoginDAO(conexao);
                ldao.cadastrarLogin(l);
                JOptionPane.showMessageDialog(null, "Login cadastrado com sucesso!");
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar login!" + ex);
            }
        }
    }
}