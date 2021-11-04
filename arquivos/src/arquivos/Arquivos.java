package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmial.com");
		pessoa1.setIdade("19");
		pessoa1.setNome("Joao pedro");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmial.com");
		pessoa2.setIdade("20");
		pessoa2.setNome("MESSI");
		
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmial.com");
		pessoa3.setIdade("30");
		pessoa3.setNome("CR7");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		
		
		File arquivo = new File("C:\\Users\\joao pedro\\eclipse-workspace\\arquivos\\src\\arquivos\\Arquivos.jav");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
	
		for (Pessoa p : pessoas) {
			
			escrever_no_arquivo.write(p.getNome() +  ";" + p.getIdade() + ";" + p.getEmail() + "\n");
			
		}
		
		
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}
}
