package ua;



import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import tables.*;

public class InfoAgent extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable carriere,grades,diplomes,qualification,affectation,conges;
	Agent agent=Interface_Agent.Agent;
	static Connection conn=null;
	JButton add=new JButton(new ImageIcon("images/add.png"));
	JButton mod=new JButton(new ImageIcon("images/add.png"));
	JButton sup=new JButton(new ImageIcon("images/add.png"));
	
	public InfoAgent()
	{
		setSize(1200,700);
		setTitle("les informations l'agent ");
		setVisible(true);
		setLocationRelativeTo(null);
		Container c=getContentPane();
		JPanel pane=new JPanel( new GridLayout(3,2));
		JPanel pane1=new JPanel(new BorderLayout());
		JPanel pane2=new JPanel(new BorderLayout());
		JPanel pane3=new JPanel(new BorderLayout());
		JPanel pane4=new JPanel(new BorderLayout());
		JPanel pane5=new JPanel(new BorderLayout());
		JPanel pane6=new JPanel(new BorderLayout());
		
		add.setPreferredSize(new Dimension(100,50));
		
		// tableau des postes  
		JScrollPane scrollPane = new JScrollPane();
		carriere=new JTable();
		carriere.setRowHeight(40);
		scrollPane.setViewportView(carriere);
		try {
			conn=login.Connexion.getConnection();
			String req = "SELECT Nom_POSTE ,Grade_POSTE,Salaire,Date_Occupation FROM carierre,poste "
					+ "WHERE carierre.Id_POSTE=poste.Id_POSTE AND Id_AGENT = "+ agent.getIdAgent();
			PreparedStatement af=conn.prepareStatement(req);
			ResultSet rst =af.executeQuery(req);
			
			carriere.setModel(DbUtils.resultSetToTableModel(rst));
			
			
			}
			catch(Exception e1)
			{
				
				e1.printStackTrace();
			
				}
			JLabel car=new JLabel("Ses Postes :");
			car.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
			car.setForeground(new Color(18,118,189));
			pane1.add( car,BorderLayout.NORTH);
			pane1.add(scrollPane,BorderLayout.CENTER);
			
		
		// tableau des diplomes 
				JScrollPane scrollPane1 = new JScrollPane();
				diplomes=new JTable();
				diplomes.setRowHeight(40);
				scrollPane1.setViewportView(diplomes);
				try {
					conn=login.Connexion.getConnection();
					String req = "SELECT Nom_DIPLOME, Date_Obtention,Spacialite_DIPLOME,"
							+" 	Etablisssement,Mention_DIPLOME "
							+ "FROM `diplome` WHERE Id_AGENT ="+agent.getIdAgent();
					PreparedStatement af=conn.prepareStatement(req);
					ResultSet rst =af.executeQuery(req);
					
					diplomes.setModel(DbUtils.resultSetToTableModel(rst));
					
					
					}
					catch(Exception e1)
					{
						
						e1.printStackTrace();
						
					
						}
				JLabel dip=new JLabel("Ses Diplomes :");
				dip.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
				dip.setForeground(new Color(18,118,189));
				pane2.add( dip,BorderLayout.NORTH);
				pane2.add(scrollPane1,BorderLayout.CENTER);
			
				// tableau des qualifications
				JScrollPane scrollPane2= new JScrollPane();
				qualification=new JTable();
				qualification.setRowHeight(40);
				scrollPane2.setViewportView(qualification);
				try {
					conn=login.Connexion.getConnection();
					String req = "SELECT * FROM qualification WHERE Id_AGENT= "+agent.getIdAgent();
					PreparedStatement af=conn.prepareStatement(req);
					ResultSet rst =af.executeQuery(req);
					
					qualification.setModel(DbUtils.resultSetToTableModel(rst));
					
					
					}
					catch(Exception e1)
					{
		
						e1.printStackTrace();
					
					}
				JLabel qualif=new JLabel("Ses qualifications :");
				qualif.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
				qualif.setForeground(new Color(18,118,189));
				pane3.add( qualif,BorderLayout.NORTH);
				pane3.add(scrollPane2,BorderLayout.CENTER);
				
				// tableau des Grades
				JScrollPane scrollPane3= new JScrollPane();
				grades=new JTable();
				grades.setRowHeight(40);
				scrollPane3.setViewportView(grades);
				try {
					conn=login.Connexion.getConnection();
					String req = "SELECT * FROM grade WHERE Id_AGENT= "+agent.getIdAgent();
					PreparedStatement af=conn.prepareStatement(req);
					ResultSet rst =af.executeQuery(req);
					
					grades.setModel(DbUtils.resultSetToTableModel(rst));
					
					
					}
					catch(Exception e1)
					{
						
						e1.printStackTrace();
					
					}
				JLabel grd=new JLabel("Ses grades :");
				grd.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
				grd.setForeground(new Color(18,118,189));
				pane4.add( grd,BorderLayout.NORTH);
				pane4.add(scrollPane3,BorderLayout.CENTER);

				
				// tableau des Affectations
				JScrollPane scrollPane4= new JScrollPane();
				affectation=new JTable();
				affectation.setRowHeight(40);
				scrollPane4.setViewportView(affectation);
				try {
					conn=login.Connexion.getConnection();
					String req = "SELECT Nom_UA,Date_Affectation FROM affectation,ua  WHERE ua.Id_UA=affectation.Id_UA "
							+ "AND Id_AGENT= "+agent.getIdAgent();
					PreparedStatement af=conn.prepareStatement(req);
					ResultSet rst =af.executeQuery(req);
					
					affectation.setModel(DbUtils.resultSetToTableModel(rst));
					
					
					}
					catch(Exception e1)
					{
						
						e1.printStackTrace();
					
					}
				JLabel affec=new JLabel("Ses affectations :");
				affec.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
				affec.setForeground(new Color(18,118,189));
				pane5.add( affec,BorderLayout.NORTH);
				pane5.add(scrollPane4,BorderLayout.CENTER);
				
				// tableau des conges
					
				JScrollPane scrollPane5 = new JScrollPane();
				conges=new JTable();
				conges.setRowHeight(40);
				scrollPane5.setViewportView(conges);
				try {
					conn=login.Connexion.getConnection();
					String req = "SELECT Type_Conge,Date_Debut,Date_Fin FROM conge "
							+ "WHERE Id_AGENT = "+ agent.getIdAgent();
					PreparedStatement af=conn.prepareStatement(req);
					ResultSet rst =af.executeQuery(req);
					
					conges.setModel(DbUtils.resultSetToTableModel(rst));
					
					
					}
					catch(Exception e1)
					{
						
						e1.printStackTrace();
					
						}
					JLabel conge=new JLabel("Ses Conges :");
					conge.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
					conge.setForeground(new Color(18,118,189));
					pane6.add( conge,BorderLayout.NORTH);
					pane6.add(scrollPane5,BorderLayout.CENTER);
				

				Border border = pane.getBorder();
				Border margin = new EmptyBorder(20,20,20,20);
				pane1.setBorder(new CompoundBorder(border, margin));
				pane2.setBorder(new CompoundBorder(border, margin));
				pane3.setBorder(new CompoundBorder(border, margin));
				pane4.setBorder(new CompoundBorder(border, margin));
				pane5.setBorder(new CompoundBorder(border, margin));
				pane6.setBorder(new CompoundBorder(border, margin));
				
				scrollPane.setBorder(new CompoundBorder(border, margin));
				scrollPane1.setBorder(new CompoundBorder(border, margin));
				scrollPane2.setBorder(new CompoundBorder(border, margin));
				scrollPane3.setBorder(new CompoundBorder(border, margin));
				scrollPane4.setBorder(new CompoundBorder(border, margin));
				scrollPane5.setBorder(new CompoundBorder(border, margin));
				
				pane.add(pane1);
				pane.add(pane2);
				pane.add(pane3);
				pane.add(pane4);
				pane.add(pane5);
				pane.add(pane6);
				
				c.add(pane);

				
	
				
				
	}

	


}

