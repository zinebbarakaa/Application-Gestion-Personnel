package dcp;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import login.Connexion;
import tables.Dicision;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class AfficherDecision extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lbv1,lbv2,lbv3,lbv4,lbv5,lbv6,lbv7,nom_prenom;
	JButton valider;	
	JComboBox<String> jc;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	
	static Dicision decision=InterfaceDecision.decision;
	public AfficherDecision() 
	{
		setTitle("Decision");
		setSize(1100,600);
		Container c=getContentPane();
		
		
		try {
			String req="SELECT admis.Nom_ADMIS,admis.Prenom_ADMIS,admis.CIN_ADMIS,Nom_POSTE,Date_prev FROM poste,decision,admis\r\n"
					+ "WHERE poste.Id_POSTE=decision.Id_POSTE AND admis.Id_ADMIS=decision.Id_ADMIS AND admis.Id_ADMIS="+decision.getAdmis().getIdAdmis()
					+ " AND poste.Id_POSTE="+decision.getPoste().getIdPoste();
			conn=login.Connexion.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(req);
			if(rs.next())
			{
				JPanel pane1=new JPanel(new BorderLayout());
				//JLabel nom_prenom=new JLabel(,JLabel.CENTER);
			/*	nom_prenom=new JLabel("",JLabel.CENTER);
				nom_prenom.setText("<html><U>"+rs.getString(1)+"</U></html>");
				nom_prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
				pane1.add(nom_prenom,BorderLayout.NORTH);*/
				
				JPanel pane2=new JPanel(new GridLayout(3,2,40,40));
				
				

				lb4=new JLabel("Nom_Admis  :");
				lb4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
				lb4.setForeground(new Color(18,118,189));
				pane2.add(lb4);
				
				lbv4=new JLabel(rs.getString(1));
				lbv4.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
				pane2.add(lbv4);
				
				
				lb5=new JLabel("Prenom_Admis  :");
				lb5.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
				lb5.setForeground(new Color(18,118,189));
				pane2.add(lb5);
				
				
				lbv5=new JLabel(rs.getString(2));// convertir date en string
				lbv5.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
				pane2.add(lbv5);
                lb3=new JLabel(" CIN :");
				
				lb3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
				lb3.setForeground(new Color(18,118,189));
				pane2.add(lb3);
				
				
				lbv3=new JLabel(rs.getString(3));
				lbv3.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
				pane2.add(lbv3);
				
				
				lb6=new JLabel("Poste  :");
				lb6.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
				lb6.setForeground(new Color(18,118,189));
				pane2.add(lb6);
				
				
				lbv6=new JLabel(rs.getString(4));// convertir date en string
				lbv6.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
				pane2.add(lbv6);
				
				lb7=new JLabel(" Date Previsionnelle : ");
				lb7.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
				lb7.setForeground(new Color(18,118,189));
				pane2.add(lb7);
				
			
				lbv7=new JLabel(rs.getString(5));
				lbv7.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
				pane2.add(lbv7);
				
				lb8=new JLabel("Status dècision  : ");
				lb8.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
				lb8.setForeground(new Color(18,118,189));
				pane2.add(lb8);
				
				
				jc=new JComboBox<String>(new String[]{"-Selécionner-","VALIDE","NON VALIDE"});
				
				pane2.add(jc);

				
				Border border = pane1.getBorder();
				Border margin = new EmptyBorder(20,20,20,20);
				pane1.setBorder(new CompoundBorder(border, margin));
				pane2.setBorder(new CompoundBorder(border, margin));
				
			
				JPanel pane3=new JPanel();
				valider=new JButton("Valider");
				valider.setFont(new Font("Bookman Old Style", Font.BOLD , 15));
				valider.setBorder(new CompoundBorder(border, margin));
				valider.addActionListener(this);
				pane3.add(valider);
				
				pane1.setBackground(new Color(245,245,245));
				pane2.setBackground(new Color(245,245,245));
				pane3.setBackground(new Color(245,245,245));
				c.setBackground(new Color(245,245,245));
				((JComponent) c).setBorder(new CompoundBorder(border, margin));
				c.add(pane1,BorderLayout.NORTH);
				c.add(pane2,BorderLayout.CENTER);
				c.add(pane3,BorderLayout.SOUTH);
				setLocationRelativeTo(null);
			}
		
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

		
		

		
		//c.setBackground(new Color(204,229,255));
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==valider)
		{	
			conn=Connexion.getConnection();
			String status = (String) jc.getSelectedItem();
			String  CIN=lbv3.getText();
						try {
							
							if(status.equals("VALIDE")) {
								
							    PreparedStatement pst = conn.prepareStatement("SELECT Status_POSTE FROM decision,poste,admis WHERE decision.Id_POSTE=poste.Id_POSTE"
							    		+ " AND decision.Id_ADMIS=admis.Id_ADMIS AND CIN_ADMIS =?");
							    pst.setString(1, CIN);
							    ResultSet rs= pst.executeQuery();
							    rs.next();
							    if(rs.getBoolean("Status_POSTE")) {
							    	JOptionPane.showMessageDialog(null, " le poste est occupee");
							    	new InterfaceDecision();
							    }
							    else {
							    	
								    
							  PreparedStatement pst1 = conn.prepareStatement("UPDATE decision SET Status_DECISION = 1  Where decision.Id_ADMIS="+decision.getAdmis().getIdAdmis() +" AND Id_Poste="+
								    
									  decision.getPoste().getIdPoste()+";");
							  
							  PreparedStatement pst2 = conn.prepareStatement("UPDATE POSTE SET Status_POSTE=1 WHERE Id_Poste = ?");
							  pst2.setInt(1,decision.getPoste().getIdPoste());
							 
									pst1.executeUpdate();	
									pst2.executeUpdate();
									JOptionPane.showMessageDialog(null, " Status Décision du "+lbv4.getText()+" "+lbv5.getText()+" est bien enregistrer");
									setVisible(false);
									new InterfaceDecision();
							    	
							    }
								
							}
							
						}
						catch (Exception e) {
							e.printStackTrace();
						}
			}
		
		}
			public static void main(String[] args) throws UnsupportedLookAndFeelException {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			new AfficherDecision();

	}

	
	
}

