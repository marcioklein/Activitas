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
import br.net.oi.activitas.model.StatusDemanda;
import br.net.oi.activitas.model.Usuario;

public class DepartamentoDaoHibernate implements DepartamentoDao{
	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	public void salvar(Departamento departamento){
		this.session.save(departamento);
	}
	
	public void atualizar(Departamento departamento){
		this.session.update(departamento);
	}
	
	public void excluir(Departamento departamento){
		this.session.delete(departamento);
	}
	
	public Departamento carregar(Integer id){
		return (Departamento)this.session.get(Departamento.class, id);
	}
	
	public List<Departamento> listar(){
		return this.session.createCriteria(Departamento.class).list();
	}
}
