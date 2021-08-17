package JUniTestes;

import com.classes.ScriptBD;
import com.classes.Tabela;

import Enum.Tipos;
import junit.framework.TestCase;

public class JUnitTeste  extends TestCase {
	
	ScriptBD scptTeste = new ScriptBD("codigo", Tipos.INT, 100, true, true, false, true);
	
	
	public void teste1() {
		assertEquals("codigo INT(100) AUTO_INCREMENT PRIMARY KEY", scptTeste.CriarScript());
	}
	
	public void teste2() {
		ScriptBD scpt = new ScriptBD("codigo", Tipos.INT, 100, true, true, false, true);
		ScriptBD scpt2 = new ScriptBD("nome", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt3 = new ScriptBD("endereço", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt4 = new ScriptBD("idade", Tipos.INT, 3, false, false, true, false);
		
		Tabela tab = new Tabela("teste");
		tab.addScript(scpt);
		tab.addScript(scpt2);
		tab.addScript(scpt3);
		tab.addScript(scpt4);
		
		assertEquals("CREATE TABLE teste(\ncodigo INT(100) AUTO_INCREMENT PRIMARY KEY,\nnome VARCHAR(100) NOT NULL,\nendereço VARCHAR(100) NOT NULL,\nidade INT(3) NOT NULL,\n UNIQUE(codigo))ENGINE = innodb;", tab.criarTabela());
	}
	
	public void teste3() {
		
	}

}
