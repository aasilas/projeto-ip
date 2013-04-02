package dados.carros;



public class Carro{

	private static final long serialVersionUID = 1L;
	
	private int porta;
	private String potencia;
	private String modelo;
	private String marca;
	private String categoria;
	private Adicionais adicionais;
	private double valor;
	private Veiculos [] quantidade ;
	private String placa;
	
	public Carro(int porta, String potencia, String modelo, String marca, 
			String categoria, Adicionais adicionais, double valor, String placa){
		this.porta = porta;
		this.modelo = modelo;
		this.potencia = potencia;
		this.marca = marca;
		this.categoria = categoria;
		this.adicionais = adicionais;
		this.valor = valor;
		this.quantidade = new Veiculos[1];
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

	public int getNumVeiculos(){
		int count = 0;
		for (int i = 0; i < quantidade.length; i++) {
			if(quantidade[i].getDisponibilidade()){
				count++;
			}
		}
		return count;
	}
	
	public void adicionarVeiculo(int adicional){
		Veiculos [] aux = new Veiculos[quantidade.length + adicional];
		for (int i = 0; i < quantidade.length; i++) {
			aux [i] = quantidade[i];
		}
		this.quantidade = aux;
	}
	
	public void setAlugar(String saida, String entrega){
		
		for (int i = 0; i < quantidade.length; ) {
			if(quantidade[i].getDisponibilidade()){
				quantidade[i].setAlugar(entrega, saida);
			}
			else{
				i++;
			}
		}
	}
	
	public void setEntregar(){
		
		for (int i = 0; i < quantidade.length; ) {
			if(!quantidade[i].getDisponibilidade()){
				quantidade[i].setEntregar();
			}else{
				i++;
			}
		}
	}
}
