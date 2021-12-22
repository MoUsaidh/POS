import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class Updatestock extends JFrame {
    JPanel right;
    JPanel center;
    JPanel top;
    JTable items;
    //connection
    Connection con = Main.Connect();
    ResultSet rs;
    String query;
    //labels

    //constructor
    public Updatestock(){
        setSize(1000,700);
        setLayout(new BorderLayout());
        initcomponent();
        connect();
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void initcomponent(){
        right = new JPanel();
        center = new JPanel();
        top = new JPanel();
        items = new JTable();

        top.setPreferredSize(new Dimension(0,30));
        top.setBackground(Color.blue);
        add(top, BorderLayout.NORTH);

        //right components



        right.setPreferredSize(new Dimension(400,20));
        right.setBackground(Color.cyan);
        add(right, BorderLayout.EAST);
        setResizable(false);
        right.setLayout(null);

        center.setPreferredSize(new Dimension(400,0));
        center.setBackground(Color.red);
        add(center, BorderLayout.CENTER);
        center.setLayout(new GridLayout());
    }
    public void connect(){
        query = "select * from stock;";
        try{
            rs = con.prepareStatement(query).executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();

        }

        items.setModel(DbUtils.resultSetToTableModel(rs));
        center.add(new JScrollPane(items));
    }
    public static void main(String[] args) {
        new Updatestock();
    }
}