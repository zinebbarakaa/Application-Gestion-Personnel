package tables;

import java.util.*;;

public class Diplome {
private int idDiplome;
private Agent agent;
private String nomDiplome;
private Date dateObtention;
private String specialite;
private String etablissement;
private String mention;
public Diplome(int idDiplome, Agent agent, String nomDiplome, Date dateOpt, String specialite,
		String etablissement, String mention) {
	super();
	this.idDiplome = idDiplome;
	this.agent = agent;
	this.nomDiplome = nomDiplome;
	this.dateObtention = dateOpt;
	this.specialite = specialite;
	this.etablissement = etablissement;
	this.mention = mention;
}
public int getIdDiplome() {
	return idDiplome;
}
public void setIdDiplome(int idDiplome) {
	this.idDiplome = idDiplome;
}
public Agent getAgent() {
	return agent;
}
public void setAgent(Agent agent) {
	this.agent = agent;
}
public String getNomDiplome() {
	return nomDiplome;
}
public void setNomDiplome(String nomDiplome) {
	this.nomDiplome = nomDiplome;
}
public Date getDateObtention() {
	return dateObtention;
}
public void setDateObtention(Date dateObtention) {
	this.dateObtention = dateObtention;
}
public String getSpecialite() {
	return specialite;
}
public void setSpecialite(String specialite) {
	this.specialite = specialite;
}
public String getEtablissement() {
	return etablissement;
}
public void setEtablissement(String etablissement) {
	this.etablissement = etablissement;
}
public String getMention() {
	return mention;
}
public void setMention(String mention) {
	this.mention = mention;
}


}
