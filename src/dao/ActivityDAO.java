package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ActivityDAO extends Database {
    public int activity_id;
    public String activity_name;
    public int city_id;
    public int state_id;
    public int country_id;
    public String address;
    public int price;


    public ArrayList<ActivityDAO> selectAll() {
        ArrayList<ActivityDAO> activitiesList = new ArrayList<ActivityDAO>();
        String query = "SELECT * FROM Activity;";
        ActivityDAO activity = new ActivityDAO();
        try {
            ResultSet result = this.select(query);
            while (result.next()) {
                activity.activity_id = result.getInt("activity_id");
                activity.activity_name = result.getString("activity_name");
                activity.city_id = result.getInt("city_id");
                activity.state_id = result.getInt("state_id");
                activity.country_id = result.getInt("country_id");
                activity.address = result.getString("address");
                activity.price = result.getInt("price");
                activitiesList.add(activity);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.close();
        }

        return activitiesList;
    }
}
