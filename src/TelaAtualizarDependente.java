package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODependente;
import RegistroEmpregados.Modelo.Dependente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class TelaAtualizarDependente extends JFrame {

    private JTextField txtId, txtNome, txtSexo, txtDataNasc, txtParentesco;
    private JButton btnCarregar, btnAtualizar, btnCancelar;

    public TelaAtualizarDependente() {
        setTitle("Atualizar Dependente");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 5, 5));

        // Campos
        add(new JLabel("ID do Dependente (números):"));
        txtId = new JTextField();
        add(txtId);

        btnCarregar = new JButton("Carregar Dados");
        add(btnCarregar);
        add(new JLabel()); // espaço vazio

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Sexo (M/F):"));
        txtSexo = new JTextField();
        add(txtSexo);

        add(new JLabel("Nascimento (AAAA-MM-DD):"));
        txtDataNasc = new JTextField();
        add(txtDataNasc);

        add(new JLabel("Parentesco:"));
        txtParentesco = new JTextField();
        add(txtParentesco);

        // Botões
        btnAtualizar = new JButton("Atualizar");
        btnCancelar = new JButton("Cancelar");

        add(btnAtualizar);
        add(btnCancelar);

        // Ações dos botões
        btnCarregar.addActionListener(this::carregarDependente);
        btnAtualizar.addActionListener(this::atualizarDependente);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarDependente(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            DAODependente dao = new DAODependente();
            Dependente dep = dao.consultarPorid(id); // método deve existir na DAO

            if (dep != null) {
                txtNome.setText(dep.getNome());
                txtSexo.setText(dep.getSexo());
                txtDataNasc.setText(dep.getDatanasc().toString());
                txtParentesco.setText(dep.getParentesco());
            } else {
                JOptionPane.showMessageDialog(this, "Dependente não encontrado!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
        }
    }

    private void atualizarDependente(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String sexo = txtSexo.getText();
            LocalDate datanasc = LocalDate.parse(txtDataNasc.getText());
            String parentesco = txtParentesco.getText();

            Dependente dep = new Dependente(id, nome, sexo, datanasc, parentesco, 0); // empregado_id_empregado não é alterado aqui
            DAODependente dao = new DAODependente();
            dao.atualizar(dep);

            JOptionPane.showMessageDialog(this, "Dependente atualizado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar dependente: " + ex.getMessage());
        }
    }
}

