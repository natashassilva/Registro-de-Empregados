package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOTrabalha_em;
import RegistroEmpregados.Modelo.Trabalha_em;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaConsultarTodosTrabalhaEm extends JFrame {

    private JTextArea areaResultado;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarTodosTrabalhaEm() {
        setTitle("Consultar Todos os Vínculos Trabalha_em");
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
        btnConsultar.addActionListener(this::consultarTodosVinculos);
        btnFechar.addActionListener(e -> dispose());
    }

    private void consultarTodosVinculos(ActionEvent e) {
        try {
            DAOTrabalha_em dao = new DAOTrabalha_em();
            List<Trabalha_em> lista = dao.consultarTodos();

            if (lista.isEmpty()) {
                areaResultado.setText("Nenhum vínculo trabalha_em encontrado.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (Trabalha_em t : lista) {
                sb.append("ID do Empregado: ").append(t.getEmpregado_id_empregado())
                  .append("\nID do Projeto: ").append(t.getProjeto_id_projeto())
                  .append("\nPapel: ").append(t.getPapel())
                  .append("\nHoras: ").append(t.getHoras())
                  .append("\n----------------------------------------\n");
            }

            areaResultado.setText(sb.toString());
        } catch (Exception ex) {
            areaResultado.setText("Erro ao consultar vínculos:\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

