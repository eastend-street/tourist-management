import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame implements ActionListener {

    private JFrame loginFrame;
    private JFrame mainPageFrame;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public UserLogin(){
        initUserLogin();
    }


    private void initUserLogin(){

        loginFrame = new JFrame("Login");


        // All labels

        JLabel loginFormLabel = new JLabel("Welcome!");
        loginFormLabel.setForeground(Color.black);
        loginFormLabel.setFont(new Font("Serif", Font.BOLD, 20));


        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");

        JLabel mainPageLabel = new JLabel("Main Page");
        mainPageLabel.setFont(new Font("Serif", Font.BOLD, 20));

        // All text fields

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton loginButton = new JButton("Login");

        // Components configuration

        loginFormLabel.setBounds(240, 30, 400, 30);
        usernameLabel.setBounds(140, 70, 200, 30);
        passwordLabel.setBounds(140, 110, 200, 30);
        username.setBounds(240, 70, 200, 30);
        password.setBounds(240, 110, 200, 30);
        loginButton.setBounds(240, 160, 100, 30);

        mainPageLabel.setBounds(240, 30, 400, 30);


        loginFrame.add(loginFormLabel);
        loginFrame.add(usernameLabel);
        loginFrame.add(passwordLabel);
        loginFrame.add(username);
        loginFrame.add(password);
        loginFrame.add(loginButton);

        loginFrame.setSize(550,300);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);


        loginButton.addActionListener(this);




        // The code above is necessary to center the window at the center of the screen

        loginFrame.setLocation(dim.width/2- loginFrame.getSize().width/2, dim.height/2- loginFrame.getSize().height/2);



    }

    public void actionPerformed(ActionEvent e) {
        loginFrame.dispose();
        TableDisplay app = new TableDisplay();
        app.setLocation(dim.width/2- loginFrame.getSize().width/2, dim.height/2- loginFrame.getSize().height/2);
        app.setVisible(true);
    }

    Boolean checkingCredentials() {
        return true;
    }

    void isUserAdmin() {
        // code
    }
}


