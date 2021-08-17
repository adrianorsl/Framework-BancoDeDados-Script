package Interface;

import java.util.List;

import com.classes.AbstratTabela;

public interface Persistencia {

	public boolean gravar(List<AbstratTabela> lista)  throws Exception;
	
	public List<AbstratTabela> ler(List<AbstratTabela> lista) throws Exception;
}
