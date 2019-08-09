package dao;

import java.sql.ResultSet;

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
}
