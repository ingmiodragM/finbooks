package com.miodrag.finbooks.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.http.HttpClient;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.miodrag.finbooks.repos.DnevnikRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


@Service
public class ReportUtilImpl implements ReportUtil {
	
	@Autowired
	private DnevnikRepository repo;
	
	private final String PATH = "C:\\Users\\Misa\\Desktop\\";

	@Override
	public void generateReportN(String path,List<Object> data)throws FileNotFoundException, JRException {
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(data);
		Map<String, Object> parameters = new HashMap<>();
		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("src/main/resources/reports/t2.jrxml"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
//JasperViewer.viewReport (jasperPrint);
		JasperExportManager.exportReportToPdfFile( jasperPrint, PATH+"Nalog.pdf");
		
		
		


	}

	@Override
	public ResponseEntity<byte[]> downloadInvoice(String path, List<Object> data) throws JRException, IOException {
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(data);
		Map<String, Object> parameters = new HashMap<>();
		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("src/main/resources/reports/t2.jrxml"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
		byte data1[] = JasperExportManager.exportReportToPdf(jasperPrint);
		System.err.println(data1);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; nalogreport.pdf");
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data1);
		
	}
	



}
