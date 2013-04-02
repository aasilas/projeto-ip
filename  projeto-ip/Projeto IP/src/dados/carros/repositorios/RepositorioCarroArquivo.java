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
	public RepositorioCarroArquivo() throws IOException{

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
			this.fis = new FileInputStream("RepositorioCarro.xls");
			wb = new HSSFWorkbook(fis);
			fis.close();
		}
	}
	public void inserirCarro(Carro carro) throws IOException {

		int count = 0;
		boolean achou = false;

		// verifica se existe um espaço em null entre as linhas da planilha
		while(count <= wb.getSheetAt(0).getLastRowNum() && !achou){

			if(wb.getSheetAt(0).getRow(count) == null){
				Row row = wb.getSheetAt(0).createRow(count);
				Row row1 = wb.getSheetAt(0).getRow(0);
				
				for (int j = 0; j < 14; j++) {
					Cell cell = row1.getCell(0);
					Cell cellInserir = row.createCell(j);
					
					String palavraBase = cell.getStringCellValue(); 


					if(palavraBase.equals("Placa")){
						cellInserir.setCellValue(carro.getPlaca());
					}else if(palavraBase.equals("Modelo")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.equals("Marca")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.equals("Potencia")){
						cellInserir.setCellValue(carro.getPotencia());

					}else if(palavraBase.equals("Porta")){
						cellInserir.setCellValue(carro.getPorta());

					}else if (palavraBase.equals("Categoria")){
						cellInserir.setCellValue(carro.getCategoria());

					}else if(palavraBase.equals("Valor")){
						cell.setCellValue(carro.getValor());

					}else if(palavraBase.equals("Ar")){
						cellInserir.setCellValue(carro.getAdicionais().isAr());

					}else if(palavraBase.equals("Travas")){
						cellInserir.setCellValue(carro.getAdicionais().isTravasEletricas());

					}else if(palavraBase.equals("Airbag")){
						cellInserir.setCellValue(carro.getAdicionais().isAirbag());

					}else if(palavraBase.equals("GPS")){
						cellInserir.setCellValue(carro.getAdicionais().isGps());

					}else if(palavraBase.equals("Som")){
						cellInserir.setCellValue(carro.getAdicionais().isSom());

					}else if (palavraBase.equals("Direção Hid.")){
						cellInserir.setCellValue(carro.getAdicionais().isDirHidraulica());

					}else {
						cellInserir.setCellValue(carro.getAdicionais().isFreioABS());

					}
				}
				achou = true;
				
			}else if(count == wb.getSheetAt(0).getLastRowNum()){
				 
				Row row = wb.getSheetAt(0).createRow(wb.getSheetAt(0).getLastRowNum()+1);
				Row row1 = wb.getSheetAt(0).getRow(0);
				
				for (int j = 0; j < 14; j++) {
					Cell cell = row1.getCell(j);
					Cell cellInserir = row.createCell(j);
					String palavraBase = cell.getStringCellValue(); 


					if(palavraBase.contains("Placa")){
						cell.setCellValue(carro.getPlaca());
						
					}else if(palavraBase.equalsIgnoreCase("Modelo")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.equals("Marca")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.equals("Potencia")){
						cellInserir.setCellValue(carro.getPotencia());

					}else if(palavraBase.equals("Porta")){
						cellInserir.setCellValue(carro.getPorta());

					}else if (palavraBase.equals("Categoria")){
						cellInserir.setCellValue(carro.getCategoria());

					}else if(palavraBase.equals("Valor")){
						cellInserir.setCellValue(carro.getValor());

					}else if(palavraBase.equals("Ar")){
						cellInserir.setCellValue(carro.getAdicionais().isAr());

					}else if(palavraBase.equals("Travas")){
						cellInserir.setCellValue(carro.getAdicionais().isTravasEletricas());

					}else if(palavraBase.equals("Airbag")){
						cellInserir.setCellValue(carro.getAdicionais().isAirbag());

					}else if(palavraBase.equals("GPS")){
						cellInserir.setCellValue(carro.getAdicionais().isGps());

					}else if(palavraBase.equals("Som")){
						cellInserir.setCellValue(carro.getAdicionais().isSom());

					}else if (palavraBase.equals("Direção Hid.")){
						cellInserir.setCellValue(carro.getAdicionais().isDirHidraulica());

					}else {
						cellInserir.setCellValue(carro.getAdicionais().isFreioABS());

					}
					
				}
				achou = true;
				
			}

			count++;
			



		}
		this.fos  = new FileOutputStream("RepositorioCarro.xls");
		wb.write(fos);
		fos.close();
	}








	public void removerCarro(String placa) {

		int count = 0;

		while(count < sheetExcel.getLastRowNum()){

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
