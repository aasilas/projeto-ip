package dados.carros.repositorios;

import interfaces.*;
import dados.carros.Carro;
import exceptions.BIException;
import exceptions.IIException;

public class ArrayCarros implements IRepositorioCarro, Iterator<Carro>{

	private Carro[] arrayCarros;
	private int count = 0;
	
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
	public void removerCarro(String placa) throws IIException {
		boolean removido = false;
		Carro[] auxArray = new Carro[arrayCarros.length -1];
		for (int i = 0, j =0; i < arrayCarros.length; i++) {
			if(arrayCarros[i].getPlaca() != placa){
				auxArray[j] = arrayCarros[i]; 
				j++;
			}else{
				removido = true;
			}
		}
		this.arrayCarros = auxArray;
		if(removido == false){
			throw new IIException();
		}
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
	public Carro pesquisarCarro(String placa) throws BIException {
		Carro tempCarro = null;
		for (int i = 0; i < this.arrayCarros.length; i++) {
			if(this.arrayCarros[i].getPlaca().equals(placa)){
				tempCarro = this.arrayCarros[i];
			}
			else{
				throw new BIException();
			}
		}
		return tempCarro;
	}

	@Override
	public Carro next() {
		count++;
		return arrayCarros[count -1];
	}

	@Override
	public boolean hasNext() {
		if(count < arrayCarros.length)
			return true;
		else
			return false;
		
	}

	@Override
	public Iterator<Carro> iterator() {
		return this;
	}
	
}
