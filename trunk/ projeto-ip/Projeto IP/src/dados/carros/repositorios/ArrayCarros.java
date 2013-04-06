package dados.carros.repositorios;

import interfaces.IRepositorioCarro;
import dados.carros.Carro;

public class ArrayCarros implements IRepositorioCarro{

	private Carro[] arrayCarros;
	
	public ArrayCarros(){
		this.arrayCarros = new Carro[0];
	}
	      
	@Override
	public void inserirCarro(Carro carro) {
		Carro[] auxArray = this.arrayCarros;
		this.arrayCarros = new Carro[arrayCarros.length +1];
		for (int i = 0; i < auxArray.length; i++) {
			this.arrayCarros[i] = auxArray[i];
		}
		this.arrayCarros[arrayCarros.length - 1] = carro;
	}

	@Override
	public void removerCarro(String placa) {
		Carro[] auxArray = new Carro[arrayCarros.length -1];
		for (int i = 0, j =0; i < arrayCarros.length; i++) {
			if(arrayCarros[i].getPlaca() != placa){
				auxArray[j] = arrayCarros[i]; 
				j++;
			}
		}
		this.arrayCarros = auxArray;
	}

	@Override
	public void atualizar(Carro carro) {
		for (int i = 0; i < this.arrayCarros.length; i++) {
			if(this.arrayCarros[i].getPlaca() == carro.getPlaca()){
				this.arrayCarros[i] = carro;
			}
		}
	}

	@Override
	public Carro pesquisarCarro(String placa) {
		Carro tempCarro = null;
		for (int i = 0; i < this.arrayCarros.length; i++) {
			if(this.arrayCarros[i].getPlaca().equals(placa)){
				tempCarro = this.arrayCarros[i];
			}
			else{
				//TODO exception
			}
		}
		return tempCarro;
	}

}