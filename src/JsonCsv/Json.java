package JsonCsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.classes.AbstratTabela;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Interface.Persistencia;
/**
 * 
 * @author adrianorslsc@hotmail.com
 *Classe de gravação e leitura em Json
 */
public class Json implements Persistencia {
	
	private String nome;
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/**Necessário criação da pasta arquivos
	 * Metodo Booleano para gravar a lista das tabelas dentro da pasta arquivos
	 */
	public boolean gravar(List<AbstratTabela> lista) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter writer;
		
			
		try {
			writer = new FileWriter("arquivos/" + getNome() + ".json");
			writer.write(gson.toJson(lista));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**Necessário criação da pasta arquivos
	 * Metodo Booleano para ler a lista das tabelas gravadas dentro da pasta arquivos
	 */
	public List<AbstratTabela> ler(List<AbstratTabela> tab) {
		FileReader reader = null;

		try {
			List<AbstratTabela> tabelas = new ArrayList<>();
			

			File arquivo = new File("arquivos/" + getNome() + ".json");

			if (arquivo.exists()) {
				try {
					reader = new FileReader(arquivo);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Gson gson = new Gson();
				
				tabelas = gson.fromJson(reader, new TypeToken<List<AbstratTabela>>() {
				}.getType());
			}

			
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reader = null;
			}
		}
		return tab;
		
	}
	
	
}
