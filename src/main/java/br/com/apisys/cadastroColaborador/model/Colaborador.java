package br.com.apisys.cadastroColaborador.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Colaborador {
	@NotNull
	private Integer id;
	@NotNull
	private String nome; 
	@Size(min=18, max=120)
	private short idade;
	@NotNull
	private double salario;
	
	public Colaborador() {
	}
	public Colaborador(String nome, short idade, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public short getIdade() {
		return idade;
	}
	public void setIdade(short idade) {
		this.idade = idade;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
