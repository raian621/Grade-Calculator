import java.util.ArrayList;
import java.util.List;
import java.awt.*;

import javax.swing.*;

public class InputPanel extends JPanel {
    
    JLabel category;
    JLabel percentage;

    List<JTextField> categories;
    List<JTextField> percentages;
    JButton addField;

    JPanel fieldPanel;
    GridBagConstraints c;
    
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
        fieldPanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);

        c.weightx = 0.8;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.gridx = 0;
        fieldPanel.add(category, c);
        c.gridx = 1;
        c.weightx = 0.2;
        fieldPanel.add(percentage, c);

        for (int i = 0; i < categories.size(); i++) {
            c.gridy++;
            c.gridx = 0;
            fieldPanel.add(categories.get(i), c);
            c.gridx = 1;
            fieldPanel.add(percentages.get(i), c);
        }

        setLayout(new BorderLayout());
        add(fieldPanel, BorderLayout.CENTER);
        add(addField, BorderLayout.SOUTH);

        addField.addActionListener(e -> addRow());
    }

    private void addRow() {
        categories.add(new JTextField());
        percentages.add(new JTextField());

        c.gridy++;
        c.gridx = 0;
        fieldPanel.add(categories.get(categories.size() - 1), c);
        c.gridx = 1;
        fieldPanel.add(percentages.get(percentages.size() - 1), c);

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

    public List<Double> getPercentages() throws NumberFormatException {
        List<Double> result = new ArrayList<>();
        
        for (int i = 0; i < percentages.size(); i++) {
            String per = percentages.get(i).getText();
            if (!per.equals("") && per != null)
                result.add(Double.parseDouble(per));
        }
        return result;
    }
}
