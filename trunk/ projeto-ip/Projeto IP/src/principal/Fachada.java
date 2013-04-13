package principal;

import java.io.*;
import java.util.Date;

import negocios.*;
import dados.carros.repositorios.*;
import dados.clientes.repositorios.*;
import dados.funcionarios.repositorios.*;
import dados.pessoas.Cliente;
import dados.pessoas.Funcionario;
import exceptions.*;
import dados.carros.Carro;


public class Fachada {

	private enum tipoRepo {ARRAY, ARQUIVO, TAD};
	private ControleCarros controleCarros;
	private ControleClientes controleClientes;
	private ControleFuncionarios controlefuncionarios;

	public void carregarRepositorios() throws FileNotFoundException, IOException,
	BDEException {
		File arquivo = new File("bat.txt");
		try {
			FileReader reader = new FileReader(arquivo);
			BufferedReader buffered = new BufferedReader(reader);
			String linha = buffered.readLine();
			if (linha.equalsIgnoreCase(tipoRepo.ARRAY.name())) {
				this.controleCarros = new ControleCarros(new ArrayCarros());
				this.controleClientes = new ControleClientes(new ArrayClientes());
				this.controlefuncionarios = new ControleFuncionarios(new ArrayFuncionarios());
			} else if (linha.equalsIgnoreCase(tipoRepo.TAD.name())) {
				this.controleCarros = new ControleCarros(new ArrayCarros());
				this.controleClientes = new ControleClientes(new ArrayClientes());
				this.controlefuncionarios = new ControleFuncionarios(new ArrayFuncionarios());
			} else if (linha.equalsIgnoreCase(tipoRepo.ARQUIVO.name())) {
				this.controleCarros = new ControleCarros(new ArrayCarros());
				this.controleClientes = new ControleClientes(new ArrayClientes());
				this.controlefuncionarios = new ControleFuncionarios(new ArrayFuncionarios());
			} else {
				throw new BDEException();
			}
		} catch (FileNotFoundException nfEx) {
			throw new FileNotFoundException();
		} catch (IOException ex) {
			throw new IOException();
		}
	}


	public void cadastrarCarro(Carro carro) throws CCException{
		try{
			controleCarros.cadastrarCarro(carro);
		}
		catch(CCException ex){
			throw new CCException();
		}	

	}

	public void removerCarro(String placa) throws IIException{
		try{
			controleCarros.removerCarro(placa);
		}
		catch(IIException ii){
			throw new IIException();
		}
	}

	public Carro pesquisarCarro(String placa) throws BIException{
		try {
			return controleCarros.pesquisarCarro(placa);
		} catch (BIException bi) {
			throw new BIException();
		}

	}

	public void atualizarCarro(Carro carro){
		controleCarros.atualizarCarro(carro);
	}

	public void alugarCarro(String placa, Date entrega, Date saida)throws BIException {
		try {
			controleCarros.alugarCarro(placa, entrega, saida);
		} catch (BIException ex) {
			throw new BIException();
		}
	}

	public void entregarCarro(String placa) throws BIException {
		try {
			controleCarros.entregarCarro(placa);
		} catch (BIException ex) {
			throw new BIException();
		}
	}
	

	
	public void cadastrarCliente(Cliente cliente) throws CCException{
		try {
			controleClientes.cadastrarCliente(cliente);
		} catch (Exception e) {
			throw new CCException();
		}
	}
	
	public void removerCliente(String cpf) throws IIException{
		try{
			controleClientes.removerCliente(cpf);
		}
		catch(IIException ii){
			throw new IIException();
		}
	}
	
	public Cliente pesquisarCliente(String cpf) throws BIException{
		try {
			return controleClientes.pesquisarCliente(cpf);
		} catch (BIException bi) {
			throw new BIException();
		}
	}
	
	public void atualizarCliente(Cliente cliente){
		controleClientes.atualizarCliente(cliente);
	}
	

	
	public void cadastrarFuncionario(Funcionario funcionario) throws CCException{
		try{
			controlefuncionarios.cadastrarFuncionario(funcionario);
		}catch(CCException ii){
			throw new CCException(); 
		}
	}
	
	public void removerFuncionario(String cpf) throws IIException{
		try{
			controlefuncionarios.removerFuncionario(cpf);
		}
		catch(IIException ii){
			throw new IIException();
		}
	}
	
	public Funcionario pesquisarFuncionario(String cpf) throws BIException{
		try {
			return controlefuncionarios.pesquisarFuncionario(cpf);
		} catch (BIException bi) {
			throw new BIException();
		}
		
	}
	
	public void atualizarFuncionario(Funcionario funcionario){
		controlefuncionarios.atualizarFuncionario(funcionario);
	}
	
	
	public void modificarSenha(String senhaAntiga, String senhaNova, String  cpf) throws BIException, SIException{
		try{
			controlefuncionarios.modificarSenha(senhaAntiga, senhaNova, cpf);
		}catch(BIException b){
			throw new BIException();
		}
	}
	

	public boolean verificarLogin(String login, String senha, String cpf){
		return controlefuncionarios.verificarLogin(login, senha, cpf);
	}
	
	

}
