package negocios;

import dados.pessoas.Funcionario;
import exceptions.BIException;
import exceptions.CCException;
import exceptions.IIException;
import exceptions.SIException;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioFuncionario;

public class ControleFuncionarios {
	
	private IRepositorioFuncionario funcionarios;
	
	
	public ControleFuncionarios(IRepositorioFuncionario funcionarios){
		this.funcionarios = funcionarios;
	}
		
	public void cadastrarFuncionario(Funcionario funcionario) throws CCException{
		if(!funcionarioCadastrado(funcionario.getCpf())){
			funcionarios.inserirFuncionario(funcionario);
		}
		else{
			throw new CCException();
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
	
	
	public void modificarSenha(String senhaAntiga, String senhaNova, String  cpf) throws BIException, SIException{
		try{
			Funcionario atual= this.funcionarios.pesquisarFuncionario(cpf);
			if(atual.getSenha().equals(senhaAntiga)){
				atual.setSenha(senhaNova);
				this.atualizarFuncionario(atual);
			}
			else{
				throw new SIException();
			}
		}catch(BIException b){
			throw new BIException();
		}
	}
	

	public boolean verificarLogin(String login, String senha, String cpf){
		boolean retorno = false;
		try{
		Funcionario atual= this.funcionarios.pesquisarFuncionario(cpf);
			if(atual.getLogin().equals(login) && atual.getSenha().equals(senha)){
				retorno = true;
			}
			else{
				retorno = false;
			}
		}catch(BIException b){
			
		}
		return retorno;
	}
	
	public boolean funcionarioCadastrado(String cpf){
		try{ 
			this.pesquisarFuncionario(cpf);
			return true;
		} catch (BIException bi) {
			return false;
		}
	}
}
