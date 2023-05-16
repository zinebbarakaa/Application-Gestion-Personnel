package ar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import login.Connexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import tables.Agent;
import tables.Conge;
public class InfoConge extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nom_prenom,type,dateDebut,dateFin,nom_prenom_value,typeValue,dateDebutValue,dateFinValue;
	JButton sup,mod;
	Conge conge=InterfaceConge.Conge;
	Agent agent= InterfaceConge.agent;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public InfoConge()
	{
		setTitle("Agent");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel nom_prenom=new JLabel("<html><U>"+agent.getNomAgent()+" "+agent.getPrenomAgent()+"</U></html>",new ImageIcon("images/"+agent.getPhotoAgent()),JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(2,2,40,40));
		nom_prenom=new JLabel("Admis  :");
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nom_prenom.setForeground(new Color(18,118,189));
		pane2.add(nom_prenom);
		
		nom_prenom_value=new JLabel(agent.getNomAgent()+" "+ agent.getPrenomAgent());
		nom_prenom_value.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nom_prenom_value);
		
		
		
		
		
		dateDebut=new JLabel("Date Debut  :");
		
		dateDebut.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateDebut.setForeground(new Color(18,118,189));
		pane2.add(dateDebut);
		
		DateFormat date = new SimpleDateFormat("yyyy-mm-dd");
		dateDebutValue=new JLabel(date.format(conge.getDateDebut()));// convertir date en string
		dateDebutValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateDebutValue);
		
		dateFin=new JLabel("Date Fin  :");
		dateFin.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateFin.setForeground(new Color(18,118,189));
		pane2.add(dateFin);
		
		dateFinValue=new JLabel(date.format(conge.getDateFin()));// convertir date en string
		dateFinValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateFinValue);
		
		
		

		type=new JLabel("Type Conge  : ");
		type.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		type.setForeground(new Color(18,118,189));
		pane2.add(type);
		
		typeValue=new JLabel(conge.getTypeConge());
		typeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(typeValue);
		
		
		
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
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==mod)
		{
			setVisible(false);
			new ModifierConge();
		}
		else if(arg0.getSource()==sup)
		{	

					int valide=JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer l'agent "+ agent.getNomAgent() +" "+agent.getPrenomAgent());
					if(valide==0)
					{
						try {
							conn = Connexion.getConnection();
							PreparedStatement pst =conn.prepareStatement("DELETE FROM CONGE WHERE Id_CONGE=?");
							pst.setInt(1, conge.getIdConge());
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Le Conge de  "+agent.getNomAgent()+" "+agent.getPrenomAgent()+" est bien supprime");
							setVisible(false);
							new InterfaceConge();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					}
		
		
	}


	public static void main(String[] args) {
		new InfoConge();

	}

	
	
}
