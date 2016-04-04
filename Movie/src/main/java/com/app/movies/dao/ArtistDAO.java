package com.app.movies.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.movies.domains.Artist;
import com.app.movies.utils.HibernateUtility;

public class ArtistDAO {

	// Add Artist
	public void addArtist(Artist artist) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(artist);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// Get Artist By ID
	public Artist getArtistById(int id) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Artist artist = null;
		try {
			transaction = session.beginTransaction();
			artist = session.get(Artist.class, id);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return artist;
	}

	// Update Artist
	public void updateArtist(Artist artist) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.merge(artist);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// Delete Artist
	public void deleteMovie(Artist artist) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(artist);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
