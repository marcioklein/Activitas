package br.net.oi.activitas.conexao;

import org.hibernate.Session;

public class ConectaHibernateMySQL {
	public static void main(String[] args){
		Session sessao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("conectou");
		}finally{
			sessao.close();
		}
	}

}
