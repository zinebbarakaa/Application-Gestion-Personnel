package login;


import java.sql.*;
public class Connexion{
	private static Connection conn;
	static String login="root";
	static String passwd="";
	static {
		try { Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/G_Personnels";
		conn = DriverManager.getConnection(url,login,passwd);}
		catch(Exception e){ System.out.println("Erreur lors du chargement de Driver:"+e);
		}
	}
	public static Connection getConnection()
	{
		return conn;
	}
 }
