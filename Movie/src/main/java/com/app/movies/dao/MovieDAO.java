package com.app.movies.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.movies.domains.Genere;
import com.app.movies.domains.Movie;
import com.app.movies.domains.Rating;
import com.app.movies.utils.HibernateUtility;

public class MovieDAO {

	public void addMovie(Movie movie) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(movie);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// Get Single Movie By ID
	public Movie getMovieById(int id) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Movie movie = null;
		try {
			transaction = session.beginTransaction();
			movie = session.get(Movie.class, id);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return movie;
	}

	// Update Movie
	public void updateMovie(Movie movie) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.merge(movie);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// Delete Movie
	public void deleteMovie(Movie movie) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(movie);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// Get All Movies By Name
	public List<Movie> getMoviesByName(String name) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Movie> moviesList = null;
		try {
			transaction = session.beginTransaction();
			moviesList = new ArrayList<Movie>();
			Query query = session.createQuery("FROM Movie m WHERE m.title = :name");
			query.setParameter("name", name);
			moviesList = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return moviesList;
	}

	// Get All Movies By Genere
	public List<Movie> getMoviesByGenere(Genere genere) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Movie> moviesList = null;
		try {
			transaction = session.beginTransaction();
			moviesList = new ArrayList<Movie>();
			Query query = session.createQuery("FROM Movie m WHERE :genere IN elements(m.genere)");
			query.setParameter("genere", genere);
			moviesList = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return moviesList;
	}

	// Get All Movies By Rating
	public List<Movie> getMoviesByRating(Rating rating) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Movie> moviesList = null;
		try {
			transaction = session.beginTransaction();
			moviesList = new ArrayList<Movie>();
			Query query = session.createQuery("FROM Movie m WHERE m.rating = :rating");
			query.setParameter("rating", rating);
			moviesList = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return moviesList;
	}

	// Get All Movies By Year
	public List<Movie> getMoviesByYear(int year) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Movie> moviesList = null;
		try {
			transaction = session.beginTransaction();
			moviesList = new ArrayList<Movie>();
			Query query = session.createQuery("FROM Movie m WHERE m.year = :year");
			query.setParameter("year", year);
			moviesList = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return moviesList;
	}

	// Get All Movies By Artist First Name and Last Name
	public List<Movie> getMoviesByArtist(String fname, String lname) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Movie> moviesList = null;
		try {
			transaction = session.beginTransaction();
			moviesList = new ArrayList<Movie>();
			Query query = session.createQuery(
					"SELECT m FROM Movie m JOIN m.artists a WHERE a.firstName = :fname AND a.lastName = :lname");
			query.setParameter("fname", fname);
			query.setParameter("lname", lname);
			moviesList = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return moviesList;
	}

	// Get All Movies By Director First Name and Last Name
	public List<Movie> getMoviesByDirector(String fname, String lname) {
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		List<Movie> moviesList = null;
		try {
			transaction = session.beginTransaction();
			moviesList = new ArrayList<Movie>();
			Query query = session
					.createQuery("FROM Movie m WHERE m.directors.firstName = :fname AND m.directors.lastName = :lname");
			query.setParameter("fname", fname);
			query.setParameter("lname", lname);
			moviesList = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return moviesList;
	}

}
