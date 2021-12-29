package loja_virtual_repostory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexao();
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");// Declaração = Statement
		stm.setInt(1,2);
		stm.execute();
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas: "+ linhasModificadas);
		
	}

}
