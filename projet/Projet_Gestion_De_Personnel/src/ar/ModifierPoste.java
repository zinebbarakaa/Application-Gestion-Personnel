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


public class ModifierPoste extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel nomPoste,gradePoste,salairePoste;

	JTextField salairePosteValue,situationFValue,gradePosteValue,nomPosteValue;

	


	
	JButton mod;
	static Agent agent=InfoDiplome.agent;
	static Diplome diplome =InfoDiplome.diplome;
	static Poste poste=InterfacePoste.post;
	static UA ua=InterfacePoste.ua;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public ModifierPoste()
	{
		setTitle("Modifier Poste");
		setSize(1000,600);
		Container c=getContentPane();
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Modifier </U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		nomPoste=new JLabel("Nom Poste :");
		nomPoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomPoste.setForeground(new Color(18,118,189));
		pane2.add(nomPoste);
		
		nomPosteValue=new JTextField();
		nomPosteValue.setText(poste.getNomPoste());
		nomPosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomPosteValue.setBorder(lineBorder );
		pane2.add(nomPosteValue);
		
		gradePoste=new JLabel(" poste");
		gradePoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		gradePoste.setForeground(new Color(18,118,189));
		pane2.add(gradePoste);
		
		gradePosteValue=new JTextField();
		gradePosteValue.setText(poste.getGradePoste());
		gradePosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		gradePosteValue.setBorder(lineBorder );
		pane2.add(gradePosteValue);
		
		salairePoste=new JLabel("Saliare:");
		salairePoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		salairePoste.setForeground(new Color(18,118,189));
		pane2.add(salairePoste);
		
		salairePosteValue=new JTextField();
		salairePosteValue.setText(String.valueOf(poste.getSalaire()));
		salairePosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		salairePosteValue.setBorder(lineBorder );
		pane2.add(salairePosteValue);
		
		
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
			String nomPostev=nomPosteValue.getText(),
					gradePostev=gradePosteValue.getText(),
					salairePostev=salairePosteValue.getText();
		
					

			
		if(nomPostev.equals("")|| gradePostev.equals("")|| salairePostev.equals(""))
		{
			JOptionPane.showMessageDialog(null, "SVP! remplir tous les données");
		}
		else
		{
			try {
				conn=Connexion.getConnection();
				String req="UPDATE POSTE SET Nom_POSTE='"+nomPostev+"', Grade_POSTE='"+gradePostev+"',Salaire='"+salairePostev+"' "
						+ "WHERE Id_POSTE="+poste.getIdPoste();
				
				st=conn.createStatement();
				st.executeUpdate(req);
			
				int n=st.executeUpdate(req);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "Le poste est bien modifié");
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
		if(poste==null || ua==null)
		{
		
			new InterfacePoste();
		}
		else
		{
			new ModifierPoste();
		}

	}

	
	
}
