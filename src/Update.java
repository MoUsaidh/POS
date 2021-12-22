import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Update extends JFrame{
    //panels
    JPanel Center;
    JPanel right;
    //label
    JLabel title = new JLabel("Update Product");
    JLabel Productid = new JLabel("Product ID :");
    JLabel productname = new JLabel("Product Name :");
    JLabel Stockqty = new JLabel("Stock Quantity :");
    JLabel price = new JLabel("Price :");
    //Textfield
    JTextField Jfieldproduct;
    JTextField Jfieldpname;
    JTextField Jfieldqty;
    JTextField Jfieldprice;
    //buttons
    JButton search;
    JButton addu;
    JButton update;
    JButton delete;
    //connection
    Connection Conn = Main.Connect();
    ResultSet rs;

    public Update() {
        setSize(450,270);
        setLayout(new BorderLayout());
        initcomponent();
        connect();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public void initcomponent(){
        Center = new JPanel();
        right = new JPanel();

        //fields
        Jfieldproduct = new JTextField(40);
        Jfieldpname = new JTextField(40);
        Jfieldqty = new JTextField(40);
        Jfieldprice = new JTextField(40);

        //buttons
        search = new JButton("Search");
        addu = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");


        //right
        right.setPreferredSize(new Dimension(80,100));
        right.setBackground(Color.GRAY);
        //center
        Center.setLayout(null);

        //positions
        title.setBounds(10,5,120,30);
        Productid.setBounds(10,40,120,20);
        productname.setBounds(10,70,120,20);
        Stockqty.setBounds(10,100,120,20);
        price.setBounds(10,130,120,20);
        //JField pos
        Jfieldproduct.setBounds(120,40,100,20);
        Jfieldpname.setBounds(120,70,200,20);
        Jfieldqty.setBounds(120,100,200,20);
        Jfieldprice.setBounds(120,130,200,20);
        //button pos
        //search.setBounds();
        search.setBounds(230,40,90,20);
        addu.setBounds(10,180,100,30);
        update.setBounds(120,180,100,30);
        delete.setBounds(230,180,100,30);


        //add
        add(Center, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);
        Center.add(search);
        Center.add(title);
        Center.add(Productid);
        Center.add(productname);
        Center.add(Stockqty);
        Center.add(price);
        Center.add(Jfieldproduct);
        Center.add(Jfieldpname);
        Center.add(Jfieldqty);
        Center.add(Jfieldprice);
        Center.add(addu);
        Center.add(update);
        Center.add(delete);

    }
    public void connect(){
        //Actionlistener
        addu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try{
                    String Qprodid;
                    String Qname;
                    String Qqty;
                    String Qprice;

                    Qprodid = Jfieldproduct.getText();
                    Qname = Jfieldpname.getText();
                    Qqty = Jfieldqty.getText();
                    Qprice = Jfieldprice.getText();
                    String query = "insert into stock values ("+Qprodid+","+"'"+Qname+"'"+","+Qqty+","+Qprice+")";


                    Connection connect = Main.Connect();
                    Statement st = connect.createStatement();
                    int count = st.executeUpdate(query);
                    //System.out.println(count);
                    if(count == 1){
                        JOptionPane.showMessageDialog(null,"1 row added");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"There seem to be somekind of error while adding");
                    }


                    st.close();
                    connect.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
    public static void main(String[] args) {
        new Update();
    }
}