package com.miodrag.finbooks.service;

import java.util.List;


import com.miodrag.finbooks.entities.ListaNaloga;

public interface ListaNalogaService {
	
	ListaNaloga saveListaNaloga(ListaNaloga listaNaloga);

	ListaNaloga updateListaNaloga(ListaNaloga listaNaloga);

	void deleteListaNaloga(ListaNaloga listaNaloga);

	ListaNaloga getListaNalogaById(int rBr);

	List<ListaNaloga> getAllListaNaloga();

}
