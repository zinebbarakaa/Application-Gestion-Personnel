package tables;

import java.util.Date;

public class Admis {
	private int idAdmis;
	private String nomAdmis;
	private  String prenomAdmis;
	private  Date naissAdmis;
	private  String telAdmis;
	private  String emailAdmis;
	private  String situationFAdmis;
	private String adresseAdmis;
	private String photoAdmis;
	private String CINAdmis;
	public Admis(int idAdmis, String nomAdmis, String prenomAdmis, Date date, String telAdmis, String emailAdmis,
			String situationFAdmis, String adresseAdmis, String photoAdmis,String CINAdmis) {
		this.idAdmis = idAdmis;
		this.nomAdmis = nomAdmis;
		this.prenomAdmis = prenomAdmis;
		this.naissAdmis = date;
		this.telAdmis = telAdmis;
		this.emailAdmis = emailAdmis;
		this.situationFAdmis = situationFAdmis;
		this.adresseAdmis = adresseAdmis;
		this.photoAdmis = photoAdmis;
		this.setCINAdmis(CINAdmis);
	}
	public Admis(int id, String nom, String prenom, String email, String cin) {
		this.idAdmis = id;
		this.nomAdmis = nom;
		this.prenomAdmis = prenom;
		this.emailAdmis = email;
		this.setCINAdmis(cin);

	}
	public int getIdAdmis() {
		return idAdmis;
	}
	public void setIdAdmis(int idAdmis) {
		this.idAdmis = idAdmis;
	}
	public String getNomAdmis() {
		return nomAdmis;
	}
	public void setNomAdmis(String nomAdmis) {
		this.nomAdmis = nomAdmis;
	}
	public String getPrenomAdmis() {
		return prenomAdmis;
	}
	public void setPrenomAdmis(String prenomAdmis) {
		this.prenomAdmis = prenomAdmis;
	}
	public Date getNaissAdmis() {
		return naissAdmis;
	}
	public void setNaissAdmis(Date naissAdmis) {
		this.naissAdmis = naissAdmis;
	}
	public String getTelAdmis() {
		return telAdmis;
	}
	public void setTelAdmis(String telAdmis) {
		this.telAdmis = telAdmis;
	}
	public String getEmailAdmis() {
		return emailAdmis;
	}
	public void setEmailAdmis(String emailAdmis) {
		this.emailAdmis = emailAdmis;
	}
	public String getSituationFAdmis() {
		return situationFAdmis;
	}
	public void setSituationFAdmis(String situationFAdmis) {
		this.situationFAdmis = situationFAdmis;
	}
	public String getAdresseAdmis() {
		return adresseAdmis;
	}
	public void setAdresseAdmis(String adresseAdmis) {
		this.adresseAdmis = adresseAdmis;
	}
	public String getPhotoAdmis() {
		return photoAdmis;
	}
	public void setPhotoAdmis(String photoAdmis) {
		this.photoAdmis = photoAdmis;
	}
	public String getCINAdmis() {
		return CINAdmis;
	}
	public void setCINAdmis(String cINAdmis) {
		CINAdmis = cINAdmis;
	}
	
	
}
