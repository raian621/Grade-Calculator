import java.util.List;

import javax.swing.JFrame;

public class GradeCalculator extends JFrame {

    private static GradeCalculator gradeCalculator = null;
    private List<String> categories;
    private List<Double> percentages;

    private GradeCalculator(List<String> categories, List<Double> percentages) {
        this.categories = categories;
        this.percentages = percentages;

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

    public static void main(String[] args) {
        new PromptWindow();
    }
}
