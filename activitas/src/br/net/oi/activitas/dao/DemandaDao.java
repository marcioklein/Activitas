package br.net.oi.activitas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.net.oi.activitas.conexao.HibernateUtil;
import br.net.oi.activitas.model.Demanda;
import br.net.oi.activitas.model.StatusDemanda;

public class DemandaDao {
	private Session sessao;
	private Transaction transacao;
	
	public void salvar(Demanda demanda){
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			demanda.setStatus(StatusDemanda.NOVA);
			this.sessao.save(demanda);
			this.transacao.commit();
		}catch(HibernateException e){
			System.out.println("Falha ao salvar demanda: "+e.getMessage());
		}finally{
			try{
				if(this.sessao.isOpen()){
					this.sessao.close();
				}
			}catch(Throwable e){
				System.out.println("Falha ao encerrar demanda: "+e.getMessage());
			}
		}
	}
	
	public void atualizar(Demanda demanda){
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(demanda);
			this.transacao.commit();
		}catch(HibernateException e){
			System.out.println("Falha ao atualizar demanda: "+e.getMessage());
		}finally{
			try{
				if(this.sessao.isOpen()){
					this.sessao.close();
				}
			}catch(Throwable e){
				System.out.println("Falha ao encerrar demanda: "+e.getMessage());
			}
		}
	}
	
	public void excluir(Demanda demanda){
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.delete(demanda);
			this.transacao.commit();
		}catch(HibernateException e){
			System.out.println("Falha ao salvar demanda: "+e.getMessage());
		}finally{
			try{
				if(this.sessao.isOpen()){
					this.sessao.close();
				}
			}catch(Throwable e){
				System.out.println("Falha ao encerrar demanda: "+e.getMessage());
			}
		}
	}
	
	public Demanda buscar(Integer id){
		Demanda demanda = null;
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Demanda.class);
			filtro.add(Restrictions.eq("id", id));
			demanda = (Demanda)filtro.uniqueResult();
			this.transacao.commit();
		}catch(Throwable e){
			if(this.transacao.isActive()){
				this.transacao.rollback();
			}
		}finally{
			try{
				if(this.sessao.isOpen()){
					this.sessao.close();
				}
			}catch(Throwable e){
				System.out.println("Falha ao encerrar demanda: "+e.getMessage());
			}
		}
		return demanda;
	}
	
	public List<Demanda> listar(){
		List<Demanda> demandas = null;
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Demanda.class);
			demandas = filtro.list();
			this.transacao.commit();
		}catch(Throwable e){
			if(this.transacao.isActive()){
				this.transacao.rollback();
			}
		}finally{
			try{
				if(this.sessao.isOpen()){
					this.sessao.close();
				}
			}catch(Throwable e){
				System.out.println("Falha ao encerrar demanda: "+e.getMessage());
			}
		}
		return demandas;
	}
}
