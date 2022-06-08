package com.miodrag.finbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miodrag.finbooks.entities.Dnevnik;
import com.miodrag.finbooks.repos.DnevnikRepository;

@Service
public class DnevnikServiceImpl implements DnevnikService {
	
	@Autowired
	private DnevnikRepository repository;

	@Override
	public Dnevnik saveDnevnik(Dnevnik dnevnik) {
		repository.save(dnevnik);
		return null;
	}

	@Override
	public Dnevnik updateDnevnik(Dnevnik dnevnik) {
		repository.save(dnevnik);
		return null;
	}

	@Override
	public void deleteDnevnik(Dnevnik dnevnik) {
		repository.delete(dnevnik);

	}

	@Override
	public Dnevnik getDnevnikById(int rBr) {
		
		return	repository.findById(rBr).get();
		 
	}

	@Override
	public List<Dnevnik> getAllDnevniks() {

		return (List<Dnevnik>) repository.findAll();
	}



	@Override
	public List<Dnevnik> findDnevniksbyBrNaloga(int brn) {

		return (List<Dnevnik>) repository.findDnevniksbyBrNaloga(brn);
	}







}
