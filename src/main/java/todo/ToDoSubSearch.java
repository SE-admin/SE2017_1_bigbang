package todo;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import subject.SubInfo;
import subject.SubInfo;

public class ToDoSubSearch {
    String subject, pro, day, time, year,seme; 
    String s_subject, s_pro, s_day, s_time, s_year,s_seme;                                                    
    String temp_subject; 
    ArrayList<SubInfo> list;
    ToDoSubSearch(String temp_subject, ArrayList<SubInfo> list) {
        this.temp_subject = temp_subject;
        this.list = list;
    }
    ToDoSubSearch(JTextField t_subject, JTextField t_pro, JTextField t_day,
            JTextField t_time, JTextField t_year,JTextField t_seme,
            Object data[], DefaultTableModel tableModel,ArrayList<SubInfo> list) {
        s_subject = t_subject.getText();
        s_pro = t_pro.getText();
        s_day = t_day.getText();
        s_time = t_time.getText();
        s_year = t_year.getText();
        s_seme = t_seme.getText();
       
       
        try {
            for(int i=0; i<list.size(); i++) {
                tableModel.removeRow(0);
            }
        } catch (Exception e) { }
 
      
        for(int i=0; i<list.size(); i++) {
            SubInfo info = list.get(i);
            subject = info.subName_s;
            pro = info.subPrf_s;
            day = info.subDay_s;
            time = info.subTime_s;
            year = info.subYear_s;
            seme = info.subSem_s;
           
            if( subject.indexOf(s_subject) != -1 &&
                    pro.indexOf(s_pro) != -1 &&
                    day.indexOf(s_day) != -1 &&
                    time.indexOf(s_time) != -1 &&
                    year.indexOf(s_year) != -1  &&
            		seme.indexOf(s_seme) != -1 ){
                data[0] = subject;
                data[1] = pro;
                data[2] = day;
                data[3] = time;
                data[4] = year;
                data[5]=seme;
              
                tableModel.addRow(data);
            }
           
        }
    }  
   
  
    public int searchData() {
      
        if(list.size() != 0) {
            for(int i=0; i<list.size(); i++) {
                SubInfo info = list.get(i);
                if(info.subName_s.equals(temp_subject)) {
                    
                    return i;
                }
            }
           
            return -1;
        }

        return -1;
    }
}
 