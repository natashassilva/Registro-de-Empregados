package RegistroEmpregados.Modelo;
import java.time.LocalDate;

public class Departamento {
    //criação dos atributos refletindo as colunas da tabela Departamento
    //id_departamento é a chave primária
    private int id_departamento;
    private String nome;
    private String localizacao;
    private LocalDate data_inicio_ger;
    private int id_gerente;

    //crição do construtor com todos os atributos
    public Departamento(int id_departamento, String nome, String localizacao, LocalDate data_inicio_ger, int id_gerente) {
        this.id_departamento = id_departamento;
        this.nome = nome;
        this.localizacao = localizacao;
        this.data_inicio_ger = data_inicio_ger;
        this.id_gerente = id_gerente;
    }

    //sobreposição do construtor somente com o atributo id_departamento que é not null
    public Departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    //criação dos métodos getters e setters para acessar os atributos
    public int getId_departamento() {
        return id_departamento;
    }
    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public LocalDate getData_inicio_ger() {
        return data_inicio_ger;
    }
    public void setData_inicio_ger(LocalDate data_inicio_ger) {
        this.data_inicio_ger = data_inicio_ger;
    }
    public int getId_gerente() {
        return id_gerente;
    }
    public void setId_gerente(int id_gerente) {
        this.id_gerente = id_gerente;
    }

}
