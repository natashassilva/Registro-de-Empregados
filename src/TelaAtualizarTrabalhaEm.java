package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOTrabalha_em;
import RegistroEmpregados.Modelo.Trabalha_em;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaAtualizarTrabalhaEm extends JFrame {

    private JTextField txtIdEmpregado, txtIdProjeto, txtPapel, txtHoras;
    private JButton btnCarregar, btnAtualizar, btnCancelar;

    public TelaAtualizarTrabalhaEm() {
        setTitle("Atualizar Trabalha_em");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Campos de identificação (chave composta)
        add(new JLabel("ID do Empregado (Apenas números):"));
        txtIdEmpregado = new JTextField();
        add(txtIdEmpregado);

        add(new JLabel("ID do Projeto (Apenas números):"));
        txtIdProjeto = new JTextField();
        add(txtIdProjeto);

        btnCarregar = new JButton("Carregar Dados");
        add(btnCarregar);
        add(new JLabel()); // espaço vazio

        // Campos para atualizar
        add(new JLabel("Papel:"));
        txtPapel = new JTextField();
        add(txtPapel);

        add(new JLabel("Horas:"));
        txtHoras = new JTextField();
        add(txtHoras);

        // Botões
        btnAtualizar = new JButton("Atualizar");
        btnCancelar = new JButton("Cancelar");
        add(btnAtualizar);
        add(btnCancelar);

        // Ações dos botões
        btnCarregar.addActionListener(this::carregarTrabalhaEm);
        btnAtualizar.addActionListener(this::atualizarTrabalhaEm);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarTrabalhaEm(ActionEvent e) {
        try {
            int idEmpregado = Integer.parseInt(txtIdEmpregado.getText());
            int idProjeto = Integer.parseInt(txtIdProjeto.getText());

            DAOTrabalha_em dao = new DAOTrabalha_em();
            Trabalha_em te = dao.consultarPorIds(idEmpregado, idProjeto); // Você precisa ter este método implementado

            if (te != null) {
                txtPapel.setText(te.getPapel());
                txtHoras.setText(String.valueOf(te.getHoras()));
            } else {
                JOptionPane.showMessageDialog(this, "Registro não encontrado!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
        }
    }

    private void atualizarTrabalhaEm(ActionEvent e) {
        try {
            int idEmpregado = Integer.parseInt(txtIdEmpregado.getText());
            int idProjeto = Integer.parseInt(txtIdProjeto.getText());
            String papel = txtPapel.getText();
            int horas = Integer.parseInt(txtHoras.getText());

            Trabalha_em te = new Trabalha_em(idEmpregado, idProjeto, papel, horas);
            DAOTrabalha_em dao = new DAOTrabalha_em();
            dao.atualizar(te);

            JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

