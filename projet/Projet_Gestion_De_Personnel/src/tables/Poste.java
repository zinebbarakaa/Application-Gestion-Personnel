package tables;

public class Poste {
	private int idPoste;
	private String gradePoste;
	private String nomPoste;
	private double salaire;
	private boolean satatusPoste;
	private UA ua;
	public Poste(int idPoste,String nomPoste,String gradePoste, double salaire,boolean satatusPoste ,UA ua) {
		this.idPoste = idPoste;
		this.setNomPoste(nomPoste);
		this.gradePoste = gradePoste;
		this.salaire = salaire;
		this.setSatatusPoste(satatusPoste);
		this.setUa(ua);
				
	}
	public Poste(int idposte, String libPoste) {
	
		this.idPoste = idposte;
		this.setNomPoste(libPoste);
	}
	
	public int getIdPoste() {
		return idPoste;
	}
	public void setIdPoste(int idPoste) {
		this.idPoste = idPoste;
	}
	
	public String getGradePoste() {
		return gradePoste;
	}
	public void setGradePoste(String gradePoste) {
		this.gradePoste = gradePoste;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public boolean isSatatusPoste() {
		return satatusPoste;
	}
	public boolean getSatatusPoste() {
		return satatusPoste;
	}
	public void setSatatusPoste(boolean satatusPoste) {
		this.satatusPoste = satatusPoste;
	}
	public UA getUa() {
		return ua;
	}
	public void setUa(UA ua) {
		this.ua = ua;
	}
	public String getNomPoste() {
		return nomPoste;
	}
	public void setNomPoste(String nomPoste) {
		this.nomPoste = nomPoste;
	}
	

}
