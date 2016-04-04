package com.app.movies.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.movies.domains.Director;
import com.app.movies.utils.HibernateUtility;

public class DirectorDAO {

	// Add Director
	public void addArtist(Director director) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(director);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// Get Director By ID
	public Director getDirectorById(int id) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Director director = null;
		try {
			transaction = session.beginTransaction();
			director = session.get(Director.class, id);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return director;
	}

	// Update Director
	public void updateDirector(Director director) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.merge(director);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// Delete Director
	public void deleteDirector(Director director) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(director);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
