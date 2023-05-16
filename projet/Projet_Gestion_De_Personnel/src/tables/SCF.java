package tables;

public class SCF {
	private int idSCF;
	private DCP dcp;
	private String loginSCF;
	private String passwdSCF;
	public SCF(int idSCF, DCP dcp, String loginSCF, String passwdSCF) {
		super();
		this.idSCF = idSCF;
		this.dcp = dcp;
		this.loginSCF = loginSCF;
		this.passwdSCF = passwdSCF;
	}
	public int getIdSCF() {
		return idSCF;
	}
	public void setIdSCF(int idSCF) {
		this.idSCF = idSCF;
	}
	public DCP getDcp() {
		return dcp;
	}
	public void setDcp(DCP dcp) {
		this.dcp = dcp;
	}
	public String getLoginSCF() {
		return loginSCF;
	}
	public void setLoginSCF(String loginSCF) {
		this.loginSCF = loginSCF;
	}
	public String getPasswdSCF() {
		return passwdSCF;
	}
	public void setPasswdSCF(String passwdSCF) {
		this.passwdSCF = passwdSCF;
	}
	
}
