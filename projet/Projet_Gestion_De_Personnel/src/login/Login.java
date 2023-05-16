package login;
import java.awt.BorderLayout;


import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.*;
import dcp.*;
import scf.Interface_scf;
import ar.*;
import sr.*;
import ua.*;

public class Login  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField JT;
	private static JPasswordField JP;
	private static JComboBox<String> JC;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	private static boolean connDCP=false;
	private static boolean connAR=false;
	private static boolean connUA=false;
	private static boolean connSCF=false;
	private static boolean connSR=false;
	static String login;
	public Login()
	{
		this.setSize(620,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel paneau=(JPanel) this.getContentPane();
		paneau.setLayout(new GridLayout(1,2,10,10));
		
		paneau.add(new JLabel(new ImageIcon("images/Hassan2.jpg")));
		
		JPanel pane2=new JPanel(new GridLayout(8,1,20,20));
		
		JLabel JL1=new JLabel("Login :");
		JL1.setIcon(new ImageIcon("images/user.png"));
		JT=new JTextField();
		JLabel JL2=new JLabel("Mot de Passe :");
		JL2.setIcon(new ImageIcon("images/lock.png"));
		JP=new JPasswordField();
		JLabel JL3=new JLabel("Type Compte :");
		JL3.setIcon(new ImageIcon("images/account.png"));
		JC=new JComboBox<String>(new String[]{"-Selécionner-","DCP","AR","UA","SR","SCF"});
		JButton JB=new JButton("Se Connecter ");
		
		JLabel JL4=new JLabel("<html>Bienvenue dans l'interface<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;de Connexion !</html>",JLabel.CENTER);
		JL4.setHorizontalAlignment(SwingConstants.CENTER);
		pane2.add(JL4,BorderLayout.NORTH);
		// les Fonts 
		JL4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
		JL1.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		JL2.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		JL3.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		JT.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		JP.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		JC.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		JB.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		JP.setEchoChar('.');
		JT.setBorder(javax.swing.BorderFactory.createEmptyBorder());// pour eliminer le bordure de JTextField
		JP.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		 // pour arrondir le bordure de JTextField
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		JT.setBorder(lineBorder );
		JP.setBorder(lineBorder );
		
		JB.addActionListener(this);
		paneau.setBackground(Color.white);
		pane2.setBackground(new Color(245,245,245));
		JB.setBackground(new Color(173,216,230));
		JC.setBackground(new Color(176,224,230));
		
		pane2.add(JL1);
		pane2.add(JT);
		pane2.add(JL3);
		pane2.add(JC);
		pane2.add(JL2);
		pane2.add(JP);
		pane2.add(JB);
		
		Border border = pane2.getBorder();
		Border margin = new EmptyBorder(30,30,20,20);
		pane2.setBorder(new CompoundBorder(border, margin));
				
		this.setBackground(Color.white);
		
		
		paneau.add(pane2);
		this.setVisible(true);
		//pack();
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
	}
	public static String getLogin() {
		return login;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		cennecterDB();
		
	}
	public void cennecterDB()
	{
		  login=JT.getText();
		char[] password=JP.getPassword();
		String typeCompte=(String) JC.getSelectedItem();
		String passe="";
		for(int i=0;i<password.length;i++)
		{
			passe=passe+password[i];
		}
		try {
			conn=Connexion.getConnection();
			st=conn.createStatement();
			String sql;
			if(typeCompte=="DCP")
			{
				sql="SELECT Login_DCP,Passwd_DCP FROM DCP";
				rs=st.executeQuery(sql);
				
				if(rs.next())
					{
						if(login.equals(rs.getString(1)) && passe.equals(rs.getString(2)))
						{
							this.dispose();
							connDCP=true;
							new Home_DCP();
						}
						
					}
			}
			else if(typeCompte=="AR")
				{sql="SELECT Login_Emp,Passwd_Emp FROM EMPLOYE";
				rs=st.executeQuery(sql);
				
				if(rs.next())
					{
						if(login.equals(rs.getString(1)) && passe.equals(rs.getString(2)))
						{
							this.dispose();
							connAR=true;
							new Home_AR();
						}
						
					}
			}
			else if(typeCompte=="UA")
			{
				sql="SELECT Login_UA,PasswdUA FROM UA WHERE Login_UA = '"+login+"';";
				rs=st.executeQuery(sql);
				if(rs.next())
					{
						if(login.equals(rs.getString(1)) && passe.equals(rs.getString(2)))
						{
							this.dispose();
							connUA=true;
							new Home_UA();
						}
						
					}
			}
			else if(typeCompte=="SCF")
			{
				sql="SELECT Login_SCF,Passwd_SCF FROM SCF";
				rs=st.executeQuery(sql);
				
				if(rs.next())
					{
						if(login.equals(rs.getString(1)) && passe.equals(rs.getString(2)))
						{
							this.dispose();
							connSCF=true;
							new Interface_scf();
						}
						
					}
			}
			else if(typeCompte=="SR"){
				sql="SELECT Login_SR,Passwd_SR FROM SR";
				rs=st.executeQuery(sql);
				if(rs.next())
					{
						if(login.equals(rs.getString(1)) && passe.equals(rs.getString(2)))
						{
							this.dispose();
							connSR=true;
							new Interface_sr();
						}
						
					}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static boolean getConnDCP()
	{
		return connDCP;
	}
	public static boolean getConnUA()
	{
		return connUA;
	}
	public static boolean getConnAR()
	{
		return connAR;
	}
	public static boolean getConnSCF()
	{
		return connSCF;
	}
	public static boolean getConnSR()
	{
		return connSR;
	}
	public static void setConnDCP()
	{
		connDCP=false;
	}
	public static void setConnUA()
	{
		connUA=false;
	}
	public static void setConnAR()
	{
		connAR=false;
	}
	public static void setConnSCF()
	{
		connSCF=false;
	}
	public static void setConnSR()
	{
		connSR=false;
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Login();
		

	}

	

}
