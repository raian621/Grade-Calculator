import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GradesPanel extends JPanel {

    private List<CategoryPanel> categoryPanels;

    GradesPanel(List<String> categories) {
        setLayout(new BorderLayout());

        categoryPanels = new ArrayList<>();
        JPanel categoryWrapper = new JPanel(new GridLayout(1, 0));

        for (String name : categories) {
            CategoryPanel cp = new CategoryPanel(name);
            JScrollPane sp = new JScrollPane(cp);

            cp.setSize(300, cp.getPreferredSize().height);

            categoryWrapper.add(sp);
            categoryPanels.add(cp);
        }
        JScrollPane sp = new JScrollPane(categoryWrapper);
        add(sp, BorderLayout.CENTER);
    }

}
