package practice2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PersonPanel extends JPanel implements ActionListener, ChangeListener {
    private Person model = null;
    private JSlider height = new JSlider(120,220);
    private TextField name = new TextField(20);
    private TextField email = new TextField(20);
    private TextField dateOfBirth = new TextField(20);
    private JComboBox gender = new JComboBox<Person.Gender>(Person.Gender.values());

    public PersonPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        add(new JLabel("Name"), constraints);
        constraints.gridx = 1;
        add(name, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(new JLabel("Email"), constraints);
        constraints.gridx = 1;
        add(email, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(new JLabel("Birthday"), constraints);
        constraints.gridx = 1;
        add(dateOfBirth, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(new JLabel("Gender"), constraints);
        constraints.gridx = 1;
        add(gender, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(new JLabel("Height"), constraints);
        constraints.gridx = 1;
        add(height, constraints);

        setModel(new Person());
        addListeners();
        slider();
    }

    private void slider() {
        height.setMajorTickSpacing(20);
        height.setMinorTickSpacing(5);
        height.setPaintTicks(true);
        height.setPaintLabels(true);
    }

    private void addListeners() {
        name.addActionListener(this);
        email.addActionListener(this);
        dateOfBirth.addActionListener(this);
        gender.addActionListener(this);
        height.addChangeListener(this);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(new PersonPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public void setModel(Person model) {
        this.model = model;
        updateGUI();
    }

    public Person getModel(){
        updateModel();
        return model;
    }

    private void updateGUI() {
        name.setText(model.getName());
        email.setText(model.getEmail());
        dateOfBirth.setText(model.getDateOfBirth());
        height.setValue(model.getHeigth());
        gender.setSelectedItem(model.getGender());
    }

    private void updateModel(){
        if (model != null) {
            model.setName(name.getText());
            model.setEmail(email.getText());
            model.setDateOfBirth(dateOfBirth.getText());
            model.setHeigth(height.getValue());
            model.setGender((Person.Gender) gender.getSelectedItem());
        }
        System.out.println(model.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateModel();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        updateModel();
    }
}