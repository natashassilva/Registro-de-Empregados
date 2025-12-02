package RegistroEmpregados.GUI;
import javax.swing.*;

import RegistroEmpregados.DAO.DAOEmpregado;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaDeletarEmpregado extends JFrame {

    private JTextField txtId;
    private JButton btnDeletar, btnCancelar;

    public TelaDeletarEmpregado() {
        setTitle("Deletar Empregado");
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
        btnDeletar.addActionListener(this::deletarEmpregado);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void deletarEmpregado(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja deletar o empregado de ID " + id + "?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                DAOEmpregado dao = new DAOEmpregado();
                dao.deletar(id);
                JOptionPane.showMessageDialog(this, "Empregado deletado com sucesso!");
                dispose();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar empregado: " + ex.getMessage());
        }
    }
}

