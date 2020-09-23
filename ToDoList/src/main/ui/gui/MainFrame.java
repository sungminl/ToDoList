package ui.gui;

import controller.Controller;
import exceptions.SameNameTaskException;
import exceptions.TooManyThingsToDo;
import network.ReadWeather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {
    private Toolbar toolbar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;

    private JLabel weatherLabel;

    private ReadWeather readWeather = new ReadWeather();
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exportDataItem;
    private JMenuItem importDataItem;
    private JMenuItem exitItem;
    private JMenu viewMenu;
    private JMenu showMenu;
    private JMenu editMenu;
    private JMenuItem deleteAllItem;


    private JCheckBoxMenuItem showWeatherItem;
    private JCheckBoxMenuItem showToolbarItem;

    public MainFrame() throws IOException {
        super("ToDoList Manager");

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        controller = new Controller();

        tablePanel.setData(controller.getItems());

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new ItemFileFilter());

        setJMenuBar(createMenuBar());

        weatherLabel = new JLabel(readWeather.getWeather());
        weatherLabel.setVisible(false);


        formPanel.setFormListener(e -> {
            controller.addItem(e);
            tablePanel.refresh();
        });

        formPanel.setFormRemoveListener(e -> {
            tablePanel.refresh();
            controller.removeItem(e);
            tablePanel.refresh();
        });

        formPanel.setFormCompleteListener(e -> {
            tablePanel.refresh();
            controller.completeItem(e);
            tablePanel.refresh();
        });

        add(formPanel, BorderLayout.EAST);
        add(toolbar, BorderLayout.NORTH);
        add(weatherLabel, BorderLayout.SOUTH);
        add(tablePanel, BorderLayout.CENTER);

        this.setMinimumSize(new Dimension(720, 600));
        this.setSize(720, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // MODIFIES: This
    // EFFECTS: Creates a menu bar consisting of menu items
    private JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        createFileMenu();
        createEditMenu();
        createViewMenu();
        exitItemActionListener();
        showWeatherItemActionListener();
        showToolbarItemActionListener();
        showToolbarItem.setState(true);

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);
        viewMenu.setMnemonic(KeyEvent.VK_W);
        showMenu.setMnemonic(KeyEvent.VK_S);
        showWeatherItem.setMnemonic(KeyEvent.VK_A);

        importDataItemActionListener();
        exportDataItemActionListener();
        deleteAllItemActionListener();

        return menuBar;
    }

    // MODIFIES: This
    // EFFECTS: Creates a file menu in the menu bar
    private void createFileMenu() {
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        exportDataItem = new JMenuItem("Save Data...");
        importDataItem = new JMenuItem("Load Data...");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
    }

    // MODIFIES: This
    // EFFECTS: Creates a view menu in the menu bar
    private void createViewMenu() {
        viewMenu = new JMenu("View");
        showMenu = new JMenu("Show");
        showWeatherItem = new JCheckBoxMenuItem("Weather");
        showToolbarItem = new JCheckBoxMenuItem("Toolbar");

        menuBar.add(viewMenu);
        viewMenu.add(showMenu);
        showMenu.add(showWeatherItem);
        showMenu.add(showToolbarItem);
    }

    // MODIFIES: This
    // EFFECTS: Creates an edit menu in the menu bar
    private void createEditMenu() {
        editMenu = new JMenu("Edit");
        deleteAllItem = new JMenuItem("Clear All Items");

        menuBar.add(editMenu);
        editMenu.add(deleteAllItem);
    }

    // EFFECTS: Prompts user with a confirm exit window, exits application when
    //          user confirms
    private void exitItemActionListener() {
        exitItem.addActionListener(e -> {
            int action = JOptionPane.showConfirmDialog(MainFrame.this,
                    "Do you really want to exit the application?",
                    "Confirm Exit",
                    JOptionPane.OK_CANCEL_OPTION);
            if (action == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        });
    }

    // MODIFIES: This
    // EFFECTS: Shows and hides weatherLabel according to showWeatherItem selected value
    private void showWeatherItemActionListener() {
        showWeatherItem.addActionListener(e -> {
            JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
            weatherLabel.setVisible(menuItem.isSelected());
        });
    }

    // MODIFIES: This
    // EFFECTS: Shows and hides toolbar according to showToolBar selected value
    private void showToolbarItemActionListener() {
        showToolbarItem.addActionListener(e -> {
            JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
            toolbar.setVisible(menuItem.isSelected());
        });
    }

    // MODIFIES: ToDoList
    // EFFECTS: Clears all items from ToDoList and refreshes tablePanel
    private void deleteAllItemActionListener() {
        deleteAllItem.addActionListener(e -> {
            tablePanel.refresh();
            controller.clearAllItem();
            tablePanel.refresh();
        });
    }

    // MODIFIES: ToDoList
    // EFFECTS: Loads data onto ToDoList from a file, if file is not of an acceptable form,
    //          prompt user with error message
    private void importDataItemActionListener() {
        importDataItem.addActionListener(e -> {
            if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                try {
                    controller.loadFromFile(fileChooser.getSelectedFile());
                    tablePanel.refresh();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Could not load data from file.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // MODIFIES: File
    // EFFECTS: Saves data onto chosen file from ToDoList, if file is not of an acceptable form,
    //          prompt user with error message
    private void exportDataItemActionListener() {
        exportDataItem.addActionListener(e -> {
            if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                try {
                    controller.saveToFile(fileChooser.getSelectedFile());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Could not save data to file.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
