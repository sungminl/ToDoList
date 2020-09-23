package ui.gui;

import exceptions.SameNameTaskException;
import exceptions.TooManyThingsToDo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JTextField nameField;
    private JTextField descriptionField;
    private JButton submitBtn;
    private FormListener formListener;
    private FormRemoveListener formRemoveListener;
    private FormCompleteListener formCompleteListener;
    private JList itemList;
    private JLabel removeLabel;
    private JTextField removeField;
    private JButton removeButton;
    private JLabel completeLabel;
    private JTextField completeField;
    private JButton completeButton;


    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("ToDo:");
        descriptionLabel = new JLabel("Description:");
        nameField = new JTextField(10);
        descriptionField = new JTextField(10);
        itemList = new JList();
        removeLabel = new JLabel("Remove Item:");
        removeField = new JTextField(10);
        completeLabel = new JLabel("Complete Item:");
        completeField = new JTextField(10);

        DefaultListModel itemModel = new DefaultListModel();
        itemModel.addElement(new ItemCategory(0, "Regular Item"));
        itemModel.addElement(new ItemCategory(1, "Urgent Item"));
        itemList.setModel(itemModel);


        itemList.setPreferredSize(new Dimension(104, 55));
        itemList.setBorder(BorderFactory.createEtchedBorder());
        itemList.setSelectedIndex(0);

        submitBtn = new JButton("Submit");
        removeButton = new JButton("Remove");
        completeButton = new JButton("Complete");



        completeLabel.setForeground(new Color(0, 222, 38));
        completeButton.setForeground(new Color(0, 222, 38));

        removeLabel.setForeground(new Color(229, 39, 50));
        removeButton.setForeground(new Color(229, 39, 50));


        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(nameField.getText().equals("") || descriptionField.getText().equals(""))) {
                    String name = nameField.getText();
                    String description = descriptionField.getText();
                    ItemCategory itemCategory = (ItemCategory) itemList.getSelectedValue();

                    FormEvent eve = new FormEvent(this, name, description, itemCategory.getText());

                    if (formListener != null) {
                        try {
                            formListener.formEventOccurred(eve);
                        } catch (TooManyThingsToDo tooManyThingsToDo) {
                            JOptionPane.showMessageDialog(submitBtn, "Too many things to do. Finish some tasks!");
                        } catch (SameNameTaskException ex) {
                            JOptionPane.showMessageDialog(submitBtn, "Cannot add ToDos with the same name.");
                        }
                    }
                }
                nameField.setText("");
                descriptionField.setText("");
                itemList.setSelectedIndex(0);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = removeField.getText();
                FormRemoveEvent eve = new FormRemoveEvent(this, name);
                formRemoveListener.formRemoveEventOccurred(eve);
                removeField.setText("");
//                if (!(nameField.getText().equals(""))) {
//                    String name = removeField.getText();
//
//                    FormRemoveEvent eve = new FormRemoveEvent(this, name);
//
//                    if (formRemoveListener != null) {
//                        try {
//                            formRemoveListener.formRemoveEventOccurred(eve);
//                        } catch (ItemNameNotFoundException ex) {
//                            JOptionPane.showMessageDialog(submitBtn, "Could not find item to remove");
//                        }
//                    }
//                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = completeField.getText();
                FormCompleteEvent eve = new FormCompleteEvent(this, name);
                formCompleteListener.formCompleteEventOccurred(eve);
                completeField.setText("");
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add a ToDo");
        Border outerBorder = BorderFactory.createEmptyBorder(10, 5, 10, 5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());


        GridBagConstraints gc = new GridBagConstraints();

        // First Row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        // Second Row
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(descriptionLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(descriptionField, gc);

        // Third Row
        gc.weightx = 1;
        gc.weighty = 0.3;

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(itemList, gc);


        // Fourth Row
        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 1;
        gc.gridy = 3;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitBtn, gc);



        // Fifth Row
        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(removeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(removeField, gc);

        // Sixth Row
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 5;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(removeButton, gc);


        // Seventh Row
        gc.weightx = 1;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.gridy = 6;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_END;
        add(completeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(completeField, gc);

        // Eighth Row
        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 1;
        gc.gridy = 7;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(completeButton, gc);
    }


    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }

    public void setFormRemoveListener(FormRemoveListener listener) {
        this.formRemoveListener = listener;
    }

    public void setFormCompleteListener(FormCompleteListener listener) {
        this.formCompleteListener = listener;
    }

}
