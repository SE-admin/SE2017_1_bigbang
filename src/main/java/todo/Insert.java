package todo;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class Insert {
    String code, name, writer, genre, price,seme;
    Insert() {}
    Insert(JTextField t_code, JTextField t_name, JTextField t_writer,
            JTextField t_genre, JTextField t_price, JTextField b_seme,
            Object data[], DefaultTableModel tableModel,                             ArrayList<BookInfo> list) {
        code = t_code.getText();
        name = t_name.getText();
        writer = t_writer.getText();
        genre = t_genre.getText();
        price = t_price.getText();
        seme = b_seme.getText();
       
        // �ڵ� �ʵ尡 �����϶��� �Է� �� �� ����
        if(!code.equals("")) {
            // �ߺ��� �ڵ尡 �������� �ʴ´ٸ�
            if(new Search(code, list).searchData() < 0) {  
                // ����Ʈ�� �����͸� �߰���Ŵ
                list.add(new BookInfo(code, name, writer, genre,price,seme));
               
                // ���̺��� ������ �࿡ �����͸� �߰���Ŵ
                BookInfo info = list.get(list.size() - 1);
                data[0] = info.b_code;
                data[1] = info.b_name;
                data[2] = info.b_writer;
                data[3] = info.b_genre;
                data[4] = info.b_price;
                data[5]=info.b_seme;
                tableModel.addRow(data);
                System.out.printf(">>>insert data: %s\t%s\t%s\t%s\t%s\t%s\n",
                        data[0], data[1], data[2], data[3], data[4],data[5]);
               
                // ������ �߰��� ���� �� �ؽ�Ʈ �ʵ带 �ʱ�ȭ
                t_code.setText("");
                t_name.setText("");
                t_writer.setText("");
                t_genre.setText("");
                t_price.setText("");
                b_seme.setText("");
            } else {
                System.err.println(">>>duplication code");
                JOptionPane.showMessageDialog(null, "�ߺ��� �ڵ尡 �����մϴ�");
            }
        } else {
            System.err.println(">>>not exist code");
            JOptionPane.showMessageDialog(null, "�ڵ尡 �Էµ��� �ʾҽ��ϴ�");
        }
    }
}