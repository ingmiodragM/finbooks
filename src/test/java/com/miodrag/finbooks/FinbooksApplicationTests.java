package com.miodrag.finbooks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.miodrag.finbooks.entities.Dnevnik;
import com.miodrag.finbooks.repos.DnevnikRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;

@SpringBootTest
class FinbooksApplicationTests {

	@Autowired
	private DnevnikRepository repo;
	
	
	@Test
	void testcreateDnevnik() {
		
//	DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	//	String str_date = "12-05-2022";
	//	Date datum =new Date("12-05-2022");

		
		Dnevnik dnevnik =new Dnevnik();
		dnevnik.setBr_naloga(3);
		dnevnik.setDatum(new Date (2022-10-05));
		dnevnik.setDatum_valute(new Date (2022-10-05));
		dnevnik.setDuguje(123);
		dnevnik.setKonto("0231");
		dnevnik.setKonto_dug("0231");
		dnevnik.setkonto_pot("0231");
		dnevnik.setOpis("o");
		dnevnik.setPotrazuje(123);
		dnevnik.setRBr(3);
		dnevnik.setSadrzaj("sadryaj");
		repo.save(dnevnik);
		System.out.println(dnevnik);
		
	}

}
