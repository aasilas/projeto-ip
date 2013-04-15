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

import dados.carros.Carro;
import dados.pessoas.Atendente;
import dados.pessoas.Cliente;
import dados.pessoas.Funcionario;
import exceptions.BIException;
import interfaces.IRepositorioFuncionario;
import interfaces.Iterator;

public class ArquivoFuncionarios implements IRepositorioFuncionario, Iterator{

	private FileOutputStream fos;
	private FileInputStream fis;
	private Sheet sheetExcel;
	private Workbook wb;
	private int count;

	public ArquivoFuncionarios(){
		count =1;
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
				createRow(row, funcionario);
				achou = true;
			}
		else if(count == ultimaLinha){

			Row row = wb.getSheetAt(0).createRow(wb.getSheetAt(0).getLastRowNum()+1);
			createRow(row, funcionario);
			achou = true;
			}
		}

		count++;
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
	String cpf = funcionario.getCpf();
	int count = 1;
	boolean achou = false;
	int ultimaLinha = wb.getSheetAt(0).getLastRowNum();

	while (count < ultimaLinha && !achou) {

		if (wb.getSheetAt(0).getRow(count).getCell(0).equals(cpf)) {
			Row selectedRow = wb.getSheetAt(0).getRow(count);
			wb.getSheetAt(0).removeRow(selectedRow);
			this.createRow(selectedRow, funcionario);
		} else {
			count++;
		}
	}

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
			count++;
		}
	}
	if(!achou){
		throw new BIException();
	}
	return null;
}
private Funcionario createFuncionario(Row posicao){
	return new Atendente(posicao.getCell(6).getStringCellValue(), posicao.getCell(2).getStringCellValue(), 
			posicao.getCell(0).getStringCellValue(), posicao.getCell(1).getStringCellValue(), posicao.getCell(3).getStringCellValue(), 
			new Date(posicao.getCell(4).getStringCellValue()), posicao.getCell(5).getStringCellValue());
}

private void createRow(Row row, Funcionario funcionario){
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
}

@Override
public Carro next() {
	count++;
	Row posicao = wb.getSheetAt(0).getRow(this.count - 1);
	return createFuncionario(posicao);
}

@Override
public boolean hasNext() {
	int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
	if (count < ultimaLinha)
		return true;
	else
		return false;

}

@Override
public Iterator iterator() {
	return this;
}
}
