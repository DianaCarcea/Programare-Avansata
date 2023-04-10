package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;

    //create all buttons (Load, Exit, etc.)
    JButton loadBtn=new JButton("Load");
    JButton saveBtn=new JButton("Save");
    JButton resetBtn=new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        //configure listeners for all buttons
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);

    }

    private void loadGame(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(ControlPanel.this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(file);
                frame.canvas.setImage(image);
                frame.canvas.revalidate();
                frame.canvas.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveGame(ActionEvent event) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().endsWith(".png")) {
                    file = new File(file.getPath() + ".png");
                }

                BufferedImage image = new BufferedImage(DrawingPanel.W, DrawingPanel.H, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2 = image.createGraphics();
                frame.canvas.paint(g2);
                ImageIO.write(image, "PNG", file);//salvare poza
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resetGame(ActionEvent event) {

        ConfigPanel configPanel=frame.getConfigPanel();
        configPanel.reset();

        frame.configPanel.revalidate();
        frame.configPanel.repaint();

        frame.canvas.revalidate();
        frame.canvas.repaint();
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}

