package interfaces;

import dados.pessoas.Funcionario;
import exceptions.BIException;
import exceptions.IIException;

public interface IRepositorioFuncionario {

	public void inserirFuncionario(Funcionario funcionario);
	
	public void removerFuncionario(String cpf) throws IIException;
	
	public void atualizar(Funcionario funcionario);
	
	public Funcionario pesquisarFuncionario(String cpf) throws BIException;
	//sem parametro pq ainda não definimos o tipo d busca que acontecerá.
}
