package dados.carros.repositorios;

import interfaces.IRepositorioCarro;
import interfaces.Iterator;
import dados.carros.Carro;
import exceptions.BIException;
import exceptions.IIException;

public class ListaCarros implements IRepositorioCarro, Iterator<Carro> {

	private Carro carro;
	private ListaCarros proximo;

	public ListaCarros(Carro carro) {
		this.carro = carro;
		this.proximo = null;
	}

	@Override
	public void inserirCarro(Carro carro) {
		if (this.carro == null) {
			this.carro = carro;
			this.proximo = new ListaCarros(null);
		} else {
			if (this.proximo == null) {
				this.proximo = new ListaCarros(carro);
			} else {
				this.proximo.inserirCarro(carro);
			}
		}
	}

	@Override
	public void removerCarro(String placa) throws IIException {
		if (this.carro != null) {
			if (this.carro.getPlaca() == placa) {
				this.carro = this.proximo.carro;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.removerCarro(placa);
			}
		} else {
			throw new IIException();
		}
	}

	@Override
	public void atualizar(Carro carro) {
		if (this.carro != null) {
			if (this.carro.getPlaca() == carro.getPlaca()) {
				this.carro = carro;
			} else {
				this.proximo.atualizar(carro);
			}
		} else {
			// TODO exception
		}
	}

	@Override
	public Carro pesquisarCarro(String placa) throws BIException {
		Carro carroProcurado = null;
		if (this.carro != null) {
			if (this.carro.getPlaca() == placa) {
				carroProcurado = this.carro;
			} else {
				carroProcurado = this.proximo.pesquisarCarro(placa);
			}
		} else {
			throw new BIException();
		}
		return carroProcurado;
	}

	@Override
	public Iterator<Carro> iterator() {
		return new ListaCarrosIterator().iterator();
	}
	
	@Override
	public Carro next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private class ListaCarrosIterator implements  Iterator<Carro> {
		Carro atual = carro;

		@Override
		public Carro next() {
			if(hasNext()){
				Carro aux = atual;
				atual = proximo.carro;
				return aux;
			}
			else{
				 throw new java.util.NoSuchElementException("error next element iterator ");
			}
		}

		@Override
		public boolean hasNext() {
			if(atual != null)
				return true;
			else
				return false;
		}

		@Override
		public Iterator<Carro> iterator() {
			return this;
		}

	}
}
