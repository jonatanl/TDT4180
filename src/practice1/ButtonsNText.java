package practice1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ButtonsNText extends JPanel implements ActionListener, KeyListener {
    private JTextField TextLine;
    private JButton UpperCaseButton;
    private JButton LowerCaseButton;
    private JCheckBox ContinousButton;
    private boolean isUpper = false;
    private ButtonGroup group;
    private int counter = 0;

	public ButtonsNText() {
        TextLine = new JTextField();
        TextLine.setColumns(30);

        UpperCaseButton = new JButton("Upper case");
        LowerCaseButton = new JButton("Lower case");
        ContinousButton = new JCheckBox("Continous");
        group = new ButtonGroup();

        group.add(UpperCaseButton);
        group.add(LowerCaseButton);

        add(TextLine);
        add(UpperCaseButton);
        add(LowerCaseButton);
        add(ContinousButton);

        UpperCaseButton.addActionListener(this);
        LowerCaseButton.addActionListener(this);

        TextLine.addKeyListener(this);
        TextLine.addActionListener(this);

	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		frame.getContentPane().add(new ButtonsNText());
		frame.pack();
		frame.setVisible(true);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == UpperCaseButton){
            isUpper = true;
        }
        else if (e.getSource() == LowerCaseButton){
            isUpper = false;
        }
        else {
            counter++;
            if (counter == 2){
                isUpper = !isUpper;
                counter = 0;
                changeCase();
            }
            return;
        }
        changeCase();
        counter = 0;
    }

    public void changeCase(){
        if (isUpper)
            TextLine.setText(TextLine.getText().toUpperCase());
        else
            TextLine.setText(TextLine.getText().toLowerCase());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!ContinousButton.isSelected())
            return;
        int pos = TextLine.getCaretPosition();
        if (isUpper)
            TextLine.setText(TextLine.getText().toUpperCase());
        else
            TextLine.setText(TextLine.getText().toLowerCase());
        TextLine.setCaretPosition(pos);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
