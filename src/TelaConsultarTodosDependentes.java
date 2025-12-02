package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODependente;
import RegistroEmpregados.Modelo.Dependente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaConsultarTodosDependentes extends JFrame {

    private JTextArea areaResultado;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarTodosDependentes() {
        setTitle("Consultar Todos os Dependentes");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Área de texto para exibir resultados
        areaResultado = new JTextArea(15, 40);
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        add(scroll, BorderLayout.CENTER);

        // Painel inferior com botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        btnConsultar = new JButton("Consultar Todos");
        btnFechar = new JButton("Fechar");
        painelBotoes.add(btnConsultar);
        painelBotoes.add(btnFechar);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        btnConsultar.addActionListener(this::consultarTodosDependentes);
        btnFechar.addActionListener(e -> dispose());
    }

    private void consultarTodosDependentes(ActionEvent e) {
        try {
            DAODependente dao = new DAODependente();
            List<Dependente> lista = dao.consultarTodos();

            if (lista.isEmpty()) {
                areaResultado.setText("Nenhum dependente encontrado.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (Dependente d : lista) {
                sb.append("ID: ").append(d.getId_dependente())
                  .append("\nNome: ").append(d.getNome())
                  .append("\nSexo: ").append(d.getSexo())
                  .append("\nData de Nascimento: ").append(d.getDatanasc())
                  .append("\nParentesco: ").append(d.getParentesco())
                  .append("\nID do Empregado: ").append(d.getEmpregado_id_empregado())
                  .append("\n----------------------------------------\n");
            }

            areaResultado.setText(sb.toString());
        } catch (Exception ex) {
            areaResultado.setText("Erro ao consultar dependentes:\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

