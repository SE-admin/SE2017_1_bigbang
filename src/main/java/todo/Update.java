package todo;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class Update {
    String code, name, writer, genre, price,seme;  // ���ڿ��� ������ ����
    JTextField t_code, t_name, t_writer, t_genre, t_price,t_seme;// �ؽ�Ʈ �ʵ�
    DefaultTableModel tableModel;
    ArrayList<BookInfo> list;
    Object data[];
    int l_row, row; // l_row: ����Ʈ�� �ε��� ��, row: ���̺��� �ε��� ��
    Update() {}
    Update(int l_row, int row,
            String temp_code, JTextField t_code, JTextField t_name,
            JTextField t_writer, JTextField t_genre, JTextField t_price,JTextField t_seme,
            Object data[], DefaultTableModel tableModel,                             ArrayList<BookInfo> list) {
        this.tableModel = tableModel;
        this.list = list;
        this.data = data;
        this.l_row = l_row;
        this.row = row;
        this.t_code = t_code;
        this.t_name = t_name;
        this.t_writer = t_writer;
        this.t_genre = t_genre;
        this.t_price = t_price;
        this.t_seme=t_seme;
       
        code = t_code.getText();
        name = t_name.getText();
        writer = t_writer.getText();
        genre = t_genre.getText();
        price = t_price.getText();
        seme = t_seme.getText();
       
        // �ؽ�Ʈ �ʵ��� ���� ��ȭ�� ���ٸ� �״�� ����
        if(temp_code.equals(code)) {
            update();
        } //  �ؽ�Ʈ �ʵ��� ���� ��ȭ��ٸ� �ߺ�üũ
        else {
            // �ڵ尪 ������ ����Ʈ�� �ߺ��� �ڵ尡 �ִ����� üũ
            if(new Search(t_code.getText(), list).searchData() < 0) {      
                update();
            } else {
                System.err.println(">>>duplication code");
                JOptionPane.showMessageDialog(null, "�ߺ��� �ڵ尡 �����մϴ�");
            }
        }
    }
   
    void update() {
        // ����Ʈ���� row ��ġ�� �����͸� ����
        list.set(l_row, new BookInfo(code, name, writer, genre, price,seme));
       
        // ���̺��� row ��ġ�� ���ο� ���� �߰���Ű��
        // �ڷ� �з��� ������ �ฦ ������Ŵ
        data[0] = code;
        data[1] = name;
        data[2] = writer;
        data[3] = genre;
        data[4] = price;
        data[5]=seme;
        tableModel.insertRow(row, data);
        tableModel.removeRow(row+1);   
       
        // ������ ���� �� �ؽ�Ʈ �ʵ带 �ʱ�ȭ ��Ŵ
        t_code.setText("");
        t_name.setText("");
        t_writer.setText("");
        t_genre.setText("");
        t_price.setText("");
        t_seme.setText("");
    }
}