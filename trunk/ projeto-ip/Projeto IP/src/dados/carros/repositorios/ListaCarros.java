package dados.carros.repositorios;

import interfaces.IRepositorioCarro;
import dados.carros.Carro;

public class ListaCarros implements IRepositorioCarro{

	private Carro carro;
	private ListaCarros proximo;
	
	public ListaCarros (Carro carro){
		this.carro = carro;
		this.proximo = null;
	}
	
	@Override
	public void inserirCarro(Carro carro) {
		if(this.carro == null){
			this.carro = carro;
			this.proximo = new ListaCarros(null);
		}
		else{
			if(this.proximo == null){
				this.proximo = new ListaCarros(carro); 
			}
			else{
				this.proximo.inserirCarro(carro);
			}
		}
	}

	@Override
	public void removerCarro(String modelo) {
		if (this.carro != null) {
			if (this.carro.getModelo() == modelo) {
				this.carro = this.proximo.carro;
				this.proximo = this.proximo.proximo;
			} else{
				this.proximo.removerCarro(modelo);
			} 
		} else {
			// TODO exception
		}
	}

	@Override
	public void atualizar(Carro carro) {
		if(this.carro != null){
			if(this.carro.getModelo() == carro.getModelo()){
				this.carro = carro;
			}
			else{
				this.proximo.atualizar(carro);
			}
		}
		else{
			//TODO exception
		}
	}

	@Override
	public Carro pesquisarCarro(String modelo) {	
		Carro carroProcurado = null;
		if(this.carro != null){
			if(this.carro.getModelo() == modelo){
				carroProcurado = this.carro;
			}
			else{
				carroProcurado = this.proximo.pesquisarCarro(modelo);
			}
		}
		else{
			//TODO exception
		}
		return carroProcurado;
	}

}
