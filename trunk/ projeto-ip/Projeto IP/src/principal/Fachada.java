package principal;

import java.io.*;

import dados.carros.repositorios.*;
import dados.clientes.repositorios.*;
import dados.funcionarios.repositorios.*;
import dados.pessoas.*;
import interfaces.*;
import exceptions.*;

public class Fachada {

	private enum tipoRepo {ARRAY, ARQUIVO, TAD};

	private IRepositorioCarro carros;
	private IRepositorioCliente clientes;
	private IRepositorioFuncionario funcionarios;

	public void carregarRepositorios() throws FileNotFoundException, IOException,
			BDEException {
		File arquivo = new File("bat.txt");
		try {
			FileReader reader = new FileReader(arquivo);
			BufferedReader buffered = new BufferedReader(reader);
			String linha = buffered.readLine();
			if (linha.equalsIgnoreCase(tipoRepo.ARRAY.name())) {
				carros = new ArrayCarros();
				clientes = new ArrayClientes();
				funcionarios = new ArrayFuncionarios();
			} else if (linha.equalsIgnoreCase(tipoRepo.TAD.name())) {
				carros = new ArrayCarros();
				clientes = new ArrayClientes();
				funcionarios = new ArrayFuncionarios();
			} else if (linha.equalsIgnoreCase(tipoRepo.ARQUIVO.name())) {
				carros = new ArrayCarros();
				clientes = new ArrayClientes();
				funcionarios = new ArrayFuncionarios();
			} else {
				throw new BDEException();
			}
		} catch (FileNotFoundException nfEx) {
			throw new FileNotFoundException();
		} catch (IOException ex) {
			throw new IOException();
		}
	}

	
	public void cadastrarCliente(Cliente cliente){
		try{
			Cliente existente = pesquisarCliente(cliente.getCpf());
		}
		catch(Exception e){
			clientes.inserirCliente(cliente);
		}
		
	}
	
	public void removerCliente(String cpf) throws IIException{
		try{
			clientes.removerCliente(cpf);
		}
		catch(IIException ii){
			throw new IIException();
		}
	}
	
	public Cliente pesquisarCliente(String cpf) throws BIException{
		try {
			return clientes.pesquisarCliente(cpf);
		} catch (BIException bi) {
			throw new BIException();
		}
		
	}
	
	public void atualizarCliente(Cliente cliente){
		this.clientes.atualizar(cliente);
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
	
}
