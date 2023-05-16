package tables;

import java.util.ArrayList;
import java.util.Date;


public class Agent {
	
	private int idAgent;
	private  String nomAgent;
	private  String prenomAgent;
	private  Date naissAgent;
	private  String telAgent;
	private  String emailAgent;
	private  String situationFAgent;
	private String adresseAgent;
	private String photoAgent;
	private String CIN;
	private ArrayList<Conge> conges;
	private ArrayList<Diplome> diplomes;
	private ArrayList<Grade> grades;
	private ArrayList<Qualification> qualifications;
	private ArrayList<Carierre> carierre;

	

	
	public Agent(int idAgent, String nomAgent, String prenomAgent, Date naissAgent, String telAgent, String emailAgent,
			String situationFAgent, String adresseAgent, String photoAgent,String CIN) {
		super();
		this.idAgent = idAgent;
		this.nomAgent = nomAgent;
		this.prenomAgent = prenomAgent;
		this.naissAgent = naissAgent;
		this.telAgent = telAgent;
		this.emailAgent = emailAgent;
		this.situationFAgent = situationFAgent;
		this.adresseAgent = adresseAgent;
		this.photoAgent = photoAgent;
		this.CIN=CIN;
		this.conges=new ArrayList<Conge>();
		this.diplomes=new ArrayList<Diplome>();
		this.grades=new ArrayList<Grade>();
		this.qualifications=new ArrayList<Qualification>();
		this.carierre=new ArrayList<>();

		


		
		
	}
	public int getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}
	public String getNomAgent() {
		return nomAgent;
	}
	public void setNomAgent(String nomAgent) {
		this.nomAgent = nomAgent;
	}
	public String getPrenomAgent() {
		return prenomAgent;
	}
	public void setPrenomAgent(String prenomAgent) {
		this.prenomAgent = prenomAgent;
	}
	public Date getNaissAgent() {
		return naissAgent;
	}
	public void setNaissAgent(Date naissAgent) {
		this.naissAgent = naissAgent;
	}
	public String getTelAgent() {
		return telAgent;
	}
	public void setTelAgent(String telAgent) {
		this.telAgent = telAgent;
	}
	public String getEmailAgent() {
		return emailAgent;
	}
	public void setEmailAgent(String emailAgent) {
		this.emailAgent = emailAgent;
	}
	public String getSituationFAgent() {
		return situationFAgent;
	}
	public void setSituationFAgent(String situationFAgent) {
		this.situationFAgent = situationFAgent;
	}
	public String getAdresseAgent() {
		return adresseAgent;
	}
	public void setAdresseAgent(String adresseAgent) {
		this.adresseAgent = adresseAgent;
	}
	public String getPhotoAgent() {
		return photoAgent;
	}
	public void setPhotoAgent(String photoAgent) {
		this.photoAgent = photoAgent;
	}
	public ArrayList<Conge> getConges() {
		return conges;
	}
	public void setConges(ArrayList<Conge> conges) {
		this.conges = conges;
	}
	public ArrayList<Diplome> getDiplomes() {
		return diplomes;
	}
	public void setDiplomes(ArrayList<Diplome> diplomes) {
		this.diplomes = diplomes;
	}
	public ArrayList<Grade> getGrades() {
		return grades;
	}
	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}
	public ArrayList<Qualification> getQualifications() {
		return qualifications;
	}
	public void setQualifications(ArrayList<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	public ArrayList<Carierre> getCarierre() {
		return carierre;
	}
	public void setCarierre(ArrayList<Carierre> carierre) {
		this.carierre = carierre;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	

}
