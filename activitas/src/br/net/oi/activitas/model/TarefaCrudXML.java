package br.net.oi.activitas.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.net.oi.activitas.conexao.HibernateUtil;

public class TarefaCrudXML {
	public void salvar(Tarefa tarefa){
		Session sessao = null;
		Transaction transacao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(tarefa);
			transacao.commit();
		}catch(HibernateException e){
			System.out.println("Falha ao salvar "+e.getMessage());
		}finally{
			try{
				sessao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar insert "+e.getMessage());
			}
		}
	}
	
	public void atualizar(Tarefa tarefa){
		Session sessao = null;
		Transaction transacao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(tarefa);
			transacao.commit();
		}catch(HibernateException e){
			System.out.println("Falha ao atualizar "+e.getMessage());
		}finally{
			try{
				sessao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar update "+e.getMessage());
			}
		}
	}
	public void excluir(Tarefa tarefa){
		Session sessao = null;
		Transaction transacao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(tarefa);
			transacao.commit();
		}catch(HibernateException e){
			System.out.println("Falha ao excluir "+e.getMessage());
		}finally{
			try{
				sessao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar excluir "+e.getMessage());
			}
		}
	}
	public List<Tarefa> listar(){
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<Tarefa> resultado = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Tarefa");
			resultado = consulta.list();
			transacao.commit();
		}catch(HibernateException e){
			System.out.println("Falha ao listar "+e.getMessage());
		}finally{
			try{
				sessao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar listar "+e.getMessage());
			}
		}
		
		return resultado;
	}
	public Tarefa buscaTarefa(Integer valor){
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		Tarefa tarefa = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from tarefa where id_tarefa = :parametro");
			consulta.setInteger("parametro", valor);
			tarefa = (Tarefa)consulta.uniqueResult();
			transacao.commit();
		}catch(HibernateException e){
			System.out.println("Falha ao buscar "+e.getMessage());
		}finally{
			try{
				sessao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar buscar "+e.getMessage());
			}
		}
		return tarefa;
	}
	public static void main(String[] args){
		TarefaCrudXML tarefaCrudXML = new TarefaCrudXML();
		String[] usuarios = {"1","1","2"};
		String[] tarefas = {"refatorar aplicacao","testar refactoring","criar usuario"};
		String[] descricoes = {"refatorar aplicacao de teste" , "testar" , "criar usuario 154385 ni sistema siap"};
		Integer[] projetos = {5,null,8};
		Integer[] prioridades = {1,2,3};
		Tarefa tarefa = null;
		for(int i=0;i<usuarios.length;i++){
			tarefa = new Tarefa();
			tarefa.setDataAbertura(new Date(System.currentTimeMillis()));
			tarefa.setDescricao(descricoes[i]);
			tarefa.setIdProjeto(projetos[i]);
			tarefa.setIdStatus("NOVO");
			tarefa.setIdUsuario(usuarios[i]);
			tarefa.setPrioridade(prioridades[i]);
			tarefa.setTarefa(tarefas[i]);
			tarefaCrudXML.salvar(tarefa);
		}
		
		System.out.println("Registros:  "+tarefaCrudXML.listar().size());
		
	}

}
