package br.edu.femass.gui.GuiCadastro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastrarLeitor {
    private JPanel jPanel;
    private JButton btnAluno;
    private JButton btnProfessor;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiCadastrarLeitor() {
        btnAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAluno guiAluno = new GuiAluno();
                JFrame jFrame = new JFrame("Cadastrar Aluno");
                jFrame.setContentPane(guiAluno.getjPanel());
                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
        btnProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiProfessor guiProfessor = new GuiProfessor();
                JFrame jFrame = new JFrame("Cadastrar Professor");
                jFrame.setContentPane(guiProfessor.getjPanel());
                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        GuiCadastrarLeitor guiCadastrarLeitor = new GuiCadastrarLeitor();
        JFrame jFrame = new JFrame("Tela de Cadastro");
        jFrame.setContentPane(guiCadastrarLeitor.jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }

}
