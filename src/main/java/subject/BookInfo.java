package subject;
import java.io.Serializable;
 
public class BookInfo implements Serializable {
    String b_code;      // �ڵ�
    String b_name;      // ����
    String b_writer;    // ����
    String b_genre;     // �帣
    String b_price;     // ����
    String b_seme;
    BookInfo(String b_code, String b_name,
            String b_writer, String b_genre, String b_price,String b_seme) {
        this.b_code = b_code;
        this.b_name = b_name;
        this.b_writer = b_writer;
        this.b_genre = b_genre;
        this.b_price = b_price;
        this.b_seme = b_seme;
    }
}