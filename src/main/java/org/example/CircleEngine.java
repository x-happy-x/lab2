package org.example;

public class CircleEngine extends Thread {

    private Rectangle bounds;
    private int delay = 20;

    private final Vector vector;
    private final Circle circle;
    private EngineListener listener;

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public CircleEngine(Circle circle, Vector vector) {
        this.vector = vector;
        this.circle = circle;
        this.bounds = new Rectangle();
    }

    public CircleEngine(Circle circle, int x, int y) {
        this(circle, new Vector(x, y));
    }

    public CircleEngine(Circle circle) {
        this(circle, 0, 0);
        while (vector.x == 0 && vector.y == 0) {
            vector.x = Random.nextInt(-3, 4);
            vector.y = Random.nextInt(-3, 4);
        }
    }

    public void setListener(EngineListener listener) {
        this.listener = listener;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setBounds(double x, double y, double width, double height) {
        bounds.set(x, y, width, height);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void run() {
        try {
            while (isAlive()) {
                update();
                if (listener != null) listener.after();
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            Main.log.warning(e.getLocalizedMessage());
        }
    }

    public void update() {
        circle.getPosition().add(vector.x, vector.y);
        if (vector.y < 0 && !bounds.collisionTop(circle) || vector.y > 0 && !bounds.collisionBottom(circle)) {
            vector.y = -vector.y;
            circle.setRandomColor();
        }
        if (vector.x < 0 && !bounds.collisionLeft(circle) || vector.x > 0 && !bounds.collisionRight(circle)) {
            vector.x = -vector.x;
            circle.setRandomColor();
        }
    }
}

