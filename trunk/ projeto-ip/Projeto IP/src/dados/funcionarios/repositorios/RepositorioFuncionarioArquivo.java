package dados.funcionarios.repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import dados.pessoas.Cliente;
import dados.pessoas.Funcionario;
import exceptions.BIException;
import interfaces.IRepositorioFuncionario;

public class RepositorioFuncionarioArquivo implements IRepositorioFuncionario{

	private FileOutputStream fos;
	private FileInputStream fis;
	private Sheet sheetExcel;
	private Workbook wb;
	
	public RepositorioFuncionarioArquivo(){
		
		if(!new File("RepositorioFuncionario.xls").exists()){
			// cria planilha
			wb = new HSSFWorkbook();
			// planilha
			sheetExcel = wb.createSheet();
			Row row = sheetExcel.createRow(0);

			String array[] = {"Nome"," CPF"," ctps "," RG "," Data de nascimento "," Endereco ","login","senha"};
			for (int i = 0; i < array.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(array[i]);
			}


			try{
				this.fos  = new FileOutputStream("RepositorioFuncionario.xls");
				wb.write(fos);
				fos.close();	


			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try{
			this.fis = new FileInputStream("RepositorioFuncionario.xls");
			wb = new HSSFWorkbook(fis);
			fis.close();}
			catch(IOException e){}
		}
	}
	
	public void inserirFuncionario(Funcionario funcionario) {
		
		int count = 0;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		// verifica se existe um espaço em null entre as linhas da planilha
		while(count <= ultimaLinha && !achou){

			if(wb.getSheetAt(0).getRow(count) == null){
				Row row = wb.getSheetAt(0).createRow(count);
				Row row1 = wb.getSheetAt(0).getRow(0);
				
				for (int j = 0; j < 8; j++) {
					Cell cell = row1.getCell(j);
					Cell cellInserir = row.createCell(j);
					
					String palavraBase = cell.getStringCellValue(); 


					if(palavraBase.contains("Nome")){
						cellInserir.setCellValue(funcionario.getNome());
					}else if(palavraBase.contains("CPF")){

						cellInserir.setCellValue(funcionario.getCpf());

					}else if(palavraBase.contains("ctps")){

						cellInserir.setCellValue(funcionario.getCtps());

					}else if(palavraBase.contains("RG")){
						cellInserir.setCellValue(funcionario.getRg());

					}else if(palavraBase.contains("Data de Nascimento")){
						cellInserir.setCellValue(funcionario.getDataNascimento().toLocaleString());

					}else if (palavraBase.contains("Endereco")){
						cellInserir.setCellValue(funcionario.getEndereco());

					}else if(palavraBase.contains("login")){
						cellInserir.setCellValue(funcionario.getLogin());
						
					}else{
						cellInserir.setCellValue(funcionario.getSenha());// definir se a senha ficará na planilha  ou não
					}
					
				}
				achou = true;
			}else if(count == ultimaLinha){
				 
				Row row = wb.getSheetAt(0).createRow(wb.getSheetAt(0).getLastRowNum()+1);
				Row row1 = wb.getSheetAt(0).getRow(0);
				
				for (int j = 0; j < 8; j++) {
					Cell cell = row1.getCell(j);
					Cell cellInserir = row.createCell(j);
					String palavraBase = cell.getStringCellValue(); 



					if(palavraBase.contains("Nome")){
						cellInserir.setCellValue(funcionario.getNome());
					}else if(palavraBase.contains("CPF")){

						cellInserir.setCellValue(funcionario.getCpf());

					}else if(palavraBase.contains("ctps")){

						cellInserir.setCellValue(funcionario.getCtps());

					}else if(palavraBase.contains("RG")){
						cellInserir.setCellValue(funcionario.getRg());

					}else if(palavraBase.contains("Data de nascimento")){
						cellInserir.setCellValue(funcionario.getDataNascimento().toLocaleString());

					}else if (palavraBase.contains("Endereco")){
						cellInserir.setCellValue(funcionario.getEndereco());

					}else if(palavraBase.contains("login")){
						cellInserir.setCellValue(funcionario.getLogin());
						
					}else{
						cellInserir.setCellValue(funcionario.getSenha());// definir se a senha ficará na planilha  ou não
					}
				}
				achou = true;
				
			}

			count++;
			



		}
		
		try {
			this.fos  = new FileOutputStream("RepositorioFuncionario.xls");
			wb.write(fos);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removerFuncionario(String cpf) {
		
		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		
		while(count < ultimaLinha && !achou){
			
				if(wb.getSheetAt(0).getRow(count).getCell(1).equals(cpf)){
					Row row = wb.getSheetAt(0).getRow(count);
					wb.getSheetAt(0).removeRow(row);
					achou = true;
				}else{
					count++;
				}
		}
		try{
			this.fos  = new FileOutputStream("RepositorioFuncionario.xls");
			wb.write(fos);
			fos.close();	
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}


	public void atualizar(Funcionario funcionario) {
		

	}

	public Funcionario pesquisarFuncionario(String cpf) throws BIException {
		
		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		Funcionario clientePesquisado = null;
		
		while(count < ultimaLinha && !achou){
			
			if(wb.getSheetAt(0).getRow(count).getCell(1).equals(cpf)){
				
				Row posicao = wb.getSheetAt(0).getRow(count);
				
					
					
				achou = true;
			}else{
				// Enviar exceção aqui
				count++;
			}
		}
		if(!achou){
			throw new BIException();
		}
		
		
		return null;
	}

	
}
