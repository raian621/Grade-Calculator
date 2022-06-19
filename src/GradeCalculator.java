import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class GradeCalculator extends JFrame {

    private static GradeCalculator gradeCalculator = null;
    private List<CategoryPanel> categoryPanels;

    private GradeCalculator(List<String> categories, List<Double> percentages) {
        setLayout(new BorderLayout());

        categoryPanels = new ArrayList<>();
        JPanel categoryWrapper = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        gbc.gridy = 0;
        gbc.gridx = 0;

        for (String name : categories) {
            CategoryPanel cp = new CategoryPanel(name);
            JScrollPane sp = new JScrollPane(cp);

            gbc.gridx++;

            categoryWrapper.add(sp, gbc);
            categoryPanels.add(cp);
        }
        JScrollPane sp = new JScrollPane(categoryWrapper);
        add(sp, BorderLayout.CENTER);

        setTitle("Grade Calculator");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static GradeCalculator getGradeCalculator(List<String> categories, List<Double> percentages) {
        if (gradeCalculator == null)
            gradeCalculator = new GradeCalculator(categories, percentages);
        return gradeCalculator;
    }

    public static GradeCalculator getGradeCalculator() {
        return gradeCalculator;
    }

    public static void main(String[] args) {
        new PromptWindow();
    }
}
