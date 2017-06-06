package todo;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 

public class ToDoSearch {
    String tdSub, tdContent, tdStar, tdTime, tdCmp; 
    String  s_tdSub, s_tdContent, s_tdStar, s_tdTime, s_tdCmp;
    String temp_tdSub; 
    ArrayList<ToDoInfo> list;
    ToDoSearch(String temp_tdSub, ArrayList<ToDoInfo> list) {
        this.temp_tdSub = temp_tdSub;
        this.list = list;
    }
    ToDoSearch( JTextField t_tdSub, 
            JTextField t_tdStar,JTextField t_tdContent, JTextField t_tdTime, JTextField t_tdCmp,
            Object data[], DefaultTableModel tableModel, ArrayList<ToDoInfo> list) {
   
       s_tdSub = t_tdSub.getText();
       s_tdStar = t_tdStar.getText();
       s_tdContent = t_tdContent.getText();
       s_tdTime = t_tdTime.getText();
       s_tdCmp = t_tdCmp.getText();
       
       
        try {
            for(int i=0; i<list.size(); i++) {
                tableModel.removeRow(0);
            }
        } catch (Exception e) { }
 
        
        for(int i=0; i<list.size(); i++) {
            ToDoInfo info = list.get(i);
            
            tdSub = info.tdSub_s;
            tdStar = info.tdStar_s;
            tdContent = info.tdContent_s;
            tdTime = info.tdTime_s;
            tdCmp = info.tdCmp_s;
           
           
            if(
                  tdSub.indexOf(s_tdSub) != -1 &&
                  tdStar.indexOf(s_tdStar) != -1 &&
                  tdContent.indexOf(s_tdContent) != -1 &&
                  tdTime.indexOf(s_tdTime) != -1  &&
                  tdCmp.indexOf(s_tdCmp) != -1 ){
              
                data[0] = tdSub;
                data[1] = tdStar;
                data[2] = tdContent;
                data[3] = tdTime;
                data[4] = tdCmp;
               
                tableModel.addRow(data);
            }
           
        }
    }  
   
   
    public int searchData() {
       
        if(list.size() != 0) {
            for(int i=0; i<list.size(); i++) {
                ToDoInfo info = list.get(i);
                if(info.tdSub_s.equals(temp_tdSub)) {
                   
                   return i;
                }
            }
          
            return -1;
        }
      
        return -1;
    }
}
