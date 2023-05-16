package ar;

import java.awt.BorderLayout;

import tables.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.toedter.calendar.JDateChooser;

import login.Connexion;

public class AjouterPosteAgent  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel nomPoste,CINagent,DateOccup,UA;
	JTextField nomPosteValue,CINagentValue;
	JDateChooser DateOccupValue;
	JButton valide;
	
	static Connection conn=null;
	static Statement st=null,st1=null,st2=null;
	static ResultSet rs=null;
	Poste poste=InterfacePoste.post;
	

	public AjouterPosteAgent()
	{
		setVisible(true);
		setSize(800,600);
		Container c=getContentPane();
		setLocationRelativeTo(null);
		JPanel paneG=new JPanel(new BorderLayout());
		JLabel titre= new JLabel("<HTML><U>Ajouter un nouveau Poste</U></HTML>",JLabel.CENTER);
		titre.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		titre.setBackground(new Color(245,245,245));
		paneG.add(titre,BorderLayout.NORTH);
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);

		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		nomPoste=new JLabel("Nom Poste :");
		nomPoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomPoste.setForeground(new Color(18,118,189));
		pane2.add(nomPoste);
		
		nomPosteValue=new JTextField();
		nomPosteValue.setText(poste.getNomPoste());
		nomPosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomPosteValue.setBorder(lineBorder );
		pane2.add(nomPosteValue);
		
		
		CINagent=new JLabel("CIN Agent:");
		CINagent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		CINagent.setForeground(new Color(18,118,189));
		pane2.add(CINagent);
		
		CINagentValue=new JTextField();
		CINagentValue.setText(InterfacePoste.CINagent);
		CINagentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		CINagentValue.setBorder(lineBorder );
		pane2.add(CINagentValue);
		
		DateOccup=new JLabel("Date d'occupation   :");
		DateOccup.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		DateOccup.setForeground(new Color(18,118,189));
		pane2.add(DateOccup);
		
		DateOccupValue=new JDateChooser();// convertir date en string
		DateOccupValue.setDateFormatString("YYYY-MM-dd");
		DateOccupValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		DateOccupValue.setBorder(lineBorder );
		pane2.add(DateOccupValue);
		
		
		
		
		Border border = pane2.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane2.setBorder(new CompoundBorder(border, margin));
		paneG.setBorder(new CompoundBorder(border, margin));
		nomPoste.setBorder(new CompoundBorder(border, margin));
		nomPosteValue.setBorder(new CompoundBorder(border, margin));
		CINagent.setBorder(new CompoundBorder(border, margin));
		CINagentValue.setBorder(new CompoundBorder(border, margin));
		DateOccup.setBorder(new CompoundBorder(border, margin));
		DateOccupValue.setBorder(new CompoundBorder(border, margin));
		
		
		
		paneG.add(pane2,BorderLayout.CENTER);
		valide=new JButton("Ajouter");
		valide.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		valide.setBorder(new CompoundBorder(border, margin));
		valide.setPreferredSize(new Dimension(100,50));
		valide.addActionListener(this);
		JPanel pane3=new JPanel();
		pane3.add(valide);
		paneG.add(pane3,BorderLayout.SOUTH);
		
		c.add(paneG);
	}
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new AjouterPosteAgent();

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==valide)
		{
			String nomv=nomPosteValue.getText(),
					CINv=CINagentValue.getText(),
					datev=((JTextField)DateOccupValue.getDateEditor().getUiComponent()).getText();
					
			if(nomv.equals("") || datev.equals("") || CINv.equals("")  )
			{
				
				JOptionPane.showMessageDialog(null, "SVP! Remplir tous les données");

				
			}
			
			else {
					
				
				try {
					conn=Connexion.getConnection();
					String req="SELECT agent.Id_AGENT FROM AFFECTATION,AGENT,UA WHERE \r\n"
							+ "							AFFECTATION.Id_AGENT=AGENT.Id_AGENT AND UA.Id_UA=AFFECTATION.Id_UA\r\n"
							+ "							AND CIN_AGENT='"+InterfacePoste.CINagent+"'\r\n"
							+ "							AND ua.Id_UA="+poste.getUa().getIdUA();
					st=conn.createStatement();
					rs=st.executeQuery(req);
					
					
					if(!rs.next())
					{
						String req0="SELECT Id_AGENT FROM AGENT WHERE CIN_AGENT='"+InterfacePoste.CINagent+"'";
						st=conn.createStatement();
						rs=st.executeQuery(req0);
						rs.next();
						String req1="INSERT INTO AFFECTATION VALUES ("+poste.getUa().getIdUA()+","+rs.getInt(1)+",'"+datev+"')";
						st=conn.createStatement();
						st.executeUpdate(req1);
						
						
						String req4="INSERT INTO CARIERRE VALUES ("+rs.getInt(1)+","+poste.getIdPoste()+",'"+datev+"')";
						st=conn.createStatement();
						st.executeUpdate(req4);
						if(!poste.getSatatusPoste())
						{
			
							String req5="UPDATE POSTE SET Status_POSTE=1 WHERE Id_POSTE="+poste.getIdPoste();
							st=conn.createStatement();
							st.executeUpdate(req5);
						}
					}
						
					else {
						
						String req0="SELECT Id_AGENT FROM AGENT WHERE CIN_AGENT='"+InterfacePoste.CINagent+"'";
						st=conn.createStatement();
						rs=st.executeQuery(req0);
						rs.next();
						int idagent=rs.getInt(1);
						
						String req1="SELECT Id_POSTE FROM carierre WHERE  carierre.Id_AGENT="+idagent
								+ "								AND Date_Occupation = (Select max(Date_Occupation) FROM carierre\r\n"
								+ "								 WHERE carierre.Id_AGENT="+idagent+")";
						st=conn.createStatement();
						rs=st.executeQuery(req1);
						rs.next();
						
						String req2="UPDATE POSTE SET Status_POSTE=0 WHERE Id_POSTE="+rs.getInt(1);
						st1=conn.createStatement();
						st1.executeUpdate(req2);
						
						String req3="INSERT INTO CARIERRE VALUES ("+idagent+","+poste.getIdPoste()+",'"+datev+"')";
						st=conn.createStatement();
						st.executeUpdate(req3);
						
						if(!poste.getSatatusPoste())
						{
			
							String req5="UPDATE POSTE SET Status_POSTE=1 WHERE Id_POSTE="+poste.getIdPoste();
							st=conn.createStatement();
							st.executeUpdate(req5);
						}
						setVisible(false);
					}
					
					
					new InterfacePoste();
		
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
					
		}
		
	}

}
