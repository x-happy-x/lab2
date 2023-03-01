package org.example;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(300, 350, 50, Color.BLUE);
        Circle circle2 = new Circle(50, 50, 50, Color.RED);
        Window window = new Window(500, 500);
        window.add(circle2);
        window.add(circle1);
        window.run();
    }
}