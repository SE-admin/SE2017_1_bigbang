package todo;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class ToDoUpdate {
    String  tdSub, tdContent, tdStar, tdTime, tdCmp;  // ���ڿ��� ������ ����
    JTextField  tdSub_s, tdContent_s, tdStar_s, tdTime_s,dCmp_s;// �ؽ�Ʈ �ʵ�
    DefaultTableModel tableModel;
    ArrayList<ToDoInfo> list;
    Object data[];
    int l_row, row; // l_row: ����Ʈ�� �ε��� ��, row: ���̺��� �ε��� ��
    ToDoUpdate() {}
    ToDoUpdate(int l_row, int row,
            String temp_tdSub,  JTextField tdSub_s,
            JTextField tdContent_s, JTextField tdStar_s, JTextField tdTime_s,JTextField dCmp_s,
            Object data[], DefaultTableModel tableModel,                             ArrayList<ToDoInfo> list) {
        this.tableModel = tableModel;
        this.list = list;
        this.data = data;
        this.l_row = l_row;
        this.row = row;
      
        this.tdSub_s = tdSub_s;
        this.tdContent_s = tdContent_s;
        this.tdStar_s = tdStar_s;
        this.tdTime_s = tdTime_s;
        this.dCmp_s=dCmp_s;
       
       
        tdSub = tdSub_s.getText();
        tdContent = tdContent_s.getText();
        tdStar = tdStar_s.getText();
        tdTime = tdTime_s.getText();
        tdCmp = dCmp_s.getText();
       
       
        if(temp_tdSub.equals(tdSub)) {
            update();
        } 
        
    }
   
    void update() {
     
        list.set(l_row, new ToDoInfo( tdSub, tdContent, tdStar, tdTime, tdCmp));
       
      
      
        data[0] = tdSub;
        data[1] = tdContent;
        data[2] = tdStar;
        data[3] = tdTime;
        data[4]=tdCmp;
        tableModel.insertRow(row, data);
        tableModel.removeRow(row+1);   
       
        // ������ ���� �� �ؽ�Ʈ �ʵ带 �ʱ�ȭ ��Ŵ
        
        tdSub_s.setText("");
        tdContent_s.setText("");
        tdStar_s.setText("");
        tdTime_s.setText("");
        dCmp_s.setText("");
    }
}