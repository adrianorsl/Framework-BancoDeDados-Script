package com.classes;

import Enum.Tipos;
/**
 * 
 * @author adrianorslsc@hotmail.com
 *
 */
public class ScriptBD {

	private String nome;
	private Tipos tipo;
	private int quantidade;
	private boolean autoIncrement;
	private boolean primaryKey;
	private boolean notNull;
	private boolean unique;
	

	
	
	public ScriptBD() {
		
	}
	/**
	 * 
	 * @param nome String do nome da linha da tabela
	 * @param tipo enum do tipo da variavel da linha da tabela
	 * @param quantidade Int da quantidade de caracteres da varivel
	 * @param autoIngrement Valor Booleano True para acrescentar Auto Increment  ou False para não acresentar
	 * @param primaryKey Valor Booleano True para acrescentar primary Key  ou False para não acresentar
	 * @param notNull Valor Booleano True para acrescentar Not Null  ou False para não acresentar
	 * @param unique Valor Booleano True para acrescentar valor Unique ou False para não acresentar
	 */
	public ScriptBD(String nome, Tipos tipo, int quantidade, boolean autoIncrement,boolean primaryKey, boolean notNull, boolean unique) {
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.autoIncrement = autoIncrement;
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

	public boolean getAutoIncrement() {
		return autoIncrement;
	}


	public void setAutoIngrement(boolean autoIncrement) {
		if (autoIncrement == true) 
			this.autoIncrement = autoIncrement;
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

	/**
	 * 
	 * @return String da linha da tabela de acordo com os dados informados
	 */
	public String CriarScript() {
		String script = getNome() + " " + getTipo() +"(" + getQuantidade() + ")";
		if (getNotNull() == true) {
			 script = script + " NOT NULL";
		}else {

		}
		if (getAutoIncrement() == true) {
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
