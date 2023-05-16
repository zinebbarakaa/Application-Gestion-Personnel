package ar;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.toedter.calendar.JDateChooser;

import login.Connexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class AjouterAgent extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nom,prenom,CIN,date,tel,email,situationF,adresse;

	JTextField CINValue,situationFValue,prenomValue,nomValue,telValue,emailValue,adresseValue;

	

	JDateChooser dateValue;

	
	
	JButton add;
	//Agent agent=InterfaceAgent.agent;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public AjouterAgent()
	{
		setTitle("Agent");
		setSize(1000,600);
		Container c=getContentPane();
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Ajouter nouveau agent</U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		nom=new JLabel("Nom  :");
		nom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nom.setForeground(new Color(18,118,189));
		pane2.add(nom);
		
		nomValue=new JTextField();
		nomValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomValue.setBorder(lineBorder );
		pane2.add(nomValue);
		
		prenom=new JLabel("Prénom  : ");
		prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		prenom.setForeground(new Color(18,118,189));
		pane2.add(prenom);
		
		prenomValue=new JTextField();
		prenomValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		prenomValue.setBorder(lineBorder );
		pane2.add(prenomValue);
		
		CIN=new JLabel("CIN  :");
		CIN.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		CIN.setForeground(new Color(18,118,189));
		pane2.add(CIN);
		
		CINValue=new JTextField();
		CINValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		CINValue.setBorder(lineBorder );
		pane2.add(CINValue);
		
		date=new JLabel("Date Naissance  :");
		date.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		date.setForeground(new Color(18,118,189));
		pane2.add(date);
		
		dateValue=new JDateChooser();// convertir date en string
		dateValue.setDateFormatString("YYYY-MM-dd");
		dateValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		dateValue.setBorder(lineBorder );
		pane2.add(dateValue);
		
		tel=new JLabel("Telephone  : ");
		tel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		tel.setForeground(new Color(18,118,189));
		pane2.add(tel);
		
		telValue=new JTextField();
		telValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		telValue.setBorder(lineBorder );
		pane2.add(telValue);
		
		email=new JLabel("Email  : ");
		email.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		email.setForeground(new Color(18,118,189));
		pane2.add(email);
		
		emailValue=new JTextField();
		emailValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		emailValue.setBorder(lineBorder );
		pane2.add(emailValue);
		

		adresse=new JLabel("Adresse : ");
		adresse.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		adresse.setForeground(new Color(18,118,189));
		pane2.add(adresse);
		
		adresseValue=new JTextField();
		adresseValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		adresseValue.setBorder(lineBorder );
		pane2.add(adresseValue);
		
		situationF=new JLabel("Situation Familiale  : ");
		situationF.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		situationF.setForeground(new Color(18,118,189));
		pane2.add(situationF);
		
		situationFValue=new JTextField();
		situationFValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		situationFValue.setBorder(lineBorder );
		pane2.add(situationFValue);
		
		
		
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		
		
		
		add=new JButton("Ajouter");
		add.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		add.setBorder(new CompoundBorder(border, margin));
		add.addActionListener(this);
		JPanel pane3=new JPanel();
		pane3.add(add);
		
		
		
		pane1.setBackground(new Color(245,245,245));
		pane2.setBackground(new Color(245,245,245));
		pane3.setBackground(new Color(245,245,245));
		c.setBackground(new Color(245,245,245));
		

		((JComponent) c).setBorder(new CompoundBorder(border, margin));
		
		c.add(pane1,BorderLayout.NORTH);
		c.add(pane2,BorderLayout.CENTER);
		c.add(pane3,BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==add)
		{
			String nomv=nomValue.getText(),
					prenomv=prenomValue.getText(),
					CINv=CINValue.getText(),
					emailv=emailValue.getText(),
					telv=telValue.getText(),
					adressev=adresseValue.getText(),
					situationv=situationFValue.getText(),
					datev=((JTextField)dateValue.getDateEditor().getUiComponent()).getText();
			//System.out.println(datev);
					
	if(nomv.equals("") || prenomv.equals("")|| CINv.equals("") || telv.equals("") || adressev.equals("") || situationv.equals("") || datev.equals(""))
		{
			
			JOptionPane.showMessageDialog(null, "SVP! Remplir tous les données");

			
		}
		
		else {
						
			try {
				conn=Connexion.getConnection();
				String req="INSERT INTO AGENT(Nom_AGENT,Prenom_AGENT,Naiss_AGENT,Tel_AGENT,"
						+ "Email_AGENT,Situation_F_AGENT,Adresse_AGENT,Photo_AGENT,CIN_AGENT "
						+ ") VALUES('"+nomv+"','"+prenomv+"','"+datev+"','"+telv+"','"+emailv+"','"+situationv+"','"
				+adressev+"','agent_photo.png','"+CINv+"')";
				
				st=conn.createStatement();
				int n=st.executeUpdate(req);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "L'agent est bien ajouté");
					new InterfaceAgent();
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
					
		
			
			
		}
		
		
	}


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new AjouterAgent();

	}

	
	
}
