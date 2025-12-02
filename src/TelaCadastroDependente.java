package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODependente;
import RegistroEmpregados.Modelo.Dependente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class TelaCadastroDependente extends JFrame {

    private JTextField txtId, txtNome, txtSexo, txtDataNasc, txtParentesco, txtEmpregadoId;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroDependente() {
        setTitle("Cadastro de Dependente");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 5, 5));

        // Campos
        add(new JLabel("ID Dependente (números):"));
        txtId = new JTextField();
        add(txtId);

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

        add(new JLabel("ID do Empregado (números):"));
        txtEmpregadoId = new JTextField();
        add(txtEmpregadoId);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        add(btnSalvar);
        add(btnCancelar);

        // Ações dos botões
        btnSalvar.addActionListener(this::salvarDependente);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvarDependente(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String sexo = txtSexo.getText();
            LocalDate datanasc = LocalDate.parse(txtDataNasc.getText());
            String parentesco = txtParentesco.getText();
            int idEmpregado = Integer.parseInt(txtEmpregadoId.getText());

            Dependente dep = new Dependente(id, nome, sexo, datanasc, parentesco, idEmpregado);
            DAODependente dao = new DAODependente();
            dao.cadastrar(dep);

            JOptionPane.showMessageDialog(this, "Dependente cadastrado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar dependente: " + ex.getMessage());
        }
    }
}

