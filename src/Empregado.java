package RegistroEmpregados.Modelo;
import java.time.LocalDate;

public class Empregado {
    //criação dos atributos de acordo com a tabela Empregado
    private int id_empregado;
    private String nome;
    private String rua;
    private String bairro;
    private String telefone;
    private LocalDate datanasc;
    private LocalDate dataadm;
    private String funcao;
    private double salario;
    private double comissao;
    private int departamento_id_departamento;

    //construtor com todos os atributos
    public Empregado(int id_empregado, String nome, String rua, String bairro, String telefone, LocalDate datanasc, LocalDate dataadm, String funcao, double salario, double comissao, int departamento_id_departamento) {
        this.id_empregado = id_empregado;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.telefone = telefone;
        this.datanasc = datanasc;
        this.dataadm = dataadm;
        this.funcao = funcao;
        this.salario = salario;
        this.comissao = comissao;
        this.departamento_id_departamento = departamento_id_departamento;
    }
    //construtor somente com o atributo id_empregado que é not null
    public Empregado(int id_empregado) {
        this.id_empregado = id_empregado;
    }
    //criação dos métodos getters e setters para acessar os atributos
    public int getId_empregado() {
        return id_empregado;
    }
    public void setId_empregado(int id_empregado) {
        this.id_empregado = id_empregado;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public LocalDate getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }
    public LocalDate getDataadm() {
        return dataadm;
    }
    public void setDataadm(LocalDate dataadm) {
        this.dataadm = dataadm;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    public int getDepartamento_id_departamento() {
        return departamento_id_departamento;
    }
    public void setDepartamento_id_departamento(int departamento_id_departamento) {
        this.departamento_id_departamento = departamento_id_departamento;
    }
    
}
