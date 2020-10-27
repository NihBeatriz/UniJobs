package Model;

/**
 *
 * @author nick_
 */
public class Vagas {
    private String codigo;
    private String titulo;
    private String descricao;
    private String empresa;
    private String area;
    private String numVagas;
    private String localizacao;
    private String telefone;
    private String email;

    public Vagas() {
    }

    public Vagas(String codigo, String titulo, String descricao, String empresa, String area, String numVagas, String localizacao, String telefone, String email) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.empresa = empresa;
        this.area = area;
        this.numVagas = numVagas;
        this.localizacao = localizacao;
        this.telefone = telefone;
        this.email = email;   
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(String numVagas) {
        this.numVagas = numVagas;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Vagas{" + "codigo=" + codigo + ", titulo=" + titulo + ", descricao=" + descricao + ", empresa=" + empresa + ", area=" + area + ", numVagas=" + numVagas + ", localizacao=" + localizacao + ", telefone=" + telefone + ", email=" + email + '}';
    }
}