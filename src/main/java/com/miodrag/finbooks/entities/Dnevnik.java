package com.miodrag.finbooks.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Dnevnik")
public class Dnevnik {

	@Id
	@Column(name = "RBr")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RBr;

	@Column(name = "konto_dug")
	private String konto_dug;

	@Column(name = "konto_pot")
	private String konto_pot;

	@Column(name = "opis")
	private String opis;

	@Column(name = "sadrzaj")
	private String sadrzaj;

	@Column(name = "konto")
	private String konto;

	@Column(name = "datum")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date datum;

	@Column(name = "datum_valute")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date datum_valute;

	@Column(name = "br_naloga")
	private int br_naloga;

	@Column(name = "duguje")
	private double Duguje;

	@Column(name = "potrazuje")
	private double potrazuje;

	public int getRBr() {
		return RBr;
	}

	public void setRBr(int rBr) {
		RBr = rBr;
	}

	public String getKonto_dug() {
		return konto_dug;
	}

	public void setKonto_dug(String konto_dug) {
		this.konto_dug = konto_dug;
	}

	public String getkonto_pot() {
		return konto_pot;
	}

	public void setkonto_pot(String konto_pot) {
		this.konto_pot = konto_pot;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public String getKonto() {
		return konto;
	}

	public void setKonto(String konto) {
		this.konto = konto;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getDatum_valute() {
		return datum_valute;
	}

	public void setDatum_valute(Date datum_valute) {
		this.datum_valute = datum_valute;
	}

	public int getBr_naloga() {
		return br_naloga;
	}

	public void setBr_naloga(int br_naloga) {
		this.br_naloga = br_naloga;
	}

	public double getDuguje() {
		return Duguje;
	}

	public void setDuguje(double duguje) {
		Duguje = duguje;
	}

	public double getPotrazuje() {
		return potrazuje;
	}

	public void setPotrazuje(double potrazuje) {
		this.potrazuje = potrazuje;
	}

	@Override
	public String toString() {
		return "Dnevnik [RBr=" + RBr + ", konto_dug=" + konto_dug + ", onto_pot=" + konto_pot + ", opis=" + opis
				+ ", sadrzaj=" + sadrzaj + ", konto=" + konto + ", datum=" + datum + ", datum_valute=" + datum_valute
				+ ", br_naloga=" + br_naloga + ", Duguje=" + Duguje + ", potrazuje=" + potrazuje + "]";
	}

}
