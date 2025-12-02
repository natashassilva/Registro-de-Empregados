package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOTrabalha_em;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaDeletarTrabalhaEm extends JFrame {

    private JTextField txtIdEmpregado, txtIdProjeto;
    private JButton btnDeletar, btnCancelar;

    public TelaDeletarTrabalhaEm() {
        setTitle("Deletar Vínculo Trabalha em");
        setSize(350, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Campos de entrada
        add(new JLabel("ID do Empregado (números):"));
        txtIdEmpregado = new JTextField();
        add(txtIdEmpregado);

        add(new JLabel("ID do Projeto (números):"));
        txtIdProjeto = new JTextField();
        add(txtIdProjeto);

        // Botões
        btnDeletar = new JButton("Deletar");
        btnCancelar = new JButton("Cancelar");

        add(btnDeletar);
        add(btnCancelar);

        // Ações dos botões
        btnDeletar.addActionListener(this::deletarTrabalhaEm);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void deletarTrabalhaEm(ActionEvent e) {
        try {
            int empregadoId = Integer.parseInt(txtIdEmpregado.getText());
            int projetoId = Integer.parseInt(txtIdProjeto.getText());

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja deletar o vínculo do empregado ID " + empregadoId +
                    " no projeto ID " + projetoId + "?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                DAOTrabalha_em dao = new DAOTrabalha_em();
                dao.deletar2(empregadoId, projetoId);
                JOptionPane.showMessageDialog(this, "Vínculo Trabalha em deletado com sucesso!");
                dispose();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe IDs válidos (apenas números).");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar vínculo: " + ex.getMessage());
        }
    }
}

