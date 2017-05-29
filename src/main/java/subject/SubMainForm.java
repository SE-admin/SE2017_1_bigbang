package subject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.crypto.Mac;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class SubMainForm extends JFrame implements ActionListener, FocusListener {
    String calName[] = { "강의명", "담당 교수", "강의 요일", "강의 시간", "수강 년도","학기" };
    Object data[] = new Object[6];
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane sp;
    ArrayList<SubInfo> list = new ArrayList<SubInfo>();
    JButton b_insert, b_delete, b_update, b_save, b_load,b_clear, b_exit;
    JTextField t_subject, t_pro, t_day, t_time, t_year,b_seme;
    JPanel panel;                  
    
    public SubMainForm() {
        setLocation(200, 200);      
        setSize(1092, 441);          
       
       
        tableModel = new DefaultTableModel(calName, 0);
        getContentPane().setLayout(null);
        table = new JTable(tableModel);
        sp = new JScrollPane(table);
        sp.setBounds(0, 0, 679, 378);
        getContentPane().add(sp);
       
   
        panel = new JPanel();
        panel.setBounds(696, 0, 357, 378);
        panel.setLayout(null);
        panel.add(t_subject = new JTextField(5));
        t_subject.setBounds(103, 0, 103, 37);
        panel.add(b_insert = new JButton("삽입"));
        b_insert.setBounds(223, 0, 117, 37);
        JLabel l_pro = new JLabel("담당교수");
        l_pro.setBounds(0, 49, 103, 37);
        panel.add(l_pro);
        panel.add(t_pro = new JTextField(5));
        t_pro.setBounds(103, 49, 103, 37);
        panel.add(b_delete = new JButton("삭제"));
        b_delete.setBounds(223, 49, 117, 37);
        JLabel l_day = new JLabel("강의요일");
        l_day.setBounds(0, 98, 103, 37);
        panel.add(l_day);
        panel.add(t_day = new JTextField(5));
        t_day.setBounds(103, 98, 103, 37);
        panel.add(b_update = new JButton("수정"));
        b_update.setBounds(223, 98, 117, 37);
        JLabel l_time = new JLabel("강의시간");
        l_time.setBounds(0, 147, 103, 37);
        panel.add(l_time);
        panel.add(t_time = new JTextField(5));
        t_time.setBounds(103, 147, 103, 37);
       
     
        JLabel l_year = new JLabel("수강년도");
        l_year.setBounds(0, 196, 103, 37);
        panel.add(l_year);
        panel.add(t_year = new JTextField(5));
        t_year.setBounds(103, 196, 103, 37);
        panel.add(b_clear = new JButton("초기화"));
        b_clear.setBounds(223, 147, 117, 37);
        panel.add(b_save = new JButton("저장"));
        b_save.setBounds(223, 196, 117, 37);
        panel.add(b_load = new JButton("불러오기"));
        b_load.setBounds(223, 248, 117, 37);
        panel.add(b_exit = new JButton("뒤로가기"));
        b_exit.setBounds(223, 300, 117, 37);
        getContentPane().add(panel);
        JLabel l_subject = new JLabel("강의명");
        l_subject.setBounds(0, 0, 103, 37);
        panel.add(l_subject);
        
        JLabel l_seme = new JLabel("학기");
        l_seme.setBounds(0, 245, 103, 37);
        panel.add(l_seme);
        panel.add(b_seme = new JTextField(5));
        
        b_seme.setBounds(103, 245, 103, 37);
        panel.add(b_seme);
       
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
       
       
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Select();
            }
        });
       
        
        b_insert.addActionListener(this);
        b_delete.addActionListener(this);
        b_update.addActionListener(this);
        b_clear.addActionListener(this);
        b_save.addActionListener(this);
        b_load.addActionListener(this);
        b_exit.addActionListener(this);
       
       
        t_subject.addFocusListener(this);
        t_pro.addFocusListener(this);
        t_day.addFocusListener(this);
        t_time.addFocusListener(this);
        t_year.addFocusListener(this);
        b_seme.addFocusListener(this);
 
        setVisible(true);
    }
 
   
    public void Select() {
        int row = table.getSelectedRow();
        System.out.println(">>>click position: " + row);
        
        t_subject.setText((String)tableModel.getValueAt(row, 0)); 
        t_pro.setText((String)tableModel.getValueAt(row, 1));
        t_day.setText((String)tableModel.getValueAt(row, 2));
        t_time.setText((String)tableModel.getValueAt(row, 3));
        t_year.setText((String)tableModel.getValueAt(row, 4));
        b_seme.setText((String)tableModel.getValueAt(row,5));
        System.out.println(">>>get data: " + tableModel.getValueAt(row, 0));
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
      
        int row = table.getSelectedRow();  
       
       
        if(e.getSource() == b_insert) {            
            System.out.println(">>>click insert");
            new SubInsert(t_subject, t_pro, t_day, t_time, t_year,b_seme,
                    data, tableModel, list);
           
        }
        else if (e.getSource() == b_delete) {
            System.out.println(">>>click delete");
            if(row == -1)   return;         
            SubInfo temp = list.get(row); 
            System.out.printf(">>>delete data: %s\t%s\t%s\t%s\t%s\t%s\n",
                    temp.subName_s, temp.subPrf_s, temp.subDay_s, temp.subTime_s, temp.subYear_s,temp.subSem_s);          
            new SubDelete(row, t_subject, tableModel, list);
           
        } 
        else if (e.getSource() == b_update) {
            System.out.println(">>>click update");
            if(row == -1)   return; 
           
            String temp_subject = (String)tableModel.getValueAt(row, 0);
         
            int l_row = new SubSearch(temp_subject, list).searchData();
            SubInfo temp = list.get(l_row); 
            System.out.println(">>>update subject: "
                    + temp.subName_s + " -> " + t_subject.getText());        
            new SubUpdate(l_row, row, temp_subject,
                    t_subject, t_pro, t_day, t_time, t_year,b_seme,
                    data, tableModel, list);
           
        }
        else if (e.getSource() == b_save) {
            System.out.println(">>>click save");
            new SubSave(t_subject, t_pro, t_day, t_time, t_year,b_seme,
                    data, tableModel, list);
           
        }
        else if (e.getSource() == b_load) {
            System.out.println(">>>click load");
            new SubLoad(t_subject, t_pro, t_day, t_time, t_year,b_seme,
                    data, tableModel, list);
           
        }
        else if (e.getSource() == b_clear) {
            System.out.println(">>>click clear");
            t_subject.setText("");
            t_pro.setText("");
            t_day.setText("");  
            t_time.setText("");   
            t_year.setText("");  
            b_seme.setText("");
           
        } 
      
        else if (e.getSource() == b_exit) {    
            System.out.println(">>>program exit");
            main.main m = new main.main();
            m.setVisible(true);
            setVisible(false);
            
        }
    }
 
    @Override
    public void focusGained(FocusEvent e) {
       
        if(e.getSource() == t_subject)
            t_subject.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_pro)
            t_pro.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_day)
            t_day.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_time)
            t_time.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_year)
            t_year.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == b_seme)
            b_seme.setBackground(new Color(250, 244, 192));
    }
 
    @Override
    public void focusLost(FocusEvent e) {
       
        if(e.getSource() == t_subject)
            t_subject.setBackground(null);
        else if(e.getSource() == t_pro)
            t_pro.setBackground(null);
        else if(e.getSource() == t_day)
            t_day.setBackground(null);
        else if(e.getSource() == t_time)
            t_time.setBackground(null);
        else if(e.getSource() == t_year)
            t_year.setBackground(null);
        else if(e.getSource() == b_seme)
            b_seme.setBackground(null);
    }
   
   
    public static void main(String args[]) {
        new SubMainForm();
    }
}