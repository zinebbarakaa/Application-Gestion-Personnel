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



public class AjouterGrade extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nomagent ,nomGrade,specialite,dateObtGrade,Etab,mention;
	JTextField specialiteValue,situationFValue,nomGradeValue,nomagentValue,EtabValue,mentionValue;

	JDateChooser dateObtGradeValue;
	
	JButton add;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	static Agent agent=InterfaceGrade.agent;
	public AjouterGrade()
	{
		setTitle("Agent");
		setSize(1200,500);
		Container c=getContentPane();
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Ajouter un nouveau grade</U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(3,2,40,40));
		nomagent=new JLabel("Agent  :");
		nomagent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomagent.setForeground(new Color(18,118,189));
		pane2.add(nomagent);
		
		
		
		nomagentValue=new JTextField();
		nomagentValue.setText(agent.getNomAgent()+" "+agent.getPrenomAgent());
		nomagentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomagentValue);
		
		nomGrade=new JLabel("Nom du Grade : ");
		nomGrade.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomGrade.setForeground(new Color(18,118,189));
		pane2.add(nomGrade);
		
		nomGradeValue=new JTextField();
		nomGradeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomGradeValue.setBorder(lineBorder );
		pane2.add(nomGradeValue);
		
		dateObtGrade=new JLabel("Date Obtention  :");
		dateObtGrade.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateObtGrade.setForeground(new Color(18,118,189));
		pane2.add(dateObtGrade);
		
		dateObtGradeValue=new JDateChooser();// convertir dateObtDip en string
		dateObtGradeValue.setDateFormatString("YYYY-MM-dd");
		dateObtGradeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateObtGradeValue);
		

		
		
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
					nomGradev=nomGradeValue.getText(),
					dateobtv=((JTextField)dateObtGradeValue.getDateEditor().getUiComponent()).getText();
	
						

					
			if(nomagentv.equals("") || nomGradev.equals("")||  dateobtv.equals("")  )
			{
			
			JOptionPane.showMessageDialog(null, "SVP! Remplir tous les données");

			
			}
		
			else {
		
				
			try {
				conn=Connexion.getConnection();
				
				
				String req="INSERT INTO `grade` (`Id_GRADE`, `Id_AGENT`, `Nom_GRADE`, `Date_GRADE`) VALUES (NULL, '"+agent.getIdAgent()+"', '"+nomGradev+"', '"+dateobtv+"')";
				
				st=conn.createStatement();
				int n=st.executeUpdate(req);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "Grade est bien ajouté");
					setVisible(false);
					new InterfaceGrade();
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
					
		
			
			
		}
		
		
	}


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		if(InterfaceGrade.agent==null)
		{
			new InterfaceGrade();
		}
		else {
		
			new AjouterGrade();
		

		}

	}
	
}
