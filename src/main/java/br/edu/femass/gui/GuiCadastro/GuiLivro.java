package br.edu.femass.gui.GuiCadastro;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiLivro {
    private JTextField txtTitulo;
    private JPanel jPanel;

    public JPanel getjPanel() {
        return jPanel;
    }

    private JButton btnSalvar;
    private JList lstAutor;
    private JButton cadastrarAutorButton;
    private JTextField txtAno;

    public GuiLivro() {
        updateList();
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = new Livro(txtTitulo.getText(), lstAutor.getSelectedValuesList(),txtAno.getText());
                    new DaoLivro().save(livro);
                    updateList();
                    JOptionPane.showMessageDialog(null, "Livro registrado com sucesso");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        cadastrarAutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog frame = new JDialog(new Frame(),true);
                GuiAutor guiAutor = new GuiAutor();
                frame.setContentPane(guiAutor.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                updateList();
            }
        });
    }
    private void updateList() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            lstAutor.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}