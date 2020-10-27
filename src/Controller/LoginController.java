package Controller;

import DAO.Conexao;
import DAO.LoginDAO;
import Model.Login;
import View.JFHome;
import View.JFLogin;
import View.JFVagas;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nick_
 */
public class LoginController {
    private JFLogin view;

    public LoginController(JFLogin view) {
        this.view = view;
    }

    //Função que confere se o login está cadastrado no banco - OK
    public void autenticar() {
        String usuario = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
        
        Login login = new Login(usuario, senha);

        if(usuario.equals("") || senha.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            try {
                Connection conexao = new Conexao().getConnection();
                LoginDAO ldao = new LoginDAO(conexao);

                boolean autentico = ldao.autenticacao(login); 

                if(autentico) {
                    if(usuario.equals("adm")){
                        JFLogin l = new JFLogin();
                        l.dispose();
                        JFVagas v = new JFVagas();
                        v.setVisible(true);
                    } else {
                        JFLogin l = new JFLogin();
                        l.dispose();
                        JFHome h = new JFHome();
                        h.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(view,"Login inválido!");
                    JFLogin l = new JFLogin();
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(view,"Erro!" + ex);
            }
        }
    }
}