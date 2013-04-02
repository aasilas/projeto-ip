package principal;

import java.io.*;

import dados.carros.repositorios.*;
import dados.clientes.repositorios.*;
import dados.funcionarios.repositorios.*;
import interfaces.*;
import exceptions.*;

public class Fachada {

	private enum tipoRepo {
		ARRAY, ARQUIVO, TAD
	};

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

}
