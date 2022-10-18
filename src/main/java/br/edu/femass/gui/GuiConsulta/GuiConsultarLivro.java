package br.edu.femass.gui.GuiConsulta;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiConsultarLivro {
    private JList lstLivros;
    private JButton btnAtualizar;
    private JPanel jPanel;
    private JTextField txtTitulo;
    private JTextField txtAutores;
    private JTextField txtAno;
    private JTextField txtCodigo;

    public GuiConsultarLivro() {
        updateList();
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateList();
            }
        });

        lstLivros.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Livro livro = (Livro) lstLivros.getSelectedValue();
                txtCodigo.setText(livro.getCodigo().toString());
                txtTitulo.setText(livro.getTitulo());
                txtAno.setText(livro.getAno());
                txtAutores.setText(livro.getAutor().toString());

            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    private void updateList() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            lstLivros.setListData(livros.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
