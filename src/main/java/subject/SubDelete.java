package subject;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class SubDelete {
    SubDelete() {}
    SubDelete(int row, JTextField t_subject,
            DefaultTableModel tableModel, ArrayList<SubInfo> list) {
     
        SubInfo temp = list.get(row);
        System.out.printf(">>>delete data: %s\t%s\t%s\t%s\t%s\t%s\n", temp.subName_s, temp.subPrf_s, temp.subDay_s, temp.subTime_s, temp.subYear_s, temp.subSem_s);
        String subject = t_subject.getText();
     
       
        if(row != -1) {      
            tableModel.removeRow(row);
            list.remove(row);
        } else {
            System.out.println(">>>delete error");
            JOptionPane.showMessageDialog(null,"삭제되지않앗습니다.");
        }
    }
 
}