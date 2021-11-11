package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class ApachePOI2 {

	public static void main(String[] args) throws Exception {
	
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\joao pedro\\git\\arquivos\\arquivos\\src\\arquivos\\arquivo_excel.xls"));

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // prepara a entrada do arquivo excel para ler 
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // pega a primeira planilha do nosso arquivo excel 
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (linhaIterator.hasNext()) { // enquanto tiver linha no arquivo do excel 
			
			Row linha = linhaIterator.next(); // dados da pessoa na linha
		
			Iterator<Cell> celula = linha.iterator();
		
		Pessoa pessoa = new Pessoa();
			
			while(celula.hasNext()) { // percorrer as celulas
				
				Cell cell = celula.next();
				
				switch (cell.getColumnIndex()) {
				
				case 0: 
					pessoa.setNome(cell.getStringCellValue());
					break;
					
				case 1: 
					pessoa.setEmail(cell.getStringCellValue());
					break;
					
				case 2: 
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}
				
				
			} // fim das celulas das linhas
		
		pessoas.add(pessoa);	
		
		}
		
		entrada.close(); // terminou de ler o arquivo excel
		
		for (Pessoa pessoa : pessoas) {
			
			System.out.println(pessoa);
		
	
		}
		
	}
	
	
	
}