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
   
    public RepositorioCarroArquivo(){
       
        Workbook wb = new HSSFWorkbook();
        Sheet planilha = wb.createSheet();
        Row row = planilha.createRow(0);
       
        String array[] = {" Modelo","Marca ","Potencia ","Modelo"," Modelo","Modelo"," Modelo"};
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
       
       
       
       
       
    }

    public void removerCarro(String modelo) {
       
    }

   
    public void atualizar(Carro carro) {
           
    }

    public Carro pesquisarCarro(String modelo) {
       
        return null;
    }

   
}