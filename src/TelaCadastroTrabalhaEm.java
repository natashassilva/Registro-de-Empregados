package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOTrabalha_em;
import RegistroEmpregados.Modelo.Trabalha_em;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCadastroTrabalhaEm extends JFrame {

    private JTextField txtIdEmpregado, txtIdProjeto, txtPapel, txtHoras;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroTrabalhaEm() {
        setTitle("Cadastro de Trabalha_em");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Campos
        add(new JLabel("ID do Empregado (Apenas números):"));
        txtIdEmpregado = new JTextField();
        add(txtIdEmpregado);

        add(new JLabel("ID do Projeto (Apenas números):"));
        txtIdProjeto = new JTextField();
        add(txtIdProjeto);

        add(new JLabel("Papel:"));
        txtPapel = new JTextField();
        add(txtPapel);

        add(new JLabel("Horas:"));
        txtHoras = new JTextField();
        add(txtHoras);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        add(btnSalvar);
        add(btnCancelar);

        // Ações dos botões
        btnSalvar.addActionListener(this::salvarTrabalhaEm);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvarTrabalhaEm(ActionEvent e) {
        try {
            int idEmpregado = Integer.parseInt(txtIdEmpregado.getText());
            int idProjeto = Integer.parseInt(txtIdProjeto.getText());
            String papel = txtPapel.getText();
            int horas = Integer.parseInt(txtHoras.getText());

            Trabalha_em te = new Trabalha_em(idEmpregado, idProjeto, papel, horas);
            DAOTrabalha_em dao = new DAOTrabalha_em();
            dao.cadastrar(te);

            JOptionPane.showMessageDialog(this, "Registro de trabalho cadastrado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

