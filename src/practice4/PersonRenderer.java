package practice4;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PersonRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);

        ImageIcon icon = getIcon((Person) value);
        label.setIcon(icon);

        return label;
    }

    private ImageIcon getIcon(Person person){
        File file;
        Image resizedImage = null;

        if (person.getGender() == Person.Gender.MALE)
            file = new File("/home/jonas/Dropbox/NTNU/4/mmi/tasks/icons/male.png");
        else
            file = new File("/home/jonas/Dropbox/NTNU/4/mmi/tasks/icons/female.jpg");

        try {
            resizedImage = ImageIO.read(file).getScaledInstance(50, 50, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(resizedImage);
        return icon;
    }
}
