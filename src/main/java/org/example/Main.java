package org.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    public static final Logger log = Logger.getLogger("App");

    public static void main(String[] args) {
        Window window = new Window(500, 500);
        window.setDelay(10);
        window.start();

        Rectangle windowBounds = new Rectangle(10, 30, window.getWidth()-10, window.getHeight()-10);
        int count = 15;
        Map<Circle, CircleEngine> circles = new HashMap<>();
        Circle circle;
        CircleEngine engine;
        double x, y;
        int r;
        for (int i = 0; i < count; i++) {
            r = Random.nextInt(20, 40);
            x = Random.nextDouble(windowBounds.getX() + r, windowBounds.getWidth() - r);
            y = Random.nextDouble(windowBounds.getY() + r, windowBounds.getHeight() - r);
            circle = new Circle(x, y, r);
            engine = new CircleEngine(circle);
            engine.setBounds(windowBounds);
            engine.setDelay((int) (window.getDelay() * Random.nextFloat(0.5f, 3)));
            engine.setListener(window::invalidate);
            engine.start();

            window.add(circle);

            circles.put(circle, engine);
        }

        circle = new Circle(windowBounds.getWidth()/2, windowBounds.getHeight()/2, 30);
        CircleControllerKeyboard keyboard = new CircleControllerKeyboard(circle, windowBounds, 3);
        keyboard.setListener(window::invalidate);
        window.addKeyListener(keyboard);
        window.add(circle);

        CircleControllerMouse mouse = new CircleControllerMouse(circle, windowBounds);
        mouse.setListener(window::invalidate);
        window.addMouseMotionListener(mouse);
        window.add(circle);
    }
}