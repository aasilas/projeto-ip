package dados.pessoas;

import java.util.Date;

import dados.carros.Carro;

public class Cliente extends Pessoa {

	private String CNH;
	private String email;
	private Carro carro;
	private double pagamento;

	public Cliente(String CNH, String email,  String nome, String cpf, String rg, Date dataNascimento, String endereco){
		super( nome,  cpf,  rg,  dataNascimento,  endereco);
		this.CNH = CNH;
		this.email = email;
		this.pagamento = 0.0;
	
	}

	public String getCNH() {
		return CNH;
	}

	public void setCNH(String CNH) {
		this.CNH = CNH;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public double getPagamento() {
		return pagamento;
	}

	public void setPagamento(double pagamento) {
		this.pagamento = pagamento;
	}
	
	public void formaPagamento(){
		
	}
	
}
