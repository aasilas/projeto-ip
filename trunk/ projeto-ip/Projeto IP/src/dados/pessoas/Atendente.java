package dados.pessoas;

public class Atendente extends Funcionario{

	private double comissao;
	private int meta;
	
	public Atendente(String nome, String cpf, String rg, String dataNascimento,
			String endereco, String ctps, String login, String senha,
			double salario) {
		super(nome, cpf, rg, dataNascimento, endereco, ctps, login, senha, salario);
		
	}

	
	public double getComissao() {
		return comissao;
	}


	public void setComissao(double comissao) {
		this.comissao += comissao;
	}


	public int getMeta() {
		return meta;
	}


	public void setMeta(int meta) {
		this.meta = meta;
	}


	public double receber() {
		double salario = getSalarioBase()+ this.comissao;
		return salario;
	}

	
}
