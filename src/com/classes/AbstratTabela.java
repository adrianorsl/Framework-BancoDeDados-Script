package com.classes;

import java.util.List;
/**
 * 
 * @author adrianorslsc@hotmail.com
 *classe usada para fazer a gravação das tabelas
 */
public class AbstratTabela {

	private String tabela;
	
	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstratTabela [tabela=");
		builder.append(tabela);
		builder.append("]");
		return builder.toString();
	}
	
	
}
