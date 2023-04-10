package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private Image image;
    final static int W = 800, H = 600;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        //s-a apasat Load
        if (image != null) {
            g.drawImage(image, 0, 0, null);
            image=null;
        }
        else {
            ConfigPanel configPanel;
            configPanel = frame.getConfigPanel();//luam cele necesare pt desen

            int numberOfDots = configPanel.getNumberOfDots();
            double edgeProbability = configPanel.getEdgeProbability();

            int radius = Math.min(getWidth(), getHeight()) / 2-50;

            Point center = new Point(getWidth() / 2, getHeight() / 2);//centrul ecranului

            double angle = 2 * Math.PI / numberOfDots;//unghiul dintre doua muchii

            Point[] nodeCoords = new Point[numberOfDots];//lista de noduri
            for (int i = 0; i < numberOfDots; i++) {//pt fiecare nod calculez coordonatele
                double x = center.x + radius * Math.cos(i * angle);
                double y = center.y + radius * Math.sin(i * angle);
                nodeCoords[i] = new Point((int) x, (int) y);
            }

            // desenez nodurile
            for (int i = 0; i < numberOfDots; i++) {
                g.fillOval(nodeCoords[i].x - 5, nodeCoords[i].y - 5, 15, 15);
            }

            // desenez muchiile
            for (int i = 0; i < numberOfDots; i++) {
                for (int j = i + 1; j < numberOfDots; j++) {
                    if (Math.random() < edgeProbability) {//desenez sau nu linia in functie de probabilitate
                        g.drawLine(nodeCoords[i].x, nodeCoords[i].y, nodeCoords[j].x, nodeCoords[j].y);
                        g.drawLine(nodeCoords[i].x, nodeCoords[i].y, nodeCoords[j].x, nodeCoords[j].y);
                    }
                }
            }

        }
    }
}
