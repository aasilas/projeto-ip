package negocios;

import interfaces.IRepositorioCarro;

public class ControleCarros {
	private IRepositorioCarro carros;
	
	public ControleCarros(IRepositorioCarro carros){
		this.carros = carros;
	}
}
