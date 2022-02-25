package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table( name= "lookify" )
public class Lookify{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@NotNull
	@Size(min = 2, max = 20, message="El titulo debe tener entre 2 y 20 caracteres.")
	private String title;
	
	@NotNull
	@Size(min = 2, max = 20, message="El artista debe tener entre 2 y 20 caracteres.")
	private String artist;
	
	@NotNull
	@Min(value=1, message="La clasificacion debe ser mayor a 1.")
	@Max(value=19, message="La clasificacion debe ser menor a 10.")
	private long rating;
	
	public Lookify() {
		
	}
	
	public Lookify( String title, String artist, long rating ) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}
}
