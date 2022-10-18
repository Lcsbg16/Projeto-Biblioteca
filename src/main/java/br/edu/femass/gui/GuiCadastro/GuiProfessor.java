package br.edu.femass.gui.GuiCadastro;

import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class GuiProfessor {
    private JPanel jPanel;



    public JPanel getjPanel() {
        return jPanel;
    }

    private JTextField txtNome;
    private JTextField txtDisciplina;
    private JTextField txtEndereco;

    private JButton btnSalvar;
    private JFormattedTextField txtTelefone;
    private JList lstProfessores;
    private JTextField txtCodigo;

    public GuiProfessor() {
        updateList();
        try {
            MaskFormatter mascara = new MaskFormatter("(##) ####-####");
            mascara.install(txtTelefone);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Professor professor = new Professor(txtNome.getText(),txtEndereco.getText(),txtTelefone.getText(),txtDisciplina.getText());
                    new DaoProfessor().save(professor);
                    new DaoLeitor().save(professor);
                    updateList();
                    JOptionPane.showMessageDialog(null,"Professor registrado com sucesso");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        lstProfessores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Professor professor = (Professor) lstProfessores.getSelectedValue();
                if (professor == null) return;
                txtCodigo.setText(professor.getCodigo().toString());
                txtNome.setText(professor.getNome());
                txtTelefone.setText(professor.getTelefone());
                txtEndereco.setText(professor.getEndereco());
                txtDisciplina.setText(professor.getDisciplina());
            }
        });
    }

    private void updateList() {
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            lstProfessores.setListData(professores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}


