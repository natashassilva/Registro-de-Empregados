package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOProjeto;
import RegistroEmpregados.Modelo.Projeto;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCadastroProjeto extends JFrame {

    private JTextField txtIdProjeto, txtNome, txtSituacao, txtIdDepartamento;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroProjeto() {
        setTitle("Cadastro de Projeto");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Campos
        add(new JLabel("ID do Projeto (Apenas números):"));
        txtIdProjeto = new JTextField();
        add(txtIdProjeto);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Situação:"));
        txtSituacao = new JTextField();
        add(txtSituacao);

        add(new JLabel("ID do Departamento (número):"));
        txtIdDepartamento = new JTextField();
        add(txtIdDepartamento);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        add(btnSalvar);
        add(btnCancelar);

        // Ações dos botões
        btnSalvar.addActionListener(this::salvarProjeto);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvarProjeto(ActionEvent e) {
        try {
            int idProjeto = Integer.parseInt(txtIdProjeto.getText());
            String nome = txtNome.getText();
            String situacao = txtSituacao.getText();
            int idDepartamento = Integer.parseInt(txtIdDepartamento.getText());

            Projeto projeto = new Projeto(idProjeto, nome, situacao, idDepartamento);
            DAOProjeto dao = new DAOProjeto();
            dao.cadastrar(projeto);

            JOptionPane.showMessageDialog(this, "Projeto cadastrado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar projeto: " + ex.getMessage());
        }
    }
}

