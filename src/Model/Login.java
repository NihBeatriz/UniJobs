package Model;

/**
 *
 * @author nick_
 */
public class Login {
    private String usuario;
    private String senha;
    
    public Login() {
    }
    
    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login{" + "usuario=" + usuario + ", senha=" + senha + '}';
    }
}