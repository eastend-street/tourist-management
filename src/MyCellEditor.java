import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class MyCellEditor extends DefaultCellEditor {

    static JComboBox<String> combo = new JComboBox<String>();

    public MyCellEditor() {
        super(combo);
        combo.addItem("X");
        combo.addItem("Y");
        combo.addItem("Z");
    }

}