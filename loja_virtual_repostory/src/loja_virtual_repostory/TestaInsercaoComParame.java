package loja_virtual_repostory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParame {
	public static void main(String[] args) throws SQLException {
		String nome = "Mouse 3";
		String descricao = "Mouse sem fio";

		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperaConexao();

		PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS); // executar c

		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);// no mysql o indice começa com 1. Logo index 1 = NOME e index 2 = DESCRICAO
			System.out.println("O id criado foi:" + id);
		}

	}
}
