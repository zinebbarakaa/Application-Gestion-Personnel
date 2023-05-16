package ar;

import javax.swing.*;


import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


import login.Connexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import tables.*;


public class AjouterPoste extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nomPoste,gradePoste,UA,salairePoste;

	JTextField gradePosteValue,nomPosteValue,UAValue,salairePosteValue;
	static UA au=InterfacePoste.ua; 

	
	
	JButton add;
	//Agent agent=InterfaceAgent.agent;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public AjouterPoste()
	{
		setTitle("Ajouter Poste");
		setSize(1000,400);
		Container c=getContentPane();
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Ajouter nouveau poste</U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(2,2,40,40));
		nomPoste=new JLabel("Nom du poste  :");
		nomPoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomPoste.setForeground(new Color(18,118,189));
		pane2.add(nomPoste);
		
		nomPosteValue=new JTextField();
		nomPosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomPosteValue.setBorder(lineBorder );
		pane2.add(nomPosteValue);
		
		gradePoste=new JLabel("Grade du poste: ");
		gradePoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		gradePoste.setForeground(new Color(18,118,189));
		pane2.add(gradePoste);
		
		gradePosteValue=new JTextField();
		gradePosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		gradePosteValue.setBorder(lineBorder );
		pane2.add(gradePosteValue);
		
		salairePoste=new JLabel("Salaire du poste :");
		salairePoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		salairePoste.setForeground(new Color(18,118,189));
		pane2.add(salairePoste);
		
		salairePosteValue=new JTextField();
		salairePosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		salairePosteValue.setBorder(lineBorder );
		pane2.add(salairePosteValue);
		
		UA=new JLabel("Unité d'affectation :");
		UA.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		UA.setForeground(new Color(18,118,189));
		pane2.add(UA);
		
		
		
		UAValue=new JTextField();
		UAValue.setText(au.getNomAU());
		UAValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		UAValue.setBorder(lineBorder );
		pane2.add(UAValue);
		
		
		
		
		
		
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
			String nomPostev=nomPosteValue.getText(),
					gradePostev=gradePosteValue.getText(),
					UAv=UAValue.getText(),
					salairePostev=salairePosteValue.getText();
		
			//System.out.println(UAv);
					
	if(nomPostev.equals("") || gradePostev.equals("")|| salairePostev.equals("") || UAv.equals("") || UAv.equals(""))
		{
			
			JOptionPane.showMessageDialog(null, "SVP! Remplir tous les données");

			
		}
		
		else {
						
			try {
				conn=Connexion.getConnection();
				
				String req="INSERT INTO POSTE (	Nom_POSTE,Grade_POSTE,Salaire,Status_POSTE,Id_UA)"
						+ " VALUES('"+nomPostev+"','"+gradePostev+"','"+String.valueOf(salairePostev)+"',0,'"+au.getIdUA()+"')";
				
				st=conn.createStatement();
				int n=st.executeUpdate(req);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "Le poste est bien ajouté");
					setVisible(false);
					new InterfacePoste();
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
					
		
			
			
		}
		
		
	}


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new AjouterPoste();

	}

	
	
}

