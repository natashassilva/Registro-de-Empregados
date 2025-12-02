package RegistroEmpregados.GUI;
import javax.swing.*;

import RegistroEmpregados.DAO.DAOEmpregado;
import RegistroEmpregados.Modelo.Empregado;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaConsultarEmpregadoPorID extends JFrame {

    private JTextField txtId;
    private JTextArea resultadoArea;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarEmpregadoPorID() {
        setTitle("Consultar Empregado por ID");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel de cima com campo de ID e botão
        JPanel painelTopo = new JPanel(new FlowLayout());
        painelTopo.add(new JLabel("ID do Empregado (Apenas Números):"));
        txtId = new JTextField(10);
        painelTopo.add(txtId);

        btnConsultar = new JButton("Consultar");
        painelTopo.add(btnConsultar);

        add(painelTopo, BorderLayout.NORTH);

        // Área de resultado
        resultadoArea = new JTextArea(10,30);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        add(scrollPane, BorderLayout.CENTER);

        // Botão de fechar
        btnFechar = new JButton("Fechar");
        add(btnFechar, BorderLayout.SOUTH);

        // Ações dos botões
        btnConsultar.addActionListener(this::consultarEmpregado);
        btnFechar.addActionListener(e -> dispose());
        pack(); // << Ajuste para o tamanho ideal da janela
        // Ajusta o tamanho da janela para o conteúdo
        setLocationRelativeTo(null);
    }

    private void consultarEmpregado(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            DAOEmpregado dao = new DAOEmpregado();
            Empregado emp = dao.consultarPorid(id);

            if (emp != null) {
                resultadoArea.setText(
                    "ID: " + emp.getId_empregado() +
                    "\nNome: " + emp.getNome() +
                    "\nRua: " + emp.getRua() +
                    "\nBairro: " + emp.getBairro() +
                    "\nTelefone: " + emp.getTelefone() +
                    "\nData de Nascimento: " + emp.getDatanasc() +
                    "\nData de Admissão: " + emp.getDataadm() +
                    "\nFunção: " + emp.getFuncao() +
                    "\nSalário: " + emp.getSalario() +
                    "\nComissão: " + emp.getComissao() +
                    "\nID do Departamento: " + emp.getDepartamento_id_departamento()
                );
            } else {
                resultadoArea.setText("Empregado com ID " + id + " não encontrado.");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.setText("Informe um ID válido.");
        } catch (Exception ex) {
            resultadoArea.setText("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

