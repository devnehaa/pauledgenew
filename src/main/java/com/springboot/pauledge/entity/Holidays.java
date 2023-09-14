package com.springboot.pauledge.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="holidays")
public class Holidays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SNo;
	private String Festival;
	private Date Date;
	private String Day;
	private String Telangana;
	private String Kerala;
	private String MP;
	private String Gujarat;
	private String Maharashtra;
	private String Chandigarh;
	private String Punjab;
	private String Haryana;
	private String HP;
	private String Delhi;
	private String UP;
	private String Rajasthan;
	
	
	public Holidays() {
		super();
	}

	public Holidays(int sNo, String festival, Date date, String day, String telangana, String kerala, String mP,
			String gujarat, String maharashtra, String chandigarh, String punjab, String haryana, String hP,
			String delhi, String uP, String rajasthan) {
		super();
		SNo = sNo;
		Festival = festival;
		Date = date;
		Day = day;
		Telangana = telangana;
		Kerala = kerala;
		MP = mP;
		Gujarat = gujarat;
		Maharashtra = maharashtra;
		Chandigarh = chandigarh;
		Punjab = punjab;
		Haryana = haryana;
		HP = hP;
		Delhi = delhi;
		UP = uP;
		Rajasthan = rajasthan;
	}
	
	public int getSNo() {
		return SNo;
	}
	public void setSNo(int sNo) {
		SNo = sNo;
	}
	public String getFestival() {
		return Festival;
	}
	public void setFestival(String festival) {
		Festival = festival;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getDay() {
		return Day;
	}
	public void setDay(String day) {
		Day = day;
	}
	public String getTelangana() {
		return Telangana;
	}
	public void setTelangana(String telangana) {
		Telangana = telangana;
	}
	public String getKerala() {
		return Kerala;
	}
	public void setKerala(String kerala) {
		Kerala = kerala;
	}
	public String getMP() {
		return MP;
	}
	public void setMP(String mP) {
		MP = mP;
	}
	public String getGujarat() {
		return Gujarat;
	}
	public void setGujarat(String gujarat) {
		Gujarat = gujarat;
	}
	public String getMaharashtra() {
		return Maharashtra;
	}
	public void setMaharashtra(String maharashtra) {
		Maharashtra = maharashtra;
	}
	public String getChandigarh() {
		return Chandigarh;
	}
	public void setChandigarh(String chandigarh) {
		Chandigarh = chandigarh;
	}
	public String getPunjab() {
		return Punjab;
	}
	public void setPunjab(String punjab) {
		Punjab = punjab;
	}
	public String getHaryana() {
		return Haryana;
	}
	public void setHaryana(String haryana) {
		Haryana = haryana;
	}
	public String getHP() {
		return HP;
	}
	public void setHP(String hP) {
		HP = hP;
	}
	public String getDelhi() {
		return Delhi;
	}
	public void setDelhi(String delhi) {
		Delhi = delhi;
	}
	public String getUP() {
		return UP;
	}
	public void setUP(String uP) {
		UP = uP;
	}
	public String getRajasthan() {
		return Rajasthan;
	}
	public void setRajasthan(String rajasthan) {
		Rajasthan = rajasthan;
	}
	
}
