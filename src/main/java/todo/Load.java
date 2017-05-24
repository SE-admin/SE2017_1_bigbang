package todo;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class Load {
    String code, name, writer, genre, price,seme;
    FileInputStream fis;
    ObjectInputStream in;
    BookInfo info;
    Load() {}
    Load(JTextField t_code, JTextField t_name, JTextField t_writer,
            JTextField t_genre, JTextField t_price, JTextField b_seme,
            Object data[], DefaultTableModel tableModel,ArrayList<BookInfo> list) {
        try {
            fis = new FileInputStream("book.txt");
            in = new ObjectInputStream(fis);
           
            while(true) {
                info = (BookInfo) in.readObject();
                // �о���� ��ü�� null �̶�� �ݺ��� ����
                if(info == null) break;
                // �о���� ��ü�� ����Ʈ�� �߰���Ŵ
                list.add(info);
                data[0] = info.b_code;
                data[1] = info.b_name;
                data[2] = info.b_writer;
                data[3] = info.b_genre;
                data[4] = info.b_price;
                data[5] = info.b_seme;
                // �о���� ��ü �����͸� Object �迭�� ������ ���̺� �߰���
                tableModel.addRow(data);
                System.out.printf(">>>load data: %s\t%s\t%s\t%s\t%s\t%s\n",
                        data[0], data[1], data[2], data[3], data[4],data[5]);
            }
           
        } catch (FileNotFoundException ffe) {
            System.err.println("not found file");
        } catch (ClassNotFoundException e) {
            System.err.println("not found class");
        } catch (IOException iod) {
            System.out.println(">>>file load fin.");
        }
        finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }
}