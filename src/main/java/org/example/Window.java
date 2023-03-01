package org.example;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Window extends Frame {

    enum STATES {
        RUN, STOP, PAUSE
    }
    private STATES STATE;
    private List<Circle> circles;
    private final Thread repainting = new Thread() {
        @Override
        public void run() {
          while (STATE != STATES.STOP) {
              if (STATE == STATES.RUN) {
                  invalidate();
              }
              try {
                  TimeUnit.MILLISECONDS.sleep(3);
              } catch (InterruptedException e) {
                  System.out.println(e.getLocalizedMessage());
              }
          }
        }
    };

    public Window(int width, int height) {
        super();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stop();
                System.exit(0);
            }
        });
        setSize(width, height);
        setVisible(true);
        circles = new ArrayList<>();
    }

    public void add(Circle circle) {
        circles.add(circle);
    }

    @Override
    public void paint(Graphics g) {
        for (Circle circle : circles) {
            circle.paint(g);
        }
    }

    public void run() {
        STATE = STATES.RUN;
        repainting.start();
    }

    public void pause() {
        STATE = STATES.PAUSE;
    }

    public void stop() {
        STATE = STATES.STOP;
    }
}
