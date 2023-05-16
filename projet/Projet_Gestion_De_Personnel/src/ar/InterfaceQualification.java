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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import tables.*;




public class InterfaceQualification extends JFrame implements ActionListener,MouseListener{
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
	JButton btn_add,btn_search,sync;
	static int IdAgent;
	static Agent agent;
    static String CIN_Agent="";
    static Qualification qualification;


	
	

	public InterfaceQualification()
	{
		super("Qualifications");
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
		archive=new JLabel("Archive");
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
		
		JLabel titre = new JLabel("<HTML><U>Liste des Qualifications!</U></HTML>",JLabel.CENTER);
		titre.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		titre.setBackground(new Color(245,245,245));
		paneG.add(titre,BorderLayout.NORTH);
		
		JPanel paneT=new JPanel(new BorderLayout());
		
		JPanel paneB=new JPanel(new GridLayout(1,5,50,50));
		search=new JTextField();
		search.setFont(new Font("Bookman Old Style" ,Font.BOLD ,15));
		search.setPreferredSize(new Dimension(300,30));
		search.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		paneB.add(search);
		
		
		btn_search =new JButton("Chercher",new ImageIcon("images/chercher.png"));
		btn_search.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btn_search.setPreferredSize(new Dimension(50,30));
		paneB.add(btn_search);
		btn_search.addActionListener(this);
		
		sync=new JButton("synchronizer",new ImageIcon("images/sync.png"));
		sync.setPreferredSize(new Dimension(50,50));
		sync.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		paneB.add(sync);
		sync.addActionListener(this);
		
		
		btn_add =new JButton("ajouter",new ImageIcon("images/add.png"));
		btn_add.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		paneB.add(btn_add);
		btn_add.addActionListener(this);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		paneau.add(scrollPane);
		table = new JTable();
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		
		
		
		paneT.setPreferredSize(new Dimension(600,100));
		
		
		paneT.add(paneB,BorderLayout.NORTH);
		paneT.add(scrollPane,BorderLayout.CENTER);
		
		paneG.add(paneT);
		paneG.setBackground(new Color(245,245,245));
		paneT.setBackground(new Color(245,245,245));
		paneB.setBackground(new Color(245,245,245));
		
		
		
		
		try {
			conn=login.Connexion.getConnection();
			String req = "SELECT Nom_AGENT,Prenom_AGENT, Description,Date_Qualification FROM `qualification`,agent\r\n"
					+ "WHERE agent.Id_AGENT=qualification.Id_AGENT  ";
			PreparedStatement af=conn.prepareStatement(req);
			ResultSet rst =af.executeQuery(req);
			
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
			
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			
			}
		
		
		
		
		paneB.setBorder(new CompoundBorder(border, margin));
		titre.setBorder(new CompoundBorder(border, margin));
		paneT.setBorder(new CompoundBorder(border, margin));
		paneau.add(menu,BorderLayout.WEST);
		paneau.add(paneG,BorderLayout.CENTER);
		
		Border border1 = search.getBorder();
		Border margin1 = new EmptyBorder(10,10,10,10);
		search.setBorder(new CompoundBorder(border1, margin1));
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		search.setBorder(lineBorder );
	
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
					conn=login.Connexion.getConnection();
					int index=table.getSelectedRow();
					String nom=table.getModel().getValueAt(index,0).toString(),
							prenom=table.getModel().getValueAt(index,1).toString(),
							description=table.getModel().getValueAt(index,2).toString(),
							str=table.getModel().getValueAt(index,3).toString();
					Date date_qualification;
	
					
					try {	
						date_qualification=new SimpleDateFormat("YYYY-MM-DD").parse(str);

						PreparedStatement ps=conn.prepareStatement("SELECT qualification.Id_QAULIFICATION,agent.Id_AGENT FROM  qualification,agent WHERE qualification.Id_AGENT=agent.Id_AGENT"
								+ " AND agent.Nom_AGENT=? AND agent.Prenom_AGENT=? AND Description=? AND Date_Qualification=?");
						ps.setString(1, nom);
						ps.setString(2, prenom);
						ps.setString(3, description);
						ps.setString(4, str);
						rs=ps.executeQuery();
						if(rs.next())
						{
							
								
							agent=new Agent(rs.getInt(2), nom, prenom, null, null, null, null, null, null, null);
							qualification=new Qualification(rs.getInt(1), agent, description, date_qualification);
							setVisible(false);
							new InfoQualification();
									
							
						}
					
					
					
					
						
					
					
				}
				catch (ParseException e) {
						
					}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(Login.getConnAR())
		{
			new InterfaceQualification();
		
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
			new InterfaceDecision();
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
		else if((JLabel)object ==archive)
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
			 CIN_Agent = search.getText();
			if(CIN_Agent.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Veuillez saisir un CIN");
			}
			else
			{
				String req="SELECT * FROM AGENT WHERE CIN_AGENT='"+CIN_Agent+"'";
				conn=login.Connexion.getConnection();
				try {
					st=conn.createStatement();
					rs=st.executeQuery(req);
					if(rs.next())
					{
						agent=new Agent(rs.getInt(1), rs.getString(2),rs.getString(3), null,null , null, null, null, null, CIN_Agent);
						setVisible(false);
						new AjouterQualification();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			
			}
		}
		else if(arg0.getSource()==btn_search)
		{
			CIN_Agent=search.getText();
			if(CIN_Agent.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Veuillez saisir un CIN");
			}
			else {
			try {
				
				conn=login.Connexion.getConnection();
				String req = "SELECT Nom_AGENT,Prenom_AGENT, Description,Date_Qualification  FROM `qualification`,agent\r\n"
						+ "WHERE agent.Id_AGENT=qualification.Id_AGENT\r\n"
						+ "AND CIN_AGENT='"+CIN_Agent+"'";
				
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
	
		else if(arg0.getSource()==sync)
		{

			try {
				conn=login.Connexion.getConnection();
				String req = "SELECT Nom_AGENT,Prenom_AGENT,Description,Date_Qualification  FROM `qualification`,agent\r\n"
						+ "WHERE agent.Id_AGENT=qualification.Id_AGENT";
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


		
	}
	
	

	

