package todo;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class Delete {
    Delete() {}
    Delete(int row, JTextField t_code,
            DefaultTableModel tableModel, ArrayList<BookInfo> list) {
        // ������ Ȯ���� ���� �κ�
        BookInfo temp = list.get(row);
        System.out.printf(">>>delete data: %s\t%s\t%s\t%s\t%s\t%s\n",
                temp.b_code, temp.b_name, temp.b_writer, temp.b_code, temp.b_writer, temp.b_seme);
        String code = t_code.getText();
        // ����Ʈ ���� �ڵ��� ���� ������ �˻��ϰ� �ε����� ��ȯ
        int s_row = new Search(code, list).searchData();
        if(s_row != -1) {      
            tableModel.removeRow(s_row);
            list.remove(row);
        } else {
            System.out.println(">>>delete error");
            JOptionPane.showMessageDialog(null,                                                               "����Ʈ�� �ڵ尡 �������� �ʽ��ϴ�.");
        }
    }
 
}