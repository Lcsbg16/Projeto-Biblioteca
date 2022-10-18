package br.edu.femass.gui.Telas;

import br.edu.femass.gui.GuiCadastro.GuiAutor;
import br.edu.femass.gui.GuiConsulta.GuiAtrasados;
import br.edu.femass.gui.GuiConsulta.GuiConsultarExemplar;
import br.edu.femass.gui.GuiCadastro.GuiExemplar;
import br.edu.femass.gui.GuiCadastro.GuiLivro;
import br.edu.femass.gui.GuiConsulta.GuiConsultarLivro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBibliotecario {
    private JPanel jPanel;
    private JButton btnCadastrarAutor;
    private JButton consultarAutorButton;
    private JButton consultarLivrosButton;
    private JButton cadastrarLivrosButton;
    private JButton btnCadastrarExemplar;
    private JButton btnConsultarExemplares;
    private JButton listaDeEmprestimosAtrasadosButton;


    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiBibliotecario() {
        btnCadastrarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAutor guiAutor = new GuiAutor();
                JFrame frame = new JFrame("Tela Cadastrar Autor");
                frame.setContentPane(guiAutor.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });


        cadastrarLivrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLivro guiLivro = new GuiLivro();
                JFrame frame = new JFrame("Tela Cadastrar Livro");
                frame.setContentPane(guiLivro.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        consultarLivrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiConsultarLivro guiConsultarLivro = new GuiConsultarLivro();
                JFrame frame = new JFrame("Tela Consultar Livro");
                frame.setContentPane(guiConsultarLivro.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiExemplar guiExemplar = new GuiExemplar();
                JFrame frame = new JFrame("Tela Cadastrar Exemplar");
                frame.setContentPane(guiExemplar.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnConsultarExemplares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiConsultarExemplar guiConsultarExemplar = new GuiConsultarExemplar();
                JFrame frame = new JFrame("Tela Consultar Exemplar");
                frame.setContentPane(guiConsultarExemplar.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        listaDeEmprestimosAtrasadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAtrasados guiAtrasados = new GuiAtrasados();
                JFrame frame = new JFrame("Tela Lista de Emprestimos Atrasados");
                frame.setContentPane(guiAtrasados.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }


}
