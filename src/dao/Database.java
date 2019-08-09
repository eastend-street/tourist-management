package dao;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Database extends JFrame {

    public Connection con;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ClassCastException("MySql driver not found");
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:8889/tourist_management", "root", "root");
        } catch (SQLException e) {
            throw new ClassCastException("Database connection error. Check your credentials");
        }
    }

    public ResultSet select(String query) {
//        ResultSet rs = null;
//        try {
//            Statement stmt = con.createStatement();
//            rs = stmt.executeQuery("SELECT * FROM Category");
//            while (rs.next())
//                System.out.println(rs.getString("category_name"));
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return rs;
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            throw new ClassCastException("It was not possible to select the data");
        }
        return rs;
    }

    public boolean modify(String query, String type) {
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            if (type.equals("update"))
                stmt.executeUpdate();
            else
                System.out.println(query);
                System.out.println(stmt);
                stmt.execute();
            con.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("It was not possible to close the connection");
        }
    }
}
