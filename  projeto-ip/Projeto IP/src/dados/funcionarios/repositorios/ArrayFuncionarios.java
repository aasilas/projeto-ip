package dados.funcionarios.repositorios;

import interfaces.IRepositorioFuncionario;
import dados.pessoas.Funcionario;

public class ArrayFuncionarios implements IRepositorioFuncionario{

	private Funcionario[] arrayFuncionarios;
	
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
	public void removerFuncionario(String cpf) {
		Funcionario[] auxArray = new Funcionario[arrayFuncionarios.length -1];
		for (int i = 0, j =0; i < arrayFuncionarios.length; i++) {
			if(arrayFuncionarios[i].getCpf() != cpf){
				auxArray[j] = arrayFuncionarios[i]; 
				j++;
			}
		}
		this.arrayFuncionarios = auxArray;
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
	public Funcionario pesquisarFuncionario(String cpf) {	
		Funcionario tempFuncionario = null;
		for (int i = 0; i < this.arrayFuncionarios.length; i++) {
			if(this.arrayFuncionarios[i].getCpf().equals(cpf)){
				tempFuncionario = this.arrayFuncionarios[i];
			}
			else{
				//TODO exception
			}
		}
		return tempFuncionario;
	}

}
