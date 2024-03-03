import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicantPositionTab extends JFrame {

    private JPanel contentPane;
    private JTable PositionsTable;
    private JTextField searchField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ApplicantPositionTab frame = new ApplicantPositionTab();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ApplicantPositionTab() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 1300, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        // LOG OUT Button
        JButton btn_LogOut = new JButton("");
        btn_LogOut.setBorder(null);
        btn_LogOut.setContentAreaFilled(false);
        btn_LogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logoutAction();
            }
        });
        btn_LogOut.setIcon(new ImageIcon("Buttons/ApplicantProcess/logoutbtnicon.png"));
        btn_LogOut.setBounds(1139, 96, 96, 40);
        contentPane.add(btn_LogOut);

        // HOME
        JButton HomeBtn = new JButton("Home");
        HomeBtn.setBorder(null);
        HomeBtn.setContentAreaFilled(false);
        HomeBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        HomeBtn.setBounds(275, 104, 85, 21);
        HomeBtn.setMargin(new Insets(0, 0, 0, 0));
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ApplicantHomeTab HomeTab = new ApplicantHomeTab();
                HomeTab.setVisible(true);
                
            }
        });
        contentPane.add(HomeBtn);

        // POSITIONS
        JButton PositionsBtn = new JButton("Positions");
        PositionsBtn.setBorder(null);
        PositionsBtn.setContentAreaFilled(false);
        PositionsBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        PositionsBtn.setBounds(375, 104, 85, 21);
        PositionsBtn.setMargin(new Insets(0, 0, 0, 0));
        contentPane.add(PositionsBtn);

        // APPLY
        JButton ApplyBtn = new JButton("Apply");
        ApplyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ApplicantProcessApplyTab applyTab = new ApplicantProcessApplyTab();
                applyTab.setVisible(true);
            }
        });
        ApplyBtn.setBorder(null);
        ApplyBtn.setContentAreaFilled(false);
        ApplyBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        ApplyBtn.setBounds(475, 104, 85, 21);
        ApplyBtn.setMargin(new Insets(0, 0, 0, 0));
        contentPane.add(ApplyBtn);

        // BLUELINE FOR APPLY BUTTON
        JLabel blueLine = new JLabel("");
        blueLine.setIcon(new ImageIcon("Pages/blueline.png"));
        blueLine.setBounds(385, 90, 59, 40);
        contentPane.add(blueLine);

        // STATUS
        JButton StatusBtn = new JButton("Status");
        StatusBtn.setBorder(null);
        StatusBtn.setContentAreaFilled(false);
        StatusBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        StatusBtn.setBounds(575, 104, 85, 21);
        StatusBtn.setMargin(new Insets(0, 0, 0, 0));
        StatusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ApplicantStatusTab statusTab = new ApplicantStatusTab();
                statusTab.setVisible(true);
                
            }
        });
        contentPane.add(StatusBtn);

        // TABLE
        Object[][] data = {
                {"PlaceHolderPOS1"},
                {"PlaceHolderPOS2"},
        };
        String[] columnNames = {"POSITIONS"};

        PositionsTable = new JTable(data, columnNames);
        PositionsTable.setPreferredScrollableViewportSize(new Dimension(1170, 489));
        PositionsTable.setFillsViewportHeight(true);
        PositionsTable.setBackground(new Color(184, 182, 182));


        JTableHeader header = PositionsTable.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 18));

        JScrollPane scrollPane = new JScrollPane(PositionsTable);
        scrollPane.setBounds(62, 180, 1170, 489);
        contentPane.add(scrollPane);


        // BACKGROUND
        JLabel lbl_ApplyTabBG = new JLabel(new ImageIcon("Pages/POSITIONS_TAB.png"));
        lbl_ApplyTabBG.setBounds(0, 0, 1300, 800);
        contentPane.add(lbl_ApplyTabBG);
        
        
    }

    // Logout Action Method
    private void logoutAction() {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            dispose();
            HomePage homepage = new HomePage();
            homepage.setVisible(true);
        }
    }
}
