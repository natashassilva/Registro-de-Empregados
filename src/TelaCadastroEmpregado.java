package RegistroEmpregados.GUI;
import javax.swing.*;

import RegistroEmpregados.DAO.DAOEmpregado;
import RegistroEmpregados.Modelo.Empregado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class TelaCadastroEmpregado extends JFrame {

    private JTextField txtId, txtNome, txtRua, txtBairro, txtTelefone,
                       txtDataNasc, txtDataAdm, txtFuncao, txtSalario,
                       txtComissao, txtDepartamentoId;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroEmpregado() {
        setTitle("Cadastro de Empregado");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(12, 2, 5, 5));

        // Campos
        add(new JLabel("ID Empregado (números):"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Rua:"));
        txtRua = new JTextField();
        add(txtRua);

        add(new JLabel("Bairro:"));
        txtBairro = new JTextField();
        add(txtBairro);

        add(new JLabel("Telefone: (XX) XXXXX-XXXX:"));
        txtTelefone = new JTextField();
        add(txtTelefone);

        add(new JLabel("Data de Nascimento (AAAA-MM-DD):"));
        txtDataNasc = new JTextField();
        add(txtDataNasc);

        add(new JLabel("Data de Admissão (AAAA-MM-DD):"));
        txtDataAdm = new JTextField();
        add(txtDataAdm);

        add(new JLabel("Função:"));
        txtFuncao = new JTextField();
        add(txtFuncao);

        add(new JLabel("Salário (0.01 - 99999999.99): "));
        txtSalario = new JTextField();
        add(txtSalario);

        add(new JLabel("Comissão (0.00001 - 1.99999): "));
        txtComissao = new JTextField();
        add(txtComissao);

        add(new JLabel("ID do Departamento (Números):"));
        txtDepartamentoId = new JTextField();
        add(txtDepartamentoId);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        add(btnSalvar);
        add(btnCancelar);

        // Ações dos botões
        btnSalvar.addActionListener(this::salvarEmpregado);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvarEmpregado(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String rua = txtRua.getText();
            String bairro = txtBairro.getText();
            String telefone = txtTelefone.getText();
            LocalDate datanasc = LocalDate.parse(txtDataNasc.getText());
            LocalDate dataadm = LocalDate.parse(txtDataAdm.getText());
            String funcao = txtFuncao.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            double comissao = Double.parseDouble(txtComissao.getText());
            int idDepto = Integer.parseInt(txtDepartamentoId.getText());

            Empregado emp = new Empregado(id, nome, rua, bairro, telefone, datanasc, dataadm, funcao, salario, comissao, idDepto);
            DAOEmpregado dao = new DAOEmpregado();
            dao.cadastrar(emp);

            JOptionPane.showMessageDialog(this, "Empregado cadastrado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar empregado: " + ex.getMessage());
        }
    }

}

