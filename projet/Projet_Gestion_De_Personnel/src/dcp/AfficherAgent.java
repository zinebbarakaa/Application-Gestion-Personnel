package dcp;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import tables.Agent;
public class AfficherAgent extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nom,prenom,CIN,date,tel,email,situationF,nomValue,prenomValue,CINValue,dateValue,
	telValue,emailValue,situationFValue,adresse,adresseValue;
	JButton sup,mod,suiv;
	Agent agent=InterfaceAgent.agent;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	
	public AfficherAgent()
	{
		setTitle("Agent");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel nom_prenom=new JLabel("<html><U>"+agent.getNomAgent()+" "+agent.getPrenomAgent()+"</U></html>",new ImageIcon("images/"+agent.getPhotoAgent()),JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		nom=new JLabel("Nom  :");
		nom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nom.setForeground(new Color(18,118,189));
		pane2.add(nom);
		
		nomValue=new JLabel(agent.getNomAgent());
		nomValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomValue);
		
		prenom=new JLabel("Prénom  : ");
		prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		prenom.setForeground(new Color(18,118,189));
		pane2.add(prenom);
		
		prenomValue=new JLabel(agent.getPrenomAgent());
		prenomValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(prenomValue);
		
		CIN=new JLabel("CIN  :");
		CIN.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		CIN.setForeground(new Color(18,118,189));
		pane2.add(CIN);
		
		CINValue=new JLabel(agent.getCIN());
		CINValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(CINValue);
		
		date=new JLabel("Date Naissance  :");
		date.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		date.setForeground(new Color(18,118,189));
		pane2.add(date);
		
		dateValue=new JLabel(String.format("%1$tY-%1$tm-%1$td",agent.getNaissAgent()));// convertir date en string
		dateValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateValue);
		
		tel=new JLabel("Telephone  : ");
		tel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		tel.setForeground(new Color(18,118,189));
		pane2.add(tel);
		
		telValue=new JLabel(agent.getTelAgent());
		telValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(telValue);
		
		email=new JLabel("Email  : ");
		email.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		email.setForeground(new Color(18,118,189));
		pane2.add(email);
		
		emailValue=new JLabel(agent.getEmailAgent());
		emailValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(emailValue);
		

		adresse=new JLabel("Adresse : ");
		adresse.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		adresse.setForeground(new Color(18,118,189));
		pane2.add(adresse);
		
		adresseValue=new JLabel(agent.getAdresseAgent());
		adresseValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(adresseValue);
		
		situationF=new JLabel("Situation Familiale  : ");
		situationF.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		situationF.setForeground(new Color(18,118,189));
		pane2.add(situationF);
		
		situationFValue=new JLabel(agent.getSituationFAgent());
		situationFValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(situationFValue);
		
		
		//pane2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		JPanel pane3=new JPanel();
		
		
		suiv=new JButton("Suivant");
		suiv.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		suiv.setBorder(new CompoundBorder(border, margin));
		suiv.addActionListener(this);
		pane3.add(suiv,BorderLayout.SOUTH);
		
		
		
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
		 if(arg0.getSource()==suiv)
		{
			setVisible(false);
			new InfoAgent();
		}
		
		
	}


	public static void main(String[] args) {
		new AfficherAgent();

	}

	
	
}
