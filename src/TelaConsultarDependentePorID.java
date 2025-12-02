package RegistroEmpregados.GUI;

import javax.swing.*;

import RegistroEmpregados.DAO.DAODependente;
import RegistroEmpregados.Modelo.Dependente;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaConsultarDependentePorID extends JFrame {

    private JTextField txtId;
    private JTextArea resultadoArea;
    private JButton btnConsultar, btnFechar;

    public TelaConsultarDependentePorID() {
        setTitle("Consultar Dependente por ID");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel superior
        JPanel painelTopo = new JPanel(new FlowLayout());
        painelTopo.add(new JLabel("ID do Dependente (Apenas Números):"));
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

        // Ações
        btnConsultar.addActionListener(this::consultarDependente);
        btnFechar.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
    }

    private void consultarDependente(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            DAODependente dao = new DAODependente();
            Dependente dep = dao.consultarPorid(id);

            if (dep != null) {
                resultadoArea.setText(
                    "ID: " + dep.getId_dependente() +
                    "\nNome: " + dep.getNome() +
                    "\nSexo: " + dep.getSexo() +
                    "\nData de Nascimento: " + dep.getDatanasc() +
                    "\nParentesco: " + dep.getParentesco() +
                    "\nID do Empregado: " + dep.getEmpregado_id_empregado()
                );
            } else {
                resultadoArea.setText("Dependente com ID " + id + " não encontrado.");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.setText("Informe um ID válido.");
        } catch (Exception ex) {
            resultadoArea.setText("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

