import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;


public class JobPosting {

	public JFrame JobPosting;
	private JTextField PosCode;
	public JTextField JobTitle;
	private JTextField Responsibilities;
	private JTextField Salary;
	private JTable table_1;
	private JScrollPane scrollPane;
    private JTable dash_table;
	private JTable App_table;
	DefaultTableModel model;

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobPosting window = new JobPosting();
					window.JobPosting.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//METHODS ====================================================================================


    
   // ====================================================================================

	/**
	 * Create the application.
	 */
	public JobPosting() {
        this.dash_table = dash_table;
        this.App_table = App_table;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JobPosting = new JFrame();
		JobPosting.setBounds(100, 100, 1300, 800);
		JobPosting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JobPosting.setResizable(false);
		JobPosting.setLocationRelativeTo(null);
		JobPosting.getContentPane().setLayout(null);
		
		//TEXT FIELDS ====================================================================================
		
		//Position Code
		PosCode = new JTextField();
		PosCode.setBounds(1033, 262, 233, 60);
		JobPosting.getContentPane().add(PosCode);
		PosCode.setColumns(10);
		
		//Job Title
		JobTitle = new JTextField();
		JobTitle.setBounds(1033, 341, 233, 60);
		JobPosting.getContentPane().add(JobTitle);
		JobTitle.setColumns(10);
		
		//Responsibilites
		Responsibilities = new JTextField();
		Responsibilities.setBounds(1033, 417, 233, 60);
		JobPosting.getContentPane().add(Responsibilities);
		Responsibilities.setColumns(10);
		
		//Salary
		Salary = new JTextField();
		Salary.setBounds(1033, 496, 233, 60);
		Salary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String SalaryNum = Salary.getText();

				//get length of string
				int length = SalaryNum.length();
				
				char c = e.getKeyChar();
				
				//check for numbers 0-9
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
					if(length<6) {
						//Editable 
						Salary.setEditable(true);
					
					} else {
						//Not editable if lenghth is more than 6
						Salary.setEditable(false);
					}
					
				} else if (e.getExtendedKeyCode()== KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()== KeyEvent.VK_DELETE) {
					
					Salary.setEditable(true);
					
				} else {
					
					Salary.setEditable(false);
					JOptionPane.showMessageDialog(null,"Only Input Numbers from 0 to 9");

				}						
			}

		});
		JobPosting.getContentPane().add(Salary);
		Salary.setColumns(10);
		
		
		//Scroll Panel ====================================================================================

		//Add JScrollPane to show values in table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 213, 782, 504);
		scrollPane.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent e) {
				
				int i = table_1.getSelectedRow();
				PosCode.setText(model.getValueAt(i, 0).toString());
				JobTitle.setText(model.getValueAt(i, 1).toString());
				Responsibilities.setText(model.getValueAt(i, 2).toString());
				Salary.setText(model.getValueAt(i, 3).toString());
			}
		});
		JobPosting.getContentPane().add(scrollPane);
		
		//TABLE ====================================================================================
		
		table_1 = new JTable();
		table_1.setShowGrid(true);
		table_1.setShowHorizontalLines(true);
		table_1.setGridColor(Color.black);  
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = table_1.getSelectedRow();
				PosCode.setText(model.getValueAt(i,0).toString());
				JobTitle.setText(model.getValueAt(i,1).toString());
				Responsibilities.setText(model.getValueAt(i,2).toString());
				Salary.setText(model.getValueAt(i,3).toString());

			}
		});
		model = new DefaultTableModel();
		Object[] column = {"       Position Code","          Job Title", "    Responsibilities", "            Salary"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		
		//BUTTONS ====================================================================================
						
		
		//ADD BUTTON
		JButton Add = new JButton("");
		Add.setBorder(null);
		Add.setIcon(new ImageIcon("Buttons/Job Posting/POSTING (ADD)_ .png"));
		Add.setBounds(930, 603, 102, 40);
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							   	    
				
			} 

		});
		JobPosting.getContentPane().add(Add);
		
		//UPDATE BUTTON
		JButton Update = new JButton("");
		Update.setBorder(null);
		Update.setIcon(new ImageIcon("Buttons/Job Posting/POSTING (UPDATE).png"));
		Update.setBounds(1048, 603, 102, 40);
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		JobPosting.getContentPane().add(Update);
		
		//DELETE BUTTON
		JButton Delete = new JButton("");
		Delete.setBorder(null);
		Delete.setIcon(new ImageIcon("Buttons/Job Posting/POSTING (DELETE)  _ .png"));
		Delete.setBounds(1044, 677, 117, 40);
		Delete.setBackground(Color.RED);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		JobPosting.getContentPane().add(Delete);
		
		//CLEAR BUTTON
		JButton Clear = new JButton("");
		Clear.setBorder(null);
		Clear.setIcon(new ImageIcon("Buttons/Job Posting/POSTING (CLEAR)  _ .png"));
		Clear.setBounds(1168, 603, 108, 40);
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PosCode.setText("");
				JobTitle.setText("");
				Responsibilities.setText("");
				Salary.setText("");
			}
		});
		JobPosting.getContentPane().add(Clear);
		
		//RETURN BUTTON
		JButton btn_Return = new JButton("");
		btn_Return.setBorder(null);
		btn_Return.setBounds(1179, 94, 100, 42);
		btn_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExecutiveDashboard ExecutiveDash = new ExecutiveDashboard();
				ExecutiveDash.ExecutiveDashboard.setVisible(true);
				JobPosting.dispose();
                			
			}
		});
		btn_Return.setIcon(new ImageIcon("Buttons/Job Posting/Return (ADMIN)_ .png"));
		JobPosting.getContentPane().add(btn_Return);
		
	
		//BACKGROUND====================================================================================

		JLabel lblJobPosting_BG = new JLabel("");
		lblJobPosting_BG.setBounds(0, 0, 1300, 800);
		lblJobPosting_BG.setIcon(new ImageIcon("Pages/JOB POSTING (ADMIN).png"));
		JobPosting.getContentPane().add(lblJobPosting_BG);
					

	}
}
