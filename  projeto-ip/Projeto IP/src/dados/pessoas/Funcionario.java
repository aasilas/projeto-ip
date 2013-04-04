package dados.pessoas;

import java.util.Date;

public abstract class Funcionario extends Pessoa {

	private String ctps;
	private String login;
	private String senha;
	private double salarioBase;
	
	public Funcionario(String nome, String cpf, String rg,
			Date dataNascimento, String endereco, String ctps, String login, String senha, double salario) {
		super(nome, cpf, rg, dataNascimento, endereco);
		this.ctps = ctps;
		this.login = login;
		this.senha = senha;
		this.salarioBase = salario;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public abstract double receber();
	

}
