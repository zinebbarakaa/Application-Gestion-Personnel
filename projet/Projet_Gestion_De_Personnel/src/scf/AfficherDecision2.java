package scf;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import login.Connexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class AfficherDecision2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lbv1,lbv2,lbv3,lbv4,lbv5,lbv6,lbv7,nom_prenom;
	JButton valider;	
	JComboBox<String> jc;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public AfficherDecision2()
	{
		setTitle("Decision");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		//JLabel nom_prenom=new JLabel("<html><U>"+"fatima"+" "+" mereme"+"</U></html>",JLabel.CENTER);
		 nom_prenom=new JLabel("",JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(3,2,40,40));
		/*lb1=new JLabel("Id_Poste :");
		lb1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb1.setForeground(new Color(18,118,189));
		pane2.add(lb1);
		
		//nomValue=new JLabel(admis.getNomAdmis());
		lbv1=new JLabel("");
		lbv1.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv1);
		
		lb2=new JLabel("Id_Admis  :");
		lb2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb2.setForeground(new Color(18,118,189));
		pane2.add(lb2);
		
		//=new JLabel(admis.getPrenomAdmis());
		lbv2=new JLabel("");
		lbv2.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv2);*/
		
		lb3=new JLabel(" CIN :");
		lb3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb3.setForeground(new Color(18,118,189));
		pane2.add(lb3);
		
		//CINValue=new JLabel(admis.getCIN());
		lbv3=new JLabel("");
		lbv3.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv3);
		

		lb4=new JLabel("Nom_Admis  :");
		lb4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb4.setForeground(new Color(18,118,189));
		pane2.add(lb4);
		
		//CINValue=new JLabel(admis.getCIN());
		lbv4=new JLabel("");
		lbv4.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv4);
		
		
		lb5=new JLabel("Prenom_Admis  :");
		lb5.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb5.setForeground(new Color(18,118,189));
		pane2.add(lb5);
		
		//dateValue=new JLabel(String.format("%1$tY-%1$tm-%1$td",admis.getNaissAdmis()));
		lbv5=new JLabel("");// convertir date en string
		lbv5.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv5);
		
		lb6=new JLabel("Poste  :");
		lb6.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb6.setForeground(new Color(18,118,189));
		pane2.add(lb6);
		
		//dateValue=new JLabel(String.format("%1$tY-%1$tm-%1$td",admis.getNaissAdmis()));
		lbv6=new JLabel("");// convertir date en string
		lbv6.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv6);
		
		lb7=new JLabel(" Date Previsionnelle : ");
		lb7.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb7.setForeground(new Color(18,118,189));
		pane2.add(lb7);
		
		//telValue=new JLabel(admis.getTelAdmis());
		lbv7=new JLabel("");
		lbv7.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv7);
		
		lb8=new JLabel("Visa  : ");
		lb8.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb8.setForeground(new Color(18,118,189));
		pane2.add(lb8);
		
		//=new JLabel(admis.getEmailAdmis());
		jc=new JComboBox<String>(new String[]{"-Selécionner-","Accepte","Refuse","attente"});
		
		pane2.add(jc);
		
		

		
		
		//pane2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		JPanel pane3=new JPanel(new GridLayout(1,1,30,30));
		valider=new JButton("Valider",new ImageIcon("mod.png"));
		valider.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		valider.setBorder(new CompoundBorder(border, margin));
		valider.addActionListener(this);
		pane3.add(valider);
		
		
		
		

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
						try {
							
							 
							String  CIN=lbv3.getText();
						    PreparedStatement pst = conn.prepareStatement("UPDATE decision,admis SET Visa = ?  Where decision.Id_ADMIS= admis.Id_ADMIS AND  CIN_ADMIS= ?;");
						    pst.setString(1, status);
						    pst.setString(2, CIN);
						   
						    
							 pst.executeUpdate();
	
							JOptionPane.showMessageDialog(null, " Status Visa du "+lbv4.getText()+" "+lbv5.getText()+" est bien valider");
							new Interface_scf();
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					
					
					
			 
			}
		
		}

	


	public static void main(String[] args) {
		new AfficherDecision2();

	}

	
	
}

