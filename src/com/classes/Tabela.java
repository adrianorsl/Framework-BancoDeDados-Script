package com.classes;

import java.util.ArrayList;
import java.util.List;

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

	public Tabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	
	public String script() {
		String st = "";
		for (int x = 0; x < lista.size(); x ++) {
			ScriptBD scpt = new ScriptBD();
			scpt = lista.get(x);
			st += scpt.CriarScript();	
		}
		return st;
	}
	
	public String criarTabela() {
		String tabela = "CREATE TABLE "+ "'" + getNomeTabela() + "'"+ "(" + "\n";
		tabela += script();
		return tabela + ")";
		
		
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
