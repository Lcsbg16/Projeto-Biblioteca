package br.edu.femass.gui.GuiCadastro;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiExemplar {
    private JList lstLivros;
    private JButton btnSalvar;
    private JPanel jPanel;
    private JComboBox cboxLivro;

    public GuiExemplar() {
        updateComboBox();
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Exemplar exemplar = new Exemplar((Livro) cboxLivro.getSelectedItem());
                    new DaoExemplar().save(exemplar);
                    updateComboBox();
                    JOptionPane.showMessageDialog(null, "Exemplar cadastrado com sucesso");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    /*private void updateList() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            lstLivros.setListData(livros.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    private void updateComboBox() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            cboxLivro.removeAllItems();
            for(Livro livro : livros){
                cboxLivro.addItem(livro);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public static void main(String[] args) {
        GuiExemplar guiExemplar = new GuiExemplar();
        JFrame frame = new JFrame("Cadastro de Exemplar");
        frame.setContentPane(guiExemplar.jPanel);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
