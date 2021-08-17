
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
		
		ScriptBD scpt = new ScriptBD("codigo", Tipos.INT, 100, true, true, true);
		ScriptBD scpt2 = new ScriptBD("nome", Tipos.VARCHAR, 100, false, false, true);
	
		
		Tabela tab = new Tabela("teste");
		tab.addScript(scpt);
		tab.addScript(scpt2);
		System.out.println(tab.criarTabela());
		
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
			
			st = conn.prepareStatement(tab.criarTabela());
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
		
		}
	}
}
