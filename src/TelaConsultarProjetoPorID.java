package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOProjeto;
import RegistroEmpregados.Modelo.Projeto;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaConsultarProjetoPorID extends JFrame {

    private JTextField txtId;
    private JTextArea resultadoArea;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarProjetoPorID() {
        setTitle("Consultar Projeto por ID");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel superior com campo de ID e botão
        JPanel painelTopo = new JPanel(new FlowLayout());
        painelTopo.add(new JLabel("ID do Projeto (Apenas Números):"));
        txtId = new JTextField(10);
        painelTopo.add(txtId);

        btnConsultar = new JButton("Consultar");
        painelTopo.add(btnConsultar);

        add(painelTopo, BorderLayout.NORTH);

        // Área de resultado
        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        add(scrollPane, BorderLayout.CENTER);

        // Botão de fechar
        btnFechar = new JButton("Fechar");
        add(btnFechar, BorderLayout.SOUTH);

        // Ações dos botões
        btnConsultar.addActionListener(this::consultarProjeto);
        btnFechar.addActionListener(e -> dispose());

        pack(); // Ajusta automaticamente o tamanho da janela
        setLocationRelativeTo(null);
    }

    private void consultarProjeto(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            DAOProjeto dao = new DAOProjeto();
            Projeto projeto = dao.consultarPorid(id);

            if (projeto != null) {
                resultadoArea.setText(
                    "ID: " + projeto.getId_projeto() +
                    "\nNome: " + projeto.getNome() +
                    "\nSituação: " + projeto.getSituacao() +
                    "\nID do Departamento: " + projeto.getDepartamento_id_departamento()
                );
            } else {
                resultadoArea.setText("Projeto com ID " + id + " não encontrado.");
            }

        } catch (NumberFormatException ex) {
            resultadoArea.setText("Informe um ID válido.");
        } catch (Exception ex) {
            resultadoArea.setText("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

