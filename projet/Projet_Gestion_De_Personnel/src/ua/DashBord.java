package ua;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import login.Connexion;

public class DashBord {

	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	
	public static String respUA() {
		String resp = null;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT `NOM_AGENT`,`PRENOM_AGENT` FROM `agent`, ua WHERE agent.`Id_AGENT`=ua.Id_Resp";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				resp=rs.getString(1)+" "+rs.getString(2);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}
	public static String AR() {
		String ar = null;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT `Nom_AR` FROM `ar`,ua WHERE ar.`Id_AR`=ua.`Id_AR`";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				ar=rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	public static int nombreAgents() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM AGENT";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				nbr=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbr;
	}
	public static int nombreAgentsConge() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="Select Count(*) from conge where Date_Fin >curdate(); ";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				nbr=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbr;
	}
	public static int nombrePosteVide() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM poste,ua WHERE Status_POSTE=FALSE AND poste.Id_UA=ua.Id_UA";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				nbr=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbr;
	}
	public static int nombrePosteUA() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM `poste`,ua WHERE poste.`Id_UA`=ua.`Id_UA` ";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				nbr=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbr;
	}
}
