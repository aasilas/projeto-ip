package Interfaces;

import dados.pessoas.Cliente;;

public interface IRepositorioCliente {
	
	public void inserirPessoa(Cliente cliente);
	
	public void removerPessoa(Cliente cliente);
	
	public void atualizar();
	
	public Cliente pesquisar();
}
