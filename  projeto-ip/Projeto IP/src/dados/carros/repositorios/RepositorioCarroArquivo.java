package dados.carros.repositorios;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import dados.carros.Carro;

import Interfaces.IRepositorioCarro;

public class RepositorioCarroArquivo implements IRepositorioCarro{

    private Workbook excel;
    private int count;
   
    public RepositorioCarroArquivo(){
    	this.count = 1;
    	
        Workbook wb = new HSSFWorkbook();
        Sheet planilha = wb.createSheet();
        Row row = planilha.createRow(0);
       
        String array[] = {" Modelo","Marca ","Potencia ","Categoria","Porta","Valor","Ar","GPS","Travas Elétricas",
        		"Som","Freios ABS","AirBag","Direção Hidráulica"};
       
        for (int i = 0; i < array.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(array[i]);
        }
       
        try{
            FileOutputStream arquivoCarro = new FileOutputStream("Repositorio Carro.xls");
            wb.write(arquivoCarro);
            arquivoCarro.close();   
            this.excel = wb;
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    public void inserirCarro(Carro carro) {
       
       Workbook wb = new HSSFWorkbook();
       Sheet planilha = wb.createSheet();
       Row row = planilha.createRow(this.count);
       
       Cell cell = row.createCell(0);
       cell.setCellValue(carro.getModelo());
       
       Cell cell1 = row.createCell(1);
       cell.setCellValue(carro.getMarca());
       
       Cell cell2 = row.createCell(2);
       cell.setCellValue(carro.getPotencia());
       
       Cell cell3 = row.createCell(3);
       cell.setCellValue(carro.getCategoria());
       
       Cell cell4 = row.createCell(4);
       cell.setCellValue(carro.getPorta());
       
       Cell cell5 = row.createCell(5);
       cell.setCellValue(carro.getValor());
    
       Cell cell6 = row.createCell(6);
       cell.setCellValue(carro.getAdicionais().isAr());
       
       Cell cell7 = row.createCell(7);
       cell.setCellValue(carro.getAdicionais().isGps());
       
       Cell cell8 = row.createCell(8);
       cell.setCellValue(carro.getAdicionais().isTravasEletricas());
       
       Cell cell9 = row.createCell(9);
       cell.setCellValue(carro.getAdicionais().isSom());
       
       Cell cell10 = row.createCell(10);
       cell.setCellValue(carro.getAdicionais().isFreioABS());
       
       Cell cell11 = row.createCell(11);
       cell.setCellValue(carro.getAdicionais().isAirbag());
       
       Cell cell12 = row.createCell(12);
       cell.setCellValue(carro.getAdicionais().isDirHidraulica());
       
    }

    public void removerCarro(String modelo) {
       
    }

   
    public void atualizar(Carro carro) {
        
    	
    	
    }

    public Carro pesquisarCarro(String modelo) {
       
        return null;
    }

   
}