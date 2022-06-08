package com.miodrag.finbooks.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miodrag.finbooks.entities.Dnevnik;
import com.miodrag.finbooks.entities.ListaNaloga;
import com.miodrag.finbooks.repos.DnevnikRepository;
import com.miodrag.finbooks.repos.ListaNalogaRepository;
import com.miodrag.finbooks.service.DnevnikService;
import com.miodrag.finbooks.service.ListaNalogaService;
import com.miodrag.finbooks.util.ReportUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class DnevnikControollers {

	@Autowired
	DnevnikService service;
	
	@Autowired
	ListaNalogaService servicel;

	@Autowired
	DnevnikRepository repository;
	
	@Autowired
	ListaNalogaRepository repositoryl;

	@Autowired
	ServletContext sc;
	
	@Autowired
	ReportUtil reputil;

	
	@RequestMapping("/showNalog")
	public String showCreate() {
		return "createNalog";
	}

	@RequestMapping("/saveNalog")
	public	 String saveNalog(@ModelAttribute("Dnevnik") Dnevnik dnevnik, ModelMap modelMap) throws JRException /*String saveNalog(@ModelAttribute("ListaNaloga") ListaNaloga listaNaloga, ModelMap modelMap) */, IOException
	
	
	{
		 
		//ListaNaloga listaNalogaSaved = servicel.saveListaNaloga(listaNaloga);
		// String msg = "Nalog saved with id: " + listaNalogaSaved.getBr_naloga();
		
		
		 Dnevnik dnevnikSaved = service.saveDnevnik(dnevnik);
		 
		 List<Object> data = new ArrayList<Object>();
		 data.add(dnevnik);
	 
		 
	//	 reputil.generateReportN("src/main/resources/reports/t2.jrxml", data);     
	//	 reputil.downloadInvoice("src/main/resources/reports/t2.jrxml", data);
		 
		 
		//String msg2 = "Parametar id: " + dnevnik.getBr_naloga();
		// String msg = "Nalog saved with id: " + listaNalogaSaved.getBr_naloga();
		// modelMap.addAttribute("msg", msg);
		// emailUtil.sendEmail("springxyzabc@gmail.com", "Location Saved",
		// "Location Saved Successfully and about to return a response");
		return "createNalog";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("RBr") int rBr, ModelMap modelMap) {
		Dnevnik dnevnik = service.getDnevnikById(rBr);
		
		
		modelMap.addAttribute("dnevnik", dnevnik);
		return "updateDnevnik";
	}

	@RequestMapping("/updateDnevnik")
	public String updateDnevnik(@ModelAttribute("dnevnik") Dnevnik dnevnik, ModelMap modelMap) {
		service.updateDnevnik(dnevnik);
		List<Dnevnik> dnevniks = service.getAllDnevniks();
		modelMap.addAttribute("dnevniks", dnevniks);
		return "displayDnevniks";
	}

	@RequestMapping("/displayDnevniks")
	public String displayDnevniks(ModelMap modelMap) {
		List<Dnevnik> dnevniks = service.getAllDnevniks();
		modelMap.addAttribute("dnevniks", dnevniks);
		return "displayDnevniks";
	}
	
	
	@RequestMapping("deleteDnevnik")
	public String deleteDnevnik(@RequestParam("RBr") int rBr, ModelMap modelMap) {
		// Location location = service.getDnevnikById(rBr);
		Dnevnik dnevnik= new Dnevnik();
		dnevnik.setRBr(rBr);
		service.deleteDnevnik(dnevnik);
		List<Dnevnik> dnevniks = service.getAllDnevniks();
		modelMap.addAttribute("dnevniks", dnevniks);
		return "displayDnevniks";	
	}
	
	
	
	@RequestMapping("/displayDnevniksforPrint")
	public String displayDnevniksforPrint(ModelMap modelMap) {
		List<Dnevnik> dnevniks = service.findDnevniksbyBrNaloga(15);
		modelMap.addAttribute("dnevniks", dnevniks);
		return "displayDnevniksforPrint";
	}
	
	
	@RequestMapping(value="/print", produces = MediaType.APPLICATION_PDF_VALUE)
	public	 ResponseEntity<byte[]> saveNalog2(@RequestParam("br_naloga") int brn, ModelMap modelMap) throws JRException , IOException
	
	
	{
	//	List<Dnevnik> dnevniks = service.findDnevniksbyBrNaloga(15);
	//	System.out.println(brn);
		List<Dnevnik> dnevniks = service.findDnevniksbyBrNaloga(brn);
		 List<Object> data = new ArrayList<Object>();
		 for (final Dnevnik dnevnik: dnevniks) {
		 data.add(dnevnik);
		 }

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
	//			return  "createNalog";
		 }
	
	@RequestMapping("/formaprint")
	public String show()
	{


		return "createNalogforprint";
	}

	}	
	
	

	
	/*
	 * @InitBinder public void initBinder(WebDataBinder webDataBinder) {
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 * dateFormat.setLenient(false); webDataBinder.registerCustomEditor(Date.class,
	 * new CustomDateEditor(dateFormat, true)); }
	 */

