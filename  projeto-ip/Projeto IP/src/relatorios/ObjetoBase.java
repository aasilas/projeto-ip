package relatorios;

public class ObjetoBase implements java.io.Serializable{
	private int carrosAlugados;
	private	double totalVendas;
	private double lucro;
	private String mes;
	
	public ObjetoBase(int carrosAlugados, double totalVendas, double lucro, String mes) {
		super();
		this.carrosAlugados = carrosAlugados;
		this.totalVendas = totalVendas;
		this.lucro = lucro;
		this.mes= mes;
	}
	
	public int getCarrosAlugados() {
		return carrosAlugados;
	}
	public void setCarrosAlugados(int carrosAlugados) {
		this.carrosAlugados = carrosAlugados;
	}
	public double getTotalVendas() {
		return totalVendas;
	}
	
	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}
	public double getLucro() {
		return lucro;
	}
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}

	@Override
	public String toString() {
		return "\n Mês : " +this.mes + "\n carrosAlugados = " + this.carrosAlugados
				+ ", totalVendas = " + this.totalVendas + "R$, lucro = " + this.lucro +"R$";
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
}
