package relatorios;

public class ObjetoBase {
	private int carrosAlugados;
	private	double totalVendas;
	private double lucro;
	
	public ObjetoBase(int carrosAlugados, double totalVendas, double lucro) {
		super();
		this.carrosAlugados = carrosAlugados;
		this.totalVendas = totalVendas;
		this.lucro = lucro;
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
		return "carrosAlugados = " + carrosAlugados
				+ ", totalVendas = " + totalVendas + ", lucro = " + lucro;
	}
	
	
}
