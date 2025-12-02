package RegistroEmpregados.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {

    private JComboBox<String> comboBoxEntidade;
    private JButton btnCadastrar, btnAtualizar, btnDeletar, btnConsultarId, btnConsultarTodos, btnAdicionar;
    private JPanel painelBotoes;

    public TelaInicial() {
        setTitle("Sistema de Registro de Empregados");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());

        // ComboBox com as opções de entidade
        String[] entidades = {"Selecione...", "Empregado", "Departamento", "Dependente", "Projeto", "Trabalha em"};
        comboBoxEntidade = new JComboBox<>(entidades);
        comboBoxEntidade.addActionListener(new EntidadeSelecionadaListener());

        // Painel superior com a ComboBox
        JPanel painelSelecao = new JPanel();
        painelSelecao.add(new JLabel("Escolha uma opção:"));
        painelSelecao.add(comboBoxEntidade);

        // Painel com os botões CRUD
        painelBotoes = new JPanel(new GridLayout(3, 2, 5, 5));
        btnCadastrar = new JButton("Cadastrar");
        btnAtualizar = new JButton("Atualizar");
        btnDeletar = new JButton("Deletar");
        btnConsultarId = new JButton("Consultar por ID");
        btnConsultarTodos = new JButton("Consultar Todos");
        btnAdicionar = new JButton("+");

        // Adiciona botões ao painel
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnDeletar);
        painelBotoes.add(btnConsultarId);
        painelBotoes.add(btnConsultarTodos);
        painelBotoes.add(btnAdicionar);

        // Desabilita os botões até uma entidade ser escolhida
        setBotoesAtivos(false);

        // Eventos dos botões (direcionamento para outras telas))
        btnCadastrar.addActionListener(e -> abrirFormulario("cadastrar"));
        btnAtualizar.addActionListener(e -> abrirFormulario("atualizar"));
        btnDeletar.addActionListener(e -> abrirFormulario("deletar"));
        btnConsultarId.addActionListener(e -> abrirFormulario("consultarPorId"));
        btnConsultarTodos.addActionListener(e -> abrirFormulario("consultarTodos"));
        btnAdicionar.addActionListener(e -> abrirFormulario("+"));

        // Montagem final da tela
        painelPrincipal.add(painelSelecao, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        add(painelPrincipal);
    }

    // Habilita ou desabilita os botões
    private void setBotoesAtivos(boolean ativo) {
        btnCadastrar.setEnabled(ativo);
        btnAtualizar.setEnabled(ativo);
        btnDeletar.setEnabled(ativo);
        btnConsultarId.setEnabled(ativo);
        btnConsultarTodos.setEnabled(ativo);
        btnAdicionar.setEnabled(ativo);
    }

    // Evento ao selecionar entidade
    private class EntidadeSelecionadaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = comboBoxEntidade.getSelectedIndex();
            setBotoesAtivos(index > 0);
        }
    }

    // Direciona para outra janela dependendo da ação escolhida
    private void abrirFormulario(String acao) {
    String entidade = (String) comboBoxEntidade.getSelectedItem();

    switch (entidade) {
        case "Empregado" -> {
            switch (acao) {
                case "cadastrar" -> new TelaCadastroEmpregado().setVisible(true);
                case "atualizar" -> new TelaAtualizarEmpregado().setVisible(true);
                case "deletar" -> new TelaDeletarEmpregado().setVisible(true);
                case "consultarPorId" -> new TelaConsultarEmpregadoPorID().setVisible(true);
                case "consultarTodos" -> new TelaConsultarTodosEmpregados().setVisible(true);
                default -> JOptionPane.showMessageDialog(this, "Função ainda não cadastrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        case "Departamento" -> {
            switch (acao) {
                case "cadastrar" -> new TelaCadastroDepartamento().setVisible(true);
                case "atualizar" -> new TelaAtualizarDepartamento().setVisible(true);
                case "deletar" -> new TelaDeletarDepartamento().setVisible(true);
                case "consultarPorId" -> new TelaConsultarDepartamentoPorID().setVisible(true);
                case "consultarTodos" -> new TelaConsultarTodosDepartamentos().setVisible(true);
                default -> JOptionPane.showMessageDialog(this, "Função ainda não cadastrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        case "Dependente" -> {
            switch (acao) {
                case "cadastrar" -> new TelaCadastroDependente().setVisible(true);
                case "atualizar" -> new TelaAtualizarDependente().setVisible(true);
                case "deletar" -> new TelaDeletarDependente().setVisible(true);
                case "consultarPorId" -> new TelaConsultarDependentePorID().setVisible(true);
                case "consultarTodos" -> new TelaConsultarTodosDependentes().setVisible(true);
                default -> JOptionPane.showMessageDialog(this, "Função ainda não cadastrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        case "Projeto" -> {
            switch (acao) {
                case "cadastrar" -> new TelaCadastroProjeto().setVisible(true);
                case "atualizar" -> new TelaAtualizarProjeto().setVisible(true);
                case "deletar" -> new TelaDeletarProjeto().setVisible(true);
                case "consultarPorId" -> new TelaConsultarProjetoPorID().setVisible(true);
                case "consultarTodos" -> new TelaConsultarTodosProjetos().setVisible(true);
                default -> JOptionPane.showMessageDialog(this, "Função ainda não cadastrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        case "Trabalha em" -> {
            switch (acao) {
                case "cadastrar" -> new TelaCadastroTrabalhaEm().setVisible(true);
                case "atualizar" -> new TelaAtualizarTrabalhaEm().setVisible(true);
                case "deletar" -> new TelaDeletarTrabalhaEm().setVisible(true);
                case "consultarPorId" -> new TelaConsultarTrabalhaEmPorID().setVisible(true);
                case "consultarTodos" -> new TelaConsultarTodosTrabalhaEm().setVisible(true);
                default -> JOptionPane.showMessageDialog(this, "Função ainda não cadastrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        default -> {
            JOptionPane.showMessageDialog(this,
                "Funcionalidade ainda não implementada para a opção: " + entidade,
                "Aviso",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }

}

