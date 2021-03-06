package todo;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 import subject.SubInfo;
public class ToDoSubLoad {
    public static  Object[] sublist = new Object[100];
	String subName, subPrf, subDay, subTime, subYear,subSem;
    FileInputStream fis;
    ObjectInputStream in;

    SubInfo info;
    ToDoSubLoad() {}
    ToDoSubLoad(JTextField t_subject, JTextField t_pro, JTextField t_day,
            JTextField t_time, JTextField t_year, JTextField b_seme, Object data[], DefaultTableModel tableModel,ArrayList<SubInfo> list) {
        try {
            fis = new FileInputStream("data/SubjectList.dat");
            in = new ObjectInputStream(fis);
           int  i = 0;
            while(true) {
                info = (SubInfo) in.readObject();
                
                if(info == null) break;
                sublist[i]=info.subName_s;
                list.add(info);
                data[0] = info.subName_s;
               
                data[1] = info.subPrf_s;
                data[2] = info.subDay_s;
                data[3] = info.subTime_s;
                data[4] = info.subYear_s;
                data[5] = info.subSem_s;
               
      
                tableModel.addRow(data);
                System.out.printf(">>>load data: %s\t%s\t%s\t%s\t%s\t%s\n",
                        data[0], data[1], data[2], data[3], data[4],data[5]);
               
                i++;
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