package ar;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import login.Connexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import tables.*;
public class InfoQualification extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nomagent,Description,dateQualif,nomagentValue,DescriptionValue,dateQualifValue;
	JButton sup,mod;
	static Agent agent=InterfaceQualification.agent;
	static Qualification qualification=InterfaceQualification.qualification;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public InfoQualification()
	{
		setTitle("Qualification");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel nom_prenom=new JLabel("<html><U>"+agent.getNomAgent()+" "+agent.getPrenomAgent()+"</U></html>",JLabel.CENTER);
		nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		
		pane1.add(nom_prenom,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(3,4,40,40));
		nomagent=new JLabel("Agent :");
		nomagent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomagent.setForeground(new Color(18,118,189));
		pane2.add(nomagent);
		
		nomagentValue=new JLabel(agent.getNomAgent()+" "+agent.getPrenomAgent());
		nomagentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomagentValue);
		
		Description=new JLabel("Description  du qualification: ");
		Description.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		Description.setForeground(new Color(18,118,189));
		pane2.add(Description);
		
		DescriptionValue=new JLabel(qualification.getDescription());
		DescriptionValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(DescriptionValue);
		
		dateQualif=new JLabel("Date du qualification :");
		dateQualif.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateQualif.setForeground(new Color(18,118,189));
		pane2.add(dateQualif);
		
		dateQualifValue=new JLabel(String.format("%1$tY-%1$tm-%1$td",qualification.getDate_qualification()));
		dateQualifValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateQualifValue);
		
				

		
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		JPanel pane3=new JPanel(new GridLayout(1,2,30,30));
		mod=new JButton("Modifier");
		mod.setIcon(new ImageIcon("mod.png"));
		mod.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		mod.setBorder(new CompoundBorder(border, margin));
		mod.addActionListener(this);
		pane3.add(mod);
		
		sup=new JButton("Supprimer");
		sup.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		sup.setBorder(new CompoundBorder(border, margin));
		sup.addActionListener(this);
		pane3.add(sup);
		
	
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
		if(arg0.getSource()==mod)
		{
			setVisible(false);
			new ModifierQualification();
		}
		else if(arg0.getSource()==sup)
		{	conn=Connexion.getConnection();
			try {
				
				
					int valide=JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette qualification "+ agent.getNomAgent() +" "+agent.getPrenomAgent());
					if(valide==0)
					{
						String req="DELETE FROM qualification WHERE Id_QAULIFICATION="+qualification.getIdQualification();
						System.out.println(qualification.getIdQualification());
							st=conn.createStatement();
							st.executeUpdate(req);
							JOptionPane.showMessageDialog(null, "La qualification de "+agent.getNomAgent()+" "+agent.getPrenomAgent()+" est bien supprimer");
							setVisible(false);
							new InterfaceQualification();
						
					}
					
					
			 
			}
		catch( SQLException e)
			{
			e.printStackTrace();
		}
			
		}
		
		
		
	}


	public static void main(String[] args) {
	
		if(agent==null || qualification==null)
		{
			new InterfaceDiplome();
		}
		else
		{
			new InfoQualification();
		}
				

	}

	
	
}
