package interfaces;

import java.util.Date;

import dados.carros.Carro;
import exceptions.BIException;
import exceptions.IIException;

public interface IRepositorioCarro {

	 void inserirCarro(Carro carro);

	 void removerCarro(String placa) throws IIException;

	 void atualizar(Carro carro);

	 Carro pesquisarCarro(String placa) throws BIException;
	 
	 Iterator iterator();
	
}
