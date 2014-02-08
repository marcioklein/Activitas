package br.net.oi.activitas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Grupo;
import br.net.oi.activitas.model.Sistema;

public class GrupoDaoHibernate implements GrupoDao {
	
	private Session session;
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Grupo grupo) {
		this.session.saveOrUpdate(grupo);

	}

	@Override
	public void excluir(Grupo grupo) {
		this.session.delete(grupo);
	}

	@Override
	public Grupo carregar(Integer id) {
		return (Grupo)this.session.get(Grupo.class, id);
	}

	@Override
	public List<Grupo> listar() {
		return this.session.createCriteria(Grupo.class).list();
	}
	
	public List<Grupo> listarPorDepartamento(Departamento departamento){
		Criteria cr = this.session.createCriteria(Grupo.class)
				.add( Restrictions.eq("departamento", departamento));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}

}
