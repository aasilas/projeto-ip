package dados.clientes.repositorios;

import dados.pessoas.Cliente;
import Interfaces.IRepositorioCliente;

public class ListaClientes implements IRepositorioCliente{

	private Cliente cliente;
	private ListaClientes proximo;
	
	public ListaClientes (Cliente cliente){
		this.cliente = cliente;
		this.proximo = null;
	}
	
	
	@Override
	public void inserirCliente(Cliente cliente) {
		if(this.cliente == null){
			this.cliente = cliente;
			this.proximo = new ListaClientes(null);
		}
		else{
			if(this.proximo == null){
				this.proximo = new ListaClientes(cliente); 
			}
			else{
				this.proximo.inserirCliente(cliente);
			}
		}
	}

	@Override
	public void removerCliente(String cpf) {
		if (this.cliente != null) {
			if (this.cliente.getCpf() == cpf) {
				this.cliente = this.proximo.cliente;
				this.proximo = this.proximo.proximo;
			} else{
				this.proximo.removerCliente(cpf);
			} 
		} else {
			// TODO exception
		}
	}

	@Override
	public void atualizar(Cliente cliente) {
		if(this.cliente != null){
			if(this.cliente.getCpf() == cliente.getCpf()){
				this.cliente = cliente;
			}
			else{
				this.proximo.atualizar(cliente);
			}
		}
		else{
			//TODO exception
		}
	}

	@Override
	public Cliente pesquisarCliente(String cpf) {
		Cliente clienteProcurado = null;
		if(this.cliente != null){
			if(this.cliente.getCpf() == cpf){
				clienteProcurado = this.cliente;
			}
			else{
				clienteProcurado = this.proximo.pesquisarCliente(cpf);
			}
		}
		else{
			//TODO exception
		}
		return clienteProcurado;
	}

}
