package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import negocios.ControleCarros;
import negocios.ControleClientes;
import negocios.ControleFuncionarios;
import dados.carros.repositorios.ArrayCarros;
import dados.clientes.repositorios.ArrayClientes;
import dados.funcionarios.repositorios.ArrayFuncionarios;
import dados.pessoas.Cliente;
import dados.pessoas.Funcionario;
import exceptions.BDEException;
import exceptions.BIException;
import exceptions.IIException;

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

	
	

	
}
