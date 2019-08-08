import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class MyTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        Component renderer = super.getTableCellRendererComponent(
                table,
                value,
                isSelected,
                hasFocus,
                row,
                column);

        if(value == null) {
            return renderer;
        }

        setHorizontalAlignment(JLabel.CENTER);

        switch(value.toString().toUpperCase()) {
            case "X":
                setBackground(Color.RED);
                break;
            case "Y":
                setBackground(Color.BLUE);
                break;
            default:
                setBackground(Color.WHITE);
        }

        return renderer;
    }
}