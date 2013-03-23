package Interfaces;

import dados.pessoas.Pessoa;

public interface IRepositorioPessoa {
	
	public void inserirPessoa(Pessoa pessoa);
	
	public void removerPessoa(Pessoa pessoa);
	
	public void atualizar();
	
	public Pessoa pesquisar();
}
