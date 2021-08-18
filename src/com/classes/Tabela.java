package com.classes;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author adrianorslsc@hotmail.com
 *
 */
public class Tabela {
	
	private String nomeTabela;
	
	List<ScriptBD> lista = new ArrayList<ScriptBD>();
	
	public List<ScriptBD> getLista() {
		return lista;
	}

	public void setLista(List<ScriptBD> lista) {
		this.lista = lista;
	}
	
	public boolean addScript(ScriptBD scriptBD) {
		return lista.add(scriptBD);
	}
	

	public Tabela() {
		
	}
	/**
	 * 
	 * @param nomeTabela Nome da tabela que irá ser criada valoe em String
	 */
	public Tabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
	/**
	 * Função String que gera cada linha da tabela
	 * @return String do script
	 */
	
	public String script() {
		String st = "";
		boolean A = false;
		for (int x = 0; x < lista.size(); x ++) {
			if (x == lista.size() - 1) {
				ScriptBD scpt = new ScriptBD();
				scpt = lista.get(x);
				if (scpt.getUnique() == true) {
					A = true;
				}
				if (A == true) {
					st += scpt.CriarScript() + "," + "\n";
				}else {
					st += scpt.CriarScript() + "\n";
				}
				
			}else {
				ScriptBD scpt = new ScriptBD();
				scpt = lista.get(x);
				st += scpt.CriarScript() + "," + "\n";
				if (scpt.getUnique() == true) {
					A = true;
				}
			}
		}
		return st;
	}
	
	/**
	 * Função de criação da tabela sem chaves estrangeiras 
	 * @return  String com a tabela montada de acordo com padrões do MySQL
	 */
	public String criarTabela() {
		String tabela = "CREATE TABLE "+  getNomeTabela() + "(" + "\n";
		tabela +=  script();
		ScriptBD scpt = new ScriptBD();
	  
		for (int x = 0; x < lista.size(); x++) {
			scpt = lista.get(x);
			if (scpt.getUnique() ==  true) {
				tabela += " UNIQUE(" + scpt.getNome() + ")";
			}
		}
		return tabela + ")ENGINE = innodb;";
		
		
	}
	
	/**
	 * Função de criação da tabela com chaves estrangeiras 
	 * @param foreignKey String da chave estrangeira
	 * @param nomeTabela String do nome da tabela da chave estrangeira
	 * @param referencia String da referencia da chave estrangeira
	 * @return String com a tabela montada de acordo com padrões do MySQL
	 */
	public String criarTabelaForeignKey(String foreignKey, String nomeTabela, String referencia) {
		String tabela = "CREATE TABLE "+  getNomeTabela() + "(" + "\n";
		tabela += script();
		ScriptBD scpt = new ScriptBD();
		int A = 0;
		for (int x = 0; x < lista.size(); x++) {
			scpt = lista.get(x);
			if (scpt.getUnique() ==  true) {
				tabela += "CONSTRAINT id_" + foreignKey + " FOREIGN KEY (" + foreignKey + ")\n";
				tabela += "REFERENCES " + nomeTabela + "(" + referencia + "),\n";
				tabela += " UNIQUE(" + scpt.getNome() + ")";
				A ++;
			}
		}
		if (A <= 0) {
			tabela += ",CONSTRAINT id_" + foreignKey + " FOREIGN KEY (" + foreignKey + ")\n";
			tabela += "REFERENCES " + nomeTabela + "(" + referencia + ")\n";
		}
		return tabela + ")ENGINE = innodb;";
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tabela [nomeTabela=");
		builder.append(nomeTabela);
		builder.append("]");
		return builder.toString();
	}
	
	

}
