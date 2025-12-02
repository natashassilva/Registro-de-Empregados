package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODepartamento;
import RegistroEmpregados.Modelo.Departamento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class TelaAtualizarDepartamento extends JFrame {

    private JTextField txtId, txtNome, txtLocalizacao, txtDataInicio, txtIdGerente;
    private JButton btnCarregar, btnAtualizar, btnCancelar;

    public TelaAtualizarDepartamento() {
        setTitle("Atualizar Departamento");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 5, 5));

        // Campos
        add(new JLabel("ID do Departamento:"));
        txtId = new JTextField();
        add(txtId);

        btnCarregar = new JButton("Carregar Dados");
        add(btnCarregar);
        add(new JLabel()); // espaço vazio

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Localização:"));
        txtLocalizacao = new JTextField();
        add(txtLocalizacao);

        add(new JLabel("Início do Gerente (AAAA-MM-DD):"));
        txtDataInicio = new JTextField();
        add(txtDataInicio);

        add(new JLabel("ID do Gerente:"));
        txtIdGerente = new JTextField();
        add(txtIdGerente);

        // Botões
        btnAtualizar = new JButton("Atualizar");
        btnCancelar = new JButton("Cancelar");
        add(btnAtualizar);
        add(btnCancelar);

        // Ações
        btnCarregar.addActionListener(this::carregarDepartamento);
        btnAtualizar.addActionListener(this::atualizarDepartamento);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarDepartamento(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            DAODepartamento dao = new DAODepartamento();
            Departamento d = dao.consultarPorid(id);

            if (d != null) {
                txtNome.setText(d.getNome());
                txtLocalizacao.setText(d.getLocalizacao());
                txtDataInicio.setText(d.getData_inicio_ger().toString());
                txtIdGerente.setText(String.valueOf(d.getId_gerente()));
            } else {
                JOptionPane.showMessageDialog(this, "Departamento não encontrado.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar: " + ex.getMessage());
        }
    }

    private void atualizarDepartamento(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String localizacao = txtLocalizacao.getText();
            LocalDate dataInicio = LocalDate.parse(txtDataInicio.getText());
            int idGerente = Integer.parseInt(txtIdGerente.getText());

            Departamento d = new Departamento(id, nome, localizacao, dataInicio, idGerente);
            DAODepartamento dao = new DAODepartamento();
            dao.atualizar(d);

            JOptionPane.showMessageDialog(this, "Departamento atualizado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage());
        }
    }
}

