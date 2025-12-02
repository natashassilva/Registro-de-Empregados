package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODepartamento;
import RegistroEmpregados.Modelo.Departamento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaConsultarTodosDepartamentos extends JFrame {

    private JTextArea areaResultado;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarTodosDepartamentos() {
        setTitle("Consultar Todos os Departamentos");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Área de texto
        areaResultado = new JTextArea(15, 40);
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
        btnConsultar.addActionListener(this::consultarTodosDepartamentos);
        btnFechar.addActionListener(e -> dispose());
    }

    private void consultarTodosDepartamentos(ActionEvent e) {
        try {
            DAODepartamento dao = new DAODepartamento();
            List<Departamento> lista = dao.consultarTodos();

            if (lista.isEmpty()) {
                areaResultado.setText("Nenhum departamento encontrado.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (Departamento d : lista) {
                sb.append("ID: ").append(d.getId_departamento())
                  .append("\nNome: ").append(d.getNome())
                  .append("\nLocalização: ").append(d.getLocalizacao())
                  .append("\nInício da Gerência: ").append(d.getData_inicio_ger())
                  .append("\nID do Gerente: ").append(d.getId_gerente())
                  .append("\n----------------------------------------\n");
            }

            areaResultado.setText(sb.toString());
        } catch (Exception ex) {
            areaResultado.setText("Erro ao consultar departamentos:\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

