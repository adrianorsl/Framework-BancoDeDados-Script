package JsonCsv;

import java.util.List;

import com.classes.AbstratTabela;

import Interface.Persistencia;

public class PersistenciaAbstratTabela {

	private Persistencia persist;
	
	public PersistenciaAbstratTabela(Persistencia persist) {
		this.persist = persist;
	}
	
	public void gravar(List<AbstratTabela> tab) throws Exception {
		persist.gravar(tab);
	}
	
	public void ler(List<AbstratTabela> tab) throws Exception {
		persist.gravar(tab);
	}
}
