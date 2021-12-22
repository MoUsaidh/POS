import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu extends JFrame {
    JButton bill;
    JButton inventory;
    JButton addStock;
    JButton report;
    JButton sales;
    JButton logout;

    public mainMenu(){
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,3));
        setLocationRelativeTo(null);
        initcomponent();
        setVisible(true);
    }

    public void initcomponent(){
        bill = new JButton("Billing");
        inventory = new JButton("Inventory");
        addStock = new JButton("Edit Stocks");
        report = new JButton("Invoice Report");
        sales = new JButton("Sales Report");
        logout = new JButton("Logout");

        add(bill);
        add(inventory);
        add(addStock);
        add(report);
        add(sales);
        add(logout);

        //actionListeners
        bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Billing();
            }
        });

        inventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Invertory();
            }
        });

        addStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Update();
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new login();
                setVisible(false);
            }
        });
    }
    public static void main(String[] args) {
        new mainMenu();
    }
}