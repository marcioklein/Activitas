package br.net.oi.activitas.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try{
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		}catch(Throwable e){
			System.out.println("Criacao do Session Factory falhou. "+e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
