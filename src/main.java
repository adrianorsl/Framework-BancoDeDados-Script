
import java.sql.Connection;

import com.classes.ConectarBD;
import com.classes.ScriptBD;
import com.classes.Tabela;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Enum.Tipos;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ScriptBD scpt = new ScriptBD("codigo", Tipos.INT, 100, true, true, false, true);
		ScriptBD scpt2 = new ScriptBD("nome", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt3 = new ScriptBD("endereço", Tipos.VARCHAR, 100, false, false, true, false);
		ScriptBD scpt4 = new ScriptBD("idade", Tipos.INT, 3, false, false, true, false);
	
		
		Tabela tab = new Tabela("teste");
		tab.addScript(scpt);
		tab.addScript(scpt2);
		tab.addScript(scpt3);
		tab.addScript(scpt4);
		
		System.out.println(tab.criarTabela());
		
		Tabela tab2 = new Tabela("teste2");
		
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
		
		
		System.out.println(tab2.criarTabelaForeignKey(scpt5.getNome(), tab.getNomeTabela(), scpt.getNome()));
		
	
		
		
		
		ConectarBD conexao = new ConectarBD();
		conexao.setClassForName("com.mysql.jdbc.Driver");
		conexao.setUrl("jdbc:mysql://localhost:3306/teste");
		conexao.setUsuario("root");
		conexao.setSenha("");
		conexao.conectar();
		System.out.println(conexao);
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = conexao.conectar();
			
			//st = conn.prepareStatement(tab.criarTabela());
			st = conn.prepareStatement(tab2.criarTabelaForeignKey(scpt6.getNome(), tab.getNomeTabela(), scpt2.getNome()));
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
		
		}
	}
}
