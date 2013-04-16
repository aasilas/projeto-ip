package Repositorios;


import java.util.Date;

import principal.Fachada;
import relatorios.ObjetoBase;
import relatorios.RelatorioMensal;

import interfaces.IRepositorioCarro;
import interfaces.Iterator;

import dados.carros.*;
import dados.carros.repositorios.*;
import dados.funcionarios.repositorios.ArquivoFuncionarios;
import dados.pessoas.Atendente;
import dados.pessoas.Funcionario;
public class Teste {

	
	public static void main(String[] args) {
		
		Adicionais adicionais = new Adicionais(true, true, false, true, true, false, true);
		Carro carro = new Carro("alk-1234",5, "1000C", "2012","Ferrari" , "4x4",adicionais , 200.00 );
		Carro carro2 = new Carro("adasd",0, "asda", "modelo", "hdasdh", "categ",adicionais ,150.00);
		Carro carro3 = new Carro("adasd",0, "asda", "modelo", "hdasdh", "categ",adicionais ,150.00);
		Date data =new Date("01/01/2001");
		System.out.print(data.toLocaleString());
		Atendente func = new Atendente("msad", "dsad54", "874564",data , "asdasd", "marcio", "mmcj", "23244", 500.00);
			
		IRepositorioCarro repositorio = new ArquivoCarro();
		repositorio.inserirCarro(carro);
		repositorio.inserirCarro(carro2);		
		repositorio.inserirCarro(carro3);
		
		Iterator carros = repositorio.iterator();
		Carro c =(Carro) carros.next();
		
		Fachada fachada = new Fachada();
		RelatorioMensal relatorio = new RelatorioMensal();
		relatorio.inserirDados(new ObjetoBase(1,100.00,600.00,"janeiro"));
		relatorio.inserirDados(new ObjetoBase(1,100.00,600.00,"fevereiro"));
		fachada.serializaRelatorio(relatorio);
		RelatorioMensal relatorio1 = new RelatorioMensal();
		relatorio1 = fachada.deserializaRelatorio();
		while (relatorio1.hasNext()) {
			System.out.print(relatorio1.next().toString());
		}
		
	}
	}

