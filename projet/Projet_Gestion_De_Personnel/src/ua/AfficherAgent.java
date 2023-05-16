package ua;


import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import tables.Agent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class AfficherAgent extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lbv1,lbv2,lbv3,lbv4,lbv5,lbv6,lbv7,lbv8,nom_prenom;
	JButton valider,next;	
	JComboBox<String> jc;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	Agent agent= Interface_Agent.Agent;
	public AfficherAgent()
	{
		setTitle("Decision");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		nom_prenom=new JLabel("<html><U>"+agent.getPrenomAgent()+" "+agent.getNomAgent()+"</U></html>",JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		lb1=new JLabel("Nom :");
		lb1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb1.setForeground(new Color(18,118,189));
		pane2.add(lb1);
		
		
		lbv1=new JLabel(agent.getNomAgent());
		lbv1.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv1);
		
		lb2=new JLabel("Prenom  :");
		lb2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb2.setForeground(new Color(18,118,189));
		pane2.add(lb2);
		
		lbv2=new JLabel(agent.getPrenomAgent());
		lbv2.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv2);
		
		lb3=new JLabel("CIN :");
		lb3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb3.setForeground(new Color(18,118,189));
		pane2.add(lb3);
		
		lbv3=new JLabel(agent.getCIN());
		lbv3.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv3);
		

		lb4=new JLabel("Date de naissance:");
		lb4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb4.setForeground(new Color(18,118,189));
		pane2.add(lb4);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		lbv4=new JLabel(dateFormat.format(agent.getNaissAgent()));
		lbv4.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv4);
		
		
		lb5=new JLabel("Tele :");
		lb5.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb5.setForeground(new Color(18,118,189));
		pane2.add(lb5);
		
		lbv5=new JLabel(agent.getTelAgent());
		lbv5.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv5);
		
		lb6=new JLabel("Email  :");
		lb6.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb6.setForeground(new Color(18,118,189));
		pane2.add(lb6);
		
		lbv6=new JLabel(agent.getEmailAgent());
		lbv6.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv6);
		
		lb7=new JLabel("Situation Familiale : ");
		lb7.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb7.setForeground(new Color(18,118,189));
		pane2.add(lb7);
		
		lbv7=new JLabel(agent.getSituationFAgent());
		lbv7.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv7);
		
		lb8=new JLabel("Adresse : ");
		lb8.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		lb8.setForeground(new Color(18,118,189));
		pane2.add(lb8);
		
		lbv8=new JLabel(agent.getAdresseAgent());
		lbv8.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(lbv8);
		
		
		

		
		
		//pane2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	    next=new JButton("Suivant");
		next.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		next.setBorder(new CompoundBorder(border, margin));
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new InfoAgent();
				
				
			}
		});
		JPanel pane3=new JPanel();
		pane3.add(next);
		
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


	


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new AfficherAgent();

	}
	

	
	
}

