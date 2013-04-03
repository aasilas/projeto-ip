package Repositorios;


import dados.carros.*;
import dados.carros.repositorios.*;
import dados.funcionarios.repositorios.RepositorioFuncionarioArquivo;
import dados.pessoas.Atendente;
import dados.pessoas.Funcionario;
public class Teste {

	
	public static void main(String[] args) {
		
		Adicionais adicionais = new Adicionais(true, true, false, true, true, false, true);
		Carro carro = new Carro(5, "1000C", "2012","Ferrari" , "4x4",adicionais , 200.00, "alk-1234");
		Carro carro2 = new Carro(0, "asda", "modelo", "hdasdh", "categ",adicionais ,150.00,"adasd");
		Carro carro3 = new Carro(0, "asda", "modelo", "hdasdh", "categ",adicionais ,150.00,"adasd");
		Atendente func = new Atendente("msad", "dsad54", "874564", "21/00/00", "asdasd", "marcio", "mmcj", "23244", 500.00);
			
		
		RepositorioCarroArquivo repositorio = new RepositorioCarroArquivo();
		//repositorio.inserirCarro(carro);
	//	repositorio.inserirCarro(carro2);
		repositorio.removerCarro("adasd");
		RepositorioFuncionarioArquivo rep = new RepositorioFuncionarioArquivo();
		rep.inserirFuncionario(func);
		//repositorio.inserirCarro(carro3);
	}
	}

