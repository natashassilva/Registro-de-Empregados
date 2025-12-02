package RegistroEmpregados.DAO;
import java.sql.*;
import java.util.*;

import RegistroEmpregados.Modelo.Trabalha_em;

public class DAOTrabalha_em extends DAOBase<Trabalha_em> {

    public DAOTrabalha_em() {
        super();
    }

    @Override
    public void cadastrar(Trabalha_em trabalhaEm) throws SQLException {
        String sql = "INSERT INTO trabalha_em (empregado_id_empregado, projeto_id_projeto, papel, horas) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, trabalhaEm.getEmpregado_id_empregado());
            ps.setInt(2, trabalhaEm.getProjeto_id_projeto());
            ps.setString(3, trabalhaEm.getPapel());
            ps.setInt(4, trabalhaEm.getHoras());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void atualizar(Trabalha_em trabalhaEm) throws SQLException {
        String sql = "UPDATE trabalha_em SET empregado_id_empregado = ?, projeto_id_projeto = ?, papel = ?, horas = ? WHERE empregado_id_empregado = ? AND projeto_id_projeto = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, trabalhaEm.getEmpregado_id_empregado());
            ps.setInt(2, trabalhaEm.getProjeto_id_projeto());
            ps.setString(3, trabalhaEm.getPapel());
            ps.setInt(4, trabalhaEm.getHoras());
            ps.setInt(5, trabalhaEm.getEmpregado_id_empregado());
            ps.setInt(6, trabalhaEm.getProjeto_id_projeto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deletar(int empregadoId) throws SQLException {
        String sql = "DELETE FROM trabalha_em WHERE empregado_id_empregado = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, empregadoId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Trabalha_em consultarPorid(int empregadoId) throws SQLException {
        String sql = "SELECT * FROM trabalha_em WHERE empregado_id_empregado = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, empregadoId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Trabalha_em(rs.getInt("empregado_id_empregado"), rs.getInt("projeto_id_projeto"), 
                                        rs.getString("papel"), rs.getInt("horas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Trabalha_em> consultarTodos() throws SQLException {
        List<Trabalha_em> lista = new ArrayList<>();
        String sql = "SELECT * FROM trabalha_em";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trabalha_em trabalhaEm = new Trabalha_em(rs.getInt("empregado_id_empregado"), 
                                                          rs.getInt("projeto_id_projeto"), 
                                                          rs.getString("papel"), 
                                                          rs.getInt("horas"));
                lista.add(trabalhaEm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Trabalha_em consultarPorIds(int idEmpregado, int idProjeto) throws SQLException {
    String sql = "SELECT * FROM trabalha_em WHERE empregado_id_empregado = ? AND projeto_id_projeto = ?";
    try (PreparedStatement ps = conexao.prepareStatement(sql)) {
        ps.setInt(1, idEmpregado);
        ps.setInt(2, idProjeto);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Trabalha_em(
                rs.getInt("empregado_id_empregado"),
                rs.getInt("projeto_id_projeto"),
                rs.getString("papel"),
                rs.getInt("horas")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }
    public void deletar2(int empregadoId, int projetoId) throws SQLException {
    String sql = "DELETE FROM trabalha_em WHERE empregado_id_empregado = ? AND projeto_id_projeto = ?";
    try (PreparedStatement ps = conexao.prepareStatement(sql)) {
        ps.setInt(1, empregadoId);
        ps.setInt(2, projetoId);
        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas == 0) {
            System.out.println("Nenhum registro encontrado para exclusão.");
        } else {
            System.out.println("Relação trabalha_em excluída com sucesso.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
    }
}

