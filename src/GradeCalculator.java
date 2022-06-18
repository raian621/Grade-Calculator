import javax.swing.JFrame;

public class GradeCalculator extends JFrame {

    GradeCalculator() {
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        GradeCalculator app = new GradeCalculator();
    }
}
