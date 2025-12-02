package RegistroEmpregados.DAO;
import java.sql.*;
import java.util.*;

import RegistroEmpregados.Modelo.Empregado;

public class DAOEmpregado extends DAOBase<Empregado> {

    public DAOEmpregado() {
        super();
    }

    @Override
    public void cadastrar(Empregado empregado) throws SQLException {
        String sql = "INSERT INTO empregado (id_empregado, nome, rua, bairro, telefone, datanasc, dataadm, funcao, salario, comissao, departamento_id_departamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, empregado.getId_empregado());
            ps.setString(2, empregado.getNome());
            ps.setString(3, empregado.getRua());
            ps.setString(4, empregado.getBairro());
            ps.setString(5, empregado.getTelefone());
            ps.setDate(6, java.sql.Date.valueOf(empregado.getDatanasc()));
            ps.setDate(7, java.sql.Date.valueOf(empregado.getDataadm()));
            ps.setString(8, empregado.getFuncao());
            ps.setDouble(9, empregado.getSalario());
            ps.setDouble(10, empregado.getComissao());
            ps.setInt(11, empregado.getDepartamento_id_departamento());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Empregado empregado) throws SQLException {
        String sql = "UPDATE empregado SET nome = ?, rua = ?, bairro = ?, telefone = ?, datanasc = ?, dataadm = ?, funcao = ?, salario = ?, comissao = ?, departamento_id_departamento = ?  WHERE id_empregado = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, empregado.getNome());
            ps.setString(2, empregado.getRua());
            ps.setString(3, empregado.getBairro());
            ps.setString(4, empregado.getTelefone());
            ps.setDate(5, java.sql.Date.valueOf(empregado.getDatanasc()));
            ps.setDate(6, java.sql.Date.valueOf(empregado.getDataadm()));
            ps.setString(7, empregado.getFuncao());
            ps.setDouble(8, empregado.getSalario());
            ps.setDouble(9, empregado.getComissao());
            ps.setInt(10, empregado.getDepartamento_id_departamento());
            ps.setInt(11, empregado.getId_empregado()); 
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
    }
    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM empregado WHERE id_empregado = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Empregado consultarPorid(int id) throws SQLException {
        String sql = "SELECT * FROM empregado WHERE id_empregado = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Empregado(rs.getInt("id_empregado"), rs.getString("nome"), rs.getString("rua"),
                        rs.getString("bairro"), rs.getString("telefone"),
                        rs.getDate("datanasc").toLocalDate(), rs.getDate("dataadm").toLocalDate(), rs.getString("funcao"), 
                        rs.getDouble("salario"), rs.getDouble("comissao"),
                        rs.getInt("departamento_id_departamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Empregado> consultarTodos() throws SQLException {
        List<Empregado> empregados = new ArrayList<>();
        String sql = "SELECT * FROM empregado";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                empregados.add(new Empregado(rs.getInt("id_empregado"), rs.getString("nome"), rs.getString("rua"),
                        rs.getString("bairro"), rs.getString("telefone"),
                        rs.getDate("datanasc").toLocalDate(), rs.getDate("dataadm").toLocalDate(), rs.getString("funcao"), 
                        rs.getDouble("salario"), rs.getDouble("comissao"),
                        rs.getInt("departamento_id_departamento")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empregados;
    }
}        
