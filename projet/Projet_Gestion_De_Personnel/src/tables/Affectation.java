package tables;

import java.sql.Date;

public class Affectation {
private Agent agent;
private UA ua;
private Date dateAffectation;
public Affectation( Agent agent, UA ua, Date dateAffectation) {
	this.agent = agent;
	this.ua=ua;
	this.dateAffectation = dateAffectation;
}

public Agent getAgent() {
	return agent;
}
public void setAgent(Agent agent) {
	this.agent = agent;
}
public UA getUa() {
	return ua;
}
public void setUa(UA ua) {
	this.ua = ua;
}
public Date getDateAffectation() {
	return dateAffectation;
}
public void setDateAffectation(Date dateAffectation) {
	this.dateAffectation = dateAffectation;
}


}
