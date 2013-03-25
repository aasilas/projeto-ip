package Interfaces;

import dados.pessoas.Funcionario;

public interface IRepositorioFuncionario {

	public void inserirFuncionario(Funcionario funcionario);
	
	public void removerFuncionario(String cpf);
	
	public void atualizar(Funcionario funcionario);
	
	public Funcionario pesquisarFuncionario(String cpf);
	//sem parametro pq ainda não definimos o tipo d busca que acontecerá.
}
