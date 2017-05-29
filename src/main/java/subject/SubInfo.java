package subject;
import java.io.Serializable;
 
public class SubInfo implements Serializable {
	 public String subName_s;      // �ڵ�
	 public String subPrf_s;      // ����
	 public String subDay_s;    // ����
	 public String subTime_s;     // �帣
	 public String subSem_s;     // ����
	 public String subYear_s;
    SubInfo(String subName_s, String subPrf_s,
            String subDay_s, String subTime_s, String b_year,String subSem_s) {
    	
        this.subName_s=subName_s;
        this.subPrf_s = subPrf_s;
        this.subDay_s = subDay_s;
        this.subTime_s = subTime_s;
        this.subYear_s = b_year;
        this.subSem_s =subSem_s;
    }

}