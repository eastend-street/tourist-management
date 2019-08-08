package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO extends Database {

    public int id;
    public String name;

    public void insert() {
        String query = String.format("INSERT INTO poi_category (name) " +
                "VALUES('%s')", this.name);
        System.out.println(query);
        try {
            this.modify(query, "insert");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update() {

        String query = String.format("UPDATE poi_category " +
                "SET name = '%s' " +
                "WHERE id = %d", this.name, this.id);
        try {
            this.modify(query, "update");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete() {

        String query = String.format("DELETE FROM poi_category " +
                "WHERE id = %d", this.id);
        try {
            this.modify(query, "delete");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<CategoryDAO> selectAll() {
        ArrayList<CategoryDAO> categories = new ArrayList<CategoryDAO>();
        String query = "SELECT * FROM poi_category";

        try {
            ResultSet result = this.select(query);
            while (result.next()) {
                CategoryDAO category = new CategoryDAO();
                category.id = result.getInt("id");
                category.name = result.getString("name");
                categories.add(category);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.close();
        }

        return categories;
    }

    public void selectById() {

        String query = "SELECT * FROM users " +
                "INNER JOIN country ON country.id = users.country" +
                "INNER JOIN country ON country.id = users.country" +
                "INNER JOIN country ON country.id = users.country" +
                "INNER JOIN country ON country.id = users.country" +
                "WHERE users.id = 4";
    }
}
