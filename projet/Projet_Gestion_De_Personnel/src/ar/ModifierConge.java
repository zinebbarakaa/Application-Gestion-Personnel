package ar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.toedter.calendar.JDateChooser;

import login.Connexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tables.*;


public class ModifierConge extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel Agent,type,dateDebut,dateFin;

	JTextField AgentValue,typeValue;

	

	JDateChooser dateDebutValue;
	JDateChooser dateFinValue;

	Conge conge=InterfaceConge.Conge;
	Agent agent = InterfaceConge.agent;
	
	
	JButton mod;
	//Agent agent=InterfaceAgent.agent;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public ModifierConge()
	{
		setTitle("Modifier Conge");
		setSize(1000,600);
		Container c=getContentPane();
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Modifier</U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		Agent=new JLabel("Agent  :");
		Agent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		Agent.setForeground(new Color(18,118,189));
		pane2.add(Agent);
		
		AgentValue=new JTextField();
		AgentValue.setText(agent.getNomAgent()+" "+agent.getPrenomAgent());
		AgentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		AgentValue.setBorder(lineBorder );
		pane2.add(AgentValue);
		
		type=new JLabel("Type  : ");
		type.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		type.setForeground(new Color(18,118,189));
		pane2.add(type);
		
		typeValue=new JTextField();
		typeValue.setText(conge.getTypeConge());
		typeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		typeValue.setBorder(lineBorder );
		pane2.add(typeValue);
		
		
		dateDebut=new JLabel("Date Debut  :");
		dateDebut.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateDebut.setForeground(new Color(18,118,189));
		pane2.add(dateDebut);
		
		dateDebutValue =new JDateChooser();
		//dateValue.get
		dateDebutValue.setDateFormatString("YYYY-MM-dd");
		dateDebutValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		dateDebutValue.setBorder(lineBorder );
		pane2.add(dateDebutValue);
		
		dateFin=new JLabel("Date Fin  :");
		dateFin.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateFin.setForeground(new Color(18,118,189));
		pane2.add(dateFin);
		
		dateFinValue =new JDateChooser();
		//dateValue.get
		dateFinValue.setDateFormatString("YYYY-MM-dd");
		dateFinValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		dateFinValue.setBorder(lineBorder );
		pane2.add(dateFinValue);
		
		
		Border border = pane1.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane1.setBorder(new CompoundBorder(border, margin));
		pane2.setBorder(new CompoundBorder(border, margin));
		
	
		
		
		
		mod=new JButton("Modifier");
		mod.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
		mod.setBorder(new CompoundBorder(border, margin));
		mod.addActionListener(this);
		JPanel pane3=new JPanel();
		pane3.add(mod);
		
		
		
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
		
		if(arg0.getSource()==mod)
		{
			String 
					typeV=typeValue.getText(),
				
					dateDebutV=((JTextField)dateDebutValue.getDateEditor().getUiComponent()).getText(),
					dateFinV=((JTextField)dateFinValue.getDateEditor().getUiComponent()).getText();

		if(typeV.equals("")|| dateDebutV.equals("")||dateFinV.equals(""))
		{
			JOptionPane.showMessageDialog(null, "SVP! remplir tous les données");
		}
			
		else
		{
			
            try {
            	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-mm-dd");
				Date date1 = sdformat.parse(dateDebutV);
				Date date2 = sdformat.parse(dateFinV);
				if(date1.compareTo(date2)>0)
				{
					JOptionPane.showMessageDialog(null, "Erreur,La date de debut suprieur a la date de fin");
				}
				else {
					try {
						conn=Connexion.getConnection();
						
						PreparedStatement pst =conn.prepareStatement("UPDATE CONGE SET TYPE_CONGE=? , Date_Debut = ? ,Date_Fin = ? ");
						pst.setString(1, typeV);
						pst.setString(2, dateDebutV);
						pst.setString(3, dateFinV);
						pst.executeUpdate();
					
						int n=0;
						n=pst.executeUpdate();
						System.out.println(n);
						
							JOptionPane.showMessageDialog(null, "L'agent est bien modifié");
							setVisible(false);
							new InterfaceConge();
						
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
					
				
			
			
		}
		
		
	}


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new ModifierConge();

	}

	
	
}
