package org.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CircleControllerKeyboard extends KeyAdapter {
    private Circle circle;
    private Rectangle bounds;
    private double speed;
    private EngineListener listener;

    public CircleControllerKeyboard(Circle circle, Rectangle bounds, double speed) {
        this.circle = circle;
        this.bounds = bounds;
        this.speed = speed;
    }

    public void setListener(EngineListener listener) {
        this.listener = listener;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                circle.getPosition().x -= speed;
                if (!bounds.collisionLeft(circle)) {
                    circle.getPosition().x = bounds.getX()+circle.getRadius();
                    circle.setRandomColor();
                }
            }
            case KeyEvent.VK_RIGHT -> {
                circle.getPosition().x += speed;
                if (!bounds.collisionRight(circle)) {
                    circle.getPosition().x = bounds.getWidth()-circle.getRadius();
                    circle.setRandomColor();
                }
            }
            case KeyEvent.VK_UP -> {
                circle.getPosition().y -= speed;
                if (!bounds.collisionTop(circle)) {
                    circle.getPosition().y = bounds.getY()+circle.getRadius();
                    circle.setRandomColor();
                }
            }
            case KeyEvent.VK_DOWN -> {
                circle.getPosition().y += speed;
                if (!bounds.collisionBottom(circle)) {
                    circle.getPosition().y = bounds.getHeight()-circle.getRadius();
                    circle.setRandomColor();
                }
            }
        }
        if (listener != null)
            listener.after();
    }
}
