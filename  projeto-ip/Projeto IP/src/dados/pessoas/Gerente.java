package dados.pessoas;

import java.util.Date;

public class Gerente extends Funcionario{

	private boolean controleAcesso;
	
	public Gerente(String nome, String cpf, String rg, Date dataNascimento,
			String endereco, String ctps, String login, String senha,
			double salario) {
		super(nome, cpf, rg, dataNascimento, endereco, ctps, login, senha, salario);
		this.controleAcesso = true;
	}

	public boolean isControleAcesso() {
		return controleAcesso;
	}
	
	public double receber() {
		return getSalarioBase();
	}
	
}
	
	


