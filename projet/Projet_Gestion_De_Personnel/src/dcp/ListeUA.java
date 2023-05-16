package dcp;


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
import java.util.Vector;
import tables.*;



public class ListeUA extends JFrame implements ActionListener,MouseListener{
	
	private static final long serialVersionUID = 1L;
	JLabel accueil;
	private JLabel Agent;
	private JLabel UA;
	private JLabel AR;
	private JLabel logout;
	private JLabel decision; 
	private JLabel Echancier; 
	JTextField search;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	Vector<Vector<String>> Vect;
	static JTable table;
	int index;
	JButton btn_add,btn_search,sync;
	//static int IdAgent;
	static AR ar;


	
	

	public ListeUA()
	{
		super("Agents");
		setSize(1200,690);	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container paneau= getContentPane();
		// le menu
		JPanel menu=new JPanel();
		menu.setLayout(new GridLayout(7,1,30,30));
		
		accueil=new JLabel("Accueil");
		accueil.setIcon(new ImageIcon("images/home.png"));
		UA=new JLabel("UA");
		UA.setIcon(new ImageIcon("images/Affect.png"));
		AR=new JLabel("AR");
		AR.setIcon(new ImageIcon("images/AR.png"));
		Agent=new JLabel("Agents");
		Agent.setIcon(new ImageIcon("images/user.png"));
		Echancier=new JLabel("Echancier");
		Echancier.setIcon(new ImageIcon("images/Decision.png"));
		decision=new JLabel("Décision");
		decision.setIcon(new ImageIcon("images/Decision.png"));
		logout=new JLabel("Déconnecter");
		logout.setIcon(new ImageIcon("images/logout.png"));
		
		// le curseur sur les elements du menu
		AR.setCursor(new Cursor(Cursor.HAND_CURSOR));
		UA.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Agent.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Echancier.setCursor(new Cursor(Cursor.HAND_CURSOR));
		decision.setCursor(new Cursor(Cursor.HAND_CURSOR));
		accueil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu.add(accueil,BorderLayout.NORTH);
		menu.add(AR);
		menu.add(UA);
		menu.add(Agent);
		menu.add(Echancier);
		menu.add(decision);
		menu.add(logout,BorderLayout.SOUTH);
		
		AR.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		UA.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		Agent.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		logout.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		decision.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		Echancier.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		accueil.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		
		
		Border border = AR.getBorder();
		Border margin = new EmptyBorder(30,30,20,20);
		accueil.setBorder(new CompoundBorder(border, margin));
		AR.setBorder(new CompoundBorder(border, margin));	
		UA.setBorder(new CompoundBorder(border, margin));
		Agent.setBorder(new CompoundBorder(border, margin));
		logout.setBorder(new CompoundBorder(border, margin));
		decision.setBorder(new CompoundBorder(border, margin));
		Echancier.setBorder(new CompoundBorder(border, margin));
		
		
		menu.setPreferredSize(new Dimension(200,500));
		menu.setBackground(new Color(173,216,230));
		
		
		
		UA.addMouseListener(this);
		AR.addMouseListener(this);
		Agent.addMouseListener(this);
		logout.addMouseListener(this);
		decision.addMouseListener(this);
		Echancier.addMouseListener(this);
		accueil.addMouseListener(this);
		
		JPanel paneG=new JPanel(new BorderLayout());
		paneG.setBorder(new CompoundBorder(border, margin));
		
		JLabel titre = new JLabel("<HTML><U>Gestion des UA!</U></HTML>",JLabel.CENTER);
		titre.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		titre.setBackground(new Color(245,245,245));
		paneG.add(titre,BorderLayout.NORTH);
		
		JPanel paneT=new JPanel(new BorderLayout());
		
		JPanel paneB=new JPanel(new GridLayout(1,4,50,50));
		search=new JTextField();
		search.setFont(new Font("Bookman Old Style" ,Font.BOLD ,15));
		search.setPreferredSize(new Dimension(300,30));
		search.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		paneB.add(search);
		

		btn_search =new JButton("chercher",new ImageIcon("images/chercher.png"));
		btn_search.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btn_search.setPreferredSize(new Dimension(50,30));
		paneB.add(btn_search);
		btn_search.addActionListener(this);
		
		sync=new JButton("synchronizer",new ImageIcon("images/sync.png"));
		sync.setPreferredSize(new Dimension(50,50));
		sync.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		paneB.add(sync);
		sync.addActionListener(this);
		
		
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
			String req = "SELECT Nom_AGENT AS Nom_RESP ,Prenom_AGENT AS Prenom_RESP,Nom_UA FROM ua,agent WHERE agent.Id_AGENT=ua.`Id_Resp`";
			PreparedStatement af=conn.prepareStatement(req);
			ResultSet rst =af.executeQuery(req);
			
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
			
			}
			catch(Exception e1)
			{
				System.out.println("erreur lors de l'affichage "+e1);
			
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
		//btn.setBorder(lineBorder );
		
		
		
		
		//this.pack();
		setVisible(true);
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		/*if(Login.getConnAR())
		{
			new Agent();
		}
		else
		{
			new Login();
		}*/
		new ListeUA();
		
		

	}

	public void mouseClicked(MouseEvent arg0) {

		Object object =arg0.getSource();
		if((JLabel)object == accueil)
		{
			new Home_DCP();
		}
		
		else if((JLabel)object ==AR)
		{
			this.setVisible(false);
			new ListeAR();
		}
		else if((JLabel)object ==UA)
		{
			this.setVisible(false);
			new ListeUA();
		}
		else if((JLabel)object ==Agent)
		{
			this.setVisible(false);
			new InterfaceAgent();
		}
		else if((JLabel)object ==decision)
		{
			this.setVisible(false);
			new InterfaceDecision();
		}
		else if((JLabel)object ==Echancier)
		{
			this.setVisible(false);
			new Echancier();
		}
		else if((JLabel)object ==logout)
		{
			this.setVisible(false);
			Login.setConnDCP();
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
		 if(arg0.getSource()==btn_search)
		{
			String text=search.getText();
			if(text.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Veuillez saisir un nom de ville valide");
			}
			else {
			try {
				
				conn=login.Connexion.getConnection();
				String req = "SELECT Nom_AGENT AS Nom_RESP ,Prenom_AGENT AS Prenom_RESP,Nom_UA FROM ua,agent WHERE agent.Id_AGENT=ua.`Id_Resp` AND Nom_UA ='"+text+"'";
				PreparedStatement af=conn.prepareStatement(req);
				ResultSet rst =af.executeQuery(req);
				
				table.setModel(DbUtils.resultSetToTableModel(rst));
				
				
				}
				catch(Exception e1)
				{
					System.out.println("erreur lors de l'affichage "+e1);
				
				}
			}
		}
		else if(arg0.getSource()==sync)
		{

			try {
				conn=login.Connexion.getConnection();
				String req = "SELECT Nom_AGENT AS Nom_RESP ,Prenom_AGENT AS Prenom_RESP,Nom_UA FROM ua,agent WHERE agent.Id_AGENT=ua.`Id_Resp`";
				PreparedStatement af=conn.prepareStatement(req);
				ResultSet rst =af.executeQuery(req);
				
				table.setModel(DbUtils.resultSetToTableModel(rst));
				
				
				}
				catch(Exception e1)
				{
					System.out.println("erreur lors de l'affichage "+e1);
				
				}
		}
		
	}


		
	}
	
	

	

