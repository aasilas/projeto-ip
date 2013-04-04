package dados.clientes.repositorios;

import interfaces.IRepositorioCliente;
import dados.pessoas.Cliente;
import exceptions.*;

public class ArrayClientes implements IRepositorioCliente{

private Cliente[] arrayClientes;
	
	public ArrayClientes (){
		this.arrayClientes = new Cliente[0];
	}
	
	@Override
	public void inserirCliente(Cliente cliente) {
		Cliente[] auxArray = this.arrayClientes;
		this.arrayClientes = new Cliente[arrayClientes.length +1];
		for (int i = 0; i < auxArray.length; i++) {
			this.arrayClientes[i] = auxArray[i];
		}
		this.arrayClientes[arrayClientes.length - 1] = cliente;
	}

	@Override
	public void removerCliente(String cpf) throws IIException {
		boolean removido = false;
		Cliente[] auxArray = new Cliente[arrayClientes.length -1];
		for (int i = 0, j =0; i < arrayClientes.length; i++) {
			if(arrayClientes[i].getCpf() != cpf){
				auxArray[j] = arrayClientes[i]; 
				j++;
			}else{
				removido = true;
			}
		}
		this.arrayClientes = auxArray;
		if(removido == false){
			throw new IIException();
		}
	}

	@Override
	public void atualizar(Cliente cliente) {
		for (int i = 0; i < this.arrayClientes.length; i++) {
			if(this.arrayClientes[i].getCpf() == cliente.getCpf()){
				this.arrayClientes[i] = cliente;
			}
		}
	}

	@Override
	public Cliente pesquisarCliente(String cpf) throws BIException {
		Cliente tempCliente = null;
		boolean encontrado = false;
		for (int i = 0; i < this.arrayClientes.length; i++) {
			if(this.arrayClientes[i].getCpf().equals(cpf)){
				tempCliente = this.arrayClientes[i];
				encontrado = true;
			}
		}
		if(encontrado){
			throw new BIException();
		}
		return tempCliente;
	}

}
