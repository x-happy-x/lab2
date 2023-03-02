package org.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CircleControllerMouse extends MouseMotionAdapter {
    private Circle circle;
    private Rectangle bounds;
    private EngineListener listener;

    public CircleControllerMouse(Circle circle, Rectangle bounds) {
        this.circle = circle;
        this.bounds = bounds;
    }

    public void setListener(EngineListener listener) {
        this.listener = listener;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        circle.setX(e.getX());
        if (!bounds.collisionLeft(circle)) {
            circle.getPosition().x = bounds.getX() + circle.getRadius();
            circle.setRandomColor();
        }
        if (!bounds.collisionRight(circle)) {
            circle.getPosition().x = bounds.getWidth() - circle.getRadius();
            circle.setRandomColor();
        }
        circle.setY(e.getY());
        if (!bounds.collisionTop(circle)) {
            circle.getPosition().y = bounds.getY() + circle.getRadius();
            circle.setRandomColor();
        }
        if (!bounds.collisionBottom(circle)) {
            circle.getPosition().y = bounds.getHeight() - circle.getRadius();
            circle.setRandomColor();
        }
        if (listener != null)
            listener.after();
    }
}
