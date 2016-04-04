package com.app.movies.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director {

	@Id
	@GeneratedValue
	private int id;

	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "directors")
	private List<Movie> movies = new ArrayList<Movie>();

	public Director() {
		super();
	}

	public Director(String firstName, String lastName, List<Movie> movies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.movies = movies;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public int getId() {
		return id;
	}
}
