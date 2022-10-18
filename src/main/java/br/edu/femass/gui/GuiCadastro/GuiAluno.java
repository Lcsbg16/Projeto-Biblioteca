package br.edu.femass.gui.GuiCadastro;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Aluno;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class GuiAluno {
    private JPanel jPanel;

    public JPanel getjPanel() {
        return jPanel;
    }

    private JTextField txtNome;
    private JTextField txtEndereco;

    private JTextField txtMatricula;
    private JButton btnSalvar;
    private JFormattedTextField txtTelefone;
    private JList lstAlunos;
    private JTextField txtCodigo;

    public GuiAluno() {
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
                    Aluno aluno = new Aluno(txtNome.getText(),txtEndereco.getText(),txtTelefone.getText(),txtMatricula.getText());
                    new DaoAluno().save(aluno);
                    new DaoLeitor().save(aluno);
                    updateList();
                    JOptionPane.showMessageDialog(null,"Aluno registrado com sucesso");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });

        lstAlunos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Aluno aluno = (Aluno) lstAlunos.getSelectedValue();
                if (aluno == null) return;
                txtCodigo.setText(aluno.getCodigo().toString());
                txtNome.setText(aluno.getNome());
                txtTelefone.setText(aluno.getTelefone());
                txtEndereco.setText(aluno.getEndereco());
                txtMatricula.setText(aluno.getMatricula());
            }
        });
    }

    private void updateList() {
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            lstAlunos.setListData(alunos.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
