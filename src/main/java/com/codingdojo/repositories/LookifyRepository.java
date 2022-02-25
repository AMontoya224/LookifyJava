package com.codingdojo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	List<Lookify> findAll();
	
	@SuppressWarnings("unchecked")
	Lookify save( Lookify lookify );
	
	List<Lookify> findByid( int id );
	
	List<Lookify> findByArtist( String artist );
	
	@Transactional
	void deleteByid( int id );
}
