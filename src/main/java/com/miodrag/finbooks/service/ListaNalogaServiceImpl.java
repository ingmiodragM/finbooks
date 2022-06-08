package com.miodrag.finbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.miodrag.finbooks.entities.ListaNaloga;
import com.miodrag.finbooks.repos.ListaNalogaRepository;

@Service
public class ListaNalogaServiceImpl implements ListaNalogaService {
	
	@Autowired
	private ListaNalogaRepository repository;

	@Override
	public ListaNaloga saveListaNaloga(ListaNaloga listaNaloga) {
		repository.save(listaNaloga);
		
		return null;
	}

	@Override
	public ListaNaloga updateListaNaloga(ListaNaloga listaNaloga) {
		repository.save(listaNaloga);
		return null;
	}

	@Override
	public void deleteListaNaloga(ListaNaloga listaNaloga) {
		repository.delete(listaNaloga);

	}

	@Override
	public ListaNaloga getListaNalogaById(int rBr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListaNaloga> getAllListaNaloga() {
		// TODO Auto-generated method stub
		return null;
	}

}
