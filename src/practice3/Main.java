package practice3;

import javax.swing.*;

public class Main extends JPanel{
    private PersonPanel panel;
    private PersonPanelPassive panelPassive;

    private Person model;

    public Main() {
        model = new Person();
        panel = new PersonPanel();
        panelPassive = new PersonPanelPassive();

        panel.setModel(model);
        add(panel);

        panelPassive.setModel(model);
        add(panelPassive);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(new Main());
        frame.pack();
        frame.setVisible(true);
    }
}
