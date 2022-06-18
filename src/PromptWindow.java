import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class PromptWindow extends JFrame {

    InputPanel inputPanel;
    JScrollPane inputViewer;
    JButton submit;
    JButton clear;

    PromptWindow() {
        GroupLayout layout = new GroupLayout(getContentPane());
        inputPanel = new InputPanel();

        inputViewer = new JScrollPane(inputPanel);
        submit = new JButton("Submit");
        clear = new JButton("Clear");

        submit.addActionListener(e -> submitInput());
        clear.addActionListener(e -> clearInput());
        
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

    private void submitInput() {
        List<String> categories = inputPanel.getCategories();
        List<Double> percentages = inputPanel.getPercentages();

        if(checkInput(categories, percentages)) {
            GradeCalculator.getGradeCalculator(categories, percentages);
            dispose();
        }
    }

    private boolean checkInput(List<String> categories, List<Double> percentages) {
        if (categories.size() != percentages.size())
            return false;

        double total = 0.0;

        for (Double d : percentages)
            total += d;
        if (total < 100.0 || total > 100.01)
            return false;
    
        return true;
    }

    private void clearInput() {
        inputPanel = new InputPanel();
        inputViewer.setViewportView(inputPanel);
        
        System.gc();
        revalidate();
    }
}
