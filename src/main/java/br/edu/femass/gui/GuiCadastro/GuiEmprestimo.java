package br.edu.femass.gui.GuiCadastro;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiEmprestimo {
    private JPanel jPanel;

    private JButton btnEmprestimo;
    private JList lstExemplar;
    private JList lstLeitor;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiEmprestimo() {
        updateList();
        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Emprestimo emprestimo = new Emprestimo((Exemplar) lstExemplar.getSelectedValue(), (Leitor) lstLeitor.getSelectedValue());
                    new DaoEmprestimo().save(emprestimo);
                    updateList();
                    JOptionPane.showMessageDialog(null, "Emprestimo Realizado!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
    }

    private void updateList() {
        try {
            List<Leitor> leitores = new DaoLeitor().getAll();
            lstLeitor.setListData(leitores.toArray());

            List<Exemplar> exemplares = new DaoExemplar().getAll();
            lstExemplar.setListData(exemplares.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





}
