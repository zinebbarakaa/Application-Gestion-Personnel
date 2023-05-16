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

import tables.*;


public class ModifierAgent extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel nom,prenom,CIN,date,tel,email,situationF,adresse;

	JTextField CINValue,situationFValue,prenomValue,nomValue,telValue,emailValue,adresseValue;

	

	JDateChooser dateValue;
	Agent agent=InterfaceAgent.agent;
	
	
	JButton mod;
	static Connection conn=null;
	static Statement st=null;
	static ResultSet rs=null;
	public ModifierAgent()
	{
		setTitle("Modifier Agent");
		setSize(1000,600);
		Container c=getContentPane();
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
		
		
		JPanel pane1=new JPanel(new BorderLayout());
		JLabel ajouter=new JLabel("<html><U>Modifier</U></html>",JLabel.CENTER);
		ajouter.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 20));
		pane1.add(ajouter,BorderLayout.NORTH);
		
		JPanel pane2=new JPanel(new GridLayout(4,2,40,40));
		nom=new JLabel("Nom  :");
		nom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		nom.setForeground(new Color(18,118,189));
		pane2.add(nom);
		
		nomValue=new JTextField();
		nomValue.setText(agent.getNomAgent());
		nomValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		nomValue.setBorder(lineBorder );
		pane2.add(nomValue);
		
		prenom=new JLabel("Prénom  : ");
		prenom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		prenom.setForeground(new Color(18,118,189));
		pane2.add(prenom);
		
		prenomValue=new JTextField();
		prenomValue.setText(agent.getPrenomAgent());
		prenomValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		prenomValue.setBorder(lineBorder );
		pane2.add(prenomValue);
		
		CIN=new JLabel("CIN  :");
		CIN.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		CIN.setForeground(new Color(18,118,189));
		pane2.add(CIN);
		
		CINValue=new JTextField();
		CINValue.setText(agent.getCIN());
		CINValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		CINValue.setBorder(lineBorder );
		pane2.add(CINValue);
		
		date=new JLabel("Date Naissance  :");
		date.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		date.setForeground(new Color(18,118,189));
		pane2.add(date);
		
		dateValue=new JDateChooser();
		//dateValue.get
		dateValue.setDateFormatString("YYYY-MM-dd");
		dateValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		dateValue.setBorder(lineBorder );
		pane2.add(dateValue);
		
		tel=new JLabel("Telephone  : ");
		tel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		tel.setForeground(new Color(18,118,189));
		pane2.add(tel);
		
		telValue=new JTextField();
		telValue.setText(agent.getTelAgent());
		telValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		telValue.setBorder(lineBorder );
		pane2.add(telValue);
		
		email=new JLabel("Email  : ");
		email.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		email.setForeground(new Color(18,118,189));
		pane2.add(email);
		
		emailValue=new JTextField();
		emailValue.setText(agent.getEmailAgent());
		emailValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		emailValue.setBorder(lineBorder );
		pane2.add(emailValue);
		

		adresse=new JLabel("Adresse : ");
		adresse.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		adresse.setForeground(new Color(18,118,189));
		pane2.add(adresse);
		
		adresseValue=new JTextField();
		adresseValue.setText(agent.getAdresseAgent());
		adresseValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		adresseValue.setBorder(lineBorder );
		pane2.add(adresseValue);
		
		situationF=new JLabel("Situation Familiale  : ");
		situationF.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC , 15));
		situationF.setForeground(new Color(18,118,189));
		pane2.add(situationF);
		
		situationFValue=new JTextField();
		situationFValue.setText(agent.getSituationFAgent());
		situationFValue.setFont(new Font("Bookman Old Style", Font.BOLD  , 15));
		situationFValue.setBorder(lineBorder );
		pane2.add(situationFValue);
		
		
		
		
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
			String nomv=nomValue.getText(),
					prenomv=prenomValue.getText(),
					CINv=CINValue.getText(),
					emailv=emailValue.getText(),
					telv=telValue.getText(),
					adressev=adresseValue.getText(),
					situationv=situationFValue.getText(),
					datev=((JTextField)dateValue.getDateEditor().getUiComponent()).getText();
			
		if(nomv!=""|| prenomv!=""|| CINv!=""|| telv!=""|| adressev!=""|| situationv!="" || datev!="")
		{
			try {
				conn=Connexion.getConnection();
				String req="UPDATE AGENT SET Nom_AGENT='"+nomv+"', Prenom_AGENT='"+prenomv+"', Naiss_AGENT='"+datev+"',Tel_AGENT='"+telv+
						"',Email_AGENT='"+emailv+"',Situation_F_AGENT='"+situationv+"',Adresse_AGENT='"+adressev+"',Photo_AGENT='agent_photo.png',CIN_AGENT='"+CINv+"' "
						+ "WHERE Id_AGENT="+agent.getIdAgent();
				
				st=conn.createStatement();
				st.executeUpdate(req);
			
				int n=st.executeUpdate(req);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "L'agent est bien modifié");
					setVisible(false);
					new InterfaceAgent();
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "SVP! remplir tous les données");
		}
		
					
				
			
			
		}
		
		
	}


	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new ModifierAgent();

	}

	
	
}
