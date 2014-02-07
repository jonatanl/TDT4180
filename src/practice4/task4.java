package practice4;

import javax.swing.*;

public class task4 extends JPanel{
    private PersonPanel panel;
    private PersonListPanel listPanel;

    private Person model;

    public task4() {
        model = new Person();
        panel = new PersonPanel();
        listPanel = new PersonListPanel();


        add(panel);
        add(listPanel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(new task4());
        frame.pack();
        frame.setVisible(true);
    }
}
