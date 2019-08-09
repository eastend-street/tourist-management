package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO extends Database {
    public int isAdmin_id;
    public int user_id;
    public String first_name;
    public String last_name;
    public String phone;
    public String email;
    public int passport_number;
    public String user_name;
    public String user_password;
    public int city_id;
    public int state_id;
    public int country_id;


    public UserDAO selectUser(String userName, String password) {
        String query = "SELECT * FROM Users WHERE user_name='" + userName +
                "' AND user_password='" + password + "';";
        UserDAO user = new UserDAO();
        try {
            ResultSet result = this.select(query);
            while (result.next()) {
                user.isAdmin_id = result.getInt("isAdmin_id");
                user.user_id = result.getInt("user_id");
                user.first_name = result.getString("first_name");
                user.last_name = result.getString("last_name");
                user.phone = result.getString("phone");
                user.email = result.getString("email");
                user.passport_number = result.getInt("passport_number");
                user.user_name = result.getString("user_name");
                user.user_password = result.getString("user_password");
                user.city_id = result.getInt("city_id");
                user.state_id = result.getInt("state_id");
                user.country_id = result.getInt("country_id");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.close();
        }

        return user;
    }

    public ArrayList<UserDAO> selectAllUser() {
        ArrayList<UserDAO> allUser = new ArrayList<UserDAO>();

        String query = "SELECT * FROM Users;";
        UserDAO user = new UserDAO();
        try {
            ResultSet result = this.select(query);
            while (result.next()) {
                user.isAdmin_id = result.getInt("isAdmin_id");
                user.user_id = result.getInt("user_id");
                user.first_name = result.getString("first_name");
                user.last_name = result.getString("last_name");
                user.phone = result.getString("phone");
                user.email = result.getString("email");
                user.passport_number = result.getInt("passport_number");
                user.user_name = result.getString("user_name");
                user.user_password = result.getString("user_password");
                user.city_id = result.getInt("city_id");
                user.state_id = result.getInt("state_id");
                user.country_id = result.getInt("country_id");
                allUser.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.close();
        }

        return allUser;
    }

    public void insertUsers() {
        String query = String.format("INSERT INTO Users VALUES('%d','%d','%s','%s','%s','%s','%s','%s','%s','%d','%d','%d');",
                this.isAdmin_id,this.user_id,this.first_name, this.last_name, this.phone, this.email, this.passport_number,this.user_name,this.user_password,
                this.city_id,this.state_id,this.country_id);
        System.out.println(query);
        try {
            this.modify(query, "insert");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteUsers() {
        String query = String.format("Delete from Users;");
        System.out.println(query);
        try {
            this.modify(query, "delete");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
