import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class TableDisplay extends JFrame {

    final JTable table = new JTable();
    final TableLogic tableLogic = new TableLogic();
    final TableRowSorter<TableLogic> sorter = new TableRowSorter<TableLogic>(tableLogic);
    final JTextField filterText = new JTextField();

    public TableDisplay() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 500);

        // Filter panel
        JPanel filterPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(filterPanel, BoxLayout.X_AXIS);
        filterPanel.setLayout(boxLayout);

        JLabel filterLabel = new JLabel("Filter:");
        filterPanel.add(filterLabel);

        filterText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RowFilter<TableLogic, Object> filter = null;
                try {
                    filter = RowFilter.regexFilter(filterText.getText(), 1);
                }
                catch(Exception ex) {
                }
                sorter.setRowFilter(filter);
            }
        });
        filterLabel.setLabelFor(filterText);
        filterPanel.add(filterText);

        // Add row button
        JButton btnAddRow = new JButton("Add row");
        filterPanel.add(btnAddRow);

        add(filterPanel, BorderLayout.NORTH);

        btnAddRow.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        tableLogic.addRow();
                    }
                }
        );

        // delete row
        JButton btnDeleteRow = new JButton("Delete row");
        filterPanel.add(btnDeleteRow);

        add(filterPanel, BorderLayout.NORTH);

        btnDeleteRow.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        int rowIndex = table.getSelectedRow();
                        tableLogic.deleteRow(rowIndex);
                    }
                }
        );

        //save
        JButton btnSave = new JButton("Save");
        filterPanel.add(btnSave);

        add(filterPanel, BorderLayout.NORTH);

        btnSave.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        tableLogic.save();
                    }
                }
        );

        // table setting
        table.setRowSorter(sorter);
        table.setModel(tableLogic);

        TableColumn col = table.getColumnModel().getColumn(0);
        //col.setCellRenderer(new MyTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);



    }

}
