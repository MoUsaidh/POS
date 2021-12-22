import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame{
    //component declaration
    JTextField name;
    JPasswordField pass;
    JButton log;
    JButton cancel;
    JLabel namelabel;
    JLabel passlabel;

    public login(){
        setUndecorated(true);
        initcomponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void initcomponents(){
        setLayout(null);
        setSize(220,120);

        //init components
        name = new JTextField(20);
        pass = new JPasswordField(20);
        log = new JButton();
        cancel = new JButton();
        namelabel = new JLabel("username");
        passlabel = new JLabel("password");

        //*placement

        //labels
        namelabel.setBounds(20,20,70,20);
        passlabel.setBounds(20,50,70,20);
        //textfields
        name.setBounds(100,20,100,20);
        pass.setBounds(100,50,100,20);
        //buttons
        log.setBounds(130,80,70,20);
        cancel.setBounds(20,80,90,20);
        //buttons options
        log.setText("login");
        cancel.setText("cancel");

        //actionListeners
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (name.getText().equals("admin") && pass.getText().equals("admin")){
                    new mainMenu();
                    setVisible(false);
                }

            }
        });

        //*add
        add(name);
        add(pass);
        add(namelabel);
        add(passlabel);
        add(log);
        add(cancel);
    }
}