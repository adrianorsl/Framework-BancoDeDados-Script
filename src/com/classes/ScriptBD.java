package com.classes;

import Enum.Tipos;

public class ScriptBD {

	private String nome;
	private Tipos tipo;
	private int quantidade;
	private int autoIngrement;
	private int primaryKey;
	private int notNull;

	
	
	public ScriptBD() {
		
	}

	public ScriptBD(String nome, Tipos tipo, int quantidade, int autoIngrement,int primaryKey, int notNull) {
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.autoIngrement = autoIngrement;
		this.primaryKey = primaryKey;
		this.notNull = notNull;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Tipos getTipo() {
		return tipo;
	}


	
	public void setTipo(Tipos i) {
		
			this.tipo = i;
	}

	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		if (quantidade > 0) {
			this.quantidade = quantidade;
		}
		
	}

	public int getAutoIngrement() {
		return autoIngrement;
	}


	public void setAutoIngrement(int autoIngrement) {
		if ((autoIngrement == 1) || (autoIngrement == 0))
			this.autoIngrement = autoIngrement;
	}
	
	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		if ((primaryKey == 1) || (primaryKey == 0))
		this.primaryKey = primaryKey;
	}

	public int getNotNull() {
		return notNull;
	}


	public void setNotNull(int notNull) {
		if ((notNull == 1) || (notNull == 0))
			this.notNull = notNull;
	}

	// autoIngrement e notNull 1 true 0 false;
	public String CriarScript() {
		String script = getNome() + " " + getTipo() +"(" + getQuantidade() + ")";
		if (getNotNull() == 1) {
			 script = script + " NOT NULL";
		}else {

		}
		if (getAutoIngrement() == 1) {
			script = script + " AUTO_INCREMENT";
			if (getPrimaryKey() == 1) {
				script = script + " PRIMARY KEY";
			}
		}else {
			
		}
		return script;			
	}
	


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScriptBD [nome=");
		builder.append(nome);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append("]");
		return builder.toString();
	}

}
