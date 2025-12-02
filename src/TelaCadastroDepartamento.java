package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODepartamento;
import RegistroEmpregados.Modelo.Departamento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class TelaCadastroDepartamento extends JFrame {

    private JTextField txtId, txtNome, txtLocalizacao, txtDataInicio, txtIdGerente;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroDepartamento() {
        setTitle("Cadastro de Departamento");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Campos
        add(new JLabel("ID Departamento (Apenas números):"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Localização:"));
        txtLocalizacao = new JTextField();
        add(txtLocalizacao);

        add(new JLabel("Início do Gerente (AAAA-MM-DD):"));
        txtDataInicio = new JTextField();
        add(txtDataInicio);

        add(new JLabel("ID do Gerente (Apenas números):"));
        txtIdGerente = new JTextField();
        add(txtIdGerente);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        add(btnSalvar);
        add(btnCancelar);

        // Ações dos botões
        btnSalvar.addActionListener(this::salvarDepartamento);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvarDepartamento(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String localizacao = txtLocalizacao.getText();
            LocalDate dataInicio = LocalDate.parse(txtDataInicio.getText());
            int idGerente = Integer.parseInt(txtIdGerente.getText());

            Departamento d = new Departamento(id, nome, localizacao, dataInicio, idGerente);
            DAODepartamento dao = new DAODepartamento();
            dao.cadastrar(d);

            JOptionPane.showMessageDialog(this, "Departamento cadastrado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar departamento: " + ex.getMessage());
        }
    }
}

