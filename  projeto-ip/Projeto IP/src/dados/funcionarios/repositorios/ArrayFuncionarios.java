package dados.funcionarios.repositorios;

import interfaces.IRepositorioFuncionario;
import interfaces.Iterator;
import dados.carros.Carro;
import dados.pessoas.Funcionario;
import exceptions.BIException;
import exceptions.IIException;

public class ArrayFuncionarios implements IRepositorioFuncionario, Iterator<Funcionario>{

	private Funcionario[] arrayFuncionarios;
	private int count = 0;
	
	public ArrayFuncionarios (){
		this.arrayFuncionarios = new Funcionario[0];
	}
	
	@Override
	public void inserirFuncionario(Funcionario funcionario) {
		Funcionario[] auxArray = this.arrayFuncionarios;
		this.arrayFuncionarios = new Funcionario[arrayFuncionarios.length +1];
		for (int i = 0; i < auxArray.length; i++) {
			this.arrayFuncionarios[i] = auxArray[i];
		}
		this.arrayFuncionarios[arrayFuncionarios.length - 1] = funcionario;
	}

	@Override
	public void removerFuncionario(String cpf) throws IIException {
		boolean removido = false;
		Funcionario[] auxArray = new Funcionario[arrayFuncionarios.length -1];
		for (int i = 0, j =0; i < arrayFuncionarios.length; i++) {
			if(arrayFuncionarios[i].getCpf() != cpf){
				auxArray[j] = arrayFuncionarios[i]; 
				j++;
			}
			else{
				removido = true;
			}
		}
		this.arrayFuncionarios = auxArray;
		if(removido == false){
			throw new IIException();
		}
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		for (int i = 0; i < this.arrayFuncionarios.length; i++) {
			if(this.arrayFuncionarios[i].getCpf() == funcionario.getCpf()){
				this.arrayFuncionarios[i] = funcionario;
			}
		}
	}

	@Override
	public Funcionario pesquisarFuncionario(String cpf) throws BIException {	
		Funcionario tempFuncionario = null;
		boolean encontrado = false;
		for (int i = 0; i < this.arrayFuncionarios.length; i++) {
			if(this.arrayFuncionarios[i].getCpf().equals(cpf)){
				tempFuncionario = this.arrayFuncionarios[i];
				encontrado = true;
			}
		}
		if(encontrado){
			throw new BIException();
		}
		return tempFuncionario;
	}

	@Override
	public Funcionario next() {
		count++;
		return arrayFuncionarios[count -1];
	}

	@Override
	public boolean hasNext() {
		if(count < arrayFuncionarios.length)
			return true;
		else
			return false;
		
	}

	@Override
	public Iterator<Funcionario> iterator() {
		return this;
	}

}
