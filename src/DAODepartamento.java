package RegistroEmpregados.DAO;
import java.sql.*;
import java.util.*;

import RegistroEmpregados.Modelo.Departamento;

import java.sql.PreparedStatement;

// A classe DepartamentoDAO estende a classe DAOBase e implementa os métodos para manipular objetos do tipo Departamento no banco de dados.

public class DAODepartamento extends DAOBase<Departamento> {

    public DAODepartamento() {
    super();
    }

    @Override
    public void cadastrar(Departamento departamento) throws SQLException {
        String sql = "INSERT INTO departamento (id_departamento, nome, localizacao, data_inicio_ger, id_gerente) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, departamento.getId_departamento());
            ps.setString(2, departamento.getNome());
            ps.setString(3, departamento.getLocalizacao());
            ps.setDate(4, java.sql.Date.valueOf(departamento.getData_inicio_ger()));
            ps.setInt(5, departamento.getId_gerente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Departamento departamento) throws SQLException {
        String sql = "UPDATE departamento SET nome = ?, localizacao = ?, data_inicio_ger = ?, id_gerente = ? WHERE id_departamento = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, departamento.getNome());
            ps.setString(2, departamento.getLocalizacao());
            ps.setDate(3, java.sql.Date.valueOf(departamento.getData_inicio_ger()));
            ps.setInt(4, departamento.getId_gerente());
            ps.setInt(5, departamento.getId_departamento());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
    }
}

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM departamento WHERE id_departamento = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
    }
}

    @Override
    public Departamento consultarPorid(int id) throws SQLException {
        String sql = "SELECT * FROM departamento WHERE id_departamento = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Departamento(rs.getInt("id_departamento"), rs.getString("nome"), rs.getString("localizacao"), 
                rs.getDate("data_inicio_ger").toLocalDate(), rs.getInt("id_gerente"));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Departamento> consultarTodos() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM departamento";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                departamentos.add(new Departamento(rs.getInt("id_departamento"), rs.getString("nome"), rs.getString("localizacao"),
                rs.getDate("data_inicio_ger").toLocalDate(), rs.getInt("id_gerente")));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
         // Retorna a lista de departamentos consultados    
        return departamentos;
    }


}
