import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InputPanel extends JPanel {
    
    JLabel category;
    JLabel percentage;

    ArrayList<JTextField> categories;
    ArrayList<JTextField> percentages;
    JButton addField;

    JPanel fieldPanel;
    
    InputPanel() {
        categories = new ArrayList<>();
        percentages = new ArrayList<>();
        category = new JLabel("Categories");
        percentage = new JLabel("Percentage");
        percentage.setSize(percentage.getPreferredSize());

        for (int i = 0; i < 4; i++) {
            categories.add(new JTextField());
            percentages.add(new JTextField());
        }
        addField = new JButton("+");

        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(0, 2, 2, 2));

        fieldPanel.add(category);
        fieldPanel.add(percentage);

        for (int i = 0; i < categories.size(); i++) {
            fieldPanel.add(categories.get(i));
            fieldPanel.add(percentages.get(i));
        }

        setLayout(new BorderLayout());
        add(fieldPanel, BorderLayout.CENTER);
        add(addField, BorderLayout.SOUTH);

        addField.addActionListener(e -> addRow());
    }

    private void addRow() {
        categories.add(new JTextField());
        percentages.add(new JTextField());

        fieldPanel.add(categories.get(categories.size() - 1));
        fieldPanel.add(percentages.get(percentages.size() - 1));

        revalidate();
    }

    public List<String> getCategories() {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {
            String cat = categories.get(i).getText();
            if (!cat.equals("") && cat != null)
                result.add(cat);
        }
        return result;
    }

    public List<Double> getGrades() throws NumberFormatException {
        List<Double> result = new ArrayList<>();
        
        for (int i = 0; i < percentages.size(); i++) {
            String per = percentages.get(i).getText();
            if (!per.equals("") && per != null)
                result.add(Double.parseDouble(per));
        }
        return result;
    }
}
