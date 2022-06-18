import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.*;

public class PromptWindow extends JFrame {

    InputPanel inputPanel;
    JScrollPane inputViewer;
    JButton submit;
    JButton clear;

    PromptWindow() {
        GroupLayout layout = new GroupLayout(getContentPane());
        InputPanel inputPanel = new InputPanel();

        inputViewer = new JScrollPane(inputPanel);
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(inputViewer)
                .addGroup(layout.createParallelGroup()
                    .addComponent(submit)
                    .addComponent(clear)));
        layout.setHorizontalGroup(layout.createParallelGroup()
            .addComponent(inputViewer)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(submit)
                    .addComponent(clear)));
            
        getContentPane().setLayout(layout);
        
        setTitle("Grade Calculator");
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
