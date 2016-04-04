package com.app.movies.control;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.app.movies.dao.ArtistDAO;
import com.app.movies.dao.DirectorDAO;
import com.app.movies.dao.MovieDAO;
import com.app.movies.domains.Artist;
import com.app.movies.domains.Director;
import com.app.movies.domains.Genere;
import com.app.movies.domains.Movie;
import com.app.movies.domains.Rating;

public class Application {

	public static void setData() {
		try {

			Director d = new Director();
			d.setFirstName("James");
			d.setLastName("Wan");

			Artist paul = new Artist();
			paul.setFirstName("Paul");
			paul.setLastName("Walker");
			paul.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1973-09-12"));
			paul.setPlaceOfBirth("California, U.S");
			paul.setBiography("He was very hard working actor.");
			Path path = FileSystems.getDefault()
					.getPath("E:/WORKSPACE/Spring Workspace/Movie/src/main/resources/images/PaulWalker.jpg");
			paul.setPicture(Files.readAllBytes(path));

			Movie fast7 = new Movie();
			fast7.setGeneres(Arrays.asList(Genere.ACTION, Genere.WAR));
			fast7.setRating(Rating.EXCELLENT);
			fast7.setTitle("Furious 7");
			fast7.setYear(2015);
			fast7.setSummary(
					"Vin Diesel, Paul Walker and Dwayne Johnson lead the returning cast across the globe in the action-packed Extended Edition of their most gravity-defying and emotional adventure yet. Targeted by a cold-blooded black-ops assassin with a score to settle (Jason Statham), their only hope is to get behind the wheel again and secure an ingenious prototype tracking device.");
			Path poster = FileSystems.getDefault()
					.getPath("E:/WORKSPACE/Spring Workspace/Movie/src/main/resources/images/fast7.jpg");
			fast7.setPoster(Files.readAllBytes(poster));

			fast7.getArtists().add(paul);
			fast7.getDirectors().add(d);

			MovieDAO movieDAO = new MovieDAO();
			movieDAO.addMovie(fast7);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void displayMovieInformation() {
		MovieDAO movieDAO = new MovieDAO();
		List<Movie> movies = movieDAO.getMoviesByName("Furious 7");

		System.out.println("\n----- Information About Furious 7 -----\n");
		for (Movie movie : movies) {
			System.out.println("TITLE: " + movie.getTitle());
			System.out.println("SUMMARY: " + movie.getSummary());
			System.out.println("ARTISTS: " + movie.getArtists());
			System.out.println("YEAR: " + movie.getYear());
			System.out.println("DIRECTORS: " + movie.getDirectors());
			System.out.println("GENERES: " + movie.getGeneres());
			System.out.println("RATINGS: " + movie.getRating());
		}
	}

	public static void displayArtistInformation() {
		ArtistDAO artistDAO = new ArtistDAO();
		Artist artist = artistDAO.getArtistById(2);

		System.out.println("\n----- Information About Artist -----\n");
		System.out.println("FIRST NAME: " + artist.getFirstName());
		System.out.println("LAST NAME: " + artist.getLastName());
		System.out.println("DATE OF BIRTH: " + artist.getDateOfBirth());
		System.out.println("PLACE OF BIRTH: " + artist.getPlaceOfBirth());
		System.out.println("BIOGRAPHY: " + artist.getBiography());
		System.out.println("MOVIES: " + artist.getMovies());
	}

	public static void displayDirectorInformation() {
		DirectorDAO directorDAO = new DirectorDAO();
		Director director = directorDAO.getDirectorById(3);

		System.out.println("\n----- Information About Director -----\n");
		System.out.println("FIRST NAME: " + director.getFirstName());
		System.out.println("LAST NAME: " + director.getLastName());
		System.out.println("MOVIES: " + director.getMovies());
	}

	public static void main(String[] args) {
		setData();
		displayMovieInformation();
		displayArtistInformation();
		displayDirectorInformation();
	}
}
