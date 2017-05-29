package subject;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class SubInsert {
	String subName;
	String subPrf;
	String subDay;
	String subTime;
	String subYear;
	String subSem;
    SubInsert() {}
    SubInsert(JTextField t_subject, JTextField t_pro, JTextField t_day,
            JTextField t_time, JTextField t_year, JTextField b_seme,
            Object data[], DefaultTableModel tableModel,  ArrayList<SubInfo> list) {
        subName = t_subject.getText();
        subPrf = t_pro.getText();
        subDay = t_day.getText();
        subTime = t_time.getText();
        subYear = t_year.getText();
        subSem = b_seme.getText();
       
        
        if(!subName.equals("")) {
           
            if(new SubSearch(subName, list).searchData() < 0) {  
            
                list.add(new SubInfo(subName, subPrf, subDay, subTime,subYear,subSem));
               
            
                SubInfo info = list.get(list.size() - 1);
                data[0] = info.subName_s;
                data[1] = info.subPrf_s;
                data[2] = info.subDay_s;
                data[3] = info.subTime_s;
                data[4] = info.subYear_s;
                data[5]=info.subSem_s;
                tableModel.addRow(data);
                System.out.printf(">>>insert data: %s\t%s\t%s\t%s\t%s\t%s\n",
                        data[0], data[1], data[2], data[3], data[4],data[5]);
               
                
                t_subject.setText("");
                t_pro.setText("");
                t_day.setText("");
                t_time.setText("");
                t_year.setText("");
                b_seme.setText("");
            } else {
                System.err.println(">>>duplication subName");
                JOptionPane.showMessageDialog(null, "이미 들어있는 과목입니다");
            }
        } else {
            System.err.println(">>>not exist subName");
            JOptionPane.showMessageDialog(null, "기입을 하시고 삽입버튼을 눌러주세요");
        }
    }
}