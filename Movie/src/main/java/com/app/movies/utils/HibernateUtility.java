package com.app.movies.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.app.movies.domains.Artist;
import com.app.movies.domains.Director;
import com.app.movies.domains.Movie;

public class HibernateUtility {

	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration();
			config.addAnnotatedClass(Movie.class);
			config.addAnnotatedClass(Artist.class);
			config.addAnnotatedClass(Director.class);
			config.configure();

			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();
			sessionFactory = config.buildSessionFactory(registry);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
