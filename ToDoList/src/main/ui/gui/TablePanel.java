package ui.gui;

import model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private ItemTableModel tableModel;

    public TablePanel() {
        tableModel = new ItemTableModel();
        table = new JTable(tableModel);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Item> toDoList) {
        tableModel.setData(toDoList);
    }

    // EFFECTS: Refreshes this
    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
