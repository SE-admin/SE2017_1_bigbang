package subject;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
/*
 *  ��� �ؽ�Ʈ �ʵ尡 ������� ���� ��ü ���
 */
public class Search {
    String code, name, writer, genre, price,seme; // �迭�� �����͸� ������ ����
    String s_code, s_name, s_writer, s_genre, s_price,s_seme; // �ؽ�Ʈ �ʵ� ��                                                             �� ������ ����
    String temp_code;  // �˻��ϴµ� Ű ������ ���� �ڵ�
    ArrayList<BookInfo> list;
    Search(String temp_code, ArrayList<BookInfo> list) {
        this.temp_code = temp_code;
        this.list = list;
    }
    Search(JTextField t_code, JTextField t_name, JTextField t_writer,
            JTextField t_genre, JTextField t_price,JTextField t_seme,
            Object data[], DefaultTableModel tableModel,                             ArrayList<BookInfo> list) {
        s_code = t_code.getText();
        s_name = t_name.getText();
        s_writer = t_writer.getText();
        s_genre = t_genre.getText();
        s_price = t_price.getText();
        s_seme = t_seme.getText();
       
        // �˻��� ������ ����� ���̺��� �ʱ�ȭ ��Ŵ
        try {
            for(int i=0; i<list.size(); i++) {
                tableModel.removeRow(0);
            }
        } catch (Exception e) { }
 
        // ����Ʈ�� ���鼭 �����͸� �˻�
        for(int i=0; i<list.size(); i++) {
            BookInfo info = list.get(i);
            code = info.b_code;
            name = info.b_name;
            writer = info.b_writer;
            genre = info.b_genre;
            price = info.b_price;
            seme = info.b_seme;
           
            // indexOf > �ش� ���ڿ��� �����Ѵٸ� ��ġ, �� �̿� -1 ����
            // �ؽ�Ʈ �ʵ尡 ������� ��� 0�� ������
            if( code.indexOf(s_code) != -1 &&
                    name.indexOf(s_name) != -1 &&
                    writer.indexOf(s_writer) != -1 &&
                    genre.indexOf(s_genre) != -1 &&
                    price.indexOf(s_price) != -1  &&
            		seme.indexOf(s_seme) != -1 ){
                data[0] = code;
                data[1] = name;
                data[2] = writer;
                data[3] = genre;
                data[4] = price;
                data[5]=seme;
                // ���̺� ���ǹ��� �����ϴ� �����͸� �߰�
                tableModel.addRow(data);
            }
           
        }
    }  
   
    // �迭�� ��ȸ�ϸ鼭 �ڵ��� ���翩�� �˻�
    public int searchData() {
        // ����Ʈ�� �����ϰ� ���� �� �˻�
        if(list.size() != 0) {
            for(int i=0; i<list.size(); i++) {
                BookInfo info = list.get(i);
                if(info.b_code.equals(temp_code)) {
                    // ����Ʈ�� �ߺ��� �ڵ尡 �ִٸ�
                    return i;
                }
            }
            // ����Ʈ�� �ߺ��� �ڵ尡 ���ٸ�
            return -1;
        }
        // ����Ʈ�� �������� �ʴ´ٸ�
        return -1;
    }
}
 