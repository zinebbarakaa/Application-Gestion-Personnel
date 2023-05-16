package sr;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import login.Connexion;
import login.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import tables.Admis;
public class AfficherAdmis extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nom,prenom,CIN,date,tel,email,situationF,nomValue,prenomValue,CINValue,dateValue,
	telValue,emailValue,situationFValue,adresse,adresseValue;
	JButton sup,mod,suiv;
	static Admis admis=Interface_sr.admis;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public AfficherAdmis()
	{
		setTitle("Agent");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel nom_prenom=new JLabel("<html><U>"+admis.getNomAdmis()+" "+admis.getPrenomAdmis()+"</U></html>",new ImageIcon("images/"+admis.getPhotoAdmis()),JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		nom=new JLabel("Nom  :");
		nom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nom.setForeground(new Color(18,118,189));
		pane2.add(nom);
		
		nomValue=new JLabel(admis.getNomAdmis());
		nomValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomValue);
		
		prenom=new JLabel("Prénom  : ");
		prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		prenom.setForeground(new Color(18,118,189));
		pane2.add(prenom);
		
		prenomValue=new JLabel(admis.getPrenomAdmis());
		prenomValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(prenomValue);
		
		CIN=new JLabel("CIN  :");
		CIN.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		CIN.setForeground(new Color(18,118,189));
		pane2.add(CIN);
		
		CINValue=new JLabel(admis.getCINAdmis());
		CINValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(CINValue);
		
		date=new JLabel("Date Naissance  :");
		date.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		date.setForeground(new Color(18,118,189));
		pane2.add(date);
		
		dateValue=new JLabel(String.format("%1$tY-%1$tm-%1$td",admis.getNaissAdmis()));// convertir date en string
		dateValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateValue);
		
		tel=new JLabel("Telephone  : ");
		tel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		tel.setForeground(new Color(18,118,189));
		pane2.add(tel);
		
		telValue=new JLabel(admis.getTelAdmis());
		telValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(telValue);
		
		email=new JLabel("Email  : ");
		email.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		email.setForeground(new Color(18,118,189));
		pane2.add(email);
		
		emailValue=new JLabel(admis.getEmailAdmis());
		emailValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(emailValue);
		

		adresse=new JLabel("Adresse : ");
		adresse.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		adresse.setForeground(new Color(18,118,189));
		pane2.add(adresse);
		
		adresseValue=new JLabel(admis.getAdresseAdmis());
		adresseValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(adresseValue);
		
		situationF=new JLabel("Situation Familiale  : ");
		situationF.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		situationF.setForeground(new Color(18,118,189));
		pane2.add(situationF);
		
		situationFValue=new JLabel(admis.getSituationFAdmis());
		situationFValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(situationFValue);
		
		
		//pane2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		JPanel pane3=new JPanel(new GridLayout(1,3,30,30));
		mod=new JButton("Modifier",new ImageIcon("mod.png"));
		mod.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		mod.setBorder(new CompoundBorder(border, margin));
		mod.addActionListener(this);
		pane3.add(mod);
		
		sup=new JButton("Supprimer");
		sup.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		sup.setBorder(new CompoundBorder(border, margin));
		sup.addActionListener(this);
		pane3.add(sup);
		
		

		pane1.setBackground(new Color(245,245,245));
		pane2.setBackground(new Color(245,245,245));
		pane3.setBackground(new Color(245,245,245));
		c.setBackground(new Color(245,245,245));
		

		((JComponent) c).setBorder(new CompoundBorder(border, margin));
		
		c.add(pane1,BorderLayout.NORTH);
		c.add(pane2,BorderLayout.CENTER);
		c.add(pane3,BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		
		//c.setBackground(new Color(204,229,255));
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==mod)
		{
			setVisible(false);
			new ModifierAdmis();
		}
		else if(arg0.getSource()==sup)
		{	
			conn=Connexion.getConnection();
			

					int valide=JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer l'admis "+ admis.getNomAdmis() +" "+admis.getPrenomAdmis());
					if(valide==0)
					{
						try {
							
							String req="DELETE FROM admis WHERE Id_ADMIS='"+admis.getIdAdmis()+"'";
							st=conn.createStatement();
							st.executeUpdate(req);
							JOptionPane.showMessageDialog(null, "L'admis "+admis.getNomAdmis()+" "+admis.getPrenomAdmis()+" est bien supprimer");
							new Interface_sr();
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					
			 
			}
		
		}

	


	public static void main(String[] args) {
		
				new AfficherAdmis();
	

	}

	
	
}
