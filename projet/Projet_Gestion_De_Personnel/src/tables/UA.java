package tables;

public class UA {

	private int idUA;
	private AR ar;
	private String nomAU;
	private Agent respAgent;
	private String loginUA;
	private String passwdUA;
	public UA(int idUA, AR ar, String nomAU, Agent respAgent, String loginUA, String passwdUA) {
		super();
		this.idUA = idUA;
		this.ar = ar;
		this.nomAU = nomAU;
		this.respAgent = respAgent;
		this.loginUA = loginUA;
		this.passwdUA = passwdUA;
	}
	public int getIdUA() {
		return idUA;
	}
	public void setIdUA(int idUA) {
		this.idUA = idUA;
	}
	public AR getAr() {
		return ar;
	}
	public void setAr(AR ar) {
		this.ar = ar;
	}
	public String getNomAU() {
		return nomAU;
	}
	public void setNomAU(String nomAU) {
		this.nomAU = nomAU;
	}
	public Agent getRespAgent() {
		return respAgent;
	}
	public void setRespAgent(Agent respAgent) {
		this.respAgent = respAgent;
	}
	public String getLoginUA() {
		return loginUA;
	}
	public void setLoginUA(String loginUA) {
		this.loginUA = loginUA;
	}
	public String getPasswdUA() {
		return passwdUA;
	}
	public void setPasswdUA(String passwdUA) {
		this.passwdUA = passwdUA;
	}
	
}
