package ar;

import javax.swing.*;



import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import login.*;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import tables.*;



public class InterfacePoste extends JFrame implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel accueil,Agent,poste,logout, decision,Affect, Diplome, grade, qaulification, conge, recrutement,archive;
	JTextField search;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;

	static JTable table;
	int index;
	JButton btn_add,btn_search_posA,btn_add_poste,btn_search,sync,modifier,supprimer;
	static int IdAgent;
	static Agent agent;
	static UA ua;
	static Poste post;
	static String CINagent="";



	
	

	public InterfacePoste()
	{
		super("Postes");
		setSize(1200,690);	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container paneau= getContentPane();
		// le menu
		JPanel menu=new JPanel();
		menu.setLayout(new GridLayout(12,1,30,30));
		
		accueil=new JLabel("Accueil");
		accueil.setIcon(new ImageIcon("images/home.png"));
		Agent=new JLabel("Agent");
		Agent.setIcon(new ImageIcon("images/Agent.png"));
		poste=new JLabel("Postes");
		poste.setIcon(new ImageIcon("images/Poste.png"));
		Affect=new JLabel("Affectation");
		Affect.setIcon(new ImageIcon("images/Affect.png"));
		Diplome=new JLabel("Diplome");
		Diplome.setIcon(new ImageIcon("images/dip.png"));
		grade = new JLabel("Grade");
		grade.setIcon(new ImageIcon("images/grade.png"));
		qaulification= new JLabel("Qualification");
		qaulification.setIcon(new ImageIcon("images/qualif.png"));
		conge= new JLabel("Congé");
		conge.setIcon(new ImageIcon("images/leave.png"));
		decision= new JLabel("Décision");
		decision.setIcon(new ImageIcon("images/Decision.png"));
		recrutement= new JLabel("Recrutement");
		recrutement.setIcon(new ImageIcon("images/job.png"));
		archive= new JLabel("Archive");
		archive.setIcon(new ImageIcon("images/archive.png"));
		logout=new JLabel("Déconnecter");
		logout.setIcon(new ImageIcon("images/logout.png"));
		
		// le curseur sur les elements du menu
		accueil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Agent.setCursor(new Cursor(Cursor.HAND_CURSOR));
		poste.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Affect.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Diplome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		grade.setCursor(new Cursor(Cursor.HAND_CURSOR));
		qaulification.setCursor(new Cursor(Cursor.HAND_CURSOR));
		conge.setCursor(new Cursor(Cursor.HAND_CURSOR));
		decision.setCursor(new Cursor(Cursor.HAND_CURSOR));
		recrutement.setCursor(new Cursor(Cursor.HAND_CURSOR));	
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		archive.setCursor(new Cursor(Cursor.HAND_CURSOR));

		
		accueil.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		Agent.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		poste.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		Affect.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		Diplome.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		grade.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		qaulification.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		conge.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		decision.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		recrutement.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		logout.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		archive.setFont(new Font("Bookman Old Style", Font.BOLD, 15));

		
		
		
		Border border = poste.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		accueil.setBorder(new CompoundBorder(border, margin));
		Agent.setBorder(new CompoundBorder(border, margin));
		poste.setBorder(new CompoundBorder(border, margin));
		Affect.setBorder(new CompoundBorder(border, margin));
		Diplome.setBorder(new CompoundBorder(border, margin));
		grade.setBorder(new CompoundBorder(border, margin));
		qaulification.setBorder(new CompoundBorder(border, margin));
		conge.setBorder(new CompoundBorder(border, margin));
		decision.setBorder(new CompoundBorder(border, margin));
		recrutement.setBorder(new CompoundBorder(border, margin));
		logout.setBorder(new CompoundBorder(border, margin));
		archive.setBorder(new CompoundBorder(border, margin));

		
		
		menu.add(accueil);
		menu.add(Agent);
		menu.add(poste);
		menu.add(Affect);
		menu.add(Diplome);
		menu.add(grade);
		menu.add(qaulification);
		menu.add(conge);
		menu.add(decision);
		menu.add(recrutement);
		menu.add(archive);

		menu.add(logout);
		menu.setPreferredSize(new Dimension(200,680));
		menu.setBackground(new Color(173,216,230));
		
		accueil.addMouseListener(this);
		Agent.addMouseListener(this);
		poste.addMouseListener(this);
		Affect.addMouseListener(this);
		Diplome.addMouseListener(this);
		grade.addMouseListener(this);
		qaulification.addMouseListener(this);
		conge.addMouseListener(this);
		decision.addMouseListener(this);
		recrutement.addMouseListener(this);
		logout.addMouseListener(this);
		archive.addMouseListener(this);

		
		JPanel paneG=new JPanel(new BorderLayout());
		paneG.setBorder(new CompoundBorder(border, margin));
		
		JLabel titre = new JLabel("<HTML><U>Liste des Postes !</U></HTML>",JLabel.CENTER);
		titre.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		titre.setBackground(new Color(245,245,245));
		paneG.add(titre,BorderLayout.NORTH);
		
		JPanel paneT=new JPanel(new BorderLayout());
		
		JPanel paneB=new JPanel(new GridLayout(1,4,50,50));
		
		JPanel paneC=new JPanel(new GridLayout(1,3,50,50));
		
		
		search=new JTextField();
		search.setFont(new Font("Bookman Old Style" ,Font.BOLD ,15));
		
		search.setPreferredSize(new Dimension(50,50));
		search.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		paneB.add(search);
		
		
		
		btn_search_posA =new JButton("P_Actuel",new ImageIcon("images/chercher.png"));
		btn_search_posA.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btn_search_posA.setPreferredSize(new Dimension(50,50));
		paneB.add(btn_search_posA);		
		btn_search_posA.addActionListener(this);
		
		
		btn_search =new JButton("Cariere",new ImageIcon("images/chercher.png"));
		btn_search.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btn_search.setPreferredSize(new Dimension(50,50));
		paneB.add(btn_search);
		btn_search.addActionListener(this);
		
		btn_add =new JButton("Ajouter",new ImageIcon("images/add.png"));
		btn_add.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btn_add.setPreferredSize(new Dimension(50,50));
		paneB.add(btn_add);
		btn_add.addActionListener(this);
		
		
		sync=new JButton(new ImageIcon("images/sync.png"));
		sync.setPreferredSize(new Dimension(50,50));
		sync.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		sync.addActionListener(this);
		paneC.add(sync);
		
		
		btn_add_poste =new JButton(new ImageIcon("images/add.png"));
		btn_add_poste.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btn_add_poste.setPreferredSize(new Dimension(50,50));
		paneC.add(btn_add_poste);
		btn_add_poste.addActionListener(this);
		
		
		
		modifier=new JButton(new ImageIcon("images/mod.png"));
		modifier.setFont(new Font("Bookman Old Style" ,Font.BOLD ,15));
		modifier.setPreferredSize(new Dimension(50,50));
		modifier.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		paneC.add(modifier);
		modifier.addActionListener(this);
		
		
		supprimer=new JButton(new ImageIcon("images/remove1.png"));
		supprimer.setFont(new Font("Bookman Old Style" ,Font.BOLD ,15));
		supprimer.setPreferredSize(new Dimension(50,50));
		supprimer.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		paneC.add(supprimer);
		supprimer.addActionListener(this);
	
		
		JScrollPane scrollPane = new JScrollPane();
		paneau.add(scrollPane);
		table = new JTable();
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		
		
		
		paneT.setPreferredSize(new Dimension(600,100));
		
		
		paneT.add(paneB,BorderLayout.NORTH);
		paneT.add(scrollPane,BorderLayout.CENTER);
		paneT.add(paneC,BorderLayout.SOUTH);
		paneG.add(paneT);
		paneG.setBackground(new Color(245,245,245));
		paneT.setBackground(new Color(245,245,245));
		paneB.setBackground(new Color(245,245,245));
		paneC.setBackground(new Color(245,245,245));
		
		
		
		
		try {
			conn=login.Connexion.getConnection();
			String req = "SELECT poste.Nom_POSTE,ua.Nom_UA,poste.Grade_POSTE,poste.Salaire FROM poste, ua "
					+ "WHERE ua.Id_UA=poste.Id_UA ";
			PreparedStatement af=conn.prepareStatement(req);
			ResultSet rst =af.executeQuery(req);
			
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
			
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			
			}
		
		
		paneB.setBorder(new CompoundBorder(border, margin));
		paneC.setBorder(new CompoundBorder(border, margin));
		paneT.setBorder(new CompoundBorder(border, margin));
		paneau.add(menu,BorderLayout.WEST);
		paneau.add(paneG,BorderLayout.CENTER);
		
		Border border1 = search.getBorder();
		Border margin1 = new EmptyBorder(10,10,10,10);
		search.setBorder(new CompoundBorder(border1, margin1));
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		search.setBorder(lineBorder );
		//btn.setBorder(lineBorder );
		
		

		
		setVisible(true);
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(Login.getConnAR())
		{
			new InterfacePoste();
		}
		else
		{
			new Login();
		}
		
		
		

	}

	public void mouseClicked(MouseEvent arg0) {

		Object object =arg0.getSource();
		if((JLabel)object == accueil)
		{
			setVisible(false);
			new Home_AR();
		}
		
		else if((JLabel)object ==Agent)
		{
			this.setVisible(false);
			new InterfaceAgent();
		
		}
		else if((JLabel)object ==poste)
		{
			this.setVisible(false);
			new InterfacePoste();
			
		}
		else if((JLabel)object ==Affect)
		{
			this.setVisible(false);
			new InterfaceAffectation();
		}
		else if((JLabel)object ==archive)
		{
			this.setVisible(false);
			new DecisionArchive();
		}
		else if((JLabel)object ==Diplome)
		{
			this.setVisible(false);
			new InterfaceDiplome();
		}
		else if((JLabel)object ==grade)
		{
			this.setVisible(false);
			new InterfaceGrade();
		}
		else if((JLabel)object ==qaulification)
		{
			this.setVisible(false);
			new InterfaceQualification();
		}
		else if((JLabel)object ==conge)
		{
			this.setVisible(false);
			new InterfaceConge();
		}
		else if((JLabel)object ==decision)
		{
			this.setVisible(false);
			new InterfacePoste();
		}
		else if((JLabel)object ==recrutement)
		{
			this.setVisible(false);
			new InterfaceRecrutement();
			
		}
		else if((JLabel)object ==logout)
		{
			this.setVisible(false);
			Login.setConnAR(); // fermer la session de L'AR
			new Login();
		}
		
		
			
		
	}
	
	
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		
	}

	
	public void mousePressed(MouseEvent arg0) {
		
		
	}

	public void mouseReleased(MouseEvent arg0) {
	
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btn_add)
		{
			CINagent=search.getText();
		
			
				if(CINagent.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Veuillez saisir un CIN");
				}
				
				else {
					try {
						conn=login.Connexion.getConnection();
						int index=table.getSelectedRow();
						String nomPoste=table.getModel().getValueAt(index,0).toString();
						String nomUA=table.getModel().getValueAt(index,1).toString();
						String req="SELECT Id_Poste,ua.Id_UA,Status_Poste FROM Poste,ua WHERE Nom_Poste='"+nomPoste+"'"
								+ "AND Nom_UA='"+nomUA+"'";
						st=conn.createStatement();
						rs=st.executeQuery(req);
						if(rs.next())
						{
							String gradePoste=table.getModel().getValueAt(index,2).toString();
							double salairePoste=(double) table.getModel().getValueAt(index,3);
							int idPoste=rs.getInt(1),
											idUA=rs.getInt(2);
							boolean statusPoste=rs.getBoolean(3);
							if(statusPoste)
							{
								JOptionPane.showMessageDialog(null, "Ce poste est non vide!");
							}
							else {
								
								ua=new UA(idUA, null, nomUA, null,null, null);
								post=new Poste(idPoste,nomPoste, gradePoste, salairePoste ,statusPoste, ua);	
								setVisible(false);	
								new AjouterPosteAgent();
							}
							
						
							
							
						}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			}
			
			
		else if(arg0.getSource()==btn_search)
		{
			CINagent=search.getText();
			if(CINagent.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Veuillez saisir un CIN");
			}
			else {
			try {
				
				conn=login.Connexion.getConnection();
				String req = "SELECT agent.Nom_AGENT,agent.Prenom_AGENT,poste.Nom_POSTE,poste.Grade_POSTE,poste.Salaire, carierre.Date_Occupation FROM poste,agent,carierre \r\n"
						+ "						WHERE poste.Id_POSTE=carierre.Id_POSTE\r\n"
						+ "						AND agent.Id_AGENT=carierre.Id_AGENT\r\n"
						+ "                        AND CIN_AGENT='"+CINagent+"'"
						+ "						ORDER BY Date_Occupation ";
				
				PreparedStatement af=conn.prepareStatement(req);
				ResultSet rst =af.executeQuery(req);
				
				table.setModel(DbUtils.resultSetToTableModel(rst));
				
				
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				
				}
			}
		}
	else if(arg0.getSource()==btn_search_posA)
		{
			String CINagent=search.getText();
			if(CINagent.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Veuillez saisir un CIN");
			}
			else {
			try {
				
				conn=login.Connexion.getConnection();
				String req0="SELECT Id_AGENT FROM AGENT WHERE CIN_AGENT='"+CINagent+"'";
				st=conn.createStatement();
				rs=st.executeQuery(req0);
				rs.next();
				int idagent=rs.getInt(1);
				if(DashBord.posteactuel(idagent)!=0)
				{
					String req = "SELECT agent.Nom_AGENT,agent.Prenom_AGENT,poste.Nom_POSTE,poste.Grade_POSTE,poste.Salaire, carierre.Date_Occupation FROM poste,agent,carierre \r\n"
							+ "						WHERE poste.Id_POSTE=carierre.Id_POSTE\r\n"
							+ "						AND agent.Id_AGENT=carierre.Id_AGENT\r\n"  
							+"						AND carierre.Id_AGENT="+idagent
							+"						AND poste.Id_POSTE="+DashBord.posteactuel(idagent);
					PreparedStatement af=conn.prepareStatement(req);
					ResultSet rst =af.executeQuery(req);
					
					table.setModel(DbUtils.resultSetToTableModel(rst));
				}
				else {
					JOptionPane.showMessageDialog(null, "L'agent "+CINagent+" n'occupe maintenant aucun poste !");
				}
					
				
				
				
				
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				
				}
			}
		}
		else if(arg0.getSource()==sync)
		{

			try {
				conn=login.Connexion.getConnection();
				String req = "SELECT poste.Nom_POSTE,ua.Nom_UA,poste.Grade_POSTE,poste.Salaire FROM poste, ua where ua.Id_UA=poste.Id_UA";
				PreparedStatement af=conn.prepareStatement(req);
				ResultSet rst =af.executeQuery(req);
				
				table.setModel(DbUtils.resultSetToTableModel(rst));
				
				
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				
				}
		}
		else if(arg0.getSource()==supprimer)
		{
				try {
					conn=login.Connexion.getConnection();
					int index=table.getSelectedRow();
					String nomPoste=table.getModel().getValueAt(index,0).toString();
					String nomUA=table.getModel().getValueAt(index,1).toString();
					String req="SELECT Id_Poste,ua.Id_UA FROM Poste,ua WHERE Nom_Poste='"+nomPoste+"'"
							+ "AND Nom_UA='"+nomUA+"'";
					st=conn.createStatement();
					rs=st.executeQuery(req);
					if(rs.next())
					{
						int n=JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer Ce Poste !");
						if(n==0)
						{
							String req1="DELETE FROM POSTE WHERE Id_POSTE="+rs.getInt(1);
							st=conn.createStatement();
							st.executeUpdate(req1);
							JOptionPane.showMessageDialog(null, "Le Poste "+nomPoste+" de l'unité "+nomUA +" est bien supprimer");
							new InterfacePoste();
						}
							
						
						
					}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}


		else if(arg0.getSource()==modifier)
		{
				try {
					conn=login.Connexion.getConnection();
					int index=table.getSelectedRow();
					String nomPoste=table.getModel().getValueAt(index,0).toString();
					String nomUA=table.getModel().getValueAt(index,1).toString(),
							gradePoste=table.getModel().getValueAt(index,2).toString();
					double salairePoste=(double) table.getModel().getValueAt(index,3);
					
							
					String req="SELECT Id_Poste,ua.Id_UA,Status_Poste FROM Poste,ua WHERE Nom_Poste='"+nomPoste+"'"
							+ "AND Nom_UA='"+nomUA+"'";
					st=conn.createStatement();
					rs=st.executeQuery(req);
					if(rs.next())
					{
						int n=JOptionPane.showConfirmDialog(null, "Voulez-vous modifier Ce Poste !");
						if(n==0)
						{
							ua=new UA(rs.getInt(2), null, nomUA, null, null, null);
							post=new Poste(rs.getInt(1), nomPoste, gradePoste,salairePoste,rs.getBoolean(3) ,ua);
							setVisible(false);
							new ModifierPoste();

						}
							
						
						
					}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		

		else if(arg0.getSource()==btn_add_poste)
		{
			String NomUA=search.getText();
			if(NomUA.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Veuillez saisir le nom de l'unité d'affecation !");
			}
			else {
				String sql="SELECT Id_UA FROM UA WHERE Nom_UA='"+NomUA+"'";
				conn=Connexion.getConnection();
				
				try {
					st=conn.createStatement();
					rs=st.executeQuery(sql);
					if(rs.next())
					{
						
						ua=new UA(rs.getInt(1), null, NomUA, null, null, null);
						setVisible(false);
						new AjouterPoste();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	


		
}
	
	

	

