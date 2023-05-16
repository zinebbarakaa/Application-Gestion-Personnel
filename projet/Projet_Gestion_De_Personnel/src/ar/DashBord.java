package ar;

import java.sql.*;


import java.util.Date;

import login.Connexion;

public class DashBord {
	static Connection  conn=null;
	static Statement st=null;
	static ResultSet rs=null;

	public static int posteactuel(int idagent)
	{
		conn=Connexion.getConnection();
		
		try {
			String req="Select max(carierre.Date_Occupation) FROM carierre Where carierre.Id_AGENT="+idagent;
			st=conn.createStatement();
			rs=st.executeQuery(req);
			rs.next();
			Date datemax=rs.getDate(1);
		
			
		String req1="SELECT Id_POSTE FROM carierre,agent\r\n"
				+ "WHERE carierre.Id_AGENT=agent.Id_AGENT\r\n"
				+ "AND carierre.Date_Occupation='"+datemax+"'\r\n"
				+ "AND carierre.Id_AGENT="+idagent;
			
			st=conn.createStatement();
			rs=st.executeQuery(req1);
			rs.next();
			int idPoste=rs.getInt(1);
		
			
			return idPoste;
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	
	
}
	public static int nombreUA() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM UA";
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
	public static int nombreAdmis() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM Admis"
					+ " where ID_Admis NOT IN (select Id_Admis FROM decision)";
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
	
	public static int nombreDecision() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM Decision"
					+ " where Status_DECISION='0'";
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
	
	public static int nombreAgentConge() {
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
	


}
