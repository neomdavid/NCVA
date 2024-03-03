import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JPanel;

public class ExecutiveDashboard {

    public JFrame ExecutiveDashboard;
    
    //Added Positions
    private DefaultTableModel model;
    private JTable dash_table;
    
    //Applicant Count
    private DefaultTableModel model2;
    private JPanel AppStatus;
    
    private Map<String, Integer> applicantCounts = new HashMap<String, Integer>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExecutiveDashboard window = new ExecutiveDashboard();
					window.ExecutiveDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
    public ExecutiveDashboard() {
        initialize();
    }
    public JTable getTable() {
        return dash_table;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	ExecutiveDashboard = new JFrame();
    	ExecutiveDashboard.setBounds(100, 100, 1300, 800);
    	ExecutiveDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ExecutiveDashboard.setResizable(false);
    	ExecutiveDashboard.setLocationRelativeTo(null);
    	ExecutiveDashboard.getContentPane().setLayout(null);

        
        // Tables ====================================================================================

	    // Added Positions
        model = new DefaultTableModel();
	    
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(24, 231, 593, 523);
        ExecutiveDashboard.getContentPane().add(scrollPane);
        
        dash_table = new JTable();
        scrollPane.setViewportView(dash_table);
        dash_table.setModel(model);       
        dash_table.setShowGrid(true);
        dash_table.setShowHorizontalLines(true);
        dash_table.setGridColor(Color.black);   
        dash_table.setEnabled(false);
        dash_table.setFocusable(false);
        dash_table.setRowSelectionAllowed(false);
        dash_table.getTableHeader().setReorderingAllowed(false);
        dash_table.getTableHeader().setResizingAllowed(false);
        dash_table.setFont(new Font("Arial", Font.PLAIN, 12));
        Object[] column = {"       Position Code","          Job Title", "    Responsibilities", "            Salary"};
        model.setColumnIdentifiers(column);
        final Object[] row = new Object[4];
        model.setColumnIdentifiers(column);      
        scrollPane.setViewportView(dash_table);

	    
	    // Applicant Count 
        model2 = new DefaultTableModel();

	    AppStatus = new JPanel();
        AppStatus.setBounds(680, 230, 593, 360);
        AppStatus.setBackground(Color.WHITE);
        ExecutiveDashboard.getContentPane().add(AppStatus);
        AppStatus.setLayout(null);


        // BUTTONS ====================================================================================

        //JOB POSTING
        JButton btn_JobPosting = new JButton("");
        btn_JobPosting.setBorder(null);
        btn_JobPosting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	JobPosting jobPosting = new JobPosting();
            	jobPosting.JobPosting.setVisible(true);
                ExecutiveDashboard.dispose();
            }
        });
        btn_JobPosting.setIcon(new ImageIcon("Buttons/ExecutiveDash/POSTING(ADMIN)_ .png"));
        btn_JobPosting.setBackground(new Color(11, 20, 10));
        btn_JobPosting.setBounds(1178, 96, 102, 40);
        ExecutiveDashboard.getContentPane().add(btn_JobPosting);

        //LOG OUT
        JButton btn_LogOut = new JButton("");
        btn_LogOut.setBorder(null);
        btn_LogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
        		AdminLogin AdminLog = new AdminLogin();
				AdminLog.setVisible(true);
				ExecutiveDashboard.dispose();
            }
        });
        btn_LogOut.setIcon(new ImageIcon("Buttons/ExecutiveDash/LOG OUT(ADMIN)_ .png"));
        btn_LogOut.setBounds(1069, 96, 97, 40);
        ExecutiveDashboard.getContentPane().add(btn_LogOut);

        // BACKGROUND====================================================================================

        JLabel ExecutiveDash_BG = new JLabel("");
        ExecutiveDash_BG.setIcon(new ImageIcon("Pages/EXECUTIVE DASHBOARD (ADMIN).png"));
        ExecutiveDash_BG.setBounds(0, 0, 1300, 800);
        ExecutiveDashboard.getContentPane().add(ExecutiveDash_BG);
    }
}