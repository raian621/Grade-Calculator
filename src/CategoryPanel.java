import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CategoryPanel extends JPanel {
    private JPanel fieldPanel;
    private String name;
    private List<JTextField> earnedPoints;
    private List<JTextField> potentialPoints;
    private GridBagConstraints c;
    private JButton addField;
    private double gradeRatio;

    public CategoryPanel(String name) {
        this.name = name;
        earnedPoints = new ArrayList<>();
        potentialPoints = new ArrayList<>();
        addField = new JButton("+");

        setLayout(new BorderLayout());
        fieldPanel = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.weightx = 1.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        fieldPanel.add(new JLabel(name), c);
        c.gridwidth = 1;
        
        for(int i = 0; i < 4; i++)
            addRow();
        add(fieldPanel, BorderLayout.CENTER);
        add(addField, BorderLayout.SOUTH);
        addField.addActionListener(e -> addRow());
    }

    public void addRow() {
        c.gridy++;
        JTextField earnedField = new JTextField();
        JTextField potentialField = new JTextField();
        earnedPoints.add(earnedField);
        potentialPoints.add(potentialField);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        fieldPanel.add(earnedField, c);
        c.gridx = 1;
        c.weightx = 0.1;
        fieldPanel.add(new JLabel("/"), c);
        c.gridx = 2;
        c.weightx = 0.5;
        fieldPanel.add(potentialField, c);
        revalidate();
    }

    public void updateGradeRatio() {
        double earned = 0.0;
        double potential = 0.0;

        for (int i = 0; i < potentialPoints.size(); i++) {
            try {
                potential += Double.parseDouble(potentialPoints.get(i).getText());
            } catch (NumberFormatException e) {
                
            }

            try {
                earned += Double.parseDouble(earnedPoints.get(i).getText());
            } catch (NumberFormatException e) {
                
            } 
        }
        gradeRatio =  earned / potential;
    }

    public double getGradeRatio() {
        return gradeRatio;
    }
}