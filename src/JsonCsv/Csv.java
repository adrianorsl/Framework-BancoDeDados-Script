package JsonCsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.classes.AbstratTabela;


import Interface.Persistencia;

public class Csv implements Persistencia {

		private final int POS_Tabela = 0;
		
		private String nome;
		
		

		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}

		public boolean gravar(List<AbstratTabela> lista)  throws IOException {
			FileWriter writer = null;

			try {
				writer = new FileWriter("arquivos/" + getNome() + ".csv");

				for (AbstratTabela a : lista) {
					String[] info = new String[5];

					info[POS_Tabela] = a.getTabela();
					
					writer.write(String.join(";", info) + "\n");
				}
			} finally {
				if (writer != null) {
					writer.close();
					writer = null;
				}
			}
			return true;
		}



		@Override
		public List<AbstratTabela> ler(List<AbstratTabela> lista) throws IOException, ParseException {
			BufferedReader reader = null;

			try {
				List<AbstratTabela> tabelas = new ArrayList<>();

				File arquivo = new File("arquivos/" + getNome() + ".csv");

				if (arquivo.exists()) {
					reader = new BufferedReader(new FileReader(arquivo));

					String linha;

					while ((linha = reader.readLine()) != null) {
						if (linha.isEmpty())
							continue;

						String[] info = linha.split(";");

						
						AbstratTabela a = new AbstratTabela();

						a.setTabela(info[POS_Tabela]);
						
						tabelas.add(a);
					}
				}

				return tabelas;
			} finally {
				if (reader != null) {
					reader.close();
					reader = null;
				}
			}
		}

}
