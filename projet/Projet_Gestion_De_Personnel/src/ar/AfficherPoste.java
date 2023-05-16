package ar;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import tables.*;

import tables.Agent;
public class AfficherPoste extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nomPoste,prenom,CIN,date,tel,email,situationF,nomPosteValue,prenomValue,CINValue,dateValue,
	telValue,emailValue,situationFValue,adresse,adresseValue;
	JButton sup,mod,suiv;
	UA ua=InterfacePoste.ua;
	Poste poste=InterfacePoste.post;
	Agent agent=InterfaceAgent.agent;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public AfficherPoste()
	{
		setTitle("Poste");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel nom_prenom=new JLabel("<html><U>"+poste.getNomPoste()+" de l'unité d'affectation "+
				ua.getNomAU()+"</U></html>",new ImageIcon("images/Poste.png"),JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		nomPoste=new JLabel("Nom Poste :");
		nomPoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomPoste.setForeground(new Color(18,118,189));
		pane2.add(nomPoste);
		
		nomPosteValue=new JLabel(agent.getNomAgent());
		nomPosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomPosteValue);
		
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
			new ModifierAgent();
		}
		else if(arg0.getSource()==sup)
		{	

					int valide=JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le poste "+poste.getNomPoste()+" de l'unité d'affectation "+
					ua.getNomAU());
					if(valide==0)
					{
						try {
							
							String req="DELETE FROM Poste WHERE Id_POSTE='"+poste.getIdPoste()+"'";
							st=conn.createStatement();
							st.executeUpdate(req);
							JOptionPane.showMessageDialog(null, "Le poste "+poste.getNomPoste()+" de l'unité d'affectation "+
									ua.getNomAU()+" est bien supprimer");
							new InterfaceAgent();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
			 
			}
		
		}
		
		
		
	


	public static void main(String[] args) {
		new AfficherPoste();

	}

	
	
}
