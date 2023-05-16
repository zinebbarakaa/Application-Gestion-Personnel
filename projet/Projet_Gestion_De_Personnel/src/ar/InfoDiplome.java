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

import tables.*;
public class InfoDiplome extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nomagent,nomDiplome,specialite,dateOpt,etablissement,mention,nomagentValue,nomDiplomeValue,specialiteValue,dateOptValue,
	etablissementValue,mentionValue,situationFValue;
	JButton sup,mod;
	static Agent agent=InterfaceDiplome.agent;
	static Diplome diplome=InterfaceDiplome.diplome;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public InfoDiplome()
	{
		setTitle("Diplome");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel nom_prenom=new JLabel("<html><U>"+agent.getNomAgent()+" "+agent.getPrenomAgent()+"</U></html>",JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(3,4,40,40));
		nomagent=new JLabel("Agent :");
		nomagent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomagent.setForeground(new Color(18,118,189));
		pane2.add(nomagent);
		
		nomagentValue=new JLabel(agent.getNomAgent()+" "+agent.getPrenomAgent());
		nomagentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomagentValue);
		
		nomDiplome=new JLabel("Nom du diplome : ");
		nomDiplome.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomDiplome.setForeground(new Color(18,118,189));
		pane2.add(nomDiplome);
		
		nomDiplomeValue=new JLabel(diplome.getNomDiplome());
		nomDiplomeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomDiplomeValue);
		
		specialite=new JLabel("Spetialité du diplome :");
		specialite.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		specialite.setForeground(new Color(18,118,189));
		pane2.add(specialite);
		
		specialiteValue=new JLabel(diplome.getSpecialite());
		specialiteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(specialiteValue);
		
		dateOpt=new JLabel("Date d'Obtention  :");
		dateOpt.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateOpt.setForeground(new Color(18,118,189));
		pane2.add(dateOpt);
		
		dateOptValue=new JLabel(String.format("%1$tY-%1$tm-%1$td",diplome.getDateObtention()));// convertir date en string
		dateOptValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateOptValue);
		
		etablissement=new JLabel("Nom Etablissement  : ");
		etablissement.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		etablissement.setForeground(new Color(18,118,189));
		pane2.add(etablissement);
		
		etablissementValue=new JLabel(diplome.getEtablissement());
		etablissementValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(etablissementValue);
		
		mention=new JLabel("Mention  : ");
		mention.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		mention.setForeground(new Color(18,118,189));
		pane2.add(mention);
		
		mentionValue=new JLabel(diplome.getMention());
		mentionValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(mentionValue);
		

		
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		JPanel pane3=new JPanel(new GridLayout(1,2,30,30));
		mod=new JButton("Modifier");
		mod.setIcon(new ImageIcon("mod.png"));
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
			new ModifierDiplome();
		}
		else if(arg0.getSource()==sup)
		{	conn=Connexion.getConnection();
			try {
				
					int valide=JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce diplome de "+ agent.getNomAgent() +" "+agent.getPrenomAgent());
					if(valide==0)
					{
						
							
							String req="DELETE FROM DIPLOME WHERE Id_DIPLOME='"+diplome.getIdDiplome()+"'";
							st=conn.createStatement();
							st.executeUpdate(req);
							JOptionPane.showMessageDialog(null, "Le diplome de "+agent.getNomAgent()+" "+agent.getPrenomAgent()+" est bien supprimer");
							new InterfaceDiplome();
						
					}
					
					
			 
			}
		catch( SQLException e)
			{
			e.printStackTrace();
		}
		}
		
		
		
	}


	public static void main(String[] args) {
	
		if(agent==null || diplome==null)
		{
			new InterfaceDiplome();
		}
		else
		{
			new InfoDiplome();
		}
				

	}

	
	
}
