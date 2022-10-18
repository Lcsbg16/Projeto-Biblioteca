package br.edu.femass.gui.GuiCadastro;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class GuiDevolucao {
    private JList lstEmprestimo;
    private JTextField txtDataEmprestimo;
    private JTextField txtDataDevolucao;
    private JPanel jPanel;
    private JButton btnDevolver;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiDevolucao() {
        updateList();
        lstEmprestimo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Emprestimo emprestimo = (Emprestimo) lstEmprestimo.getSelectedValue();
                txtDataEmprestimo.setText(emprestimo.getDataEmprestimo().toString());
                txtDataDevolucao.setText(emprestimo.getDataPrevistaDevolucao().toString());
            }
        });
    }

    private void updateList() {
        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            lstEmprestimo.setListData(emprestimos.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
