package org.example;

public class Vector {
    public double x;
    public double y;

    public Vector(double x, double y) {
        set(x, y);
    }

    public Vector(Vector vector) {
        this(vector.getX(), vector.getY());
    }

    public void add(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void add(Vector vector) {
        add(vector.x, vector.y);
    }

    public void sub(double dx, double dy) {
        add(-dx, -dy);
    }

    public void sub(Vector vector) {
        sub(vector.x, vector.y);
    }

    public void set(double x, double y) {
        setX(x);
        setY(y);
    }

    public void set(Vector vector) {
        set(vector.getX(), vector.getY());
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

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
