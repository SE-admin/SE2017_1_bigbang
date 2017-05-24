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
 
public class MainForm extends JFrame implements ActionListener, FocusListener {
    String calName[] = { "���Ǹ�", "��米��", "���� ����", "���� �ð�", "���� �⵵","�б�" };
    Object data[] = new Object[6];
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane sp;
    ArrayList<BookInfo> list = new ArrayList<BookInfo>();
    JButton b_insert, b_delete, b_update, b_save, b_load, b_search,b_clear, b_exit;
    JTextField t_code, t_name, t_writer, t_genre, t_price,b_seme;
    JPanel panel;                   // ������ ���� ������Ʈ�� ��ġ��ų �г�
    
    public MainForm() {
        setLocation(200, 200);      // ������ ��ġ ����
        setSize(800, 400);          // ������ ũ�� ����
       
        // JTable
        tableModel = new DefaultTableModel(calName, 0);
        getContentPane().setLayout(null);
        table = new JTable(tableModel);
        sp = new JScrollPane(table);
        sp.setBounds(0, 0, 491, 378);
        getContentPane().add(sp);
       
        // �Է� ������Ʈ panel
        panel = new JPanel();
        panel.setBounds(491, 0, 309, 378);
        panel.setLayout(null);
        panel.add(t_code = new JTextField(5));
        t_code.setBounds(103, 0, 103, 37);
        panel.add(b_insert = new JButton("����"));
        b_insert.setBounds(206, 0, 103, 37);
        JLabel label_1 = new JLabel("��米��");
        label_1.setBounds(0, 49, 103, 37);
        panel.add(label_1);
        panel.add(t_name = new JTextField(5));
        t_name.setBounds(103, 49, 103, 37);
        panel.add(b_delete = new JButton("����"));
        b_delete.setBounds(206, 49, 103, 37);
        JLabel label_2 = new JLabel("\uAC15\uC758 \uC694\uC77C");
        label_2.setBounds(0, 98, 103, 37);
        panel.add(label_2);
        panel.add(t_writer = new JTextField(5));
        t_writer.setBounds(103, 98, 103, 37);
        panel.add(b_update = new JButton("����"));
        b_update.setBounds(206, 98, 103, 37);
        JLabel label_3 = new JLabel("\uAC15\uC758 \uC2DC\uAC04");
        label_3.setBounds(0, 147, 103, 37);
        panel.add(label_3);
        panel.add(t_genre = new JTextField(5));
        t_genre.setBounds(103, 147, 103, 37);
        panel.add(b_search = new JButton("�˻�"));
        b_search.setBounds(206, 147, 103, 37);
        JLabel label_4 = new JLabel("\uC218\uAC15 \uB144\uB3C4");
        label_4.setBounds(0, 196, 103, 37);
        panel.add(label_4);
        panel.add(t_price = new JTextField(5));
        t_price.setBounds(103, 196, 103, 37);
        panel.add(b_clear = new JButton("�ʵ� �ʱ�ȭ"));
        b_clear.setBounds(206, 196, 103, 37);
        panel.add(b_save = new JButton("����"));
        b_save.setBounds(206, 245, 103, 37);
        panel.add(b_load = new JButton("�ε�"));
        b_load.setBounds(206, 294, 103, 37);
        panel.add(b_exit = new JButton("�ǵ��ư���"));
        b_exit.setBounds(206, 335, 103, 37);
        getContentPane().add(panel);
        JLabel label = new JLabel(" \uACFC\uBAA9 \uBA85 ");
        label.setBounds(0, 0, 103, 37);
        panel.add(label);
        
        JLabel label_5 = new JLabel("\uD559\uAE30");
        label_5.setBounds(0, 245, 103, 37);
        panel.add(label_5);
        panel.add(b_seme = new JTextField(5));
        
        b_seme.setBounds(103, 245, 103, 37);
        panel.add(b_seme);
       
        // ������ ���� �̺�Ʈ
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
       
        // ���̺� Ŭ�� �̺�Ʈ
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Select();
            }
        });
       
        // ��ư �̺�Ʈ ������
        b_insert.addActionListener(this);
        b_delete.addActionListener(this);
        b_update.addActionListener(this);
        b_clear.addActionListener(this);
        b_search.addActionListener(this);
        b_save.addActionListener(this);
        b_load.addActionListener(this);
        b_exit.addActionListener(this);
       
        // �ؽ�Ʈ �ʵ� ��Ŀ�� ������
        t_code.addFocusListener(this);
        t_name.addFocusListener(this);
        t_writer.addFocusListener(this);
        t_genre.addFocusListener(this);
        t_price.addFocusListener(this);
        b_seme.addFocusListener(this);
 
        setVisible(true);
    }
 
    // ���̺� Ŭ���� �ش� ���� ���� �ؽ�Ʈ �ʵ忡 ����
    public void Select() {
        int row = table.getSelectedRow();
        System.out.println(">>>click position: " + row);
        // ���̺��� (row, ?) ��ġ�� �����͸� �ؽ�Ʈ �ʵ忡 ����
        t_code.setText((String)tableModel.getValueAt(row, 0)); 
        t_name.setText((String)tableModel.getValueAt(row, 1));
        t_writer.setText((String)tableModel.getValueAt(row, 2));
        t_genre.setText((String)tableModel.getValueAt(row, 3));
        t_price.setText((String)tableModel.getValueAt(row, 4));
        b_seme.setText((String)tableModel.getValueAt(row,5));
        System.out.println(">>>get data: "                                                          + tableModel.getValueAt(row, 0));
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // ���õ� ���̺��� ����ġ�� ������, ���õ��� �ʾ��� ��� -1 ��ȯ
        int row = table.getSelectedRow();  
       
        // ���� ��ư
        if(e.getSource() == b_insert) {            
            System.out.println(">>>click insert");
            new Insert(t_code, t_name, t_writer, t_genre, t_price,b_seme,
                    data, tableModel, list);
           
        } // ���� ��ư (���� �ڵ� �����ε� ���� �����ϵ��� ����)
        else if (e.getSource() == b_delete) {
            System.out.println(">>>click delete");
            if(row == -1)   return;         // ���� ���õ��� �ʾҴٸ� �н�
            BookInfo temp = list.get(row);  // ������ Ȯ���� ���� �κ�
            System.out.printf(">>>delete data: %s\t%s\t%s\t%s\t%s\t%s\n",
                    temp.b_code, temp.b_name, temp.b_writer, temp.b_code, temp.b_writer,temp.b_seme);          
            new Delete(row, t_code, tableModel, list);
           
        } // ���� ��ư
        else if (e.getSource() == b_update) {
            System.out.println(">>>click update");
            if(row == -1)   return; // ���� ���õ��� �ʾҴٸ� �н�
            // �ؽ�Ʈ �ʵ� ������ �����ͷ� ����Ʈ ��ġ �˻�
            String temp_code = (String)tableModel.getValueAt(row, 0);
            // ����Ʈ �� ������ ���濡 ����ϱ����ؼ� ���� ����
            int l_row = new Search(temp_code, list).searchData();
            BookInfo temp = list.get(l_row); // ������ Ȯ���� ���� �κ�
            System.out.println(">>>update code: "
                    + temp.b_code + " -> " + t_code.getText());        
            new Update(l_row, row, temp_code,
                    t_code, t_name, t_writer, t_genre, t_price,b_seme,
                    data, tableModel, list);
           
        } // ���� ��ư
        else if (e.getSource() == b_save) {
            System.out.println(">>>click save");
            new Save(t_code, t_name, t_writer, t_genre, t_price,b_seme,
                    data, tableModel, list);
           
        } // �ҷ����� ��ư
        else if (e.getSource() == b_load) {
            System.out.println(">>>click load");
            new Load(t_code, t_name, t_writer, t_genre, t_price,b_seme,
                    data, tableModel, list);
           
        } // �ؽ�Ʈ�ʵ� �ʱ�ȭ
        else if (e.getSource() == b_clear) {
            System.out.println(">>>click clear");
            t_code.setText("");
            t_name.setText("");
            t_writer.setText("");  
            t_genre.setText("");   
            t_price.setText("");  
            b_seme.setText("");
           
        } // �˻� ��ư (�׽�Ʈ �ʵ尡 ������� ���� ��ü ���)
        else if (e.getSource() == b_search) {      
            System.out.println(">>>click search");
            new Search(t_code, t_name, t_writer, t_genre, t_price,b_seme,
                    data, tableModel, list);
           
        } // ���� ��ư
        else if (e.getSource() == b_exit) {    
            System.out.println(">>>program exit");
            main.main m = new main.main();
            m.setVisible(true);
            setVisible(false);
            
        }
    }
 
    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
        // �ؽ�Ʈ �ʵ尡 ���õǾ��� �� �ش� �ؽ�Ʈ �ʵ��� ���� ����
        if(e.getSource() == t_code)
            t_code.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_name)
            t_name.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_writer)
            t_writer.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_genre)
            t_genre.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == t_price)
            t_price.setBackground(new Color(250, 244, 192));
        else if(e.getSource() == b_seme)
            b_seme.setBackground(new Color(250, 244, 192));
    }
 
    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
        // �ؽ�Ʈ �ʵ��� ������ �����Ǿ����� ���� ����
        if(e.getSource() == t_code)
            t_code.setBackground(null);
        else if(e.getSource() == t_name)
            t_name.setBackground(null);
        else if(e.getSource() == t_writer)
            t_writer.setBackground(null);
        else if(e.getSource() == t_genre)
            t_genre.setBackground(null);
        else if(e.getSource() == t_price)
            t_price.setBackground(null);
        else if(e.getSource() == b_seme)
            b_seme.setBackground(null);
    }
   
    // ���� �޼ҵ�
    public static void main(String args[]) {
        new MainForm();
    }
}