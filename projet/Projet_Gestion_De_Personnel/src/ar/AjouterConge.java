package ar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.toedter.calendar.JDateChooser;

import login.Connexion;
import tables.Agent;

public class AjouterConge  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel nomagent,TypeConge,dateD,dateF;
	JTextField nomagentValue;
	JComboBox<String> TypeCongeValue;
	JButton valide;
	private JDateChooser dateDValue,dateFValue;
	static Connection conn=null;
	static Statement st=null,st1=null,st2=null;
	static ResultSet rs=null;
	static Agent agent=InterfaceConge.agent;
			
	

	public AjouterConge()
	{
		setVisible(true);
		setSize(800,600);
		Container c=getContentPane();
		setLocationRelativeTo(null);
		JPanel paneG=new JPanel(new BorderLayout());
		JLabel titre= new JLabel("<HTML><U>Ajouter un nouveau Conge</U></HTML>",JLabel.CENTER);
		titre.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		titre.setBackground(new Color(245,245,245));
		paneG.add(titre,BorderLayout.NORTH);
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);

		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		nomagent=new JLabel("Agent :");
		nomagent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomagent.setForeground(new Color(18,118,189));
		pane2.add(nomagent);
		
		nomagentValue=new JTextField(agent.getNomAgent()+" "+agent.getPrenomAgent());
		nomagentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomagentValue.setBorder(lineBorder );
		pane2.add(nomagentValue);
		
		
		TypeConge=new JLabel("Type Conge :");
		TypeConge.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		TypeConge.setForeground(new Color(18,118,189));
		pane2.add(TypeConge);
		
		String conge[] ={"-Selectioner-","MALADIE","MATERNITE","ANNUEL"};
		TypeCongeValue=new JComboBox<String>(conge);
		TypeCongeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		TypeCongeValue.setBorder(lineBorder );
		pane2.add(TypeCongeValue);
		
		dateD = new JLabel("Date Debut  :");
		dateD.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateD.setForeground(new Color(18,118,189));
		pane2.add(dateD);
		
		dateDValue=new JDateChooser();// convertir dateD en string
		dateDValue.setDateFormatString("YYYY-MM-dd");
		dateDValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		dateDValue.setBorder(lineBorder );
		pane2.add(dateDValue);
		
		dateF = new JLabel("Date Fin  :");
		dateF.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateF.setForeground(new Color(18,118,189));
		pane2.add(dateF);
		
		dateFValue=new JDateChooser();// convertir dateF en string
		dateFValue.setDateFormatString("YYYY-MM-dd");
		dateFValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		dateFValue.setBorder(lineBorder );
		pane2.add(dateFValue);
		
		
		
		
		
		Border border = pane2.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane2.setBorder(new CompoundBorder(border, margin));
		paneG.setBorder(new CompoundBorder(border, margin));
		nomagent.setBorder(new CompoundBorder(border, margin));
		nomagentValue.setBorder(new CompoundBorder(border, margin));
		TypeConge.setBorder(new CompoundBorder(border, margin));
		TypeCongeValue.setBorder(new CompoundBorder(border, margin));
		dateD.setBorder(new CompoundBorder(border, margin));
		//dateDValue.setBorder(new CompoundBorder(border, margin));
		dateF.setBorder(new CompoundBorder(border, margin));
		//dateFValue.setBorder(new CompoundBorder(border, margin));
		
		
		paneG.add(pane2,BorderLayout.CENTER);
		valide=new JButton("Ajouter");
		valide.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		valide.setBorder(new CompoundBorder(border, margin));
		valide.setPreferredSize(new Dimension(100,50));
		valide.addActionListener(this);
		JPanel pane3=new JPanel();
		pane3.add(valide);
		paneG.add(pane3,BorderLayout.SOUTH);
		
		c.add(paneG);
	}
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
			new AjouterConge();
		
	

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==valide)
		{
			String nomv=nomagentValue.getText(),
					typeCongev=(String) TypeCongeValue.getSelectedItem(),
							dateDv=((JTextField)dateDValue.getDateEditor().getUiComponent()).getText(),
							dateFv=((JTextField)dateFValue.getDateEditor().getUiComponent()).getText();
			

			if(nomv.equals("") || typeCongev.equals("-selectioner-") || dateDv.equals("") || dateFv.equals(""))
			{
				
				JOptionPane.showMessageDialog(null, "SVP! Remplir tous les données");

				
			}
			
			else {
				if(dateDv.compareTo(dateFv)>0)
				{
					JOptionPane.showMessageDialog(null, "Erreur,La date de debut suprieur a la date de fin");
				}
				else {
					
				
				try {
					conn=Connexion.getConnection();
					
					PreparedStatement pst=conn.prepareStatement("SELECT max(Date_Fin) From agent,conge where agent.Id_AGENT = conge.Id_AGENT AND CIN_AGENT = ?");
					pst.setString(1, agent.getCIN());
					ResultSet rs =pst.executeQuery();
					SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-mm-dd");
		            Date date1 = sdformat.parse(dateDv);
		            rs.next();
					if(rs.getString(1)!=null)
						{
						if(rs.getDate(1).compareTo(date1)>0)
							{
							
							JOptionPane.showMessageDialog(null, "L'agent est en Conge entre "+dateDv+"et "+rs.getDate(1));
							}
					
					
						else 
						{
							String req1="INSERT INTO `conge` (`Id_CONGE`, `Id_AGENT`, `TYPE_CONGE`, `Date_Debut`, `Date_Fin`) VALUES (NULL, "+agent.getIdAgent()+", '"+typeCongev+"', '"+dateDv+"', '"+dateFv+"');";
					
							st2=conn.createStatement();
					
							int n=st2.executeUpdate(req1);
					
							if(n==1)
							{
								JOptionPane.showMessageDialog(null, "Le Congé est bien ajouté ");
								setVisible(false);
								new InterfaceConge();
							}
					}
						
						
					}
					else
					{
					
					
					
						String req1="INSERT INTO `conge` (`Id_CONGE`, `Id_AGENT`, `TYPE_CONGE`, `Date_Debut`, `Date_Fin`) VALUES (NULL, "+agent.getIdAgent()+", '"+typeCongev+"', '"+dateDv+"', '"+dateFv+"');";
						
						st2=conn.createStatement();
						
						int n=st2.executeUpdate(req1);
						
						if(n==1)
						{
							JOptionPane.showMessageDialog(null, "Le Conge est bien ajoute");
							setVisible(false);
							new InterfaceConge();
						}
					
					
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			}
			
					
		}
		
	}

}
