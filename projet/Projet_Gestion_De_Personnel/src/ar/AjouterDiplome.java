package ar;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.toedter.calendar.JDateChooser;

import login.Connexion;
import tables.Agent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class AjouterDiplome extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nomagent ,nomDip,specialite,dateObtDip,Etab,mention;
	JTextField specialiteValue,nomDipValue,EtabValue,mentionValue,nomagentValue;

	JDateChooser dateObtDipValue;
	static Agent agent=InterfaceDiplome.agent;
	
	JButton add;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public AjouterDiplome()
	{
		setTitle("Ajouter Diplome");
		setSize(1200,500);
		Container c=getContentPane();
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Ajouter un nouveau Diplome</U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(3,4,40,40));
		nomagent=new JLabel("Agent :");
		nomagent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomagent.setForeground(new Color(18,118,189));
		pane2.add(nomagent);
		
		nomagentValue=new JTextField();
		nomagentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomagentValue.setText(agent.getNomAgent()+" "+agent.getPrenomAgent());
		pane2.add(nomagentValue);
		
		nomDip=new JLabel("Nom Diplome : ");
		nomDip.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomDip.setForeground(new Color(18,118,189));
		pane2.add(nomDip);
		
		nomDipValue=new JTextField();
		nomDipValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomDipValue.setBorder(lineBorder );
		pane2.add(nomDipValue);
		
		dateObtDip=new JLabel("Date Obtention  :");
		dateObtDip.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateObtDip.setForeground(new Color(18,118,189));
		pane2.add(dateObtDip);
		
		dateObtDipValue=new JDateChooser();// convertir dateObtDip en string
		dateObtDipValue.setDateFormatString("YYYY-MM-dd");
		dateObtDipValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateObtDipValue);
		
		specialite=new JLabel("Spécialité :");
		specialite.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		specialite.setForeground(new Color(18,118,189));
		pane2.add(specialite);
		
		specialiteValue=new JTextField();
		specialiteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		specialiteValue.setBorder(lineBorder );
		pane2.add(specialiteValue);
		
		
		
		Etab=new JLabel("Etablisement  : ");
		Etab.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		Etab.setForeground(new Color(18,118,189));
		pane2.add(Etab);
		
		EtabValue=new JTextField();
		EtabValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		EtabValue.setBorder(lineBorder );
		pane2.add(EtabValue);
		
		mention=new JLabel("Mention  : ");
		mention.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		mention.setForeground(new Color(18,118,189));
		pane2.add(mention);
		
		mentionValue=new JTextField();
		mentionValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		mentionValue.setBorder(lineBorder );
		pane2.add(mentionValue);
		

		
		
		
		
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		
		
		
		add=new JButton("Ajouter");
		add.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		add.setBorder(new CompoundBorder(border, margin));
		add.addActionListener(this);
		JPanel pane3=new JPanel();
		pane3.add(add);
		
		
		
		pane1.setBackground(new Color(245,245,245));
		pane2.setBackground(new Color(245,245,245));
		pane3.setBackground(new Color(245,245,245));
		c.setBackground(new Color(245,245,245));
		

		((JComponent) c).setBorder(new CompoundBorder(border, margin));
		
		c.add(pane1,BorderLayout.NORTH);
		c.add(pane2,BorderLayout.CENTER);
		c.add(pane3,BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==add)
		{
			String nomagentv=nomagentValue.getText(),
					nomDipv=nomDipValue.getText(),
					specialitev=specialiteValue.getText(),
					mentionv=mentionValue.getText(),
					Etabv=EtabValue.getText(),
					dateobtv=((JTextField)dateObtDipValue.getDateEditor().getUiComponent()).getText();
					
			if(nomagentv.equals("") || nomDipv.equals("")|| specialitev.equals("") || mentionv.equals("") || Etabv.equals("") || dateobtv.equals("")  )
			{
			
			JOptionPane.showMessageDialog(null, "SVP! Remplir tous les données");

			
			}
		
		else {
		
			try {
				conn=Connexion.getConnection();
				
				
				PreparedStatement ps=conn.prepareStatement("INSERT INTO `diplome` (`Id_AGENT`, `Nom_DIPLOME`, `Date_Obtention`, `Spacialite_DIPLOME`, `Etablisssement`, `Mention_DIPLOME`) VALUES"
						+ "(?,?,?,?,?,?);");
				ps.setInt(1, agent.getIdAgent());
				ps.setString(2, nomDipv);
				ps.setString(3, dateobtv);
				ps.setString(4, specialitev);
				ps.setString(5, Etabv);
				ps.setString(6, mentionv);
				int n=ps.executeUpdate();
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "Diplome est bien ajouté");
					setVisible(false);
					new InterfaceDiplome();
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
			
		}
		
		
	}


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(agent==null)
		{
			new InterfaceDiplome();
		}
		else {
		new AjouterDiplome();
		}

	}

	
	
}
