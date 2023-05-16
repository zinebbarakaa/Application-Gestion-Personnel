package ua;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import login.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home_UA extends JFrame implements MouseListener{
	private static final long serialVersionUID = 1L;
	JLabel accueil;
	private JLabel agent;
	
	
	private JLabel logout;
	private JLabel decision; 
 
	

	public Home_UA()
	{
		super("Home UA");
		this.setSize(1200,690);	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel paneau=(JPanel) this.getContentPane();
		// le menu
		JPanel menu=new JPanel();
		menu.setLayout(new GridLayout(4,1,30,30));
		
		accueil=new JLabel("Accueil");
		accueil.setIcon(new ImageIcon("images/home.png"));
		
		agent=new JLabel("Agents");
		agent.setIcon(new ImageIcon("images/user.png"));
		
		decision=new JLabel("Decision");
		decision.setIcon(new ImageIcon("images/Decision.png"));
		logout=new JLabel("Deconnecter");
		logout.setIcon(new ImageIcon("images/logout.png"));
		
		// le curseur sur les elements du menu
		
		agent.setCursor(new Cursor(Cursor.HAND_CURSOR));
		decision.setCursor(new Cursor(Cursor.HAND_CURSOR));
		accueil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		menu.add(accueil,BorderLayout.NORTH);
		menu.add(agent);
		menu.add(decision);
		menu.add(logout,BorderLayout.SOUTH);
		
		menu.setPreferredSize(new Dimension(220,500));
		menu.setBackground(new Color(173,216,230));
		
		JPanel pane=new JPanel(new GridLayout(3,1));
		JPanel pane1=new JPanel(new GridLayout(3,1));
		JPanel pane2=new JPanel(new GridLayout(3,1));
		JPanel pane3=new JPanel(new GridLayout(3,1));
		JPanel pane4=new JPanel(new GridLayout(3,1));
		JPanel pane5=new JPanel(new GridLayout(3,1));
		// le contenu de pane
		JLabel nbrAR =new JLabel("Responsable de UA");
		nbrAR.setIcon(new ImageIcon("images/user.png"));
		JLabel nbr=new JLabel(String.valueOf(DashBord.respUA()));
		pane.add(nbrAR);
		pane.add(nbr);
		// le contenu de pane1
		JLabel nbrUA=new JLabel("AR");
		nbrUA.setIcon(new ImageIcon("images/AR.png"));
		JLabel nbr1=new JLabel(String.valueOf(DashBord.AR()));
		pane1.add(nbrUA);
		pane1.add(nbr1);
		// le contenu de pane2
		JLabel nbrAgent =new JLabel("Nombre des Agents");
		nbrAgent.setIcon(new ImageIcon("images/Agent.png"));
		JLabel nbr2=new JLabel(String.valueOf(DashBord.nombreAgents()));
		pane2.add(nbrAgent);
		pane2.add(nbr2);
		
		// le contenu de pane3
		JLabel nbrDecision=new JLabel("Nombre des  Agents en conge");
		nbrDecision.setIcon(new ImageIcon("images/Agent.png"));
		JLabel nbr3=new JLabel(String.valueOf(DashBord.nombreAgentsConge()));
		pane3.add(nbrDecision);
		pane3.add(nbr3);
		// le contenu de pane4
		JLabel nbrPoste=new JLabel("Nombre de Poste Vide");
		nbrPoste.setIcon(new ImageIcon("images/Poste.png"));
		JLabel nbr4=new JLabel(String.valueOf(DashBord.nombrePosteVide()));
		pane4.add(nbrPoste);
		pane4.add(nbr4);
		// le contenu de pane5
		JLabel nbrPoste1=new JLabel("Nombre poste dans UA ");
		nbrPoste1.setIcon(new ImageIcon("images/Poste.png"));
		JLabel nbr5=new JLabel(String.valueOf(DashBord.nombrePosteUA()));
		pane5.add(nbrPoste1);
		pane5.add(nbr5);
		
		nbrAgent.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrUA.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrAR.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrDecision.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrPoste.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbrPoste1.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		
		nbr.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbr1.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbr2.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbr3.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbr4.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		nbr5.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		
		agent.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		logout.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		decision.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		accueil.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		
		JPanel paneG=new JPanel(new BorderLayout());
		
		JLabel titre = new JLabel("<HTML><U>Bienvenue dans l'interface UA !</U></HTML>",JLabel.CENTER);
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
				
		

		
		Border border = accueil.getBorder();
		Border margin = new EmptyBorder(40,40,20,20);
		
		accueil.setBorder(new CompoundBorder(border, margin));
		agent.setBorder(new CompoundBorder(border, margin));
		logout.setBorder(new CompoundBorder(border, margin));
		decision.setBorder(new CompoundBorder(border, margin));
		
	
		
		
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
		agent.addMouseListener(this);
		decision.addMouseListener(this);
		logout.addMouseListener(this);
		
		
		//this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(Login.getConnUA())
		{
			new Home_UA();
		}
		else {
			new Login();
		}
		
		
	}

	public void mouseClicked(MouseEvent arg0) {

		Object object =arg0.getSource();
		if((JLabel)object == accueil)
		{
			setVisible(false);
			new Home_UA();
		}
		
		
		else if((JLabel)object ==agent)
		{
			setVisible(false);
			new Interface_Agent();;
			
			this.setVisible(false);
		}
		else if((JLabel)object ==decision)
		{
			this.setVisible(false);
			new InterfaceDecision();
		}
		
		else if((JLabel)object ==logout)
		{
			this.setVisible(false);
			Login.setConnUA();
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
