package org.example;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Window extends Frame {

    private final List<Circle> circles;
    private final BufferedImage bufImage;
    private final Graphics bufGraphics;
    private int delay = 20;
    private final Thread validator = new Thread(() -> {
        while (true) {
            if (!isValid()) {
                repaint();
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Main.log.warning(e.getLocalizedMessage());
            }
        }
    });

    public Window(int width, int height) {
        super();

        bufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufGraphics = bufImage.createGraphics();

        circles = new ArrayList<>();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(width, height);
        setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        bufGraphics.setColor(Color.WHITE);
        bufGraphics.fillRect(0,0, bufImage.getWidth(), bufImage.getHeight());
        for (Circle circle : circles) {
            circle.paint(bufGraphics);
        }
        g.drawImage(bufImage,0,0,getWidth(),getHeight(), null);
    }

    public void add(Circle circle) {
        circles.add(circle);
    }

    public void start() {
        validator.start();
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
