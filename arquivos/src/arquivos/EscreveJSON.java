package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {
	
		Usuario usuario1 = new Usuario();
		usuario1.setCPF("902094039");
		usuario1.setLogin("joao");
		usuario1.setSenha("12127001");
		usuario1.setNome("Joao_Pedro_Mendes");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCPF("230200923");
		usuario2.setLogin("Amor");
		usuario2.setSenha("12108474");
		usuario2.setNome("Nathalia_");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\joao pedro\\git\\arquivos\\arquivos\\src\\arquivos\\filjson.json");
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		// -------------------------------- LEDO ARQUIVO JSON ---------------------------------------
		
		FileReader fileReader = new FileReader("C:\\Users\\joao pedro\\git\\arquivos\\arquivos\\src\\arquivos\\filjson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuario);
			
		}
		
		System.out.println("leitura do arquivo JSON " + listUsuarios);
	}

}
