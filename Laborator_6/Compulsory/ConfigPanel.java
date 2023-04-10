package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        linesLabel=new JLabel("Line probability:");
        linesCombo=new JComboBox(new Double[]{1.0,0.75,0.5,0.25});

        createButton=new JButton();
        createButton.setText("Create new game!");

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);

        add(linesLabel);
        add(linesCombo);

        add(createButton);

        createButton.addActionListener(this::createGame);//metoda clasei curente
    }

    public int getNumberOfDots()
    {
        return (int) dotsSpinner.getValue();
    }

    public double getEdgeProbability()
    {
        return (double) linesCombo.getSelectedItem();
    }

    public void reset() {
        remove(dotsLabel);
        remove(dotsSpinner);
        remove(linesLabel);
        remove(linesCombo);
        remove(createButton);

        init();
    }

    private void createGame(ActionEvent actionEvent) {
        frame.canvas.revalidate();;
        frame.canvas.repaint();
    }
}