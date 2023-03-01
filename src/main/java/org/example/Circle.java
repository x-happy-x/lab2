package org.example;

import java.awt.*;

public class Circle {

    private int x;
    private int y;
    private int radius;
    private Color color;

    public Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Circle setRadius(int radius) {
        this.radius = radius;
        return this;
    }
    public int getRadius() {
        return radius;
    }
    public Circle setX(int x) {
        this.x = x;
        return this;
    }
    public Circle setY(int y) {
        this.y = y;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
    }
}
