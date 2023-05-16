package dcp;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import login.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home_DCP extends JFrame implements MouseListener{
	private static final long serialVersionUID = 1L;
	JLabel accueil;
	private JLabel agent;
	private JLabel UA;
	private JLabel AR;
	private JLabel logout;
	private JLabel decision; 
	private JLabel Echancier; 
	public Home_DCP()
	{
		super("Home DCP");
		this.setSize(1000,650);	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel paneau=(JPanel) this.getContentPane();
		// le menu
		JPanel menu=new JPanel();
		menu.setLayout(new GridLayout(7,1,30,30));
		
		accueil=new JLabel("Accueil");
		accueil.setIcon(new ImageIcon("images/home.png"));
		UA=new JLabel("UA");
		UA.setIcon(new ImageIcon("images/Affect.png"));
		AR=new JLabel("AR");
		AR.setIcon(new ImageIcon("images/AR.png"));
		agent=new JLabel("Agents");
		agent.setIcon(new ImageIcon("images/user.png"));
		Echancier=new JLabel("Echancier");
		Echancier.setIcon(new ImageIcon("images/Decision.png"));
		decision=new JLabel("Décision");
		decision.setIcon(new ImageIcon("images/Decision.png"));
		logout=new JLabel("Déconnecter");
		logout.setIcon(new ImageIcon("images/logout.png"));
		
		// le curseur sur les elements du menu
		AR.setCursor(new Cursor(Cursor.HAND_CURSOR));
		UA.setCursor(new Cursor(Cursor.HAND_CURSOR));
		agent.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Echancier.setCursor(new Cursor(Cursor.HAND_CURSOR));
		decision.setCursor(new Cursor(Cursor.HAND_CURSOR));
		accueil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu.add(accueil,BorderLayout.NORTH);
		menu.add(AR);
		menu.add(UA);
		menu.add(agent);
		menu.add(Echancier);
		menu.add(decision);
		menu.add(logout,BorderLayout.SOUTH);
		
		menu.setPreferredSize(new Dimension(200,500));
		menu.setBackground(new Color(173,216,230));
		
		JPanel pane=new JPanel(new GridLayout(2,1));
		JPanel pane1=new JPanel(new GridLayout(2,1));
		JPanel pane2=new JPanel(new GridLayout(2,1));
		JPanel pane3=new JPanel(new GridLayout(2,1));
		JPanel pane4=new JPanel(new GridLayout(2,1));
		JPanel pane5=new JPanel(new GridLayout(2,1));
		// le contenu de pane
		JLabel nbrAR =new JLabel("Nombre AR");
		nbrAR.setIcon(new ImageIcon("images/AR.png"));
		JLabel nbr=new JLabel(String.valueOf(DashBord.nombreAR()));
		pane.add(nbrAR);
		pane.add(nbr);
		// le contenu de pane1
		JLabel nbrUA=new JLabel("Nombre UA");
		nbrUA.setIcon(new ImageIcon("images/Affect.png"));
		JLabel nbr1=new JLabel(String.valueOf(DashBord.nombreAgents()));
		pane1.add(nbrUA);
		pane1.add(nbr1);
		// le contenu de pane2
		JLabel nbrAgent =new JLabel("Nombre Agents");
		nbrAgent.setIcon(new ImageIcon("images/user.png"));
		JLabel nbr2=new JLabel(String.valueOf(DashBord.nombreAgents()));
		pane2.add(nbrAgent);
		pane2.add(nbr2);
		
		// le contenu de pane3
		JLabel nbrDecision=new JLabel("Nombre Decision");
		nbrDecision.setIcon(new ImageIcon("images/Decision.png"));
		JLabel nbr3=new JLabel(String.valueOf(DashBord.nombreAgents()));
		pane3.add(nbrDecision);
		pane3.add(nbr3);
		// le contenu de pane4
		JLabel nbrPoste=new JLabel("Nombre Poste Vide");
		nbrPoste.setIcon(new ImageIcon("images/Poste.png"));
		JLabel nbr4=new JLabel(String.valueOf(DashBord.nombrePosteVide()));
		pane4.add(nbrPoste);
		pane4.add(nbr4);
		// le contenu de pane5
		JLabel nbrPoste1=new JLabel("Nombre Poste ");
		nbrPoste1.setIcon(new ImageIcon("images/Poste.png"));
		JLabel nbr5=new JLabel(String.valueOf(DashBord.nombrePoste()));
		pane5.add(nbrPoste1);
		pane5.add(nbr5);
		
		nbrAgent.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrUA.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrAR.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrDecision.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrPoste.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrPoste1.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		
		nbr.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr1.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr2.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr3.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr4.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		nbr5.setFont(new Font("Bookman Old Style", Font.BOLD , 20));
		
		AR.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		UA.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		agent.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		logout.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		decision.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		Echancier.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		accueil.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		
		JPanel paneG=new JPanel(new BorderLayout());
		
		JLabel titre = new JLabel("<HTML><U>Bienvenue dans l'interface DCP !</U></HTML>",JLabel.CENTER);
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
					
		Border border = AR.getBorder();
		Border margin = new EmptyBorder(30,30,20,20);
		accueil.setBorder(new CompoundBorder(border, margin));
		AR.setBorder(new CompoundBorder(border, margin));	
		UA.setBorder(new CompoundBorder(border, margin));
		agent.setBorder(new CompoundBorder(border, margin));
		logout.setBorder(new CompoundBorder(border, margin));
		decision.setBorder(new CompoundBorder(border, margin));
		Echancier.setBorder(new CompoundBorder(border, margin));
			
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
	
		UA.addMouseListener(this);
		AR.addMouseListener(this);
		agent.addMouseListener(this);
		logout.addMouseListener(this);
		decision.addMouseListener(this);
		Echancier.addMouseListener(this);
		accueil.addMouseListener(this);
		//this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(Login.getConnDCP())
		{
			new Home_DCP();
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
			this.setVisible(false);
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
		else if((JLabel)object ==agent)
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
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	
		
	}

	
	


}
