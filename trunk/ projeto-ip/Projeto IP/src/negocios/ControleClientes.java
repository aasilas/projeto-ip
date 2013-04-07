package negocios;

import dados.pessoas.Cliente;
import exceptions.BIException;
import exceptions.CCException;
import exceptions.IIException;
import interfaces.IRepositorioCliente;

public class ControleClientes {
	
	private IRepositorioCliente clientes;
	
	public ControleClientes(IRepositorioCliente clientes){
		this.clientes = clientes;
	}
	
	public void cadastrarCliente(Cliente cliente) throws CCException{
		if(!clienteCadastrado(cliente.getCpf())){
			clientes.inserirCliente(cliente);
		}
		else{
			throw new CCException();
		}	
		
	}
	
	public void removerCliente(String cpf) throws IIException{
		try{
			clientes.removerCliente(cpf);
		}
		catch(IIException ii){
			throw new IIException();
		}
	}
	
	public Cliente pesquisarCliente(String cpf) throws BIException{
		try {
			return clientes.pesquisarCliente(cpf);
		} catch (BIException bi) {
			throw new BIException();
		}
		
	}
	
	public void atualizarCliente(Cliente cliente){
		this.clientes.atualizar(cliente);
	}
	
	public boolean clienteCadastrado(String cpf){
		try{ 
			this.pesquisarCliente(cpf);
			return true;
		} catch (BIException bi) {
			return false;
		}
	}

}
