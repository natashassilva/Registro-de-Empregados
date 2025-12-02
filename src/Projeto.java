package RegistroEmpregados.Modelo;

public class Projeto {
    //Criação dos atributos de acordo com a tabela Projeto
    private int id_projeto;
    private String nome;
    private String situacao;
    private int departamento_id_departamento;

    //Construtor com todos os atributos
    public Projeto(int id_projeto, String nome, String situacao, int departamento_id_departamento) {
        this.id_projeto = id_projeto;
        this.nome = nome;
        this.situacao = situacao;
        this.departamento_id_departamento = departamento_id_departamento;
    }
    //Construtor somente com o atributo id_projeto que é not null
    public Projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }
    //Criação dos métodos getters e setters para acessar os atributos
    public int getId_projeto() {
        return id_projeto;
    }
    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public int getDepartamento_id_departamento() {
        return departamento_id_departamento;
    }
    public void setDepartamento_id_departamento(int departamento_id_departamento) {
        this.departamento_id_departamento = departamento_id_departamento;
    }
    
}
