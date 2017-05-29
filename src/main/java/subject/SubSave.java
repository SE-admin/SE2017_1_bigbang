package subject;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class SubSave {
    String subject, pro, day, time, year,seme;
    BufferedOutputStream bos;
    ObjectOutputStream out;
    SubSave() {}
    SubSave(JTextField t_subject, JTextField t_pro, JTextField t_day,
            JTextField t_time, JTextField t_year,JTextField b_seme,
            Object data[], DefaultTableModel tableModel, ArrayList<SubInfo> list) {
        try {
            bos = new BufferedOutputStream(
                    new FileOutputStream("data/SubjectList.dat"));
            out = new ObjectOutputStream(bos);
           
           
            for(int i=0; i<list.size(); i++) {
                SubInfo info = list.get(i);
                subject = info.subName_s;
                pro = info.subPrf_s;
                day = info.subDay_s;
                time = info.subTime_s;
                year = info.subYear_s;
                seme = info.subSem_s;
             
                out.writeObject(new SubInfo(subject, pro, day, time,year,seme));
                System.out.printf(">>>save data: %s\t%s\t%s\t%s\t%s\t%s\n",
                        subject, pro, day, time, year,seme);
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