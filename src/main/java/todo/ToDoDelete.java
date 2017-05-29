package todo;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class ToDoDelete {
    ToDoDelete() {}
    ToDoDelete(int row, JTextField t_tdSub,
            DefaultTableModel tableModel, ArrayList<ToDoInfo> list) {
        // ������ Ȯ���� ���� �κ�
        ToDoInfo temp = list.get(row);
        System.out.printf(">>>delete data:  %s\t%s\t%s\t%s\t%s\n",
                 temp.tdSub_s, temp.tdContent_s, temp.tdStar_s, temp.tdTime_s, temp.tdCmp_s);
        String tdSub = t_tdSub.getText();
        int td_row = new ToDoSearch(tdSub, list).searchData();
        if(td_row != -1) {      
            tableModel.removeRow(td_row);
            list.remove(row);
        } else {
            System.out.println(">>>delete error");
            JOptionPane.showMessageDialog(null, "삭제할 줄이 없습니다.");
        }
    }
 
}