package Interfaces;

import dados.carros.Carro;

public interface IRepositorioCarro {
	
	public void inserirCarro(Carro carro);
	
	public void removerCarro();
	
	public void atualizar();
	
	public Carro pesquisarCarro();
}
