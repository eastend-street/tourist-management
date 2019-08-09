import dao.ActivityDAO;
import dao.UserDAO;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private int sample;

    public static void main(String[] args) {
//        UserDAO userDAO = new UserDAO();
//        UserDAO user = userDAO.selectUser("john", "password");
//        System.out.println(user.user_name);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserLogin loginPage = new UserLogin();
            }
        });
    }
}
