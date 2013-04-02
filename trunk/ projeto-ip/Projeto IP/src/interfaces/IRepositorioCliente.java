package interfaces;

import dados.pessoas.Cliente;;

public interface IRepositorioCliente {
	
	public void inserirCliente(Cliente cliente);
	
	public void removerCliente(String cpf);
	
	public void atualizar(Cliente cliente);
	
	public Cliente pesquisarCliente(String cpf);
}
