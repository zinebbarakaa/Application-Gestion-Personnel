package tables;

import java.util.Date;

public class Dicision {
	private Poste poste;
	private Admis admis;
	private String avisFonction;
	private Date datePres;
	private String visa;
	public Dicision(Poste poste, Admis admis, String avisFonction, Date date_prev, String visa) {
		this.poste = poste;
		this.admis = admis;
		this.avisFonction = avisFonction;
		this.datePres = date_prev;
		this.visa = visa;
	}
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	public Admis getAdmis() {
		return admis;
	}
	public void setAdmis(Admis admis) {
		this.admis = admis;
	}
	public String getAvisFonction() {
		return avisFonction;
	}
	public void setAvisFonction(String avisFonction) {
		this.avisFonction = avisFonction;
	}
	public Date getDatePres() {
		return datePres;
	}
	public void setDatePres(Date datePres) {
		this.datePres = datePres;
	}
	public String getVisa() {
		return visa;
	}
	public void setVisa(String visa) {
		this.visa = visa;
	}
	
	
}
;