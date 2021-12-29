package loja_virtual_repostory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteListagem {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexao();
		PreparedStatement stm = con.prepareStatement("SELECT ID , NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		ResultSet rst = stm.getResultSet();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			String nome = rst.getString(2);
			String descricao = rst.getString(3);
			
			System.out.print(id +" | ");
			System.out.print(nome +" | ");
			System.out.println(descricao);
		}
	}

}
