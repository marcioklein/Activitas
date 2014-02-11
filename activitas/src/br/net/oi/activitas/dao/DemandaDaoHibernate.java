package br.net.oi.activitas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.net.oi.activitas.conexao.HibernateUtil;
import br.net.oi.activitas.model.Demanda;
import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Sistema;
import br.net.oi.activitas.model.StatusDemanda;
import br.net.oi.activitas.model.Usuario;

public class DemandaDaoHibernate implements DemandaDao{
	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	public void salvar(Demanda demanda){
		try{
			this.session.save(demanda);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void atualizar(Demanda demanda){
		this.session.update(demanda);
	}
	
	public void excluir(Demanda demanda){
		this.session.delete(demanda);
	}
	
	public Demanda carregar(Integer id){
		return (Demanda)this.session.get(Demanda.class, id);
	}
	
	public List<Demanda> listar(){
		return this.session.createCriteria(Demanda.class).list();
	}
	
	public List<Demanda> listarPorUsuario(Departamento departamento , Usuario usuario){
		Criteria cr = this.session.createCriteria(Demanda.class)
				.add( Restrictions.eq("departamento", departamento))
				.add( Restrictions.eq("solicitante", usuario));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}
}
