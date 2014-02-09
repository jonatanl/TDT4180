package practice4;

import javax.swing.*;

public class task4 extends JPanel{
    private PersonPanel panel;
    private PersonListPanel listPanel;

    public task4() {
        panel = new PersonPanel();
        listPanel = new PersonListPanel();
        listPanel.setPersonPanel(panel);
        add(listPanel);
        add(panel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(new task4());
        frame.pack();
        frame.setVisible(true);
    }
}
