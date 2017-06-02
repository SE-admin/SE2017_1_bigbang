package todo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class ToDoOrdByNm {
    String  tdSub, tdContent, tdStar, tdTime, tdCmp;
    FileInputStream fis;
    ObjectInputStream in;
    ToDoInfo info;
    String name;
    Map<String, Object[]> map = new HashMap<String, Object[]>();
    ToDoOrdByNm() {}
    <map> ToDoOrdByNm( JTextField t_tdSub, JTextField t_tdContent,
            JTextField t_tdStar, JTextField t_tdTime, JTextField t_tdCmp,
            Object data[], DefaultTableModel tableModel,ArrayList<ToDoInfo> list) {
        try {
            fis = new FileInputStream("data/ToDoList.dat");
            in = new ObjectInputStream(fis);
           
            while(true) {
                info = (ToDoInfo) in.readObject();
           
                if(info == null) break;
           
                list.add(info);
              
                data[0] = info.tdSub_s;
                data[1] = info.tdContent_s;
                data[2] = info.tdStar_s;
                data[3] = info.tdTime_s;
                data[4] = info.tdCmp_s;
             
                name = info.tdSub_s.toString();
                map.put(name, data); //map에 넣음
            }   
            
            TreeMap<String,Object[]> tm = new TreeMap<String,Object[]>(map);
            Iterator<String> keys = tm.keySet( ).iterator( );//오름차순 정렬
            
            while(keys.hasNext()){
            	String key = keys.next();
            	System.out.println(String.format("키 : %s", key));
            	tableModel.addRow(tm.get(key));
            	System.out.printf(">>>load data: \t%s\t%s\t%s\t%s\t%s\n",
                        data[0], data[1], data[2], data[3], data[4]);
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