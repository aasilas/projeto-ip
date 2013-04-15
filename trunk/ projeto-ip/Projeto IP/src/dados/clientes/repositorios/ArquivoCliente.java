package dados.clientes.repositorios;

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
import dados.pessoas.Cliente;
import exceptions.BIException;
import interfaces.*;

public class ArquivoCliente implements IRepositorioCliente, Iterator{

	private FileOutputStream fos;
	private FileInputStream fis;
	private Sheet sheetExcel;
	private Workbook wb;
	private int count;

	public ArquivoCliente(){

		count = 1;
		if(!new File("RepositorioCliente.xls").exists()){
			// cria planilha
			wb = new HSSFWorkbook();
			// planilha
			sheetExcel = wb.createSheet();
			Row row = sheetExcel.createRow(0);

			String array[] = {"Nome"," CPF"," Email "," RG "," Data de nascimento "," Endereco ","CNH","Placa do carro"};
			for (int i = 0; i < array.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(array[i]);
			}


			try{
				this.fos  = new FileOutputStream("RepositorioCliente.xls");
				wb.write(fos);
				fos.close();	


			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try{
				this.fis = new FileInputStream("RepositorioCliente.xls");
				wb = new HSSFWorkbook(fis);
				fis.close();}
			catch(IOException e){}
		}
	}


	public void inserirCliente(Cliente cliente) {

		int count = 0;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		// verifica se existe um espaço em null entre as linhas da planilha
		while(count <= ultimaLinha && !achou){

			if(wb.getSheetAt(0).getRow(count) == null){
				Row selectedRow = wb.getSheetAt(0).createRow(count);
				this.createRow(selectedRow, cliente);
				achou = true;
			}else if(count == ultimaLinha){
				Row selectedRow = wb.getSheetAt(0).createRow(wb.getSheetAt(0).getLastRowNum()+1);
				this.createRow(selectedRow, cliente);
				achou = true;
			}
			count++;
		}

		try {
			this.fos  = new FileOutputStream("RepositorioCliente.xls");
			wb.write(fos);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void removerCliente(String cpf) {

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
			this.fos  = new FileOutputStream("RepositorioCliente.xls");
			wb.write(fos);
			fos.close();	


		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public void atualizar(Cliente cliente) {
		String cpf = cliente.getCpf();
		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();

		while (count < ultimaLinha && !achou) {

			if (wb.getSheetAt(0).getRow(count).getCell(0).equals(cpf)) {
				Row selectedRow = wb.getSheetAt(0).getRow(count);
				wb.getSheetAt(0).removeRow(selectedRow);
				this.createRow(selectedRow, cliente);
			} else {
				count++;
			}
		}

	}


	public Cliente pesquisarCliente(String cpf) throws BIException {

		int count = 1;
		boolean achou = false;
		int ultimaLinha = wb.getSheetAt(0).getLastRowNum();
		Cliente clientePesquisado = null;

		while(count < ultimaLinha && !achou){

			if(wb.getSheetAt(0).getRow(count).getCell(1).equals(cpf)){
				Row posicao = wb.getSheetAt(0).getRow(count);
				this.createCliente(posicao);
				achou = true;
			}else{
				// Enviar exceção aqui
				count++;
			}
		}
		if(!achou){
			throw new BIException();
		}
		return clientePesquisado;
	}
	
	private Cliente createCliente(Row posicao){
		return new Cliente(posicao.getCell(6).getStringCellValue(), posicao.getCell(2).getStringCellValue(), 
				posicao.getCell(0).getStringCellValue(), posicao.getCell(1).getStringCellValue(), posicao.getCell(3).getStringCellValue(), 
				new Date(posicao.getCell(4).getStringCellValue()), posicao.getCell(5).getStringCellValue());
	}
	
	private void createRow (Row selectedRow, Cliente cliente){
		Row row = selectedRow;
		Row row1 = wb.getSheetAt(0).getRow(0);

		for (int j = 0; j < 8; j++) {
			Cell cell = row1.getCell(j);
			Cell cellInserir = row.createCell(j);

			String palavraBase = cell.getStringCellValue(); 


			if(palavraBase.contains("Nome")){
				cellInserir.setCellValue(cliente.getNome());
			}else if(palavraBase.contains("CPF")){

				cellInserir.setCellValue(cliente.getCpf());

			}else if(palavraBase.contains("Email")){

				cellInserir.setCellValue(cliente.getEmail());

			}else if(palavraBase.contains("RG")){
				cellInserir.setCellValue(cliente.getRg());

			}else if(palavraBase.contains("Data de Nascimento")){
				cellInserir.setCellValue(cliente.getDataNascimento().toLocaleString());

			}else if (palavraBase.contains("Endereco")){
				cellInserir.setCellValue(cliente.getEndereco());

			}else if(palavraBase.contains("CNH")){
				cellInserir.setCellValue(cliente.getCNH());

			}else{
				cellInserir.setCellValue(cliente.getCarro().getModelo());
			}

		}
	}
	
	@Override
	public Cliente next() {
		count++;
		Row posicao = wb.getSheetAt(0).getRow(this.count - 1);
		return createCliente(posicao);
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
