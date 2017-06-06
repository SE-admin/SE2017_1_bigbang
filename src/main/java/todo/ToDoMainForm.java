package todo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import subject.SubDelete;
import subject.SubInfo;
import javax.swing.JComboBox;
 
public class ToDoMainForm extends JFrame implements ActionListener, FocusListener {
    String calName[] = { "강의명", "중요도", "내용", "마감기한", "완료여부" };
    String calName2[] = { "등록된 강의명"};
    Object data[] = new Object[5];
    Object data2[] = new Object[6];
    JTable table,table2;
    DefaultTableModel tableModel,tableModel2;
    JScrollPane sp,sp2;
    ArrayList<ToDoInfo> list = new ArrayList<ToDoInfo>();
    ArrayList<SubInfo> list2 =new ArrayList<SubInfo>();
    
    JButton b_insert, b_delete, b_update, b_save, b_load, b_search,b_clear, b_exit;
    JTextField t_tdSub, t_tdStar, t_tdContent, tdTime_s, tdCmp_s, t_subject, t_pro, t_day, t_time, t_year,b_seme;
   
    JPanel panel;                  
    private JButton m_clean;
    private JButton m_load;
    private MemoContent memocontent;
    private JTextArea m_textArea;
    private JScrollPane scrollPane;
    private JButton b_ordByNm;
    private JButton b_ordByCon;
    private JButton b_ordByStar;
    private JButton b_ordByTime;
    private JButton b_ordByCmp;
    private JButton b_tooltip;
    
    public ToDoMainForm() {
        setLocation(200, 200);     
        setSize(1240, 430);         
        
        
        tableModel = new DefaultTableModel(calName, 0);
        getContentPane().setLayout(null);
        table = new JTable(tableModel);
        sp = new JScrollPane(table);
        sp.setBounds(0, 39, 491, 354);
        getContentPane().add(sp);
        
        tableModel2 = new DefaultTableModel(calName2, 0);
        getContentPane().setLayout(null);
        table2 = new JTable(tableModel2);
        sp2 = new JScrollPane(table2);
        sp2.setBounds(492, 0, 162, 393);
        getContentPane().add(sp2);
       
       
        panel = new JPanel();
        panel.setBounds(655, 0, 319, 393);
        panel.setLayout(null);
        panel.add(t_tdSub = new JTextField(5));
        t_tdSub.setText("ex)소프트웨어공학");
        t_tdSub.setToolTipText("");
        t_tdSub.setBounds(103, 0, 103, 37);
        panel.add(b_insert = new JButton("삽입"));
        b_insert.setBounds(206, 0, 103, 37);
        JLabel label_1 = new JLabel("중요도");
        label_1.setBounds(0, 49, 103, 37);
        panel.add(label_1);
        panel.add(t_tdStar = new JTextField(5));
        t_tdStar.setText("ex)1~100");
        t_tdStar.setToolTipText("");
        t_tdStar.setBounds(103, 49, 103, 37);
        panel.add(b_delete = new JButton("삭제"));
        b_delete.setBounds(206, 49, 103, 37);
        JLabel label_2 = new JLabel("내용");
        label_2.setBounds(0, 98, 103, 37);
        panel.add(label_2);
        panel.add(t_tdContent = new JTextField(5));
        t_tdContent.setText("ex)과제해야함");
        t_tdContent.setBounds(103, 98, 103, 37);
        panel.add(b_update = new JButton("수정"));
        b_update.setBounds(206, 98, 103, 37);
        JLabel label_3 = new JLabel("마감기한");
        label_3.setBounds(0, 147, 103, 37);
        panel.add(label_3);
        panel.add(tdTime_s = new JTextField(5));
        tdTime_s.setText("ex)17-06-06  ");
        tdTime_s.setToolTipText("");
        tdTime_s.setBounds(103, 147, 103, 37);
        panel.add(b_search = new JButton("등록된 강의 불러오기"));
        b_search.setBounds(12, 290, 158, 37);
        JLabel label_4 = new JLabel("완료여부");
        label_4.setBounds(0, 196, 103, 37);
        panel.add(label_4);
        panel.add(tdCmp_s = new JTextField(5));
        tdCmp_s.setText("ex)o,x");
        tdCmp_s.setToolTipText("");
        tdCmp_s.setBounds(103, 196, 103, 37);
        panel.add(b_clear = new JButton("초기화"));
        b_clear.setBounds(206, 145, 103, 37);
        panel.add(b_save = new JButton("저장"));
        b_save.setBounds(206, 194, 103, 37);
        panel.add(b_load = new JButton("불러오기"));
        b_load.setBounds(206, 243, 103, 37);
        panel.add(b_exit = new JButton("뒤로가기"));
        b_exit.setBounds(206, 290, 103, 37);
        getContentPane().add(panel);
        
        JLabel lblLsub = new JLabel("강의명");
        lblLsub.setBounds(0, 0, 103, 37);
        panel.add(lblLsub);
        
        b_tooltip = new JButton("입력 예 보기");
        b_tooltip.setBounds(12, 243, 158, 37);
        panel.add(b_tooltip);
        
        m_textArea = new JTextArea();
        scrollPane = new JScrollPane(m_textArea);
        scrollPane.setBounds(976, 39, 238, 250);
        getContentPane().add(scrollPane);
        
        JButton m_save = new JButton("저장");
        m_save.setFont(new Font("굴림", Font.PLAIN, 12));
        m_save.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		memocontent = new MemoContent(m_textArea.getText());
        		writeMemoDB();
        	}
        }); 
        m_save.setBounds(976, 299, 69, 37);
        getContentPane().add(m_save);
                
        m_clean = new JButton("비우기");
        m_clean.setFont(new Font("굴림", Font.PLAIN, 12));
        m_clean.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m_textArea.setText("");
        	}
        }); 
        m_clean.setBounds(1062, 299, 75, 37);
        getContentPane().add(m_clean);
        
        m_load = new JButton("로드");
        m_load.setFont(new Font("굴림", Font.PLAIN, 12));
        m_load.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		readMemoDB();
        	}
        }); 
        m_load.setBounds(1149, 299, 65, 37);
        getContentPane().add(m_load);
        
        JLabel label_6 = new JLabel("메모");
        label_6.setFont(new Font("Gulim", Font.PLAIN, 12));
        label_6.setBounds(976, 10, 78, 24);
        getContentPane().add(label_6);
        
        b_ordByNm = new JButton("강의명");
        b_ordByNm.setBounds(0, 8, 98, 29);
        getContentPane().add(b_ordByNm);
        
        b_ordByCon = new JButton("내용");
        b_ordByCon.setBounds(196, 8, 98, 29);
        getContentPane().add(b_ordByCon);
        
        b_ordByStar = new JButton("중요도");
        b_ordByStar.setBounds(98, 8, 98, 29);
        getContentPane().add(b_ordByStar);
        
        b_ordByTime = new JButton("마감기한");
        b_ordByTime.setBounds(295, 8, 98, 29);
        getContentPane().add(b_ordByTime);
        
        b_ordByCmp = new JButton("완료여부");
        b_ordByCmp.setBounds(393, 8, 98, 29);
        getContentPane().add(b_ordByCmp);
      
       
      
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
        table2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Select2();
            }
        });
        
        b_insert.addActionListener(this);
        b_delete.addActionListener(this);
        b_update.addActionListener(this);
        b_clear.addActionListener(this);
        b_search.addActionListener(this);
        b_save.addActionListener(this);
        b_load.addActionListener(this);
        b_exit.addActionListener(this);
        b_ordByNm.addActionListener(this);
        b_ordByCon.addActionListener(this);
        b_ordByTime.addActionListener(this);
        b_ordByCmp.addActionListener(this);
        b_ordByStar.addActionListener(this);
        b_tooltip.addActionListener(this);
        
       
        t_tdSub.addFocusListener(this);
        t_tdStar.addFocusListener(this);
        t_tdContent.addFocusListener(this);
        tdTime_s.addFocusListener(this);
        tdCmp_s.addFocusListener(this);
 
        setVisible(true);
    }
 
	void writeMemoDB() {
		try {
			File f1 = new File("data/MemoDB.dat");
			f1.createNewFile();
			FileOutputStream fos = new FileOutputStream(f1);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(memocontent);
			oos.close();
		} catch (IOException ie) {}
	}
	
	void readMemoDB() {
		try {
			MemoContent content;
			File f1 = new File("data/MemoDB.dat");
			if (f1.exists()) {
				FileInputStream fis = new FileInputStream(f1);
				ObjectInputStream ois = new ObjectInputStream(fis);
				content = (MemoContent) ois.readObject();
				m_textArea.setText(content.getContent());
				ois.close();
			}
		}
		catch (IOException ie) {} 
		catch (ClassNotFoundException ce) {}
	}
	
   
    public void Select() {
        int row = table.getSelectedRow();
     
        System.out.println(">>>click position: " + row);
       
        t_tdSub.setText((String)tableModel.getValueAt(row, 0)); 
        t_tdStar.setText((String)tableModel.getValueAt(row, 1));
        t_tdContent.setText((String)tableModel.getValueAt(row, 2));
        tdTime_s.setText((String)tableModel.getValueAt(row, 3));
        tdCmp_s.setText((String)tableModel.getValueAt(row, 4));
       
       
       
        System.out.println(">>>get data: "+ tableModel.getValueAt(row, 0));
    }
    public void Select2() {
       
        int row2=table2.getSelectedRow();
        System.out.println(">>>click position: " + row2);
       
        t_tdSub.setText((String)tableModel2.getValueAt(row2, 0)); 
       
      
        System.out.println(">>>get data: "+ tableModel2.getValueAt(row2, 0));
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
       
        int row = table.getSelectedRow();  
      
       
       
      
        if(e.getSource() == b_insert) {            
            System.out.println(">>>click insert");
            new ToDoInsert(t_tdSub, t_tdStar, t_tdContent, tdTime_s, tdCmp_s,data,tableModel, list, list2);
           
        } 
        else if (e.getSource() == b_delete) {
        	System.out.println(">>>click delete");
            if(row == -1)   return;         
            ToDoInfo temp = list.get(row); 
            System.out.printf(">>>delete data:  %s\t%s\t%s\t%s\t%s\n",
                    temp.tdSub_s, temp.tdStar_s, temp.tdContent_s, temp.tdTime_s, temp.tdCmp_s);          
            new ToDoDelete(row, t_tdSub, tableModel, list);
           
        } 
        else if (e.getSource() == b_update) {
            System.out.println(">>>click update");
            if(row == -1)   return;
           
            String temp_code = (String)tableModel.getValueAt(row, 0);
            
            int l_row = new ToDoSearch(temp_code, list).searchData();
            ToDoInfo temp = list.get(l_row); 
            System.out.println(">>>update code: "
                    + temp.tdSub_s + " -> " + t_tdSub.getText());        
            new ToDoUpdate(l_row, row, temp_code,
                  t_tdSub, t_tdStar, t_tdContent, tdTime_s, tdCmp_s,
                    data, tableModel, list);
           
        } 
        else if (e.getSource() == b_save) {
            System.out.println(">>>click save");
            new ToDoSave(t_tdSub, t_tdStar, t_tdContent, tdTime_s, tdCmp_s,
                    data, tableModel, list);
           
        } 
        else if (e.getSource() == b_load) {
        	
            System.out.println(">>>click load");
            new ToDoLoad(t_tdSub, t_tdStar, t_tdContent, tdTime_s, tdCmp_s,
                    data, tableModel, list);
           
        } 
        else if (e.getSource() == b_clear) {
            System.out.println(">>>click clear");
            t_tdSub.setText("");
            t_tdStar.setText("");
            t_tdContent.setText("");  
            tdTime_s.setText("");   
            tdCmp_s.setText("");  
    
           
        } 
        else if (e.getSource() == b_search) {      
            System.out.println(">>>click search");
            new ToDoSubLoad(t_subject, t_pro, t_day, t_time, t_year,b_seme, data2, tableModel2, list2);
           
        } 
        else if (e.getSource() == b_exit) {    
            System.out.println(">>>program exit");
            main.main m = new main.main();
            m.setVisible(true);
            setVisible(false);
            
        }
        else if (e.getSource() == b_ordByNm) {
        	
            System.out.println(">>>click ordByNm");
            new ToDoOrdByNm(data, tableModel, list);
           
        } 
        else if (e.getSource() == b_ordByCon) {
        	
            System.out.println(">>>click ordByCon");
            new ToDoOrdByCon(data, tableModel, list);
           
        } 
        else if (e.getSource() == b_ordByCmp) {
        	
            System.out.println(">>>click ordByCmp");
            new ToDoOrdByCmp(data, tableModel, list);
           
        } 
        else if (e.getSource() == b_ordByTime) {
        	
            System.out.println(">>>click ordByTime");
            new ToDoOrdByTime(data, tableModel, list);
           
        } 
        else if (e.getSource() == b_ordByStar) {
        	
            System.out.println(">>>click ordByTime");
            new ToDoOrdByTime(data, tableModel, list);
           
        } 
        else if (e.getSource() == b_tooltip) {
        	
        	 t_tdSub.setText("ex)소프트웨어공학");
             t_tdStar.setText("ex)1~100");
             t_tdContent.setText("ex)과제해야함");  
             tdTime_s.setText("ex)17-06-06");   
             tdCmp_s.setText("ex)o,x");  
           
        } 
    }
 
    @Override
    public void focusGained(FocusEvent e) {
        
        if(e.getSource() == t_tdSub)
           t_tdSub.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_tdStar)
           t_tdStar.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_tdContent)
           t_tdContent.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == tdTime_s)
           tdTime_s.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == tdCmp_s)
           tdCmp_s.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == tdCmp_s)
           tdCmp_s.setBackground(new Color(250, 244, 192));
    }
 
    @Override
    public void focusLost(FocusEvent e) {
       
        if(e.getSource() == t_tdSub)
           t_tdSub.setBackground(null);
        else if(e.getSource() == t_tdStar)
           t_tdStar.setBackground(null);
        else if(e.getSource() == t_tdContent)
           t_tdContent.setBackground(null);
        else if(e.getSource() == tdTime_s)
           tdTime_s.setBackground(null);
        else if(e.getSource() == tdCmp_s)
           tdCmp_s.setBackground(null);
        
    }
   
  
    public static void main(String args[]) {
        new ToDoMainForm();
    }
}

class MemoContent implements Serializable {
	private String content;

	public MemoContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}