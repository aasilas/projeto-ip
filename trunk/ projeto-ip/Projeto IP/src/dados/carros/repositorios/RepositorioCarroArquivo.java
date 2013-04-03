package dados.carros.repositorios;

import interfaces.IRepositorioCarro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import dados.carros.Carro;

public class RepositorioCarroArquivo implements IRepositorioCarro{

	private FileOutputStream fos;
	private FileInputStream fis;
	private Sheet sheetExcel;
	private Workbook wb;

	// TODO: Fazer checagem se o arquivo ja existe para poder persistir
	public RepositorioCarroArquivo(){

		if(!new File("RepositorioCarro.xls").exists()){
			// cria planilha
			wb = new HSSFWorkbook();
			// planilha
			sheetExcel = wb.createSheet();
			Row row = sheetExcel.createRow(0);

			String array[] = {"Placa "," Modelo "," Marca "," Potencia "," Porta "," Categoria "," Valor "," Ar "," Travas "," Airbag "," GPS "," Som ","Direção Hid.", "Freios ABS"};
			for (int i = 0; i < array.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(array[i]);
			}


			try{
				this.fos  = new FileOutputStream("RepositorioCarro.xls");
				wb.write(fos);
				fos.close();	


			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try{
			this.fis = new FileInputStream("RepositorioCarro.xls");
			wb = new HSSFWorkbook(fis);
			fis.close();}
			catch(IOException e){}
		}
	}
	public void inserirCarro(Carro carro){

		int count = 0;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		// verifica se existe um espaço em null entre as linhas da planilha
		while(count <= ultimaLinha && !achou){

			if(wb.getSheetAt(0).getRow(count) == null){
				Row row = wb.getSheetAt(0).createRow(count);
				Row row1 = wb.getSheetAt(0).getRow(0);
				
				for (int j = 0; j < 14; j++) {
					Cell cell = row1.getCell(0);
					Cell cellInserir = row.createCell(j);
					
					String palavraBase = cell.getStringCellValue(); 


					if(palavraBase.contains("Placa")){
						cellInserir.setCellValue(carro.getPlaca());
					}else if(palavraBase.contains("Modelo")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.contains("Marca")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.contains("Potencia")){
						cellInserir.setCellValue(carro.getPotencia());

					}else if(palavraBase.contains("Porta")){
						cellInserir.setCellValue(carro.getPorta());

					}else if (palavraBase.contains("Categoria")){
						cellInserir.setCellValue(carro.getCategoria());

					}else if(palavraBase.contains("Valor")){
						cell.setCellValue(carro.getValor());

					}else if(palavraBase.contains("Ar")){
						cellInserir.setCellValue(carro.getAdicionais().isAr());

					}else if(palavraBase.contains("Travas")){
						cellInserir.setCellValue(carro.getAdicionais().isTravasEletricas());

					}else if(palavraBase.contains("Airbag")){
						cellInserir.setCellValue(carro.getAdicionais().isAirbag());

					}else if(palavraBase.contains("GPS")){
						cellInserir.setCellValue(carro.getAdicionais().isGps());

					}else if(palavraBase.contains("Som")){
						cellInserir.setCellValue(carro.getAdicionais().isSom());

					}else if (palavraBase.contains("Direção Hid.")){
						cellInserir.setCellValue(carro.getAdicionais().isDirHidraulica());

					}else {
						cellInserir.setCellValue(carro.getAdicionais().isFreioABS());

					}
				}
				achou = true;
				
			}else if(count == ultimaLinha){
				 
				Row row = wb.getSheetAt(0).createRow(wb.getSheetAt(0).getLastRowNum()+1);
				Row row1 = wb.getSheetAt(0).getRow(0);
				
				for (int j = 0; j < 14; j++) {
					Cell cell = row1.getCell(j);
					Cell cellInserir = row.createCell(j);
					String palavraBase = cell.getStringCellValue(); 


					if(palavraBase.contains("Placa")){
						cellInserir.setCellValue(carro.getPlaca());
						
					}else if(palavraBase.contains("Modelo")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.contains("Marca")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.contains("Potencia")){
						cellInserir.setCellValue(carro.getPotencia());

					}else if(palavraBase.contains("Porta")){
						cellInserir.setCellValue(carro.getPorta());

					}else if (palavraBase.contains("Categoria")){
						cellInserir.setCellValue(carro.getCategoria());

					}else if(palavraBase.contains("Valor")){
						cellInserir.setCellValue(carro.getValor());

					}else if(palavraBase.contains("Ar")){
						cellInserir.setCellValue(carro.getAdicionais().isAr());

					}else if(palavraBase.contains("Travas")){
						cellInserir.setCellValue(carro.getAdicionais().isTravasEletricas());

					}else if(palavraBase.contains("Airbag")){
						cellInserir.setCellValue(carro.getAdicionais().isAirbag());

					}else if(palavraBase.contains("GPS")){
						cellInserir.setCellValue(carro.getAdicionais().isGps());

					}else if(palavraBase.contains("Som")){
						cellInserir.setCellValue(carro.getAdicionais().isSom());

					}else if (palavraBase.contains("Direção Hid.")){
						cellInserir.setCellValue(carro.getAdicionais().isDirHidraulica());

					}else {
						cellInserir.setCellValue(carro.getAdicionais().isFreioABS());

					}
					
				}
				achou = true;
				
			}

			count++;
			



		}
		
		try {
			this.fos  = new FileOutputStream("RepositorioCarro.xls");
			wb.write(fos);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}








	public void removerCarro(String placa) {

		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		
		while(count < ultimaLinha && !achou){
			
				if(wb.getSheetAt(0).getRow(count).getCell(0).equals(placa)){
					Row row = wb.getSheetAt(0).getRow(count);
					wb.getSheetAt(0).removeRow(row);
					achou = true;
				}else{
					count++;
				}
			
		}
	}


	public void atualizar(Carro carro) {

	}

	public Carro pesquisarCarro(String modelo) {

		for (int i = 0; i < 9; i++) {
			Row celula = this.sheetExcel.getRow(i);


		}


		return null;
	}


}
