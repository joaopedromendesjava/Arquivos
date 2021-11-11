package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class ApachePOI {

	public static void main(String[] args) throws Exception {
		
		
		File file = new File ("C:\\Users\\joao pedro\\git\\arquivos\\arquivos\\src\\arquivos\\arquivos_excel_xls");
		
		if (file.exists()) {
			file.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmial.com");
		pessoa1.setIdade(19);
		pessoa1.setNome("Joao pedro");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmial.com");
		pessoa2.setIdade(20);
		pessoa2.setNome("MESSI");
		
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmial.com");
		pessoa3.setIdade(30);
		pessoa3.setNome("CR7");
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("pessoa4@gmial.com");
		pessoa4.setIdade(10);
		pessoa4.setNome("NEYMAR");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // vai ser usado para escrever a planilha
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("planilha de pessoas JDEV treinamento"); // criar a planilha
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			
			Row linha = linhaPessoa.createRow(numeroLinha ++ ); // criando a linha na planilha
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++ ); // celula 1
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++ ); // celula 2
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++ ); // celula 3
			celIdade.setCellValue(p.getIdade());
		} // termino de montar a planilha
	
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); // escreve planilha em arquivo
		saida.flush();
		saida.close();
		
		System.out.println("planilha criada");
		
		
	}

}
