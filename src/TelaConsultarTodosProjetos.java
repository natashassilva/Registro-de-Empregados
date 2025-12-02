package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOProjeto;
import RegistroEmpregados.Modelo.Projeto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaConsultarTodosProjetos extends JFrame {

    private JTextArea areaResultado;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarTodosProjetos() {
        setTitle("Consultar Todos os Projetos");
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
        btnConsultar.addActionListener(this::consultarTodosProjetos);
        btnFechar.addActionListener(e -> dispose());
    }

    private void consultarTodosProjetos(ActionEvent e) {
        try {
            DAOProjeto dao = new DAOProjeto();
            List<Projeto> lista = dao.consultarTodos();

            if (lista.isEmpty()) {
                areaResultado.setText("Nenhum projeto encontrado.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (Projeto p : lista) {
                sb.append("ID: ").append(p.getId_projeto())
                  .append("\nNome: ").append(p.getNome())
                  .append("\nSituação: ").append(p.getSituacao())
                  .append("\nID do Departamento: ").append(p.getDepartamento_id_departamento())
                  .append("\n----------------------------------------\n");
            }

            areaResultado.setText(sb.toString());
        } catch (Exception ex) {
            areaResultado.setText("Erro ao consultar projetos:\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

