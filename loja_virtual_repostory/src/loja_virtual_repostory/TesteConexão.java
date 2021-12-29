package loja_virtual_repostory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexão {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactoy = new ConnectionFactory();
		Connection con = connectionFactoy.recuperaConexao();
		
		Statement stm = con.createStatement();
		boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		ResultSet rst = stm.getResultSet();// retorna lista do resultado do stm.execute
		
		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.print(id +" / ");
			String nome = rst.getString("NOME");
			System.out.print( nome +" / ");
			String descricao = rst.getString("DESCRICAO");
			System.out.println( descricao +" ");
		}
		
		
		System.out.println(resultado);
		
		
		
		con.close();
		System.out.println("Estou aqui");
	}
}
