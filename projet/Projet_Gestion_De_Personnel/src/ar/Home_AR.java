package ar;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import login.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Home_AR extends JFrame implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel accueil;
	private JLabel Agent;
	private JLabel poste;
	private JLabel logout;
	private JLabel decision; 
	private JLabel Affect; 
	private JLabel Diplome; 
	private JLabel grade;
	private JLabel qaulification;
	private JLabel conge;
	private JLabel recrutement;
	private JLabel archive;
	
	

	public Home_AR()
	{
		super("Home DCP");
		setSize(1200,690);	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel paneau=(JPanel) getContentPane();
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
		logout=new JLabel("Deconecter");
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
		
		JPanel pane=new JPanel(new GridLayout(2,1));
		JPanel pane1=new JPanel(new GridLayout(2,1));
		JPanel pane2=new JPanel(new GridLayout(2,1));
		JPanel pane3=new JPanel(new GridLayout(2,1));
		JPanel pane4=new JPanel(new GridLayout(2,1));
		JPanel pane5=new JPanel(new GridLayout(2,1));
		// le contenu de pane
		JLabel nbrUA =new JLabel("Nombre UA");
		nbrUA.setIcon(new ImageIcon("images/Affect.png"));
		JLabel nbr=new JLabel(String.valueOf(DashBord.nombreUA()));
		pane.add(nbrUA);
		pane.add(nbr);
		// le contenu de pane1
		JLabel nbrAgent=new JLabel("Nombre Agents");
		nbrAgent.setIcon(new ImageIcon("images/Agent.png"));
		JLabel nbr1=new JLabel(String.valueOf(DashBord.nombreAgents()));
		pane1.add(nbrAgent);
		pane1.add(nbr1);
		// le contenu de pane2
		JLabel nbrposte =new JLabel("Nombre Postes");
		nbrposte.setIcon(new ImageIcon("images/Poste.png"));
		JLabel nbr2=new JLabel(String.valueOf(DashBord.nombreAgents()));
		pane2.add(nbrposte);
		pane2.add(nbr2);
		
		// le contenu de pane3
		JLabel nbrConge=new JLabel("Nombre Agents en Congé");
		nbrConge.setIcon(new ImageIcon("images/leave.png"));
		JLabel nbr3=new JLabel(String.valueOf(DashBord.nombreAgents()));
		pane3.add(nbrConge);
		pane3.add(nbr3);
		
		//le contenu de pane4
		JLabel nbrAdmis=new JLabel("Nombre Admis");
		nbrAdmis.setIcon(new ImageIcon("images/Admis.png"));
		JLabel nbr4=new JLabel(String.valueOf(DashBord.nombreAdmis()));
		pane4.add(nbrAdmis);
		pane4.add(nbr4);
		//le contenu de pane5
		JLabel nbrDecision=new JLabel("Nombre de décision non valide");
		nbrDecision.setIcon(new ImageIcon("images/dec_non_valide.png"));
		JLabel nbr5=new JLabel(String.valueOf(DashBord.nombreDecision()));
		pane5.add(nbrDecision);
		pane5.add(nbr5);
		
		nbrUA.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrAgent.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrposte.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrDecision.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrConge.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrAdmis.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		
		
		nbr.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr1.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr2.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr3.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr4.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr5.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		
		JPanel paneG=new JPanel(new BorderLayout());
		
		JLabel titre = new JLabel("<HTML><U>Bienvenue dans l'interface AR !</U></HTML>",JLabel.CENTER);
		titre.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		titre.setBackground(new Color(245,245,245));
		
		
		JPanel paneT=new JPanel(new GridLayout(3,2,40,40));	
		paneT.add(pane);
		paneT.add(pane1);
		paneT.add(pane2);
		paneT.add(pane3);
		paneT.add(pane4);
		paneT.add(pane5);
		
		paneG.add(titre,BorderLayout.NORTH);
		paneG.add(paneT,BorderLayout.CENTER);
		
		pane.setBackground(Color.white);
		pane1.setBackground(Color.white);
		pane2.setBackground(Color.white);
		pane3.setBackground(Color.white);
		pane4.setBackground(Color.white);
		pane5.setBackground(Color.white);
		
				
		

		
		
	
		
		
		Border border1 = pane.getBorder();
		Border margin1 = new EmptyBorder(20,20,10,10);
		pane.setBorder(new CompoundBorder(border1, margin1));
		pane1.setBorder(new CompoundBorder(border1, margin1));
		pane2.setBorder(new CompoundBorder(border1, margin1));
		pane3.setBorder(new CompoundBorder(border1, margin1));
		pane4.setBorder(new CompoundBorder(border1, margin1));
		pane5.setBorder(new CompoundBorder(border1, margin1));
		
		
		paneT.setBorder(new CompoundBorder(border, margin));
		titre.setBorder(new CompoundBorder(border, margin));
		
		paneau.add(menu,BorderLayout.WEST);
		paneau.add(paneG,BorderLayout.CENTER);
		
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
		archive.addMouseListener(this);
		logout.addMouseListener(this);
		
		
		
		//this.pack();
		setVisible(true);
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(Login.getConnAR())
		{
			new Home_AR();
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
			setVisible(false);
			new InterfaceAgent();
		
		}
		else if((JLabel)object ==poste)
		{
			setVisible(false);
			new InterfacePoste();
			
		}
		else if((JLabel)object ==Affect)
		{
			setVisible(false);
			new InterfaceAffectation();
		}
		else if((JLabel)object ==Diplome)
		{
			setVisible(false);
			new InterfaceDiplome();
		}
		else if((JLabel)object ==grade)
		{
			setVisible(false);
			new InterfaceGrade();
		}
		else if((JLabel)object ==qaulification)
		{
			setVisible(false);
			new InterfaceQualification();
		}
		else if((JLabel)object ==conge)
		{
			setVisible(false);
			new InterfaceConge();
		}
		else if((JLabel)object ==decision)
		{
			setVisible(false);
			new InterfaceDecision();
		}
		else if((JLabel)object ==recrutement)
		{
			setVisible(false);
			new InterfaceRecrutement();
			
		}
		else if((JLabel)object ==archive)
		{
			setVisible(false);
			new DecisionArchive();
			
		}
		else if((JLabel)object ==logout)
		{
			setVisible(false);
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

	
	

	
}
