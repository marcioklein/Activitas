package br.net.oi.activitas.util;

import br.net.oi.activitas.conexao.HibernateUtil;
import br.net.oi.activitas.dao.DemandaDao;
import br.net.oi.activitas.dao.DemandaDaoHibernate;
import br.net.oi.activitas.dao.DepartamentoDao;
import br.net.oi.activitas.dao.DepartamentoDaoHibernate;
import br.net.oi.activitas.dao.UsuarioDao;
import br.net.oi.activitas.dao.UsuarioDaoHibernate;

public class DaoFactory {
	
	public static UsuarioDao criarUsuarioDao(){
		UsuarioDaoHibernate usuarioDao = new UsuarioDaoHibernate();
		usuarioDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDao;
	}
	
	public static DemandaDao criarDemandaDao(){
		DemandaDaoHibernate demandaDao = new DemandaDaoHibernate();
		demandaDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return demandaDao;
	}
	
	public static DepartamentoDao criarDepartamentoDao(){
		DepartamentoDaoHibernate departamentoDao = new DepartamentoDaoHibernate();
		departamentoDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return departamentoDao;
	}

}
