package br.edu.femass.gui.GuiCadastro;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiAutor {
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtNacionalidade;

    private JButton btnSalvar;
    private JPanel jPanel;
    private JList lstAutores;
    //private JList lstAutores;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiAutor() {

        updateList();
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                Autor autor = new Autor(txtNome.getText(),txtSobrenome.getText(),txtNacionalidade.getText());
                new DaoAutor().save(autor);
                updateList();
                JOptionPane.showMessageDialog(null,"Autor registrado com sucesso");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
        lstAutores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) lstAutores.getSelectedValue();
                if (autor == null) return;
                txtNome.setText(autor.getNome());
                txtSobrenome.setText(autor.getSobrenome());
                txtNacionalidade.setText(autor.getNacionalidade());
            }
        });
    }

    private void updateList() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            lstAutores.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        GuiAutor guiAutor = new GuiAutor();

        JFrame frame = new JFrame();
        frame.setContentPane(guiAutor.jPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
    }

}
