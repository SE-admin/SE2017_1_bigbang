package subject;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class Save {
    String code, name, writer, genre, price,seme;
    BufferedOutputStream bos;
    ObjectOutputStream out;
    Save() {}
    Save(JTextField t_code, JTextField t_name, JTextField t_writer,
            JTextField t_genre, JTextField t_price,JTextField b_seme,
            Object data[], DefaultTableModel tableModel,                             ArrayList<BookInfo> list) {
        try {
            bos = new BufferedOutputStream(
                    new FileOutputStream("book.txt"));
            out = new ObjectOutputStream(bos);
           
            // ����Ʈ ��ü�� ���鼭
            for(int i=0; i<list.size(); i++) {
                BookInfo info = list.get(i);
                code = info.b_code;
                name = info.b_name;
                writer = info.b_writer;
                genre = info.b_genre;
                price = info.b_price;
                seme = info.b_seme;
                // BookInfo ��ü�� ������
                out.writeObject(new BookInfo(code, name, writer, genre,price,seme));
                System.out.printf(">>>save data: %s\t%s\t%s\t%s\t%s\t%s\n",
                        code, name, writer, genre, price,seme);
            }
        } catch (FileNotFoundException ffeo) {
            System.err.println("not found file");
        } catch (IOException ioe) {
            System.err.println("not read file");
        } finally {
            try {
                out.close();
            } catch (Exception e) {
            }
        }
    }
}