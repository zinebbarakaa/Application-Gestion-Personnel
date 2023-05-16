package ar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import login.Connexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import tables.*;


public class ModifierDiplome extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nomagent,nomDiplome,specialite,dateOpt,etablissement,mention;
	
	JTextField nomagentValue,nomDiplomeValue,specialiteValue,dateOptValue,
	etablissementValue,mentionValue,situationFValue;

	JButton mod;
	static Agent agent=InfoDiplome.agent;
	static Diplome diplome=InfoDiplome.diplome;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public ModifierDiplome()
	{
		setTitle("Modifier Poste");
		setSize(1000,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Modifier </U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(3,4,40,40));
		
		nomagent=new JLabel("Nom de l'agent : ");
		nomagent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomagent.setForeground(new Color(18,118,189));
		pane2.add(nomagent);
		
		nomagentValue=new JTextField();
		nomagentValue.setText(agent.getNomAgent()+" "+agent.getPrenomAgent());
		nomagentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomagentValue);
		nomDiplome=new JLabel("Nom du diplome : ");
		nomDiplome.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomDiplome.setForeground(new Color(18,118,189));
		pane2.add(nomDiplome);
		
		nomDiplomeValue=new JTextField();
		nomDiplomeValue.setText(diplome.getNomDiplome());
		nomDiplomeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomDiplomeValue);
		
		specialite=new JLabel("Spetialité du diplome :");
		specialite.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		specialite.setForeground(new Color(18,118,189));
		pane2.add(specialite);
		
		specialiteValue=new JTextField();
		specialiteValue.setText(diplome.getSpecialite());
		specialiteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(specialiteValue);
		
		dateOpt=new JLabel("Date d'Obtention  :");
		dateOpt.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateOpt.setForeground(new Color(18,118,189));
		pane2.add(dateOpt);
		
		dateOptValue=new JTextField(String.format("%1$tY-%1$tm-%1$td",diplome.getDateObtention()));// convertir date en string
		dateOptValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateOptValue);
		
		etablissement=new JLabel("Nom Etablissement  : ");
		etablissement.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		etablissement.setForeground(new Color(18,118,189));
		pane2.add(etablissement);
		
		etablissementValue=new JTextField(diplome.getEtablissement());
		etablissementValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(etablissementValue);
		
		mention=new JLabel("Mention  : ");
		mention.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		mention.setForeground(new Color(18,118,189));
		pane2.add(mention);
		
		mentionValue=new JTextField(diplome.getMention());
		mentionValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(mentionValue);
		
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
		
		mod=new JButton("Modifier");
		mod.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		mod.setBorder(new CompoundBorder(border, margin));
		mod.addActionListener(this);
		JPanel pane3=new JPanel();
		pane3.add(mod);
		
		
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
			String nomAgent=nomagentValue.getText(),
					nomdiplomev=nomDiplomeValue.getText(),
					specialitev=specialiteValue.getText(),
					etablissementv=etablissementValue.getText(),
					mentionv=mentionValue.getText(),
					datev=dateOptValue.getText();
		
					

			
		if(nomAgent.equals("")| nomdiplomev.equals("")|| specialitev.equals("")|| etablissementv.equals("") || mentionv.equals("") || datev.equals("") )
		{
			JOptionPane.showMessageDialog(null, "SVP! remplir tous les données");
	
		}
		else
		{
			try {
				conn=Connexion.getConnection();
				String req="UPDATE diplome SET diplome.Nom_DIPLOME='"+nomdiplomev+"', diplome.Date_Obtention='"+datev+"',"
						+ "diplome.Spacialite_DIPLOME='"+specialitev+"', diplome.Etablisssement='"+etablissementv+"', diplome.Mention_DIPLOME='"+mentionv+"' "
								+ "where Id_DIPLOME="+diplome.getIdDiplome();
				
				st=conn.createStatement();
				st.executeUpdate(req);
			
				int n=st.executeUpdate(req);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "Le diplome est bien modifié");
					setVisible(false);
					new InterfaceDiplome();
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
					
				
			
			
		}
		
		
	}


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(agent==null || diplome==null)
		{
		
			new InterfaceDiplome();
		}
		else
		{
			new ModifierDiplome();
		}

	}

	
	
}
