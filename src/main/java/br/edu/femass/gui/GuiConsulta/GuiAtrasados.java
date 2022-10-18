package br.edu.femass.gui.GuiConsulta;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Emprestimo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.time.LocalDate;
import java.util.*;

public class GuiAtrasados {
    private JList lstAtrasados;
    private JTextField txtNome;
    private JTextField txtExemplar;
    private JTextField txtDataEmprestimo;
    private JTextField txtDataPrevista;
    private JPanel jPanel;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiAtrasados() {
        updateList();
        lstAtrasados.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Emprestimo atrasado = (Emprestimo) lstAtrasados.getSelectedValue();
                txtNome.setText(atrasado.getLeitor().getCodigo()+" "+atrasado.getLeitor().getNome());
                txtExemplar.setText(atrasado.getExemplar().toString());
                txtDataEmprestimo.setText(atrasado.getDataEmprestimo().toString());
                txtDataPrevista.setText(atrasado.getDataPrevistaDevolucao().toString());
                //txtAtraso.setText(LocalDate.now().toString());
            }
        });
    }

    private void updateList() {
        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            ArrayList<Emprestimo> atrasados = new ArrayList<>();
            for (Emprestimo emprestimo: emprestimos){
                if(emprestimo.getDataPrevistaDevolucao().isBefore(LocalDate.now())){
                    atrasados.add(emprestimo);
                }

            }
            lstAtrasados.setListData(atrasados.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        GuiAtrasados guiAtrasados = new GuiAtrasados();
        JFrame frame = new JFrame("Tela Atrasados");
        frame.setContentPane(guiAtrasados.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tela Inicial");
        frame.pack();
        frame.setVisible(true);
    }
}
