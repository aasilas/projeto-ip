package dados.carros.repositorios;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Interfaces.IRepositorioCarro;
import dados.carros.Carro;

public class RepositorioCarroArquivo implements IRepositorioCarro{

	
	public RepositorioCarroArquivo(){
		
		Workbook wb = new HSSFWorkbook();
		Sheet planilha = wb.createSheet();
		
		Cell cell1 = planilha.createRow(0).createCell(0);
		Cell cell2 = planilha.createRow(0).createCell(1);
		Cell cell3 = planilha.createRow(0).createCell(2);
		Cell cell4 = planilha.createRow(0).createCell(3);
		Cell cell5 = planilha.createRow(0).createCell(4);
		Cell cell6 = planilha.createRow(0).createCell(5);
		Cell cell7 = planilha.createRow(0).createCell(6);
		Cell cell8 = planilha.createRow(0).createCell(7);
		
		cell1.setCellValue("Modelo");
		cell2.setCellValue("Marca");
		cell3.setCellValue("Potencia");
		cell4.setCellValue("Modelo");
		cell5.setCellValue("Modelo");
		cell6.setCellValue("Modelo");
		cell7.setCellValue("Modelo");
		cell8.setCellValue("Modelo");
		
		
		
		
		try{
			FileOutputStream arquivoCarro = new FileOutputStream("Repositorio Carro.xls");
			wb.write(arquivoCarro);
			arquivoCarro.close();		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void inserirCarro(Carro carro) {
		
	}

	public void removerCarro(String modelo) {
		
	}

	
	public void atualizar(Carro carro) {
			
	}

	public Carro pesquisarCarro(String modelo) {
		
		return null;
	}

	public  gerarPlanilha(String nome, String[] valores){
		
		Workbook wb = new HSSFWorkbook();
		Sheet planilha = wb.createSheet();
		Cell[] arrayCell = new Cell[valores.length]; 
		
		cell1
		
		
		
		try{
			FileOutputStream arquivoCarro = new FileOutputStream("Repositorio " + nome +".xls");
			wb.write(arquivoCarro);
			arquivoCarro.close();		
		}catch(Exception e){
			e.printStackTrace();
		}
}
