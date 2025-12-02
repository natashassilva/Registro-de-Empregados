package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODepartamento;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaDeletarDepartamento extends JFrame {

    private JTextField txtId;
    private JButton btnDeletar, btnCancelar;

    public TelaDeletarDepartamento() {
        setTitle("Deletar Departamento");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("ID (número):"));
        txtId = new JTextField();
        add(txtId);

        btnDeletar = new JButton("Deletar");
        btnCancelar = new JButton("Cancelar");

        add(btnDeletar);
        add(btnCancelar);

        // Ações dos botões
        btnDeletar.addActionListener(this::deletarDepartamento);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void deletarDepartamento(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja deletar o departamento de ID " + id + "?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                DAODepartamento dao = new DAODepartamento();
                dao.deletar(id);
                JOptionPane.showMessageDialog(this, "Departamento deletado com sucesso!");
                dispose();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar departamento: " + ex.getMessage());
        }
    }
}

