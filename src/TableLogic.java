import dao.CategoryDAO;
import dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableLogic extends AbstractTableModel{


    ArrayList<Object[]> data = new ArrayList<Object[]>();
    String[] columns = {"isAdmin_id", "user_id", "first_name", "last_name", "phone", "email", "passport_number", "user_name", "user_password", "city_id", "state_id","country_id"};

    public TableLogic() {
        /*data.add(new Object[]{"X", "100", true});
        data.add(new Object[]{"X", "200", false});
        data.add(new Object[]{"X", "300", false});
        data.add(new Object[]{"Y", "400", false});
        data.add(new Object[]{"Y", "500", false});
        data.add(new Object[]{"Z", "600", false});
        data.add(new Object[]{"Z", "700", false});*/

        UserDAO userDAO = new UserDAO();
        List<UserDAO> allUsers = userDAO.selectAllUser();

        int cnt = 0;
        for(UserDAO s: allUsers){
            data.add(new Object[]{s.isAdmin_id, s.user_id, s.first_name, s.last_name, s.phone, s.email, s.passport_number, s.user_name, s.user_password, s.city_id, s.state_id, s.country_id});
        }



    }

    public void addRow() {
        data.add(new Object[] {2,0,"john","smith","000-000-000","john@gmail.com" ,999999999 ,"john", "password",1,1,1});
        fireTableRowsInserted(0, data.size()-1);
    }

    public void deleteRow(int rowIndex) {

        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex,rowIndex);

    }

    public void save() {
        UserDAO userDAO = new UserDAO();
        //userDAO.deleteUsers();
        for(int i = 0; i < data.size();i++){

            userDAO.isAdmin_id = (int)data.get(i)[0];
            userDAO.user_id = (int)data.get(i)[1];
            userDAO.first_name = (String)data.get(i)[2];
            userDAO.last_name = (String)data.get(i)[3];
            userDAO.phone = (String)data.get(i)[4];
            userDAO.email = (String)data.get(i)[5];
            userDAO.passport_number = (int)data.get(i)[6];
            userDAO.user_name = (String)data.get(i)[7];
            userDAO.user_password = (String)data.get(i)[8];
            userDAO.city_id = (int)data.get(i)[9];
            userDAO.state_id = (int)data.get(i)[10];
            userDAO.country_id = (int)data.get(i)[11];
            userDAO.insertUsers();
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object val, int rowIndex, int columnIndex) {
        data.get(rowIndex)[columnIndex] = val;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return data.get(0)[columnIndex].getClass();
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

}
