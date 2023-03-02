package org.example;

import java.awt.*;

public class Circle {

    Vector position;
    private int radius;
    private Color color;

    public Circle(double x, double y, int radius, Color color) {
        this.position = new Vector(x, y);
        this.radius = radius;
        this.color = color;
    }

    public Circle(double x, double y, int radius) {
        this(x, y, radius, new Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)));
    }

    public void setRandomColor() {
        color = new Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256));
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Circle setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public boolean contains(double x, double y) {
        double dx = x - getX();
        double dy = y - getY();
        return dx * dx + dy * dy < radius * radius;
    }

    public boolean contains(Circle circle) {
        double dx = circle.getX() - getX();
        double dy = circle.getY() - getY();
        double dr = circle.getRadius() + getRadius();
        return dx * dx + dy * dy < dr * dr;
    }

    public boolean contains(Vector vector) {
        return contains(vector.x, vector.y);
    }

    public int getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.position.x = x;
    }

    public void setY(double y) {
        this.position.y = y;
    }

    public Color getColor() {
        return color;
    }

    public double getX() {
        return position.x;
    }

    public double getY() {
        return position.y;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (getX() - radius), (int) (getY() - radius), radius * 2, radius * 2);
    }
}
