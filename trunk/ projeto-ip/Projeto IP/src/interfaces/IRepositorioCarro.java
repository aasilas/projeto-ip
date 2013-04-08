package interfaces;

import java.util.Date;

import dados.carros.Carro;
import exceptions.BIException;
import exceptions.IIException;

public interface IRepositorioCarro {

	public void inserirCarro(Carro carro);

	public void removerCarro(String placa) throws IIException;

	public void atualizar(Carro carro);

	public Carro pesquisarCarro(String placa) throws BIException;
	
}
