package RegistroEmpregados.DAO;
import java.sql.SQLException;
import java.util.List;
//Criação de uma interface genérica DAO<T> que define os métodos básicos para operações CRUD (Create, Read, Update, Delete).
// A interface é parametrizada com o tipo T, permitindo que seja usada com diferentes tipos de objetos.
public interface DAO<T> {

    void cadastrar (T objeto) throws SQLException;
    void atualizar (T objeto) throws SQLException;
    void deletar (int id) throws SQLException;
    T consultarPorid(int id) throws SQLException;
    List<T> consultarTodos() throws SQLException;
}
// A interface DAO<T> define os métodos que devem ser implementados por qualquer classe que deseje atuar como um DAO (Data Access Object).
// Esses métodos incluem:
// - cadastrar: para inserir um novo objeto no banco de dados.
// - atualizar: para atualizar um objeto existente no banco de dados.
// - deletar: para remover um objeto do banco de dados com base em seu ID.
// - consultarPorid: para buscar um objeto específico pelo seu ID.
// - consultarTodos: para recuperar todos os objetos do tipo T armazenados no banco de dados.