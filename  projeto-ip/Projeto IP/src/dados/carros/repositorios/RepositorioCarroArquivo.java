package dados.carros.repositorios;

import dados.carros.Carro;
import Interfaces.IRepositorioCarro;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;

public class RepositorioCarroArquivo implements IRepositorioCarro{

	
	
	public void inserirCarro(Carro carro) {
		
	}

	public void removerCarro() {

		
	}

	public void atualizar() {
	
		
	}

	public Carro pesquisarCarro() {
	
		return null;
	}

	@Override
	public void removerCarro(String modelo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Carro carro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carro pesquisarCarro(String modelo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
