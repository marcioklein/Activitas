package br.net.oi.activitas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySQL {
	public static void main(String[] args){
		Connection conexao = null;
		try{
			String url = "jdbc:mysql://localhost/activitas";
			String usuario = "activitas";
			String senha = "activitas";
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou!");
		}catch(SQLException e){
			System.out.println("Erro de SQL. Erro:" + e.getMessage());
		}finally{
			try{
				conexao.close();
			}catch(SQLException e){
				System.out.println("Erro ao tentar fechar a conexao SQL. Erro:" + e.getMessage());
			}
		}
	}

}
