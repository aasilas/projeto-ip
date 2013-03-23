package dados.carros;

public class Veiculos {
	
	private boolean disponibilidade;
	
	private String dataSaida;

	private String dataEntrega;
	
	public Veiculos(){
		this.disponibilidade = true;
	}

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setAlugar(String dataEntrega,String dataSaida) {
		this.dataEntrega = dataEntrega;
		this.dataSaida = dataSaida;
		this.disponibilidade = false;
	}
	
	public void setEntregar(){
		this.dataEntrega = "";
		this.dataSaida = "";
		this.disponibilidade = true;
	}
	
}


