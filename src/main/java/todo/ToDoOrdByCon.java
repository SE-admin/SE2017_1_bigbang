package todo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
 
public class ToDoOrdByCon {
    String  tdSub, tdContent, tdStar, tdTime, tdCmp;

    ToDoOrdByCon() {}
    ToDoOrdByCon(Object data[], DefaultTableModel tableModel, ArrayList<ToDoInfo> list) {
    	
    	Collections.sort(list, new NameAscCompare());
    	System.out.printf("\n\n===== 오름 차순 정렬 =====\n");
    	for (ToDoInfo temp : list) {
    		System.out.println(temp);
    	}    	
    	tableModel.setNumRows(0);

    	for(int i=0;i<list.size();i++) {
    		data[0] = list.get(i).tdSub_s;
    		data[1] = list.get(i).tdStar_s;
    		data[2] = list.get(i).tdContent_s;
    		data[3] = list.get(i).tdTime_s;
    		data[4] = list.get(i).tdCmp_s;
    		
    		tableModel.addRow(data);
    	}
    }
    static class NameAscCompare implements Comparator<ToDoInfo> {
    	@Override
    	public int compare(ToDoInfo arg0, ToDoInfo arg1) {
    		return arg0.getTdContent_s().compareTo(arg1.getTdContent_s());
    	}
    }
}
