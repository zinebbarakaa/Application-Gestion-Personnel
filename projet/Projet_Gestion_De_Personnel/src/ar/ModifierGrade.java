package ar;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.toedter.calendar.JDateChooser;

import login.Connexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import tables.*;


public class ModifierGrade extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nomagent,nomGrade,dateGrade;
	JTextField nomagentValue,nomGradeValue;
	JButton mod;
	static Agent agent=InfoGrade.agent;
	static Grade grade=InfoGrade.grade;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	JDateChooser dateGradeValue;
	public ModifierGrade()
	{
		setTitle("Modifier Poste");
		setSize(1000,600);
		Container c=getContentPane();
		
		
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Modifier </U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(3,4,40,40));
		
		nomagent = new JLabel("Agent :");
		nomagent.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomagent.setForeground(new Color(18,118,189));
		pane2.add(nomagent);
		
		nomagentValue=new JTextField(agent.getNomAgent()+" "+agent.getPrenomAgent());
		nomagentValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomagentValue);
		
		nomGrade=new JLabel("Nom du grade : ");
		nomGrade.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomGrade.setForeground(new Color(18,118,189));
		pane2.add(nomGrade);
		
		nomGradeValue = new JTextField(grade.getNomGrade());
		nomGradeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(nomGradeValue);
		
		
		
		dateGrade=new JLabel("Date du grade :");
		dateGrade.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		dateGrade.setForeground(new Color(18,118,189));
		pane2.add(dateGrade);
		
		dateGradeValue=new JDateChooser();
		dateGradeValue.setDateFormatString("YYYY-MM-dd");
		dateGradeValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(dateGradeValue); 
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
			String nomAgent=nomagentValue.getText(),
					nomGradev=nomGradeValue.getText(),
					dateGradev=((JTextField)dateGradeValue.getDateEditor().getUiComponent()).getText();
		
					
			if(nomAgent.equals("")|| nomGradev.equals("")|| dateGradev.equals("") )
			{
				JOptionPane.showMessageDialog(null, "SVP! remplir tous les données");
			}
			
					
			
			else 

			{
			try {
				conn=Connexion.getConnection();
				String req="UPDATE Grade SET Grade.Nom_GRADE='"+nomGradev+"', Grade.Date_Grade='"+dateGradev+"' WHERE Id_GRADE="+grade.getIdGrade();
				
				st=conn.createStatement();			
				int n=st.executeUpdate(req);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "Le grade est bien modifié");
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
		if(agent==null || grade==null)
		{
		
			new InterfaceGrade();
		}
		else
		{
			new ModifierGrade();
		}

	}

	
	
}
