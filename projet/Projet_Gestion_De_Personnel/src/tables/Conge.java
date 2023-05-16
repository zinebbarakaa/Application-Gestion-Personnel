package tables;

import java.util.Date;

public class Conge {
	private  int idConge;
	private Agent agent;
	private String typeConge;
	private Date dateDebut;
	private Date dateFin;
	public Conge(int idConge, Agent agent, String typeConge, Date dateDebut, Date dateFin) {
		super();
		this.idConge = idConge;
		this.agent = agent;
		this.typeConge = typeConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public int getIdConge() {
		return idConge;
	}
	public void setIdConge(int idConge) {
		this.idConge = idConge;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public String getTypeConge() {
		return typeConge;
	}
	public void setTypeConge(String typeConge) {
		this.typeConge = typeConge;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	

}
