package dados.carros.repositorios;

import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Interfaces.IRepositorioCarro;
import dados.carros.Carro;

public class RepositorioCarroArquivo implements IRepositorioCarro{

	private FileOutputStream excel;
	private Sheet sheetExcel;

	// TODO: Fazer checagem se o arquivo ja existe para poder persistir
	public RepositorioCarroArquivo(){

		// cria planilha
		Workbook wb = new HSSFWorkbook();
		// planilha
		sheetExcel = wb.createSheet();
		Row row = sheetExcel.createRow(0);

		String array[] = {" Modelo "," Marca "," Potencia "," Porta "," Categoria "," Valor "," Ar "," Travas "," Airbag "," GPS "," Som ","Direção Hid.", "Freios ABS"};
		for (int i = 0; i < array.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(array[i]);
		}


		try{
			this.excel  = new FileOutputStream("Repositorio Carro.xls");
			wb.write(excel);
			excel.close();	


		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public void inserirCarro(Carro carro) {
		// Roda as linhas e insere o valor devido
		for (int i = 0; i < sheetExcel.getRow(0).getHeight(); i++) {
			Row row = sheetExcel.getRow(0);
			Cell cell = row.getCell(i);
		  
			
					
				// Verificar se as linhas são nulas e caso nenhuma seja nula,add o obj na linha após a ultima 
				String palavraBase = cell.getStringCellValue() ;
				for (int j = 1;j <= sheetExcel.getLastRowNum(); j++) {
					int count = 0;
					Row rowInserir = null;
					Cell cellInserir = null;
					if(sheetExcel.getRow(j) == null){
						count = j;
						rowInserir = sheetExcel.createRow(count);
						cellInserir = rowInserir.createCell(i);
					}else{
						count = j+1;
						rowInserir = sheetExcel.createRow(count);
						cellInserir = rowInserir.createCell(i);
					}
					
				if(palavraBase.equals("Modelo")){
					
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
				
				}
				
		


	}

	public void removerCarro(String modelo) {
		
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
