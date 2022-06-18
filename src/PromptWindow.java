import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.*;

public class PromptWindow extends JFrame {

    JLabel category;
    JLabel percentage;

    ArrayList<JTextField> categories;
    ArrayList<JTextField> percentages;
    JButton addField;

    JScrollPane inputPane;
    JButton submit;
    JButton clear;

    PromptWindow() {
        GroupLayout layout = new GroupLayout(getContentPane());
        
        inputPane = new JScrollPane();
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(inputPane)
                .addGroup(layout.createParallelGroup()
                    .addComponent(submit)
                    .addComponent(clear)));
        layout.setHorizontalGroup(layout.createParallelGroup()
            .addComponent(inputPane)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(submit)
                    .addComponent(clear)));
            
        getContentPane().setLayout(layout);

        for (int i = 0; i < 4; i++) {
            categories.add(new JTextField());
            percentages.add(new JTextField());
        }

        GroupLayout inputLayout = new GroupLayout(inputPane);
        
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
