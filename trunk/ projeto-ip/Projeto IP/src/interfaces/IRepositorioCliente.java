package interfaces;

import dados.pessoas.Cliente;
import exceptions.BIException;
import exceptions.IIException;

public interface IRepositorioCliente {

	void inserirCliente(Cliente cliente);

	void removerCliente(String cpf) throws IIException;

	void atualizar(Cliente cliente);

	Cliente pesquisarCliente(String cpf) throws BIException;

	Iterator iterator();
}
