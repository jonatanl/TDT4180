package practice3;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class PersonPanelPassive extends PersonPanel {
    JTextField heightField;
    JTextField genderField;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName() == Person.NAME_PROPERTY)
            name.setText(model.getName());
        else if (event.getPropertyName() == Person.EMAIL_PROPERTY)
            email.setText(model.getEmail());
        else if (event.getPropertyName() == Person.DATE_PROPERTY)
            dateOfBirth.setText(model.getDateOfBirth());
        else if (event.getPropertyName() == Person.GENDER_PROPERTY)
            genderField.setText(model.getGender() + "");
        else if (event.getPropertyName() == Person.HEIGHT_PROPERTY)
            heightField.setText(model.getHeigth() + "");
    }

    public PersonPanelPassive() {
        super();
        remove(height);
        remove(gender);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 3;

        genderField = new JTextField(20);
        add(genderField, constraints);

        constraints.gridy = 4;
        heightField = new JTextField(20);
        add(heightField, constraints);

        name.setEditable(false);
        email.setEditable(false);
        dateOfBirth.setEditable(false);
        genderField.setEditable(false);
        heightField.setEditable(false);
    }
}
