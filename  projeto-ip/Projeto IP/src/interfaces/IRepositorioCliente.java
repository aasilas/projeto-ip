package interfaces;

import dados.pessoas.Cliente;
import exceptions.BIException;
import exceptions.IIException;

public interface IRepositorioCliente {
	
	public void inserirCliente(Cliente cliente);
	
	public void removerCliente(String cpf) throws IIException;
	
	public void atualizar(Cliente cliente);
	
	public Cliente pesquisarCliente(String cpf) throws BIException;
}
