package dados.funcionarios.repositorios;

import interfaces.IRepositorioFuncionario;
import dados.pessoas.Funcionario;

public class ListaFuncionarios implements IRepositorioFuncionario{
	
	private Funcionario funcionario;
	private ListaFuncionarios proximo;
	
	public ListaFuncionarios (Funcionario funcionario){
		this.funcionario = funcionario;
		this.proximo = null;
	}
	
	@Override
	public void inserirFuncionario(Funcionario funcionario) {
		if(this.funcionario == null){
			this.funcionario = funcionario;
			this.proximo = new ListaFuncionarios(null);
		}
		else{
			if(this.proximo == null){
				this.proximo = new ListaFuncionarios(funcionario); 
			}
			else{
				this.proximo.inserirFuncionario(funcionario);
			}
		}
	}

	@Override
	public void removerFuncionario(String cpf) {
		if (this.funcionario != null) {
			if (this.funcionario.getCpf() == cpf) {
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			} else{
				this.proximo.removerFuncionario(cpf);
			} 
		} else {
			// TODO exception
		}
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		if(this.funcionario != null){
			if(this.funcionario.getCpf() == funcionario.getCpf()){
				this.funcionario = funcionario;
			}
			else{
				this.proximo.atualizar(funcionario);
			}
		}
		else{
			//TODO exception
		}
	}

	@Override
	public Funcionario pesquisarFuncionario(String cpf) {	
		Funcionario funcionarioProcurado = null;
		if(this.funcionario != null){
			if(this.funcionario.getCpf() == cpf){
				funcionarioProcurado = this.funcionario;
			}
			else{
				funcionarioProcurado = this.proximo.pesquisarFuncionario(cpf);
			}
		}
		else{
			//TODO exception
		}
		return funcionarioProcurado;
	}


}
