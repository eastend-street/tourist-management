import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Display extends JFrame {

    public Connection con;

    public Display(){
        initDisplay();
        connectDatabaseTest();
    }

    void initDisplay(){
        this.setTitle("Hotel management");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        JLabel label = new JLabel("Login");
        JButton button1 = new JButton("Login");
        p.add(button1);
        Container contentPane = getContentPane();
        p.setBackground(Color.white);
        contentPane.add(p, BorderLayout.CENTER);

        this.setVisible(true);
    }

    void connectDatabaseTest(){
//        try{
//            System.out.println("hello");
//            Connection connection_mysql = null;
//            connection_mysql = DriverManager.getConnection("jdbc:mysql://localhost:8889", "root", "root");
//        } catch (SQLException e) {
//            System.out.println("exception");
//        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ClassCastException("MySql driver not found");
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:8889/test","root","root");
        }catch (SQLException e) {
            throw new ClassCastException("Database connection error. Check your credentials");
        }
        this.select();
    }

    public ResultSet select () {
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM test");
            while(rs.next())
                System.out.println(rs.getString("name"));
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }
}
