package com.classes;

import java.util.ArrayList;
import java.util.List;

public class ListAbstratTabela {
	
	List<AbstratTabela> lista = new ArrayList<AbstratTabela>();
	
	public void add(AbstratTabela tabela){
		lista.add(tabela);
	}
	
	public List<AbstratTabela> getLista(){
		return lista;
	}

}
