package todo;
import java.io.Serializable;
 
public class ToDoInfo implements Serializable {
       
	public String tdSub_s;      // to do 과목명
    public String tdContent_s;    // 내용
    public String tdStar_s;     // 별점
    public String tdTime_s;     // to do 마감일
    public String tdCmp_s;      // 완료여부
	
    ToDoInfo( String tdSub_s,String tdContent_s, String tdStar_s, String tdTime_s ,String tdCmp_s) {
    
       this.tdSub_s = tdSub_s;
        this.tdContent_s = tdContent_s;
        this.tdStar_s = tdStar_s;
        this.tdTime_s = tdTime_s;
        this.tdCmp_s = tdCmp_s;
    }
}