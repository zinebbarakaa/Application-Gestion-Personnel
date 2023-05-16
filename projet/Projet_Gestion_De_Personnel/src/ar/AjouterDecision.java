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
import java.util.Vector;

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
import tables.*;

public class AjouterDecision  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel nomAdmis,nomPoste,Date_prev;
	JComboBox<String> nomPosteValue;
	JButton valide;
	JDateChooser Date_prevValue;
	static Connection conn=null;
	static Statement st=null,st1=null,st2=null,st3=null;
	static ResultSet rs=null,rs1=null,rs2=null;
	
	JTextField nomAdmisValue;
	static Admis admis=InterfaceDecision.admis;
	static String nomUA=InterfaceDecision.nomUA;
	

	public AjouterDecision()
	{
		setVisible(true);
		setSize(800,500);
		Container c=getContentPane();
		setLocationRelativeTo(null);
		JPanel paneG=new JPanel(new BorderLayout());
		JLabel titre= new JLabel("<HTML><U>Ajouter une Decision </U></HTML>",JLabel.CENTER);
		titre.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		titre.setBackground(new Color(245,245,245));
		paneG.add(titre,BorderLayout.NORTH);
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);

		
		JPanel pane2=new JPanel(new GridLayout(3,2,40,40));
		nomAdmis=new JLabel("Admis :");
		nomAdmis.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomAdmis.setForeground(new Color(18,118,189));
		pane2.add(nomAdmis);
		
	
		nomAdmisValue=new JTextField();
		nomAdmisValue.setText(admis.getNomAdmis()+" "+admis.getPrenomAdmis());
		nomAdmisValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomAdmisValue.setBorder(lineBorder );
		pane2.add(nomAdmisValue);
		
		
		nomPoste=new JLabel("Nom du poste :");
		nomPoste.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nomPoste.setForeground(new Color(18,118,189));
		pane2.add(nomPoste);
		
		Vector<String> vect1=new Vector<String>();
		vect1.add("-Selectionner-");
		try {
			
			conn=Connexion.getConnection();
			String req="SELECT Nom_Poste FROM poste,UA WHERE  UA.Id_UA=Poste.Id_UA AND Nom_UA='"+nomUA+"'";
			st=conn.createStatement();
			rs=st.executeQuery(req);
			while(rs.next())
			{
				vect1.add(rs.getString(1));
			}
			nomPosteValue=new JComboBox<String>(vect1);
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		nomPosteValue=new JComboBox<String>(vect1);
		nomPosteValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomPosteValue.setBorder(lineBorder );
		pane2.add(nomPosteValue);
		
		Date_prev=new JLabel("Date prévisionnelle du décision :");
		Date_prev.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		Date_prev.setForeground(new Color(18,118,189));
		pane2.add(Date_prev);
		
		
		
		Date_prevValue = new JDateChooser();// convertir date en string
		Date_prevValue.setDateFormatString("YYYY-MM-dd");
		Date_prevValue.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		Date_prevValue.setForeground(new Color(18,118,189));
		pane2.add(Date_prevValue);
	
		Date_prevValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		pane2.add(Date_prevValue);
		
		
		
		Border border = pane2.getBorder();
		Border margin = new EmptyBorder(20,20,20,20);
		pane2.setBorder(new CompoundBorder(border, margin));
		paneG.setBorder(new CompoundBorder(border, margin));
		nomAdmis.setBorder(new CompoundBorder(border, margin));
		nomAdmisValue.setBorder(new CompoundBorder(border, margin));
		nomPoste.setBorder(new CompoundBorder(border, margin));
		nomPosteValue.setBorder(new CompoundBorder(border, margin));
		Date_prev.setBorder(new CompoundBorder(border, margin));
		Date_prevValue.setBorder(new CompoundBorder(border, margin));
		
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
		new AjouterDecision();

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==valide)
		{
			String nomPostev=(String)nomPosteValue.getSelectedItem(),
					datev=((JTextField)Date_prevValue.getDateEditor().getUiComponent()).getText();
			if(nomPostev.equals("") || datev.equals("") )
			{
				
				JOptionPane.showMessageDialog(null, "SVP! Remplir tous les données");

				
			}
			else {
					
				
				
				try {
					
					 conn=Connexion.getConnection();
					
					String req="SELECT Poste.Id_Poste FROM Poste,UA WHERE Poste.Id_UA=UA.Id_UA AND Nom_Poste='"+nomPostev+"' AND "
							+ "Nom_UA='"+nomUA+"'";
					st=conn.createStatement();
					rs=st.executeQuery(req);
					
					if(rs.next())
					{
						String req1="INSERT INTO `decision` VALUES ("+rs.getInt(1)+", "+admis.getIdAdmis()+", 'Non Prise', '"+datev+"',0, '')";
						st=conn.createStatement();
						st.executeUpdate(req1);
						JOptionPane.showMessageDialog(null, "la décision est bien inserée");
						setVisible(false);
						new InterfaceDecision();
					}
					
					
					
					
					
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
				
		}
		
	}

}

	