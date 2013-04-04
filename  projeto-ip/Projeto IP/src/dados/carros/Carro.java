package dados.carros;

import java.util.Date;



public class Carro{

	private static final long serialVersionUID = 1L;
	
	private int porta;
	private String potencia;
	private String modelo;
	private String marca;
	private String categoria;
	private Adicionais adicionais;
	private double valor;
	private String placa;
	private boolean disponibilidade;
	private Date dataSaida;
	private Date dataEntrega;
	
	public Carro(String placa, int porta, String potencia, String modelo, String marca, 
			String categoria, Adicionais adicionais, double valor ){
		this.porta = porta;
		this.modelo = modelo;
		this.potencia = potencia;
		this.marca = marca;
		this.categoria = categoria;
		this.adicionais = adicionais;
		this.valor = valor;
		this.placa = placa;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Adicionais getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(Adicionais adicionais) {
		this.adicionais = adicionais;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public Date getDataSaida() {
		return dataSaida;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setAlugar(Date saida, Date entrega){
		this.dataEntrega = entrega;
		this.dataSaida = saida;
		this.disponibilidade = false;
	}
	
	public void setEntregar(){
		this.dataEntrega = null;
		this.dataSaida = null;
		this.disponibilidade = true;
	}
}
