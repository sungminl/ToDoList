package ui.gui;

import model.Item;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ItemTableModel extends AbstractTableModel {

    private List<Item> toDoList;
    private String[] columnNames = {"ToDo", "Description", "Status"};


    public ItemTableModel() {
    }


    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setData(List<Item> toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public int getRowCount() {
        return toDoList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }


    // EFFECTS: Returns Item based on values of a row
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = toDoList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return item.getName();
            case 1 :
                return item.getDescription();
            default:
                return item.getStatus();
        }
    }
}
