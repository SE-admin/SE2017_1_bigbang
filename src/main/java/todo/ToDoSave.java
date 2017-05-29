package todo;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class ToDoSave {
    String  tdSub, tdContent, tdStar, tdTime, tdCmp;
    BufferedOutputStream bos;
    ObjectOutputStream out;
    ToDoSave() {}
    ToDoSave( JTextField t_tdSub, JTextField t_tdContent,
            JTextField t_tdStar, JTextField t_tdTime, JTextField t_tdCmp,
            Object data[], DefaultTableModel tableModel,                             ArrayList<ToDoInfo> list) {
        try {
            bos = new BufferedOutputStream(
                    new FileOutputStream("data/ToDoList.dat"));
            out = new ObjectOutputStream(bos);
           
            // ����Ʈ ��ü�� ���鼭
            for(int i=0; i<list.size(); i++) {
                ToDoInfo info = list.get(i);
               
                tdSub = info.tdSub_s;
                tdContent = info.tdContent_s;
                tdStar = info.tdStar_s;
                tdTime = info.tdTime_s;
                tdCmp = info.tdCmp_s;
                // BookInfo ��ü�� ������
                out.writeObject(new ToDoInfo( tdSub, tdContent, tdStar, tdTime, tdCmp));
                System.out.printf(">>>save data: \t%s\t%s\t%s\t%s\t%s\n",
                       tdSub, tdContent, tdStar, tdTime, tdCmp);
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