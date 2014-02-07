package practice4;

import javax.swing.*;

public class PersonListPanel extends JPanel{
    private JList<Person> listField;
    private DefaultListModel<Person> model;

    public void setModel(DefaultListModel<Person> listModel){
        listField.setModel(listModel);
    }

    public JList getListField() {
        return listField;
    }

    public PersonListPanel() {
        model = new DefaultListModel<Person>();
        model.addElement(new Person("Jonatan"));
        model.addElement(new Person("Jonatan"));
        model.addElement(new Person("Jonatan"));
        listField = new JList<Person>();
        setModel(model);
        add(listField);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(new PersonListPanel());
        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}
