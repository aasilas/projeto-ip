package negocios;

import dados.pessoas.Funcionario;
import exceptions.BIException;
import exceptions.IIException;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioFuncionario;

public class ControleFuncionarios {
	
	private IRepositorioFuncionario funcionarios;
	
	
	public ControleFuncionarios(IRepositorioFuncionario funcionarios){
		this.funcionarios = funcionarios;
	}
		
	public void cadastrarFuncionario(Funcionario funcionario){
		try{
			Funcionario existente = pesquisarFuncionario(funcionario.getCpf());
		}
		catch(Exception e){
			funcionarios.inserirFuncionario(funcionario);
		}
		
	}
	
	public void removerFuncionario(String cpf) throws IIException{
		try{
			funcionarios.removerFuncionario(cpf);
		}
		catch(IIException ii){
			throw new IIException();
		}
	}
	
	public Funcionario pesquisarFuncionario(String cpf) throws BIException{
		try {
			return funcionarios.pesquisarFuncionario(cpf);
		} catch (BIException bi) {
			throw new BIException();
		}
		
	}
	
	public void atualizarFuncionario(Funcionario funcionario){
		this.funcionarios.atualizar(funcionario);
	}
	
	
	public void modificarSenha(String senhaAntiga){
		
	}
	

	public boolean verificarLogin(String login, String senha){
		return false;
	}
	
	public boolean clienteCadastrado(String cpf){
		try{ 
			this.pesquisarFuncionario(cpf);
			return true;
		} catch (BIException bi) {
			return false;
		}
	}
}
