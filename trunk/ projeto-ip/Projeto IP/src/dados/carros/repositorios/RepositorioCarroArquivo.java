package dados.carros.repositorios;

import interfaces.IRepositorioCarro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import dados.carros.Adicionais;
import dados.carros.Carro;
import dados.pessoas.Cliente;
import exceptions.BIException;

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

			String array[] = {"Placa "," Modelo "," Marca "," Potencia "," Porta "," Categoria "," Valor "," Ar "," Travas "," Airbag "," GPS "," Som ","Direção Hid.", "Freios ABS","Disponibilidade"," Data de Entrega","Data de Saida"};
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
			abrirRepositorio();
		}
	}
	
	private void abrirRepositorio(){
		try{
			this.fis = new FileInputStream("RepositorioCarro.xls");
			wb = new HSSFWorkbook(fis);
			fis.close();}
		catch(IOException e){
			
		}
	}
	
	public void inserirCarro(Carro carro){
		//abrirRepositorio();
		int count = 0;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		// verifica se existe um espaço em null entre as linhas da planilha
		while(count <= ultimaLinha && !achou){

			if(wb.getSheetAt(0).getRow(count) == null){
				Row row = wb.getSheetAt(0).createRow(count);
				Row row1 = wb.getSheetAt(0).getRow(0);
				
				for (int j = 0; j < 17; j++) {
					Cell cell = row1.getCell(j);
					Cell cellInserir = row.createCell(j);
					
					String palavraBase = cell.getStringCellValue(); 


					if(palavraBase.contains("Placa")){
						cellInserir.setCellValue(carro.getPlaca());
					}else if(palavraBase.contains("Modelo")){

						cellInserir.setCellValue(carro.getModelo());

					}else if(palavraBase.contains("Marca")){

						cellInserir.setCellValue(carro.getMarca());

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

					}else if(palavraBase.contains("Freios ABS")){
						cellInserir.setCellValue(carro.getAdicionais().isFreioABS());

					}else if(palavraBase.contains("Disponibilidade")){
						cellInserir.setCellValue(carro.isDisponibilidade());
						
					}else if(palavraBase.contains("Data de Entrega")){
						cellInserir.setCellValue(carro.getDataEntrega());
						
					}else{
						cellInserir.setCellValue(carro.getDataSaida());
					}
				}
				achou = true;
				
			}else if(count == ultimaLinha){
				 
				Row row = wb.getSheetAt(0).createRow(wb.getSheetAt(0).getLastRowNum()+1);
				Row row1 = wb.getSheetAt(0).getRow(0);
				
				for (int j = 0; j < 17; j++) {
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

					}else if(palavraBase.contains("Freios ABS")){
						cellInserir.setCellValue(carro.getAdicionais().isFreioABS());

					}else if(palavraBase.contains("Disponibilidade")){
						cellInserir.setCellValue(carro.isDisponibilidade());
						
					}else if(palavraBase.contains("Data de Entrega")){
						cellInserir.setCellValue(carro.getDataEntrega());
						
					}else{
						cellInserir.setCellValue(carro.getDataSaida());
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
		abrirRepositorio();
		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		
		while(count < ultimaLinha && !achou){
			
			if(wb.getSheetAt(0).getRow(count) == null){
				count++;
			}
			
				String placaAtual = wb.getSheetAt(0).getRow(count).getCell(0).getStringCellValue();
			if(placaAtual.equals(placa)){
				Row row = wb.getSheetAt(0).getRow(count);
				wb.getSheetAt(0).removeRow(row);
				achou = true;
			}else{
				count++;
			}
		
			}
		try{
			this.fos  = new FileOutputStream("RepositorioCarro.xls");
			wb.write(fos);
			fos.close();	


		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public void atualizar(Carro carro) {
		
		String placaCarro = carro.getPlaca();
		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		
		while(count < ultimaLinha && !achou){
			
			if(wb.getSheetAt(0).getRow(count).getCell(0).equals(placaCarro)){
				
				
			}else{
				
				count++;
			}
		}
		
	}

	public Carro pesquisarCarro(String placa) throws BIException {

		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		Carro carroPesquisado = null;
		
		while(count < ultimaLinha && !achou){
			
			if(wb.getSheetAt(0).getRow(count).getCell(0).equals(placa)){
				
				Row posicao = wb.getSheetAt(0).getRow(count);
				Adicionais adicionais = new Adicionais(posicao.getCell(7).getBooleanCellValue(), posicao.getCell(10).getBooleanCellValue(), posicao.getCell(8).getBooleanCellValue(), 
						posicao.getCell(11).getBooleanCellValue(), posicao.getCell(13).getBooleanCellValue(), posicao.getCell(9).getBooleanCellValue(), posicao.getCell(12).getBooleanCellValue());
				//new Carro(placa, porta, potencia, modelo, marca, categoria, adicionais, valor)
				carroPesquisado = new Carro(posicao.getCell(0).getStringCellValue(),Integer.getInteger(posicao.getCell(4).getStringCellValue()), posicao.getCell(3).getStringCellValue(), posicao.getCell(1).getStringCellValue(), 
						posicao.getCell(2).getStringCellValue(), posicao.getCell(5).getStringCellValue() , adicionais, posicao.getCell(6).getNumericCellValue());
				achou = true;
			}else{
				
				count++;
			}
		}
		if(!achou){
			throw new BIException();
		}
		
		

		return carroPesquisado;
	}


}
