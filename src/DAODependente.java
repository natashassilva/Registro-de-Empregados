package RegistroEmpregados.DAO;
import java.sql.*;
import java.util.*;

import RegistroEmpregados.Modelo.Dependente;

public class DAODependente extends DAOBase<Dependente> {
    
    public DAODependente() {
        super();
    }

    @Override
    public void cadastrar(Dependente dependente) throws SQLException {
        String sql = "INSERT INTO dependente (id_dependente, nome, sexo, datanasc, parentesco, empregado_id_empregado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, dependente.getId_dependente());
            ps.setString(2, dependente.getNome());
            ps.setString(3, dependente.getSexo());
            ps.setDate(4, java.sql.Date.valueOf(dependente.getDatanasc()));
            ps.setString(5, dependente.getParentesco());
            ps.setInt(6, dependente.getEmpregado_id_empregado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    @Override
    public void atualizar(Dependente dependente) throws SQLException {
        String sql = "UPDATE dependente SET nome = ?, sexo = ?, datanasc = ?, parentesco = ? WHERE id_dependente = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, dependente.getNome());
            ps.setString(2, dependente.getSexo());
            ps.setDate(3, java.sql.Date.valueOf(dependente.getDatanasc()));
            ps.setString(4, dependente.getParentesco());
            ps.setInt(5, dependente.getId_dependente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM dependente WHERE id_dependente = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Dependente consultarPorid(int id) throws SQLException {
        String sql = "SELECT * FROM dependente WHERE id_dependente = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Dependente(rs.getInt("id_dependente"), rs.getString("nome"), rs.getString("sexo"),
                        rs.getDate("datanasc").toLocalDate(), rs.getString("parentesco"), rs.getInt("empregado_id_empregado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Dependente> consultarTodos() throws SQLException {
        List<Dependente> dependentes = new ArrayList<>();
        String sql = "SELECT * FROM dependente";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dependente dependente = new Dependente(rs.getInt("id_dependente"), rs.getString("nome"), rs.getString("sexo"),
                        rs.getDate("datanasc").toLocalDate(), rs.getString("parentesco"), rs.getInt("empregado_id_empregado"));
                dependentes.add(dependente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dependentes;
    }

}
