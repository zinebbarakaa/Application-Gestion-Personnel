package dcp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import login.Connexion;

public class DashBord {

	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	
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
	public static int nombreAR() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM AR";
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
	public static int nombrePosteVide() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM Poste WHERE Status_POSTE=FALSE";
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
	public static int nombrePoste() {
		int nbr=0;
		
		try {
			conn=Connexion.getConnection();
			String sql="SELECT COUNT(*) FROM Poste ";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				nbr=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nbr;
	}
}
