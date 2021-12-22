import javax.swing.*;
import java.awt.*;

public class Billing extends JFrame {
    JTable Items;
    JPanel westp;
    JPanel northp;
    JPanel eastp;

    public Billing(){
        setSize(1366,740);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String data[][] = {{"1.", "ABC","1"}, {"2.", "DEF","1"}};
        String col[] = {"product id", "product name","quantity"};

        Items = new JTable(data,col);
        //Items.setSize(1000,1000);

        westp = new JPanel();
        westp.setPreferredSize(new Dimension(100,100));
        westp.setBackground(Color.red);
        add(westp,BorderLayout.CENTER);
        westp.setLayout(new GridLayout());
        westp.add(new JScrollPane(Items));


         northp= new JPanel();
        northp.setPreferredSize(new Dimension(100,40));
        northp.setBackground(Color.blue);
        add(northp,BorderLayout.NORTH);

        eastp = new JPanel();
        eastp.setPreferredSize(new Dimension(350,10));
        eastp.setBackground(Color.MAGENTA);
        add(eastp,BorderLayout.EAST);

        setVisible(true);


    }

/*    public static void main(String[] args) {
        Billing Bill = new Billing();
    }*/
}
