package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOProjeto;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaDeletarProjeto extends JFrame {

    private JTextField txtId;
    private JButton btnDeletar, btnCancelar;

    public TelaDeletarProjeto() {
        setTitle("Deletar Projeto");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("ID (números):"));
        txtId = new JTextField();
        add(txtId);

        btnDeletar = new JButton("Deletar");
        btnCancelar = new JButton("Cancelar");

        add(btnDeletar);
        add(btnCancelar);

        // Ações dos botões
        btnDeletar.addActionListener(this::deletarProjeto);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void deletarProjeto(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja deletar o projeto de ID " + id + "?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                DAOProjeto dao = new DAOProjeto();
                dao.deletar(id);
                JOptionPane.showMessageDialog(this, "Projeto deletado com sucesso!");
                dispose();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar projeto: " + ex.getMessage());
        }
    }
}

