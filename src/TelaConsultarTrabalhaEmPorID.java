package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAOTrabalha_em;
import RegistroEmpregados.Modelo.Trabalha_em;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaConsultarTrabalhaEmPorID extends JFrame {

    private JTextField txtIdEmpregado, txtIdProjeto;
    private JTextArea resultadoArea;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarTrabalhaEmPorID() {
        setTitle("Consultar Trabalha_em por IDs");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel superior com campos e botão
        JPanel painelTopo = new JPanel(new FlowLayout());
        painelTopo.add(new JLabel("ID do Empregado:"));
        txtIdEmpregado = new JTextField(5);
        painelTopo.add(txtIdEmpregado);

        painelTopo.add(new JLabel("ID do Projeto:"));
        txtIdProjeto = new JTextField(5);
        painelTopo.add(txtIdProjeto);

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
        btnConsultar.addActionListener(this::consultarTrabalhaEm);
        btnFechar.addActionListener(e -> dispose());

        pack(); // Ajuste automático da janela
        setLocationRelativeTo(null); // Centraliza
    }

    private void consultarTrabalhaEm(ActionEvent e) {
        try {
            int idEmpregado = Integer.parseInt(txtIdEmpregado.getText());
            int idProjeto = Integer.parseInt(txtIdProjeto.getText());

            DAOTrabalha_em dao = new DAOTrabalha_em();
            Trabalha_em te = dao.consultarPorIds(idEmpregado, idProjeto);

            if (te != null) {
                resultadoArea.setText(
                    "ID do Empregado: " + te.getEmpregado_id_empregado() +
                    "\nID do Projeto: " + te.getProjeto_id_projeto() +
                    "\nPapel: " + te.getPapel() +
                    "\nHoras: " + te.getHoras()
                );
            } else {
                resultadoArea.setText("Vínculo não encontrado para os IDs informados.");
            }

        } catch (NumberFormatException ex) {
            resultadoArea.setText("Informe IDs válidos (apenas números).");
        } catch (Exception ex) {
            resultadoArea.setText("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

