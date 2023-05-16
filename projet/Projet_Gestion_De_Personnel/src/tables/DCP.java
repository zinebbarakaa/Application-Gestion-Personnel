package tables;

public class DCP {
	private int idDCP;
	private String nomDCP;
	private String login;
	private String passwd;
	public DCP(int idDCP, String nomDCP, String login, String passwd) {
		super();
		this.idDCP = idDCP;
		this.nomDCP = nomDCP;
		this.login = login;
		this.passwd = passwd;
	}
	public int getIdDCP() {
		return idDCP;
	}
	public void setIdDCP(int idDCP) {
		this.idDCP = idDCP;
	}
	public String getNomDCP() {
		return nomDCP;
	}
	public void setNomDCP(String nomDCP) {
		this.nomDCP = nomDCP;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	

}
