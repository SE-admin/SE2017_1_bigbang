package todo;
import java.io.Serializable;
 
public class ToDoInfo implements Serializable {
       
    public String tdSub_s;      // to do 과목명
    public String tdContent_s;    // 내용
    public String tdStar_s;     // 별점
    public String tdTime_s;     // to do 마감일
    public String tdCmp_s;      // 완료여부
    
    ToDoInfo( String tdSub_s, String tdStar_s,String tdContent_s, String tdTime_s ,String tdCmp_s) {
    
       this.tdSub_s = tdSub_s;
       this.tdStar_s = tdStar_s;
        this.tdContent_s = tdContent_s;
        this.tdTime_s = tdTime_s;
        this.tdCmp_s = tdCmp_s;
    }

    public String getTdSub_s() {
        return tdSub_s;
    }

    public void setTdSub_s(String tdSub_s) {
        this.tdSub_s = tdSub_s;
    }

    public String getTdStar_s() {
        return tdStar_s;
    }

    public void setTdStar_s(String tdStar_s) {
        this.tdStar_s = tdStar_s;
    }
    public String getTdContent_s() {
        return tdContent_s;
    }

    public void setTdContent_s(String tdContent_s) {
        this.tdContent_s = tdContent_s;
    }

   

    public String getTdTime_s() {
        return tdTime_s;
    }

    public void setTdTime_s(String tdTime_s) {
        this.tdTime_s = tdTime_s;
    }

    public String getTdCmp_s() {
        return tdCmp_s;
    }

    public void setTdCmp_s(String tdCmp_s) {
        this.tdCmp_s = tdCmp_s;
    }

    @Override
    public String toString() {
        return "ToDoInfo [tdSub_s=" + tdSub_s + ", tdStar_s=" + tdStar_s+ ", tdContent_s=" + tdContent_s + ", tdTime_s=" + tdTime_s + ", tdCmp_s=" + tdCmp_s + "]";
    }


}