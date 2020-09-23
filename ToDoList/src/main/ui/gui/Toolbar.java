package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;



    public Toolbar() {
        setBorder(BorderFactory.createEtchedBorder());

        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");
        button6 = new JButton("Button 6");
        button7 = new JButton("Button 7");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

//        if(clicked == button1) {
//            if (textListener != null) {
//                textListener.textEmitted("Button 1 \n");
//            }
//        } else if (clicked == button2) {
//            if (textListener != null) {
//                textListener.textEmitted("Button 2 \n");
//            }
//        }


}

