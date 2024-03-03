import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;

public class HomePage extends JFrame {

	private JPanel HomePage;
	private JTextField ApplicantUser;
	private JPasswordField ApplicantPassword;
	private JButton Admin;
	private JButton btn_Login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String connectionString =
								"jdbc:sqlserver:localhost;databaseName=AdventureWorks2022";
					try (Connection connectino = DriverManager.getConnection(connectionString)){
						System.out.println("Connectio established.");
					} 
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setResizable(false);
        setOpacity(1.0f);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		HomePage = new JPanel();
		HomePage.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(HomePage);
		setLocationRelativeTo(null);
		HomePage.setLayout(null);
		
		//TEXT FIELDS ====================================================================================

		
		ApplicantUser = new JTextField();
		ApplicantUser.setBounds(874, 391, 246, 41);
		HomePage.add(ApplicantUser);
		ApplicantUser.setColumns(10);
		
		JCheckBox showHidePass = new JCheckBox("Show Password");
		showHidePass.setBounds(1004, 457, 114, 23);
		showHidePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(showHidePass.isSelected()) {
					
					ApplicantPassword.setEchoChar((char)0);
					
				} else {
					
					ApplicantPassword.setEchoChar('•');
					
				}
			}
		});
		showHidePass.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		HomePage.add(showHidePass);
		
		ApplicantPassword = new JPasswordField();
		ApplicantPassword.setBounds(874, 484, 246, 41);
		HomePage.add(ApplicantPassword);
		
	
		//BUTTONS ====================================================================================
		
		//REGISTER
		JButton Register = new JButton("New button");
		Register.setBorder(null);
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicantRegistration register = new ApplicantRegistration();
                register.setVisible(true);
                dispose();
			}
		});
		Register.setIcon(new ImageIcon("Buttons/HomePage/RegisterBtnn.png"));
		Register.setBounds(1018, 83, 102, 41);
		HomePage.add(Register);
		
		//ADMIN LOGIN
		Admin = new JButton("New button");
		Admin.setBorder(null);
		Admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLogin AdminLog = new AdminLogin();
				AdminLog.setVisible(true);
				dispose();
				
			}
		});
		Admin.setIcon(new ImageIcon("Buttons/HomePage//AdminBtn.png"));
		Admin.setBounds(1151, 89, 95, 29);
		HomePage.add(Admin);
		
		//SIGN IN BTN
		btn_Login = new JButton(new ImageIcon("Buttons/HomePage/SIGN IN (ADMIN).png"));
		btn_Login.setBorder(null);
		btn_Login.setBounds(931, 536, 133, 40);
		HomePage.add(btn_Login);
		
		
		
		//BACKGROUND====================================================================================
		
		JLabel HomeBG = new JLabel("New label");
		HomeBG.setIcon(new ImageIcon("Pages/HOME PAGEUSER LOGIN__ _ .png"));
		HomeBG.setBounds(0, 0, 1300, 800);
		HomePage.add(HomeBG);
		
		
	
	
		


		
	}
}
