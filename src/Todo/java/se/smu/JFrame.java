package Todo;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.List;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import java.awt.GridBagConstraints;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Button;
import java.awt.Checkbox;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Label;

public class JFrame extends javax.swing.JFrame {

   private String tdl_n, cl_n;
   private JPanel contentPane;
   private JTable table;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               JFrame frame = new JFrame();
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
   public JFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 856, 587);
      contentPane = new JPanel();
      contentPane.setBackground(Color.WHITE);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      Panel panel = new Panel();
      panel.setBounds(5, 5, 254, 521);
      panel.setBackground(new Color(135, 206, 250));
      contentPane.add(panel);
      
      JButton btnNewButton_2 = new JButton("수정");
      btnNewButton_2.setBounds(168, 492, 69, 29);
      btnNewButton_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         }
      });
      
      JButton btnNewButton = new JButton("삭제");
      btnNewButton.setBounds(93, 492, 69, 29);
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         }
      });
      
      JButton btnNewButton_1 = new JButton("추가");
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton_1.setBounds(17, 492, 69, 29);
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            
         }
      });
      btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
      panel.setLayout(null);
      panel.add(btnNewButton_1);
      btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
      btnNewButton.setBackground(new Color(255, 255, 255));
      panel.add(btnNewButton);
      
      TextArea textArea = new TextArea();
      textArea.setBounds(26, 302, 197, 168);
      panel.add(textArea);
      btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
      panel.add(btnNewButton_2);
      
      JList list = new JList();
      list.setBackground(new Color(135, 206, 250));
      list.setBounds(0, 0, 254, 296);
      panel.add(list);
      
      Panel panel_1 = new Panel();
      panel_1.setBounds(265, 56, 559, 186);
      contentPane.add(panel_1);
      panel_1.setLayout(null);
      
      String tdl_header[] = {"중요도", "과목", "D-day", "마감기한", "내용", "완료여부"};
      String tdl_content[][] = {};
      table = new JTable(tdl_content, tdl_header);
      table.setBounds(0, 15, 559, 186);
      panel_1.add(table);
      
      Button button = new Button("추가");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      button.setBounds(497, 243, 105, 30);
      contentPane.add(button);
      
      Button button_1 = new Button("삭제");
      button_1.setBounds(608, 243, 105, 30);
      contentPane.add(button_1);
      
      Button button_2 = new Button("수정");
      button_2.setBounds(719, 243, 105, 30);
      contentPane.add(button_2);
      
      JPanel panel_3 = new JPanel();
      panel_3.setBackground(new Color(255, 255, 255));
      panel_3.setBounds(265, 5, 559, 45);
      contentPane.add(panel_3);
      panel_3.setLayout(null);
      
      JComboBox comboBox = new JComboBox();
      comboBox.setBackground(new Color(255, 255, 255));
      comboBox.setBounds(17, 10, 100, 27);
      panel_3.add(comboBox);
      comboBox.addItem("전체");
      comboBox.addItem("전체");
      comboBox.addItem("전체");
      
      Label label = new Label("TO DO LIST");
      label.setBounds(218, 10, 106, 30);
      panel_3.add(label);
      
      Label label_2 = new Label("달성율: ");
      label_2.setBounds(443, 10, 106, 30);
      panel_3.add(label_2);
      
      JPanel panel_2 = new JPanel();
      panel_2.setLayout(null);
      panel_2.setBackground(Color.WHITE);
      panel_2.setBounds(265, 279, 559, 45);
      contentPane.add(panel_2);
      
      JComboBox comboBox_1 = new JComboBox();
      comboBox_1.setBackground(new Color(255, 255, 255));
      comboBox_1.setBounds(17, 10, 100, 27);
      panel_2.add(comboBox_1);
      
      Label label_1 = new Label("완료 LIST");
      label_1.setBounds(235, 10, 106, 30);
      panel_2.add(label_1);
      
      Label label_3 = new Label("달성율: ");
      label_3.setBounds(443, 10, 106, 30);
      panel_2.add(label_3);
      
      Panel panel_4 = new Panel();
      panel_4.setLayout(null);
      panel_4.setBounds(265, 330, 559, 186);
      contentPane.add(panel_4);
   }

   private static void addPopup(Component component, final JPopupMenu popup) {
      component.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            if (e.isPopupTrigger()) {
               showMenu(e);
            }
         }
         public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
               showMenu(e);
            }
         }
         private void showMenu(MouseEvent e) {
            popup.show(e.getComponent(), e.getX(), e.getY());
         }
      });
   }
}