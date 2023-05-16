package tables;

import java.sql.Date;

import java.util.ArrayList;

public class Carierre {
	private Agent agent;
	private ArrayList<Poste> postes;
	private Date dateOccupation;
	
	public Carierre(Agent agent, Date dateOccupation) {
		this.agent = agent;
		this.postes=new ArrayList<>();
		this.dateOccupation = dateOccupation;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public ArrayList<Poste> getPostes() {
		return postes;
	}

	public void setPostes(ArrayList<Poste> postes) {
		this.postes = postes;
	}

	public Date getDateOccupation() {
		return dateOccupation;
	}

	public void setDateOccupation(Date dateOccupation) {
		this.dateOccupation = dateOccupation;
	}
	

}
