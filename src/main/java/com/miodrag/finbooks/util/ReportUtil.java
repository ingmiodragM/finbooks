package com.miodrag.finbooks.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.miodrag.finbooks.entities.Dnevnik;

import net.sf.jasperreports.engine.JRException;

public interface ReportUtil {
	
//	Dnevnik getDnevnikById(int rBr);

	
	void generateReportN(String path,List<Object> data)throws FileNotFoundException, JRException;
	
	ResponseEntity<byte[]> downloadInvoice(String path,List<Object> data) throws JRException, IOException;
}