package negocios;

import java.util.Date;

import dados.carros.Carro;
import exceptions.BIException;
import exceptions.CCException;
import exceptions.IIException;
import interfaces.IRepositorioCarro;

public class ControleCarros {
	private IRepositorioCarro carros;
	
	public ControleCarros(IRepositorioCarro carros){
		this.carros = carros;
	}
	
	public void cadastrarCarro(Carro carro) throws CCException{
		if(!carroCadastrado(carro.getPlaca())){
			carros.inserirCarro(carro);
		}
		else{
			throw new CCException();
		}	
		
	}
	
	public void removerCarro(String placa) throws IIException{
		try{
			carros.removerCarro(placa);
		}
		catch(IIException ii){
			throw new IIException();
		}
	}
	
	public Carro pesquisarCarro(String placa) throws BIException{
		try {
			return carros.pesquisarCarro(placa);
		} catch (BIException bi) {
			throw new BIException();
		}
		
	}
	
	public void atualizarCarro(Carro carro){
		this.carros.atualizar(carro);
	}
	
	public boolean carroCadastrado(String placa){
		try{ 
			this.pesquisarCarro(placa);
			return true;
		} catch (BIException bi) {
			return false;
		}
	}
	
	public void alugarCarro(String placa, Date entrega, Date saida)throws BIException {
		try {
			pesquisarCarro(placa).setAlugar(saida, entrega);
		} catch (BIException ex) {
			throw new BIException();
		}
	}

	public void entregarCarro(String placa) throws BIException {
		try {
			pesquisarCarro(placa).setEntregar();
		} catch (BIException ex) {
			throw new BIException();
		}

	}

	
}
