package subject;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class SubUpdate {
	   String subject, pro, day, time, year,seme; 
    JTextField t_sub, t_pro, t_day, t_time, t_year,t_seme;
    DefaultTableModel tableModel;
    ArrayList<SubInfo> list;
    Object data[];
    int l_row, row;
    SubUpdate() {}
    SubUpdate(int l_row, int row,
            String temp_sub, JTextField t_sub, JTextField t_pro,
            JTextField t_day, JTextField t_time, JTextField t_year,JTextField t_seme,
            Object data[], DefaultTableModel tableModel,                             ArrayList<SubInfo> list) {
        this.tableModel = tableModel;
        this.list = list;
        this.data = data;
        this.l_row = l_row;
        this.row = row;
        this.t_sub = t_sub;
        this.t_pro = t_pro;
        this.t_day = t_day;
        this.t_time = t_time;
        this.t_year = t_year;
        this.t_seme=t_seme;
       
        subject = t_sub.getText();
        pro = t_pro.getText();
        day = t_day.getText();
        time = t_time.getText();
        year = t_year.getText();
        seme = t_seme.getText();
       
       
        if(temp_sub.equals(subject)) {
            update();
        } 
        else {
          
            if(new SubSearch(t_sub.getText(), list).searchData() < 0) {      
                update();
            } else {
                System.err.println(">>>duplication code");
                JOptionPane.showMessageDialog(null, "같은 과목이 이미 들어있습니다.");
            }
        }
    }
   
    void update() {
       
        list.set(l_row, new SubInfo(subject, pro, day, time, year,seme));
       
      
        data[0] = subject;
        data[1] = pro;
        data[2] = day;
        data[3] = time;
        data[4] = year;
        data[5]=seme;
        tableModel.insertRow(row, data);
        tableModel.removeRow(row+1);   
       
       
        t_sub.setText("");
        t_pro.setText("");
        t_day.setText("");
        t_time.setText("");
        t_year.setText("");
        t_seme.setText("");
    }
}