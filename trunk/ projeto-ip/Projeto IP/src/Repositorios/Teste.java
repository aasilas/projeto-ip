package Repositorios;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import dados.carros.*;
import dados.carros.repositorios.*;
public class Teste {

	
	public static void main(String[] args) throws IOException {
		
		Adicionais adicionais = new Adicionais(true, true, false, true, true, false, true);
		Carro carro = new Carro(5, "1000C", "2012","Ferrari" , "4x4",adicionais , 200.00, "alk-1234");
		Carro carro2 = new Carro(0, "asda", "modelo", "hdasdh", "categ",adicionais ,150.00,"adasd");
		/*Workbook wb = new HSSFWorkbook();
		Sheet planilha = wb.createSheet();
		Row row = planilha.createRow(0);
		
		String array[] = {" Modelo","Marca ","Potencia ","Modelo"," Modelo","chupa"," marcio"};
		for (int i = 0; i < array.length; i ++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(array[i]);
		}
		
		try{
			FileOutputStream arquivoCarro = new FileOutputStream("Repositorio Carro.xls");
			wb.write(arquivoCarro);
			arquivoCarro.close();		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Sheet sheet = wb.getSheetAt(0);
		
		Cell cell1 = (Cell) sheet.getCellComment(0, 0);
		for (int i = 0; i <= 1; i++) {  
			  
            System.out.println("Linha " + i);  
 
            row = sheet.getRow(1);  
 
            for (int j = 1; j<= row.getLastCellNum();j++ ){  
 
                //System.out.println(row.getCell((short) j));  
 
                System.out.println(row.toString());  }*/
		
		RepositorioCarroArquivo repositorio = new RepositorioCarroArquivo();
		repositorio.inserirCarro(carro);
		repositorio.inserirCarro(carro2);
	}
	}

