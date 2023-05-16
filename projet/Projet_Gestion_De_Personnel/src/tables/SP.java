package tables;

public class SP {
	private int idSP;
	private AR ar;
	private Employe[] employes;
	
	public int getIdSP() {
		return idSP;
	}

	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}

	public AR getAr() {
		return ar;
	}

	public void setAr(AR ar) {
		this.ar = ar;
	}

	public Employe[] getEmployes() {
		return employes;
	}

	public void setEmployes(Employe[] employes) {
		this.employes = employes;
	}

	public SP(int idSP, AR ar) {
		this.idSP = idSP;
		this.ar = ar;
		this.employes = new Employe[5];
	}

}
