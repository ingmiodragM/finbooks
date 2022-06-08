package com.miodrag.finbooks.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.miodrag.finbooks.entities.Dnevnik;



public interface DnevnikService {
	
	Dnevnik saveDnevnik(Dnevnik dnevnik);

	Dnevnik updateDnevnik(Dnevnik dnevnik);

	void deleteDnevnik(Dnevnik dnevnik);

	Dnevnik getDnevnikById(int rBr);

	List<Dnevnik> getAllDnevniks();
	
//	@Query("SELECT * FROM dnevnik WHERE br+naloga =?1")
	List<Dnevnik> findDnevniksbyBrNaloga(int brn);

}
