package RegistroEmpregados.DAO;
import java.sql.*;
import java.util.*;

import RegistroEmpregados.Modelo.Projeto;

public class DAOProjeto extends DAOBase<Projeto> {

    public DAOProjeto() {
        super();
    }

    @Override
    public void cadastrar(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO projeto (id_projeto, nome, situacao, departamento_id_departamento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, projeto.getId_projeto());
            ps.setString(2, projeto.getNome());
            ps.setString(3, projeto.getSituacao());
            ps.setInt(4, projeto.getDepartamento_id_departamento());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Projeto projeto) throws SQLException {
        String sql = "UPDATE projeto SET nome = ?, situacao = ?, departamento_id_departamento = ? WHERE id_projeto = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getSituacao());
            ps.setInt(3, projeto.getDepartamento_id_departamento());
            ps.setInt(4, projeto.getId_projeto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM projeto WHERE id_projeto = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Projeto consultarPorid(int id) throws SQLException {
        String sql = "SELECT * FROM projeto WHERE id_projeto = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Projeto(rs.getInt("id_projeto"), rs.getString("nome"), rs.getString("situacao"), 
                                   rs.getInt("departamento_id_departamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Projeto> consultarTodos() throws SQLException {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT * FROM projeto";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Projeto projeto = new Projeto(rs.getInt("id_projeto"), rs.getString("nome"), rs.getString("situacao"), 
                                               rs.getInt("departamento_id_departamento"));
                projetos.add(projeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }
}
