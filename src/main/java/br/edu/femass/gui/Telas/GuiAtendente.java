package br.edu.femass.gui.Telas;

import br.edu.femass.gui.GuiCadastro.GuiCadastrarLeitor;
import br.edu.femass.gui.GuiCadastro.GuiEmprestimo;
import br.edu.femass.gui.GuiCadastro.GuiDevolucao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAtendente {
    private JPanel jPanel;
    private JButton btnConsultarLeitor;
    private JButton btnCadastrarLeitor;
    private JButton realizarEmprestimoButton;
    private JButton btnDevolucao;

    public GuiAtendente() {
        btnCadastrarLeitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarLeitor guiCadastrarLeitor = new GuiCadastrarLeitor();
                JFrame frame = new JFrame("Tela Leitor");
                frame.setContentPane(guiCadastrarLeitor.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });


        realizarEmprestimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
                JFrame frame = new JFrame("Tela Emprestimo");
                frame.setContentPane(guiEmprestimo.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnDevolucao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDevolucao guiDevolucao = new GuiDevolucao();
                JFrame frame = new JFrame("Tela Devolução");
                frame.setContentPane(guiDevolucao.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
