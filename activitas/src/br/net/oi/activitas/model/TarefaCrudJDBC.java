package br.net.oi.activitas.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TarefaCrudJDBC {
	
	public void salvar(Tarefa tarefa){
		Connection conexao = this.geraConexao();
		PreparedStatement insertSt = null;
		String sql = "insert into tarefa(id_usuario , id_status , tarefa , descricao , id_projeto , data_abertura , data_encerramento , data_prevista , prioridade) values (?,?,?,?,?,?,?,?,?)";
		try{
			insertSt = conexao.prepareStatement(sql);
			insertSt.setString(1, tarefa.getIdUsuario());
			insertSt.setString(2, tarefa.getIdStatus());
			insertSt.setString(3, tarefa.getTarefa());
			insertSt.setString(4, tarefa.getDescricao());
			insertSt.setInt(5, tarefa.getIdProjeto());
			insertSt.setDate(6, tarefa.getDataAbertura());
			insertSt.setDate(7, tarefa.getDataEncerramento());
			insertSt.setDate(8, tarefa.getDataPrevista());
			insertSt.setInt(9, tarefa.getPrioridade());
			insertSt.executeUpdate();
		}catch(SQLException e){
			System.out.println("Erro ao incluir tarefa. Erro: "+e.getMessage());
		}finally{
			try{
				insertSt.close();
				conexao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar operações de inserção. Erro: "+e.getMessage());
			}
		}
	}
	
	public void atualizar(Tarefa tarefa){
		
	}
	
	public void excluir(Tarefa tarefa){
		
	}
	
	public List<Tarefa> listar(){
		Connection conexao = this.geraConexao();
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		Statement consulta = null;
		ResultSet resultado = null;
		Tarefa tarefa = null;
		String sql = "select * from tarefa";
		try{
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while(resultado.next()){
				tarefa = new Tarefa();
				tarefa.setIdTarefa(new Integer(resultado.getInt("id_tarefa")));
				tarefa.setIdUsuario(resultado.getString("id_usuario"));
				tarefa.setIdStatus(resultado.getString("id_status"));
				tarefa.setTarefa(resultado.getString("tarefa"));
				tarefa.setDescricao(resultado.getString("descricao"));
				tarefa.setIdProjeto(resultado.getInt("id_projeto"));
				tarefa.setDataAbertura(resultado.getDate("data_abertura"));
				tarefa.setDataEncerramento(resultado.getDate("data_encerramento"));
				tarefa.setDataPrevista(resultado.getDate("data_prevista"));
				tarefa.setPrioridade(resultado.getInt("prioridade"));
				tarefas.add(tarefa);
			}
		}catch(SQLException e){
			System.out.println("Erro ao buscar código da tarefa. Falha: "+e.getMessage());
		}finally{
			try{
				consulta.close();
				resultado.close();
				conexao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar as operacoes deconsulta. Falha: "+e.getMessage());
			}
		}
		return tarefas;
	}
	
	/*public Tarefa buscaTarefa(Integer idTarefa){
		
	}*/
	
	public Connection geraConexao(){
		Connection conexao = null;
		try{
			String url = "jdbc:mysql://localhost/activitas";
			String usuario = "activitas";
			String senha = "activitas";
			conexao = DriverManager.getConnection(url, usuario, senha);
			//System.out.println("Conectou!");
			//return conexao;
		}catch(SQLException e){
			System.out.println("Erro de SQL. Erro:" + e.getMessage());
		}
		return conexao;
		/*finally{
			try{
				conexao.close();
			}catch(SQLException e){
				System.out.println("Erro ao tentar fechar a conexao SQL. Erro:" + e.getMessage());
			}
		}*/
	}
	
	public static void main(String[] args){
		TarefaCrudJDBC tarefaCrudJDBC = new TarefaCrudJDBC();
		Tarefa t = new Tarefa();
		t.setDataAbertura(new Date(System.currentTimeMillis()));
		t.setDescricao("Tarefa de teste");
		t.setIdProjeto(1);
		t.setIdStatus("NOVO");
		t.setIdUsuario("1");
		t.setTarefa("Executar Tarefa");
		tarefaCrudJDBC.salvar(t);
		
		Tarefa t2 = new Tarefa();
		t2.setDataAbertura(new Date(System.currentTimeMillis()));
		t2.setDescricao("Segunda Tarefa de teste");
		t2.setIdProjeto(1);
		t2.setIdStatus("NOVO");
		t2.setIdUsuario("1");
		t2.setTarefa("Executar Tarefa numero 2");
		tarefaCrudJDBC.salvar(t2);
		
		System.out.println("Tarefas cadastradas: "+tarefaCrudJDBC.listar().size());
	}
	

}
