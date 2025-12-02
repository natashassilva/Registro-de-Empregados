package RegistroEmpregados.Modelo;
import java.time.LocalDate;

public class Dependente {
    //criação dos atributos de acordo com a tabela Dependente 
    private int id_dependente;
    private String nome;
    private String sexo;
    private LocalDate datanasc;
    private String parentesco;
    private int empregado_id_empregado;

    //construtor com todos os atributos
    public Dependente(int id_dependente, String nome, String sexo, LocalDate datanasc, String parentesco, int empregado_id_empregado) {
        this.id_dependente = id_dependente;
        this.nome = nome;
        this.sexo = sexo;
        this.datanasc = datanasc;
        this.parentesco = parentesco;
        this.empregado_id_empregado = empregado_id_empregado;
    }
    //construtor somente com o atributo id_dependente que é not null
    public Dependente(int id_dependente) {
        this.id_dependente = id_dependente;
    }
    //criação dos métodos getters e setters para acessar os atributos
    public int getId_dependente() {
        return id_dependente;
    }
    public void setId_dependente(int id_dependente) {
        this.id_dependente = id_dependente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public LocalDate getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }
    public String getParentesco() {
        return parentesco;
    }
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    public int getEmpregado_id_empregado() {
        return empregado_id_empregado;
    }
    public void setEmpregado_id_empregado(int empregado_id_empregado) {
        this.empregado_id_empregado = empregado_id_empregado;
    }
    
}
