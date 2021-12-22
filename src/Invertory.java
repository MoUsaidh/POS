import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class Invertory extends JFrame{

    //db declare
    Connection con = Main.Connect();
    String query;
    ResultSet rs;

    //ui declare
    JPanel top;
    JPanel center;
    JPanel bottom;

    JTable itemst;
    JButton update;

    //constructor
    public Invertory(){
        setSize(1366,740);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        initcomponent();
        con();
        setExtendedState(Frame.MAXIMIZED_BOTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Invertory();
    }

    public void initcomponent(){
        //init
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        update = new JButton("update");

        //size
        top.setPreferredSize(new Dimension(100,70));

        //top.setBackground(Color.blue);
        center.setBackground(Color.MAGENTA);
        bottom.setPreferredSize(new Dimension(100,30));

        //add
        add(top, BorderLayout.NORTH);
        add(center,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);

        top.setBackground(Color.GRAY);
        JLabel Title = new JLabel("Inventory");
        Title.setFont(new Font("Serif",Font.PLAIN,40));
        top.add(Title);

        center.setLayout(new GridLayout());
        itemst = new JTable();
    }
    public void con(){
        //connection
        query = "select * from stock;";
        try{
            rs = con.prepareStatement(query).executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        itemst.setModel(DbUtils.resultSetToTableModel(rs));
        center.add(new JScrollPane(itemst));

        update.setSize(20,20);
        bottom.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                itemst.repaint();
            }
        });

    }
}