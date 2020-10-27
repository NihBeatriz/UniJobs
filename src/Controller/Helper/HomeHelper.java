package Controller.Helper;

import Model.Vagas;
import View.JFHome;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nick_
 */
public class HomeHelper {
    private final JFHome view;
    
    public HomeHelper(JFHome view) {
        this.view = view;
    }
    
    //Função para preencher a tabela com os dados do banco
    public void preencherTabela(ArrayList<Vagas> vagas) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTbVagas().getModel();
        tableModel.setNumRows(0);
        
        vagas.forEach(vaga -> {
            tableModel.addRow(new Object[]{
                vaga.getCodigo(),
                vaga.getTitulo(),
                vaga.getDescricao(),
                vaga.getEmpresa(),
                vaga.getArea(),
                vaga.getNumVagas(),
                vaga.getLocalizacao(),
                vaga.getTelefone(),
                vaga.getEmail()
            });
        });
    }
}
