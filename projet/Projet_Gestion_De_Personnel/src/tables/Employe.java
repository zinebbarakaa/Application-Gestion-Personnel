package tables;

public class Employe {
	private int idEmp;
	private SP sp;
	private String nomEmp;
	private String prenomEmp;
	private String loginEmp;
	private String passwdEmp;
	public Employe(int idEmp, SP sp, String nomEmp, String prenomEmp, String loginEmp, String passwdEmp) {
		this.idEmp = idEmp;
		this.sp = sp;
		this.setNomEmp(nomEmp);
		this.prenomEmp = prenomEmp;
		this.loginEmp = loginEmp;
		this.passwdEmp = passwdEmp;
	}
	public SP getSp() {
		return sp;
	}
	public void setSp(SP sp) {
		this.sp = sp;
	}
	public String getPrenomEmp() {
		return prenomEmp;
	}
	public void setPrenomEmp(String prenomEmp) {
		this.prenomEmp = prenomEmp;
	}
	public String getPasswdEmp() {
		return passwdEmp;
	}
	public void setPasswdEmp(String passwdEmp) {
		this.passwdEmp = passwdEmp;
	}
	public int getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	public String getLoginEmp() {
		return loginEmp;
	}
	public void setLoginEmp(String loginEmp) {
		this.loginEmp = loginEmp;
	}
	/**
	 * @return the nomEmp
	 */
	public String getNomEmp() {
		return nomEmp;
	}
	/**
	 * @param nomEmp the nomEmp to set
	 */
	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}
	
	


}
