package RegistroEmpregados.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Conexao.Conexao;

public abstract class DAOBase<T> implements DAO<T> {
    // A classe DAOBase implementa a interface DAO<T> e define uma conexão com o banco de dados.
    protected Connection conexao;

    public DAOBase() {
        
        this.conexao = Conexao.getConexao();
 
    }
    // A classe DAOBase é uma classe abstrata que implementa a interface DAO<T>.
    // Ela contém um construtor que recebe uma conexão com o banco de dados e a armazena em um campo protegido.
    @Override
    public abstract void cadastrar(T objeto) throws SQLException;

    @Override
    public abstract void atualizar(T objeto) throws SQLException;

    @Override
    public abstract void deletar(int id) throws SQLException;

    @Override
    public abstract T consultarPorid(int id) throws SQLException;

    @Override
    public abstract List<T> consultarTodos() throws SQLException;

}
