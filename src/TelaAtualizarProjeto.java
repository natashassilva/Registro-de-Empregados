package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOProjeto;
import RegistroEmpregados.Modelo.Projeto;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaAtualizarProjeto extends JFrame {

    private JTextField txtIdProjeto, txtNome, txtSituacao, txtIdDepartamento;
    private JButton btnCarregar, btnAtualizar, btnCancelar;

    public TelaAtualizarProjeto() {
        setTitle("Atualizar Projeto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Campos
        add(new JLabel("ID do Projeto (Apenas números):"));
        txtIdProjeto = new JTextField();
        add(txtIdProjeto);

        btnCarregar = new JButton("Carregar Dados");
        add(btnCarregar);
        add(new JLabel()); // espaço vazio

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
        btnAtualizar = new JButton("Atualizar");
        btnCancelar = new JButton("Cancelar");
        add(btnAtualizar);
        add(btnCancelar);

        // Ações dos botões
        btnCarregar.addActionListener(this::carregarProjeto);
        btnAtualizar.addActionListener(this::atualizarProjeto);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarProjeto(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtIdProjeto.getText());
            DAOProjeto dao = new DAOProjeto();
            Projeto projeto = dao.consultarPorid(id);

            if (projeto != null) {
                txtNome.setText(projeto.getNome());
                txtSituacao.setText(projeto.getSituacao());
                txtIdDepartamento.setText(String.valueOf(projeto.getDepartamento_id_departamento()));
            } else {
                JOptionPane.showMessageDialog(this, "Projeto não encontrado!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
        }
    }

    private void atualizarProjeto(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtIdProjeto.getText());
            String nome = txtNome.getText();
            String situacao = txtSituacao.getText();
            int idDepartamento = Integer.parseInt(txtIdDepartamento.getText());

            Projeto projeto = new Projeto(id, nome, situacao, idDepartamento);
            DAOProjeto dao = new DAOProjeto();
            dao.atualizar(projeto);

            JOptionPane.showMessageDialog(this, "Projeto atualizado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar projeto: " + ex.getMessage());
        }
    }
}

