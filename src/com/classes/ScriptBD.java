package com.classes;

import Enum.Tipos;

public class ScriptBD {

	private String nome;
	private Tipos tipo;
	private int quantidade;
	private boolean autoIngrement;
	private boolean primaryKey;
	private boolean notNull;
	private boolean unique;
	

	
	
	public ScriptBD() {
		
	}

	public ScriptBD(String nome, Tipos tipo, int quantidade, boolean autoIngrement,boolean primaryKey, boolean notNull, boolean unique) {
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.autoIngrement = autoIngrement;
		this.primaryKey = primaryKey;
		this.notNull = notNull;
		this.unique = unique;
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

	public boolean getAutoIngrement() {
		return autoIngrement;
	}


	public void setAutoIngrement(boolean autoIngrement) {
		if (autoIngrement == true) 
			this.autoIngrement = autoIngrement;
	}
	
	public boolean getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		if (primaryKey == true) 
			this.primaryKey = primaryKey;
	}

	public boolean getNotNull() {
		return notNull;
	}


	public void setNotNull(boolean notNull) {
		if (notNull == true) 
			this.notNull = notNull;
	}
	

	public boolean getUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	// autoIngrement, notNull, primaryKey true or false;
	public String CriarScript() {
		String script = getNome() + " " + getTipo() +"(" + getQuantidade() + ")";
		if (getNotNull() == true) {
			 script = script + " NOT NULL";
		}else {

		}
		if (getAutoIngrement() == true) {
			script = script + " AUTO_INCREMENT";
			if (getPrimaryKey() == true) {
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
