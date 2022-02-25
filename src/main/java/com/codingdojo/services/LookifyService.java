package com.codingdojo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Lookify;
import com.codingdojo.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;
	
	public LookifyService( LookifyRepository lookifyRepository ) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<Lookify> selectAllFromLookify(){
		List<Lookify> lookifyList = lookifyRepository.findAll();
		if ( lookifyList.isEmpty() ) {
			Lookify lookifyVacio = new Lookify("N/A", "N/A", 0);
			lookifyList.add(lookifyVacio);
		}
		return lookifyList;
	}
	
	public Lookify insertIntoLookify( Lookify lookify ) {
		return lookifyRepository.save(lookify);
	}
	
	public Lookify selectFromLookifyWhereId( int id ){
		List<Lookify> lookifyList = lookifyRepository.findByid(id);
		if ( lookifyList.isEmpty() ) {
			Lookify lookifyVacio = new Lookify();
			return lookifyVacio;
		}
		return lookifyList.get(0);
	}
	
	public List<Lookify> selectFromLookifyWhereArtist( String artist ){
		List<Lookify> lookifyList = lookifyRepository.findByArtist(artist);
		if ( lookifyList.isEmpty() ) {
			Lookify lookifyVacio = new Lookify( "No hubo resultados", artist, 0  );
			List<Lookify> lookifyVacioList = new ArrayList<>(); 
			lookifyVacioList.add(lookifyVacio);
			return lookifyVacioList;
		}
		return lookifyList;
	}
	
	public void updateLookify( Lookify lookify ) {
		lookifyRepository.save(lookify);
	}
	
	public void deleteFromLookify( int id ) {
		lookifyRepository.deleteByid( id );
	}
}
