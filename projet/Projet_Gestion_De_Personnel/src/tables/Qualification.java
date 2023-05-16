package tables;

import java.util.Date;

public class Qualification {
	private int idQualification;
	private Agent agent;
	private String description;
	private Date date_qualification;
	public Qualification(int idQualification, Agent agent, String description,Date date_qualification) {
		super();
		this.idQualification = idQualification;
		this.agent = agent;
		this.setDescription(description);
		this.setDate_qualification(date_qualification);
	}
	public int getIdQualification() {
		return idQualification;
	}
	public void setIdQualification(int idQualification) {
		this.idQualification = idQualification;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_qualification() {
		return date_qualification;
	}
	public void setDate_qualification(Date date_qualification) {
		this.date_qualification = date_qualification;
	}
	
	

}
