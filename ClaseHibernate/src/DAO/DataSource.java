package DAO;

import org.apache.commons.collections.Factory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import exception.MyException;

public class DataSource {
	private static DataSource instancia;
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	private DataSource(){
		
	}
	
	public static DataSource getInstance() {
		if(instancia == null ){
			instancia = new DataSource();
		}
		
		return instancia;
	}
	
	public Session getSession() throws MyException{
		try {
			if (factory == null) {
				conf.configure("DAO/hibernate.cfg.xml");
				factory = conf.buildSessionFactory();
				
			}
			return factory.openSession();
		} 
		catch (HibernateException e) {
			throw new MyException("Error configurando la sesión",e);
		}	
	}
}
