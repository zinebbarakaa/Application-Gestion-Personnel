package tables;

public class AR {
	private int idAR;
	private DCP dcp;
	private String nomAR;
	public AR(int idAR, DCP dcp, String nomAR) {
		super();
		this.idAR = idAR;
		this.dcp = dcp;
		this.nomAR = nomAR;
	}
	public int getIdAR() {
		return idAR;
	}
	public void setIdAR(int idAR) {
		this.idAR = idAR;
	}
	public DCP getDcp() {
		return dcp;
	}
	public void setDcp(DCP dcp) {
		this.dcp = dcp;
	}
	public String getNomAR() {
		return nomAR;
	}
	public void setNomAR(String nomAR) {
		this.nomAR = nomAR;
	}
	

}

