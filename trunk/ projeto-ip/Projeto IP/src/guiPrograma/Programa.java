package guiPrograma;

import java.util.Date;

import dados.carros.Adicionais;
import dados.carros.Carro;
import dados.pessoas.Atendente;
import dados.pessoas.Cliente;
import dados.pessoas.Funcionario;
import exceptions.BIException;
import exceptions.CCException;
import exceptions.IIException;
import principal.Fachada;

public class Programa {

	public static void main(String[] args) throws BIException {
		
		Fachada fachada = new Fachada();
		
		Adicionais adicionais = new Adicionais(true, false, false, true, true, false, true);
		Carro carro = new Carro("KLL-1234", 5, "1000C", "2012", "Gol", "comum", adicionais, 100.00);
		Carro carroAtualizar = new Carro("ABC-0000", 4, "1800C", "2012", "Gol", "comum", adicionais, 200.00);
		
		Cliente cliente = new Cliente("05477816819", "marcioelo@hotmail.com", "marcio", "000111222-33", "7.282.188", new Date(23/05/2013), "Rua. Jose Ozorio");
		Cliente clienteAtualizar = new Cliente("05234234242", "marcio@hotmail.com", "jonathan", "000111222-33", "7.245.188", new Date(23/05/2013), "Rua. Jose Ozorio");
		
		Funcionario funcionario = new Atendente("Jose", "111.222.333.444-55", "1234567", new Date(05/06/1979), "Rua joao Carlos", "121342323", "jms", "j12@", 1000.00);
		Funcionario funcAtualizar = new Atendente("Joao", "111.777.222.444-55", "1232367", new Date(21/01/1979), "Rua joao Carlos", "12121242323", "j12", "j31@", 1500.00);
		
		try {
			fachada.cadastrarCarro(carroAtualizar);
		} catch (CCException e) {
			e.printStackTrace();
		}
				
		try {
			fachada.cadastrarCliente(cliente);
		} catch (CCException e) {
			e.printStackTrace();
		}
		
		fachada.atualizarCliente(cliente);
		fachada.pesquisarCliente(clienteAtualizar.getCpf());
		
		

		fachada.atualizarCarro(carro);
		fachada.alugarCarro(carro.getPlaca(), new Date(12/05/2013), new Date(01/05/2013));
		fachada.entregarCarro(carro.getPlaca());
		fachada.pesquisarCarro(carro.getPlaca());
		
		try {
			fachada.cadastrarFuncionario(funcionario);
		} catch (CCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fachada.atualizarFuncionario(funcAtualizar);
		fachada.pesquisarFuncionario(funcAtualizar.getCpf());
		
		try {
			fachada.removerCarro(carro.getPlaca());
		} catch (IIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fachada.removerCliente(clienteAtualizar.getCpf());
		} catch (IIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fachada.removerFuncionario(funcAtualizar.getCpf());
		} catch (IIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
