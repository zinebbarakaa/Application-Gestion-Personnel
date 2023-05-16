package tables;

public class SR {
private int idSR;
private DCP dcp;
private String loginSR;
private String passwdSR;
public SR(int idSR, DCP dcp, String loginSR, String passwdSR) {
	super();
	this.idSR = idSR;
	this.dcp = dcp;
	this.loginSR = loginSR;
	this.passwdSR = passwdSR;
}
public int getIdSR() {
	return idSR;
}
public void setIdSR(int idSR) {
	this.idSR = idSR;
}
public DCP getDcp() {
	return dcp;
}
public void setDcp(DCP dcp) {
	this.dcp = dcp;
}
public String getLoginSR() {
	return loginSR;
}
public void setLoginSR(String loginSR) {
	this.loginSR = loginSR;
}
public String getPasswdSR() {
	return passwdSR;
}
public void setPasswdSR(String passwdSR) {
	this.passwdSR = passwdSR;
}

}

