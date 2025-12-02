package RegistroEmpregados.GUI;
import javax.swing.*;

import RegistroEmpregados.DAO.DAOEmpregado;
import RegistroEmpregados.Modelo.Empregado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaConsultarTodosEmpregados extends JFrame {

    private JTextArea areaResultado;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarTodosEmpregados() {
        setTitle("Consultar Todos os Empregados");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Área de texto
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        add(scroll, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        btnConsultar = new JButton("Consultar Todos");
        btnFechar = new JButton("Fechar");
        painelBotoes.add(btnConsultar);
        painelBotoes.add(btnFechar);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        btnConsultar.addActionListener(this::consultarTodosEmpregados);
        btnFechar.addActionListener(e -> dispose());
    }

    private void consultarTodosEmpregados(ActionEvent e) {
        try {
            DAOEmpregado dao = new DAOEmpregado();
            List<Empregado> lista = dao.consultarTodos();

            if (lista.isEmpty()) {
                areaResultado.setText("Nenhum empregado encontrado.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (Empregado emp : lista) {
                sb.append("ID: ").append(emp.getId_empregado())
                  .append("\nNome: ").append(emp.getNome())
                  .append("\nRua: ").append(emp.getRua())
                  .append("\nBairro: ").append(emp.getBairro())
                  .append("\nTelefone: ").append(emp.getTelefone())
                  .append("\nNascimento: ").append(emp.getDatanasc())
                  .append("\nAdmissão: ").append(emp.getDataadm())
                  .append("\nFunção: ").append(emp.getFuncao())
                  .append("\nSalário: ").append(emp.getSalario())
                  .append("\nComissão: ").append(emp.getComissao())
                  .append("\nID Departamento: ").append(emp.getDepartamento_id_departamento())
                  .append("\n----------------------------------------\n");
            }

            areaResultado.setText(sb.toString());
        } catch (Exception ex) {
            areaResultado.setText("Erro ao consultar empregados:\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

