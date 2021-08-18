package Interface;

import java.util.List;

import com.classes.AbstratTabela;
/**
 * 
 * @author adrianorslsc@hotmail.com
 *
 */
public interface Persistencia {
	/**
	 * Interface usada para gravar os Scripts criados
	 * @param lista
	 * @return 
	 * @throws Exception
	 */
	public boolean gravar(List<AbstratTabela> lista)  throws Exception;
	/**
	 * Interface usada para ler os Scripts criados
	 * @param lista
	 * @return
	 * @throws Exception
	 */
	public List<AbstratTabela> ler(List<AbstratTabela> lista) throws Exception;
}
