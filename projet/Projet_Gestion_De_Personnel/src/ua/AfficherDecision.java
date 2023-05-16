package ua;


import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import login.Connexion;
import tables.Admis;
import tables.Dicision;
import tables.Poste;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class AfficherDecision extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lbv1,lbv2,lbv3,lbv4,lbv5,lbv6,lbv7,nom_prenom;
	JButton valider;	
	JComboBox<String> jc;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	static Admis admis = InterfaceDecision.admis;
	Poste poste = InterfaceDecision.poste;
	Dicision decision = InterfaceDecision.decision;
	public AfficherDecision()
	{
		setTitle("Decision");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel nom_prenom=new JLabel("<html><U>"+admis.getNomAdmis()+" "+admis.getPrenomAdmis()+"</U></html>",JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		lb1=new JLabel("Nom Admis");
		lb1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb1.setForeground(new Color(18,118,189));
		pane2.add(lb1);
		
		//nomValue=new JLabel(admis.getNomAdmis());
		lbv1=new JLabel(admis.getNomAdmis());
		lbv1.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv1);
		
		lb2=new JLabel("Prenom Admis:");
		lb2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb2.setForeground(new Color(18,118,189));
		pane2.add(lb2);
		
		//=new JLabel(admis.getPrenomAdmis());
		lbv2=new JLabel(admis.getPrenomAdmis());
		lbv2.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv2);
		
		lb3=new JLabel("Visa :");
		lb3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb3.setForeground(new Color(18,118,189));
		pane2.add(lb3);
		
		//CINValue=new JLabel(admis.getCIN());
		lbv3=new JLabel(decision.getVisa());
		lbv3.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv3);
		

		lb4=new JLabel("Date Previsionnelle :");
		lb4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb4.setForeground(new Color(18,118,189));
		pane2.add(lb4);
		
		//CINValue=new JLabel(admis.getCIN());
		DateFormat date = new SimpleDateFormat("yyyy-mm-dd");
		lbv4=new JLabel(date.format(decision.getDatePres()));
		lbv4.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv4);
		
		
		lb5=new JLabel(" CIN Admis :");
		lb5.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb5.setForeground(new Color(18,118,189));
		pane2.add(lb5);
		
		lbv5=new JLabel(admis.getCINAdmis());
		lbv5.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv5);
		
		lb6=new JLabel("Poste :");
		lb6.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb6.setForeground(new Color(18,118,189));
		pane2.add(lb6);
		
		lbv6=new JLabel(poste.getNomPoste());
		lbv6.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv6);
		
		lb7=new JLabel("Email Admis: ");
		lb7.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb7.setForeground(new Color(18,118,189));
		pane2.add(lb7);
		
		lbv7=new JLabel(admis.getEmailAdmis());
		lbv7.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv7);
		
		lb8=new JLabel("Avis de Prise  : ");
		lb8.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb8.setForeground(new Color(18,118,189));
		pane2.add(lb8);
		
		jc=new JComboBox<String>(new String[]{"-Selécionner-","PRISE","NON PRISE"});
		
		pane2.add(jc);
		
		

		
		
		//pane2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		JPanel pane3=new JPanel();
		valider=new JButton("Valider");
		valider.setFont(new Font("Bookman Old Style", Font.BOLD , 10));
		valider.setBorder(new CompoundBorder(border, margin));
		valider.addActionListener(this);
		pane3.add(valider,BorderLayout.SOUTH);
		
		
		
		
		

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
		
		if(arg0.getSource()==valider)
		{	
			conn=Connexion.getConnection();
			String status = (String) jc.getSelectedItem();
			if(status.equals("PRISE"))
			{

				try {
					int idP=decision.getPoste().getIdPoste();
					int idD=decision.getAdmis().getIdAdmis();
	
				    PreparedStatement pst = conn.prepareStatement("UPDATE `decision` SET `Avis_Prise_Fonction` ='"+status+"' WHERE `decision`.`Id_POSTE` ="+idP+" AND `decision`.`Id_ADMIS` ="+idD);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, " Avis de prise de fonction du  "+lbv3.getText()+" est bien valider");
					new InterfaceDecision();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			
			}
					
					
			 
			}
		
		}

	


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new AfficherDecision();

	}

	
	
}

