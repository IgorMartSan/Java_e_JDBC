package loja_virtual_repostory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexao();
		
		Statement stm = con.createStatement();// Declaração = Statement
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas: "+ linhasModificadas);
		
	}

}
