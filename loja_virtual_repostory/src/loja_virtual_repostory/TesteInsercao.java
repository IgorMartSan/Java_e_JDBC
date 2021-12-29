package loja_virtual_repostory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperaConexao();
		
		Statement stm = con.createStatement(); //executar c
		boolean resp = stm.execute("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES ('Mouse','Mouse sem fio')", Statement.RETURN_GENERATED_KEYS); // se retonar  for uma lista retorna true, neste caso vai ser falso pois estamos inserindo um valor no banco de dados
		System.out.println(resp);
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);//no mysql o indice começa com 1. Logo index 1 = NOME e index 2 = DESCRICAO
			System.out.println("O id criado foi:"+ id );
		}
		
	}
}
