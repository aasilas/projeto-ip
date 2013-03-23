package Repositorios;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
public class GeradorPlanilha {
	
	public void gerarPlanilha(String nome){
		
		Workbook wb = new HSSFWorkbook();
		
		Sheet planilha = wb.createSheet();
		
		
		
		try{
			FileOutputStream arquivoCarro = new FileOutputStream("Repositorio" + nome +".xls");
			wb.write(arquivoCarro);
			arquivoCarro.close();		
		}catch(Exception e){
			e.printStackTrace();
		}
		/*A cada vez que inicializar um tipo de repositorio,vamos chamar esse metodo e criar uma planilha,mas isso apenas se não existir uma.*/
	}
	

}
