package br.edu.femass.gui.GuiConsulta;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.model.Exemplar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiConsultarExemplar {
    private JList lstExemplares;
    private JPanel jPanel;
    private JButton btnAtualizar;
    private JTextField txtCodigo;
    private JTextField txtLivro;
    private JTextField txtData;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiConsultarExemplar() {
        updateList();
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateList();
            }
        });
        lstExemplares.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Exemplar exemplar = (Exemplar) lstExemplares.getSelectedValue();
                txtCodigo.setText(exemplar.getCodigo().toString());
                txtLivro.setText(exemplar.getLivro().toString());
                txtData.setText(exemplar.getDataAquisicao().toString());
            }
        });
    }

    private void updateList() {
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            lstExemplares.setListData(exemplares.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
