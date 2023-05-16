package tables;

import java.util.Date;

public class Grade {
private int idGrade;
private Agent agent;
private String nomGrade;
private Date dateGrade;
public Grade(int idGrade, Agent agent, String nomGrade, Date dategrade2) {
	super();
	this.idGrade = idGrade;
	this.agent = agent;
	this.nomGrade = nomGrade;
	this.dateGrade = dategrade2;
}
public int getIdGrade() {
	return idGrade;
}
public void setIdGrade(int idGrade) {
	this.idGrade = idGrade;
}
public Agent getAgent() {
	return agent;
}
public void setAgent(Agent agent) {
	this.agent = agent;
}
public String getNomGrade() {
	return nomGrade;
}
public void setNomGrade(String nomGrade) {
	this.nomGrade = nomGrade;
}
public Date getDateGrade() {
	return dateGrade;
}
public void setDateGrade(Date dateGrade) {
	this.dateGrade = dateGrade;
}

}
