package interfaces;

import dados.carros.Carro;
import exceptions.BIException;

public interface IRepositorioCarro {
	
	public void inserirCarro(Carro carro);
	
	public void removerCarro(String modelo);
	
	public void atualizar(Carro carro);
	
	public Carro pesquisarCarro(String modelo) throws BIException ;
}
