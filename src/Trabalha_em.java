package RegistroEmpregados.Modelo;

public class Trabalha_em {
    //Criação dos atributos de acordo com a tabela Trabalha_em
    private int empregado_id_empregado;
    private int projeto_id_projeto;
    private String papel;
    private int horas;

    //Construtor com todos os atributos
    public Trabalha_em(int empregado_id_empregado, int projeto_id_projeto, String papel, int horas) {
        this.empregado_id_empregado = empregado_id_empregado;
        this.projeto_id_projeto = projeto_id_projeto;
        this.papel = papel;
        this.horas = horas;
    }
    //Construtor somente com o atributo empregado_id_empregado e projeto_id_projeto que são not null
    public Trabalha_em(int empregado_id_empregado, int projeto_id_projeto) {
        this.empregado_id_empregado = empregado_id_empregado;
        this.projeto_id_projeto = projeto_id_projeto;
    }
    //Criação dos métodos getters e setters para acessar os atributos
    public int getEmpregado_id_empregado() {
        return empregado_id_empregado;
    }
    public void setEmpregado_id_empregado(int empregado_id_empregado) {
        this.empregado_id_empregado = empregado_id_empregado;
    }
    public int getProjeto_id_projeto() {
        return projeto_id_projeto;
    }
    public void setProjeto_id_projeto(int projeto_id_projeto) {
        this.projeto_id_projeto = projeto_id_projeto;
    }
    public String getPapel() {
        return papel;
    }
    public void setPapel(String papel) {
        this.papel = papel;
    }
    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
    
}
