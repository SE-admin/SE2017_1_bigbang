package todo;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 import subject.SubInfo;

public class ToDoInsert {
    String  tdSub, tdContent, tdStar, tdTime, tdCmp;
    
    ToDoInsert() {}
    ToDoInsert(JTextField t_tdSub, JTextField t_tdContent,
            JTextField t_tdStar, JTextField t_tdTime, JTextField t_tdCmp,
            Object data[], DefaultTableModel tableModel, ArrayList<ToDoInfo> list, ArrayList<SubInfo> list2) {
                 
       tdSub = t_tdSub.getText();
       tdContent = t_tdContent.getText();
       tdStar = t_tdStar.getText();
       tdTime = t_tdTime.getText();
       tdCmp = t_tdCmp.getText();
          
        if(!tdSub.equals("")) {         
            for(int i=0;i<100;i++)
            {
                if(tdSub.equals(ToDoSubLoad.sublist[i]))
                {                    
                    list.add(new ToDoInfo( tdSub, tdContent, tdStar, tdTime, tdCmp));      
                    ToDoInfo info = list.get(list.size() - 1);
                   
                    data[0] = info.tdSub_s;
                    data[1] = info.tdContent_s;
                    data[2] = info.tdStar_s;
                    data[3] = info.tdTime_s;
                    data[4] = info.tdCmp_s;
                    tableModel.addRow(data);
                    System.out.printf(">>>insert data:\t%s\t%s\t%s\t%s\t%s\n",
                            data[0], data[1], data[2], data[3], data[4]);
                  
                    t_tdSub.setText("");
                    t_tdContent.setText("");
                    t_tdStar.setText("");
                    t_tdTime.setText("");
                    t_tdCmp.setText("");
                    break;
                }else if(i == 99) {
                    System.err.println(">>>duplication subName");
                    JOptionPane.showMessageDialog(null, "들어있지않은 과목입니다");
                }
            }
        }  
        else {
            System.err.println(">>>not exist code");
            JOptionPane.showMessageDialog(null, "과목명을 입력하십시오");
        }
    }
}