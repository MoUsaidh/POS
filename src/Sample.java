import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Sample {
    public static void main(String[] args) throws Exception{
        //update db
        String url = "jdbc:mysql://localhost:3306/pos";
        String uname = "root";
        String pass = "1";
        String Qprodid = "9";
        String Qname = "hjg";
        String Qqty = "30";
        String Qprice = "35";

        String query = "insert into stock values ("+Qprodid+","+"'"+Qname+"'"+","+Qqty+","+Qprice+")";


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection(url,uname,pass);
        Statement stmt = connect.createStatement();
        int count = stmt.executeUpdate(query);
        System.out.println(count);

        stmt.close();
        connect.close();
    }
}
