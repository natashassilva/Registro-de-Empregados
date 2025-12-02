package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODependente;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaDeletarDependente extends JFrame {

    private JTextField txtId;
    private JButton btnDeletar, btnCancelar;

    public TelaDeletarDependente() {
        setTitle("Deletar Dependente");
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
        btnDeletar.addActionListener(this::deletarDependente);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void deletarDependente(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja deletar o dependente de ID " + id + "?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                DAODependente dao = new DAODependente();
                dao.deletar(id);
                JOptionPane.showMessageDialog(this, "Dependente deletado com sucesso!");
                dispose();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar dependente: " + ex.getMessage());
        }
    }
}

