
import java.sql.Connection;

import com.classes.AbstratTabela;
import com.classes.ConectarBD;
import com.classes.ListAbstratTabela;
import com.classes.ScriptBD;
import com.classes.Tabela;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import Enum.Tipos;
import JsonCsv.Csv;
import JsonCsv.Json;
import JsonCsv.PersistenciaAbstratTabela;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ScriptBD scpt = new ScriptBD("codigo", Tipos.INT, 100, true, true, false, true);
		ScriptBD scpt2 = new ScriptBD("nome", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt3 = new ScriptBD("endereço", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt4 = new ScriptBD("idade", Tipos.INT, 3, false, false, true, false);
	
		
		Tabela tab = new Tabela("Cliente");
		tab.addScript(scpt);
		tab.addScript(scpt2);
		tab.addScript(scpt3);
		tab.addScript(scpt4);
		
		
		
		Tabela tab2 = new Tabela("Funcionario");
		
		ScriptBD scpt5 = new ScriptBD("codigoFuncionario", Tipos.INT, 100, false,false, false, false);
		ScriptBD scpt6 = new ScriptBD("nomeFuncionario", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt7 = new ScriptBD("funcao", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt8 = new ScriptBD("setor", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt9 = new ScriptBD("salario", Tipos.FLOAT, 10, false, false, true, false);
		
		tab2.addScript(scpt5);
		tab2.addScript(scpt6);
		tab2.addScript(scpt7);
		tab2.addScript(scpt8);
		tab2.addScript(scpt9);
		
		System.out.println(tab.criarTabela() + "\n");
		
		System.out.println(tab2.criarTabelaForeignKey(scpt5.getNome(), tab.getNomeTabela(), scpt.getNome()));
		
		
		AbstratTabela abstrat = new AbstratTabela();
		AbstratTabela abstrat2 = new AbstratTabela();
		
		
		ListAbstratTabela lista = new ListAbstratTabela();
	
		abstrat.setTabela(tab.criarTabela());
		lista.add(abstrat);
		
		
		abstrat2.setTabela(tab2.criarTabela());
		lista.add(abstrat2);
		
		Json a = new Json();
		a.setNome("Teste.json");
		PersistenciaAbstratTabela persist = new PersistenciaAbstratTabela(a);
		persist.gravar(lista.getLista());
		
		
		List<AbstratTabela> list2 = a.ler(lista.getLista());
		
		for (Iterator iter = list2.iterator(); iter.hasNext();) {
			AbstratTabela element = (AbstratTabela) iter.next();
			System.out.println(element.toString() + "\n---");	
		}
	
		Csv b = new Csv();
		b.setNome("teste.csv");
		PersistenciaAbstratTabela persist2 = new PersistenciaAbstratTabela(b);
		persist2.gravar(lista.getLista());
		
		List<AbstratTabela> list3 = b.ler(lista.getLista());
		
		for (Iterator iter = list3.iterator(); iter.hasNext();) {
			AbstratTabela element = (AbstratTabela) iter.next();
			System.out.println(element.toString() + "\n---");	
		}
		
		
		ConectarBD conexao = new ConectarBD();
		conexao.setClassForName("com.mysql.jdbc.Driver");
		conexao.setUrl("jdbc:mysql://localhost:3306/teste");
		conexao.setUsuario("root");
		conexao.setSenha("");
		conexao.conectar();
		System.out.println(conexao);
		
		Connection conn = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		
		try {
			conn = conexao.conectar();
			
			st = conn.prepareStatement(tab.criarTabela());
			st2 = conn.prepareStatement(tab2.criarTabelaForeignKey(scpt5.getNome(), tab.getNomeTabela(), scpt.getNome()));
			
			
			int rowsAffected = st.executeUpdate();
			rowsAffected = st2.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
		
		}
	}
}
