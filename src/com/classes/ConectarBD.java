package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarBD {
	
	private String classForName;
	private String url;
	private String usuario;
	private String senha;
	
	
	
	public ConectarBD() {
	
	}
	
	public ConectarBD(String classForName, String url, String usuario, String senha) {
		this.classForName = classForName;
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getClassForName() {
		return classForName;
	}
	public void setClassForName(String classForName) {
		this.classForName = classForName;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Connection conectar() {
		try {
    		Class.forName(getClassForName());
            String url = getUrl();	
            return DriverManager.getConnection(url,getUsuario(),getSenha());
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConectarBD [classForName=");
		builder.append(classForName);
		builder.append(", url=");
		builder.append(url);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", senha=");
		builder.append(senha);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
