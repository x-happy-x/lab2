package org.example;

public class Rectangle {
    public double x,y,width,height;

    public Rectangle(double x, double y, double width, double height) {
        set(x, y, width, height);
    }

    public Rectangle(Rectangle rectangle) {
        set(rectangle);
    }

    public Rectangle() {
        this(0,0,0,0);
    }

    public boolean contains(Circle circle) {
        return !(!collisionTop(circle) || !collisionBottom(circle) || !collisionLeft(circle) || !collisionRight(circle));
    }


    public boolean collisionTop(Circle circle) {
        return getY() < circle.getY() - circle.getRadius();
    }

    public boolean collisionBottom(Circle circle) {
        return getHeight() > circle.getY() + circle.getRadius();
    }

    public boolean collisionLeft(Circle circle) {
        return getX() < circle.getX() - circle.getRadius();
    }

    public boolean collisionRight(Circle circle) {
        return getWidth() > circle.getX() + circle.getRadius();
    }

    public void set(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void set(Rectangle rectangle) {
        set(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
