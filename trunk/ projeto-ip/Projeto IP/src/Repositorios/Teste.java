package Repositorios;

import dados.carros.*;
import dados.carros.repositorios.*;
public class Teste {

	
	public static void main(String[] args) {

		Adicionais ad = new Adicionais(true, true, true, true, true, true, true); 
		Carro car= new Carro(5, "1.6","fox", "vw", "f", ad, 540.00);
		Carro car2= new Carro(5, "1.0","gol", "vw", "f", ad, 540.00);
		Carro car3 = new Carro(5, "1.0","polo", "vw", "fdff", ad, 540.00);
		ArrayCarros carros = new ArrayCarros();
		carros.inserirCarro(car);
		carros.inserirCarro(car2);
		carros.inserirCarro(car3);
		carros.removerCarro("fox");
		car2 = new Carro(5, "1.0","gol", "vw", "fdff", ad, 540.00);
		carros.atualizar(car2);
		carros.inserirCarro(car);
		Carro car4 = carros.pesquisarCarro("fox");
	}

}
