package Interfaces;

import dados.pessoas.Funcionario;

public interface IRepositorioFuncionario {

	public void inserirFuncionario(Funcionario funcionario);
	
	public void removerFuncionario(Funcionario funcionario);
	
	public void atualizar();
	
	public Funcionario pesquisarFuncionario();
	//sem parametro pq ainda não definimos o tipo d busca que acontecerá.
}
