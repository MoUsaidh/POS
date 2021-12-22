import java.sql.Connection;
import java.sql.DriverManager;

public class Main{
    public static void main(String[] args){
        //init
        Connect();
        new login();
    }

    public static Connection Connect(){

        String url = "jdbc:mysql://localhost:3306/pos";
        String uname = "root";
        String pass = "1";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url,uname,pass);
            return connect;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}


