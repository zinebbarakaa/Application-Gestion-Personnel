package scf;


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
import tables.*;



public class Interface_scf extends JFrame implements ActionListener,MouseListener{
	
	
	private static final long serialVersionUID = 1L;
	JLabel accueil,logout;
	JTextField search;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	static JTable table;
	int index;
    JButton btn_search,sync;
	static Dicision decision;
	static Admis admis;
	static Poste poste;

	
	

	public Interface_scf()
	{
		super("Decision");
		setSize(1200,690);	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container paneau= getContentPane();
		// le menu
		JPanel menu=new JPanel();
		menu.setLayout(new GridLayout(4,1,170,170));
		
		accueil=new JLabel("Accueil");
		accueil.setIcon(new ImageIcon("images/home.png"));
		
		logout=new JLabel("Déconnecter");
		logout.setIcon(new ImageIcon("images/logout.png"));
		
		// le curseur sur les elements du menu
		accueil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		accueil.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		logout.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		
		
		
		Border border = accueil.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		accueil.setBorder(new CompoundBorder(border, margin));
		logout.setBorder(new CompoundBorder(border, margin));
		
		
		
		menu.add(accueil,BorderLayout.NORTH);
		menu.add(logout,BorderLayout.SOUTH);
		menu.setPreferredSize(new Dimension(200,680));
		menu.setBackground(new Color(173,216,230));
		
		accueil.addMouseListener(this);
		logout.addMouseListener(this);
		
		JPanel paneG=new JPanel(new BorderLayout());
		paneG.setBorder(new CompoundBorder(border, margin));
		
		JLabel titre = new JLabel("<HTML><U>Gestion des decision!</U></HTML>",JLabel.CENTER);
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
			String req ="SELECT CIN_ADMIS,Nom_ADMIS,Prenom_Admis,Nom_POSTE,Date_Prev,Visa"
					+ "  FROM decision,poste,admis WHERE decision.Id_POSTE=poste.Id_POSTE AND decision.Id_ADMIS=admis.Id_ADMIS ;";
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
		
		
		table.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				try {
					conn=login.Connexion.getConnection();
					int index=table.getSelectedRow();
					String id = table.getModel().getValueAt(index,0).toString();
					 
					PreparedStatement pst= conn.prepareStatement("select CIN_ADMIS,Nom_ADMIS,Prenom_Admis,Nom_POSTE,Date_Prev,Visa "
							+ "from decision ,poste,admis where  decision.Id_Poste=poste.Id_Poste AND decision.Id_ADMIS= admis.Id_ADMIS AND Visa NOT LIKE 'Accepte' AND CIN_ADMIS=? ;" );
					pst.setString(1, id);
					
					rs=pst.executeQuery();
					
							AfficherDecision2 a=new AfficherDecision2();
							rs.next();

							a.lbv3.setText(rs.getString("CIN_ADMIS"));
							a.lbv4.setText(rs.getString("Nom_ADMIS"));
							a.lbv5.setText(rs.getString("Prenom_ADMIS"));
							a.lbv6.setText(rs.getString("Nom_POSTE"));
							a.lbv7.setText(rs.getString("Date_Prev"));
							a.nom_prenom.setText("<html><U>"+rs.getString("Nom_ADMIS")+" "+rs.getString("Prenom_ADMIS")+"</U></html>");
							
							
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
				
			}
		});
		
	
		
		
		setVisible(true);
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(Login.getConnSCF())
		{
			new Interface_scf();
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
			new Interface_scf();
		}
		
		else if((JLabel)object ==logout)
		{
			setVisible(false);
			Login.getConnSCF(); 
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
				JOptionPane.showMessageDialog(null, "Veuillez saisir un CIN");
			}
			else {
			try {
				
				conn=login.Connexion.getConnection();
				
				PreparedStatement af=conn.prepareStatement("SELECT CIN_ADMIS,Nom_ADMIS,Prenom_ADMIS, poste.Nom_POSTE,Date_Prev,Visa"
						+" FROM decision,poste,admis WHERE decision.Id_POSTE=poste.Id_POSTE AND decision.Id_ADMIS=admis.Id_ADMIS AND CIN_ADMIS=?;");
				af.setString(1, text);
				ResultSet rst =af.executeQuery();
				
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
				
				PreparedStatement af=conn.prepareStatement("select CIN_ADMIS,Nom_ADMIS,Prenom_ADMIS, poste.Nom_POSTE,Date_Prev,Visa "
						+ "from decision ,poste,admis where  decision.Id_Poste=poste.Id_Poste AND decision.Id_ADMIS= admis.Id_ADMIS ;");
				ResultSet rst =af.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rst));
				
				}
				catch(Exception e1)
				{
					System.out.println("erreur lors de l'affichage "+e1);
				
				}
		}
		
	}


		
	}

