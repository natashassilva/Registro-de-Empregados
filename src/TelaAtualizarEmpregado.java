package RegistroEmpregados.GUI;
import javax.swing.*;

import RegistroEmpregados.DAO.DAOEmpregado;
import RegistroEmpregados.Modelo.Empregado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class TelaAtualizarEmpregado extends JFrame {

    private JTextField txtId, txtNome, txtRua, txtBairro, txtTelefone,
                       txtDataNasc, txtDataAdm, txtFuncao, txtSalario,
                       txtComissao, txtDepartamentoId;

    private JButton btnCarregar, btnAtualizar, btnCancelar;

    public TelaAtualizarEmpregado() {
        setTitle("Atualizar Empregado");
        setSize(450, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(13, 2, 5, 5));

        // Campos
        add(new JLabel("ID do Empregado (Apenas números):"));
        txtId = new JTextField();
        add(txtId);

        btnCarregar = new JButton("Carregar Dados");
        add(btnCarregar);
        add(new JLabel()); // espaço vazio

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

        add(new JLabel("Salário:"));
        txtSalario = new JTextField();
        add(txtSalario);

        add(new JLabel("Comissão:"));
        txtComissao = new JTextField();
        add(txtComissao);

        add(new JLabel("ID do Departamento:"));
        txtDepartamentoId = new JTextField();
        add(txtDepartamentoId);

        // Botões
        btnAtualizar = new JButton("Atualizar");
        btnCancelar = new JButton("Cancelar");

        add(btnAtualizar);
        add(btnCancelar);

        // Ações dos botões
        btnCarregar.addActionListener(this::carregarEmpregado);
        btnAtualizar.addActionListener(this::atualizarEmpregado);
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarEmpregado(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            DAOEmpregado dao = new DAOEmpregado();
            Empregado emp = dao.consultarPorid(id);

            if (emp != null) {
                txtNome.setText(emp.getNome());
                txtRua.setText(emp.getRua());
                txtBairro.setText(emp.getBairro());
                txtTelefone.setText(emp.getTelefone());
                txtDataNasc.setText(emp.getDatanasc().toString());
                txtDataAdm.setText(emp.getDataadm().toString());
                txtFuncao.setText(emp.getFuncao());
                txtSalario.setText(String.valueOf(emp.getSalario()));
                txtComissao.setText(String.valueOf(emp.getComissao()));
                txtDepartamentoId.setText(String.valueOf(emp.getDepartamento_id_departamento()));
            } else {
                JOptionPane.showMessageDialog(this, "Empregado não encontrado!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
        }
    }

    private void atualizarEmpregado(ActionEvent e) {
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
            dao.atualizar(emp);

            JOptionPane.showMessageDialog(this, "Empregado atualizado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage());
        }
    }
}

