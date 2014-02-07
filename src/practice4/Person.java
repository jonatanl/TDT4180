package practice4;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
    public final static String NAME_PROPERTY = "name";
    public final static String EMAIL_PROPERTY = "email";
    public final static String DATE_PROPERTY = "date";
    public final static String GENDER_PROPERTY = "gender";
    public final static String HEIGHT_PROPERTY = "height";

    private PropertyChangeSupport pcs;

    private String name;
    private String dateOfBirth;
    private String email;
    private Gender gender = Gender.MALE;
    private int heigth;

    public Person(String name) {
        this.name = name;
    }

    public static enum Gender {
        MALE,
        FEMALE
    }

    public Person() {
        pcs = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        pcs.firePropertyChange(NAME_PROPERTY, oldValue, name);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        String oldValue = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        pcs.firePropertyChange(DATE_PROPERTY, oldValue, dateOfBirth);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldValue = this.email;
        this.email = email;
        pcs.firePropertyChange(EMAIL_PROPERTY, oldValue, email);
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        int oldValue = this.heigth;
        this.heigth = heigth;
        pcs.firePropertyChange(HEIGHT_PROPERTY, oldValue, heigth);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        Gender oldValue = this.gender;
        this.gender = gender;
        pcs.firePropertyChange(GENDER_PROPERTY, oldValue, gender);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return name;
    }
}
