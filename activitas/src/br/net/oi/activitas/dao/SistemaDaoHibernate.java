package br.net.oi.activitas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Sistema;

public class SistemaDaoHibernate implements SistemaDao {
	private Session session;
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Sistema sistema) {
		this.session.saveOrUpdate(sistema);

	}

	@Override
	public void excluir(Sistema sistema) {
		this.session.delete(sistema);

	}

	@Override
	public Sistema carregar(Integer id) {
		return (Sistema)this.session.get(Sistema.class, id);
	}

	@Override
	public List<Sistema> listar() {
		return this.session.createCriteria(Sistema.class).list();
	}
	
	public List<Sistema> listarPorDepartamento(Departamento departamento){
		Criteria cr = this.session.createCriteria(Sistema.class)
				.add( Restrictions.eq("departamento", departamento));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}

}
