package day2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGui extends JFrame {
    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button pushed from Inner Class");
            textField.setText("Button Pushed");
        }
    }

    private JButton button;
    private JTextField textField;

    public MyGui(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        layoutUI();
        setupEvents();
        pack();
    }

    private void setupEvents() {
        button.addActionListener(new MyListener());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pushed from Anonymous Inner Class");
            }
        });
        button.addActionListener(e -> System.out.println("Button pushed from Lambda"));
        button.addActionListener(this::wibble);
    }

    private void wibble(ActionEvent e) {
        System.out.println("Button pushed from regular method");
    }

    private void layoutUI() {
        button = new JButton("Push Me");
        textField = new JTextField(10);

        setLayout(new FlowLayout());
        add(button);
        add(textField);
    }
}
