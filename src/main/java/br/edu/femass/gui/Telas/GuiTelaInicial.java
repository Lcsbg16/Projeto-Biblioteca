package br.edu.femass.gui.Telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiTelaInicial {
    private JButton bibliotecárioButton;
    private JButton atendenteButton;
    private JPanel jPanel;

    public GuiTelaInicial() {
        bibliotecárioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiBibliotecario guiBibliotecario = new GuiBibliotecario();
                JFrame frame = new JFrame("Tela Bibliotecario");
                frame.setContentPane(guiBibliotecario.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        atendenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAtendente guiAtendente = new GuiAtendente();
                JFrame frame = new JFrame("Tela Atendente");
                frame.setContentPane(guiAtendente.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public void abrirTela() {
        GuiTelaInicial guiTelaInicial = new GuiTelaInicial();
        JFrame frame = new JFrame("Tela Inicial");
        frame.setContentPane(guiTelaInicial.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tela Inicial");
        frame.pack();
        frame.setVisible(true);
    }

    /*public void abrirTela() {
        JFrame frame = new JFrame();
        GuiConta gui = new GuiConta();
        gui.preencherLista();
        gui.preencherListaCliente();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cadastro de Contas de Clientes");
        frame.pack();
        frame.setVisible(true);
    }*/


}
