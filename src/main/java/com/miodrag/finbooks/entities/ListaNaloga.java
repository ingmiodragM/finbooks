package com.miodrag.finbooks.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ListaNaloga")
public class ListaNaloga {
	

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
	private String datum;

	@Column(name = "datum_valute")
	private String datum_valute;

	@Column(name = "br_naloga")
	private String br_naloga;

	@Column(name = "duguje")
	private String Duguje;

	@Column(name = "potrazuje")
	private String potrazuje;

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

	public String getKonto_pot() {
		return konto_pot;
	}

	public void setKonto_pot(String konto_pot) {
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

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getDatum_valute() {
		return datum_valute;
	}

	public void setDatum_valute(String datum_valute) {
		this.datum_valute = datum_valute;
	}

	public String getBr_naloga() {
		return br_naloga;
	}

	public void setBr_naloga(String br_naloga) {
		this.br_naloga = br_naloga;
	}

	public String getDuguje() {
		return Duguje;
	}

	public void setDuguje(String duguje) {
		Duguje = duguje;
	}

	public String getPotrazuje() {
		return potrazuje;
	}

	public void setPotrazuje(String potrazuje) {
		this.potrazuje = potrazuje;
	}

	@Override
	public String toString() {
		return "ListaNaloga [RBr=" + RBr + ", konto_dug=" + konto_dug + ", konto_pot=" + konto_pot + ", opis=" + opis
				+ ", sadrzaj=" + sadrzaj + ", konto=" + konto + ", datum=" + datum + ", datum_valute=" + datum_valute
				+ ", br_naloga=" + br_naloga + ", Duguje=" + Duguje + ", potrazuje=" + potrazuje + "]";
	}

}
