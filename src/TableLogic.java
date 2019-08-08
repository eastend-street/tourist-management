import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableLogic extends AbstractTableModel{


    ArrayList<Object[]> data = new ArrayList<Object[]>();
    String[] columns = {"Column 0", "Column 1", "Column 2"};

    public TableLogic() {
        data.add(new Object[]{"X", "100", true});
        data.add(new Object[]{"X", "200", false});
        data.add(new Object[]{"X", "300", false});
        data.add(new Object[]{"Y", "400", false});
        data.add(new Object[]{"Y", "500", false});
        data.add(new Object[]{"Z", "600", false});
        data.add(new Object[]{"Z", "700", false});
    }

    public void addRow() {
        data.add(new Object[] {"X", "999", false});
        fireTableRowsInserted(0, data.size()-1);
    }

    public void deleteRow(int rowIndex) {

        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex,rowIndex);

    }

    public void save() {

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
