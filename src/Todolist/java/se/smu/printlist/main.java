package se.smu.printlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JTextArea;

public class main extends JFrame {

   private JPanel contentPane;
   private DefaultTableModel model;
   private JTable tdlTable;
   private JTable sucTable;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               main frame = new main();
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
   public main() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 856, 587);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(135, 206, 250));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel subPanel = new JPanel();
      subPanel.setBounds(12, 10, 228, 528);
      contentPane.add(subPanel);
      subPanel.setLayout(null);
      
      JButton subAddBtn = new JButton("추가");
      subAddBtn.setFont(new Font("굴림", Font.PLAIN, 15));
      subAddBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      subAddBtn.setBounds(12, 241, 61, 23);
      subPanel.add(subAddBtn);
      
      JButton subDelBtn = new JButton("삭제");
      subDelBtn.setFont(new Font("굴림", Font.PLAIN, 15));
      subDelBtn.setBounds(150, 241, 61, 23);
      subPanel.add(subDelBtn);
      
      JButton subModBtn = new JButton("수정");
      subModBtn.setFont(new Font("굴림", Font.PLAIN, 15));
      subModBtn.setBounds(82, 241, 61, 23);
      subPanel.add(subModBtn);
      
      JLabel memoLabel = new JLabel("할일 메모");
      memoLabel.setBounds(12, 290, 90, 15);
      subPanel.add(memoLabel);
      
      JTextArea memoTextArea = new JTextArea();
      memoTextArea.setBounds(12, 320, 199, 193);
      subPanel.add(memoTextArea);
      
      JPanel tdlPanel = new JPanel();
      tdlPanel.setBounds(252, 10, 576, 246);
      contentPane.add(tdlPanel);
      tdlPanel.setLayout(null);
      
      JList tdlList = new JList();
      tdlList.setBounds(288, 5, 0, 0);
      tdlPanel.add(tdlList);
      
      JPanel tdlTitlePanel = new JPanel();
      tdlTitlePanel.setBounds(12, 10, 552, 47);
      tdlPanel.add(tdlTitlePanel);
      tdlTitlePanel.setLayout(null);
      
      JComboBox tdlComboBox = new JComboBox();
      tdlComboBox.setBounds(0, 0, 116, 47);
      tdlComboBox.setModel(new DefaultComboBoxModel(new String[] {"전 체"}));
      tdlTitlePanel.add(tdlComboBox);
      
      JLabel tdlLabel  = new JLabel("TO DO LIST");
      tdlLabel.setBounds(184, 0, 184, 47);
      tdlTitlePanel.add(tdlLabel);
      
      JScrollPane tdlScrollPane = new JScrollPane();
      tdlScrollPane.setEnabled(false);
      tdlScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      tdlScrollPane.setBounds(12, 58, 552, 145);
      tdlPanel.add(tdlScrollPane);
      
      tdlTable = new JTable();
      tdlTable.setModel(new DefaultTableModel(
         new Object[][] {
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
         },
         new String[] {
            "", "중요도", "과목", "D-DAY", "마감기한", "내용", "완료여부"
         }
      ));
      tdlTable.getColumnModel().getColumn(0).setPreferredWidth(50);
      tdlTable.getColumnModel().getColumn(1).setPreferredWidth(65);
      tdlTable.getColumnModel().getColumn(3).setPreferredWidth(60);
      tdlTable.getColumnModel().getColumn(4).setPreferredWidth(70);
      tdlTable.getColumnModel().getColumn(5).setPreferredWidth(100);
      tdlTable.getColumnModel().getColumn(6).setPreferredWidth(60);
      tdlScrollPane.setViewportView(tdlTable);
      
      JButton tdlAddBtn = new JButton("추가");
      tdlAddBtn.setBounds(12, 213, 97, 23);
      tdlPanel.add(tdlAddBtn);
      
      JButton tdlModBtn = new JButton("수정");
      tdlModBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      tdlModBtn.setBounds(121, 213, 97, 23);
      tdlPanel.add(tdlModBtn);
      
      JButton tdlDelBtn = new JButton("삭제");
      tdlDelBtn.setBounds(230, 213, 97, 23);
      tdlPanel.add(tdlDelBtn);
      
      JPanel sucPanel = new JPanel();
      sucPanel.setLayout(null);
      sucPanel.setBounds(252, 292, 576, 246);
      contentPane.add(sucPanel);
      
      JList sucList = new JList();
      sucList.setBounds(288, 5, 0, 0);
      sucPanel.add(sucList);
      
      JPanel sucTitlePanel = new JPanel();
      sucTitlePanel.setLayout(null);
      sucTitlePanel.setBounds(12, 10, 552, 47);
      sucPanel.add(sucTitlePanel);
      
      JComboBox sucComboBox = new JComboBox();
      sucComboBox.setModel(new DefaultComboBoxModel(new String[] {"전체"}));
      sucComboBox.setBounds(0, 0, 116, 47);
      sucTitlePanel.add(sucComboBox);
      
      JLabel sucLabel = new JLabel("FINISH LIST");
      sucLabel.setBounds(184, 0, 184, 47);
      sucTitlePanel.add(sucLabel);
      
      JLabel sucSucLabel = new JLabel("달성율");
      sucSucLabel.setBounds(368, 0, 92, 47);
      sucTitlePanel.add(sucSucLabel);
      
      JLabel sucSucLabel_p = new JLabel("");
      sucSucLabel_p.setBounds(460, 0, 92, 47);
      sucTitlePanel.add(sucSucLabel_p);
      
      JScrollPane sucScrollPane = new JScrollPane();
      sucScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      sucScrollPane.setEnabled(false);
      sucScrollPane.setBounds(12, 58, 552, 145);
      sucPanel.add(sucScrollPane);
      
      sucTable = new JTable();
      sucTable.setModel(new DefaultTableModel(
         new Object[][] {
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
         },
         new String[] {
            "", "중요도", "과목", "나의 마감일", "마감기한", "내용", "완료여부"
         }
      ));
      sucTable.getColumnModel().getColumn(0).setPreferredWidth(50);
      sucTable.getColumnModel().getColumn(1).setPreferredWidth(65);
      sucTable.getColumnModel().getColumn(3).setPreferredWidth(70);
      sucTable.getColumnModel().getColumn(4).setPreferredWidth(70);
      sucTable.getColumnModel().getColumn(5).setPreferredWidth(100);
      sucTable.getColumnModel().getColumn(6).setPreferredWidth(60);
      sucScrollPane.setViewportView(sucTable);
      
      JButton sucModBtn = new JButton("수정");
      sucModBtn.setBounds(12, 213, 97, 23);
      sucPanel.add(sucModBtn);
      
      JButton sucDelBtn = new JButton("삭제");
      sucDelBtn.setBounds(121, 213, 97, 23);
      sucPanel.add(sucDelBtn);
      
      
   }
}