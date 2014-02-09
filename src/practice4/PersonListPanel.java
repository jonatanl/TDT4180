package practice4;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonListPanel extends JPanel implements ListSelectionListener, ActionListener {
    private JList<Person> listField;
    private DefaultListModel<Person> listModel;
    private JScrollPane scrollPane;
    private PersonPanel personPanel;
    private JButton addPersonButton;
    private JButton removePersonButton;

    public PersonListPanel() {
        listModel = new DefaultListModel<Person>();
        listField = new JList<Person>();
        scrollPane = new JScrollPane(listField);
        addPersonButton = new JButton("Add person");
        removePersonButton = new JButton("Delete person");

        listField.addListSelectionListener(this);
        addPersonButton.addActionListener(this);
        removePersonButton.addActionListener(this);

        listField.setSize(250, 350);
        listField.setCellRenderer(new PersonRenderer());

        listModel.addElement(new Person("Jonatan"));
        listModel.addElement(new Person("Baggis bjørn"));
        Person girl = new Person("girl");
        girl.setGender(Person.Gender.FEMALE);
        listModel.addElement(girl);

        setListModel(listModel);
        add(scrollPane);
        add(addPersonButton);
        add(removePersonButton);
    }

    public void setPersonPanel(PersonPanel personPanel) {
        this.personPanel = personPanel;
    }

    public void setListModel(DefaultListModel<Person> listModel){
        listField.setModel(listModel);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (listField.getSelectedValue() != null){
            Person model = listField.getSelectedValue();
            personPanel.setModel(model);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPersonButton){
            if (listField.getSelectedValue() != null && listField.getSelectedValue().equals(personPanel.getModel()))   {
                personPanel.setModel(new Person());
                return;
            }
            if ( personPanel.getModel().getName().equals("")) {
                listField.clearSelection();
                return;
            }
            Person model = personPanel.getModel();
            listModel.addElement(model);
        } else {
            if (listField.getSelectedValue() != null){
                listModel.removeElement(listField.getSelectedValue());
                personPanel.setModel(new Person());
            }
        }
    }
}