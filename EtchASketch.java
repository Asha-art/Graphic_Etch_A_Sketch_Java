/*  1.Modify the game so that the circle can move left and right instead of just up and down.
    2.Make the circle a bit smaller, and make it move 10 pixels at a time instead of 5.
    3.Make it so that if you press F1, the current color changes to red, F2 changes it to green, F3 changes to blue, and F5 resets to black.*/

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class EtchASketch extends Canvas {
    int x, y;
    Color cur;

    public static void main(String[] args) {
        JFrame win = new JFrame("Use the arrow keys!");
        win.setSize(1024, 768);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add(new EtchASketch());
        win.setVisible(true);
    }

    public EtchASketch() {
        enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
        requestFocus();
        x = 100;
        y = 100;
        cur = Color.black;
    }

    public void paint(Graphics g) {
        g.setColor(cur);
        g.fillOval(x, y, 20, 20);// size of the ball
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void processKeyEvent(KeyEvent e) {
        // this method automatically gets called with they press a key
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_UP)
                y -= 10;
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                y += 10;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)// left move
                x -= 10;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)// right move
                x += 10;

            // change color for F1 = red, F2 = green, F3 = blue, and F5 = black
            if (e.getKeyCode() == KeyEvent.VK_F1)
                cur = Color.red;
            if (e.getKeyCode() == KeyEvent.VK_F2)
                cur = Color.green;
            if (e.getKeyCode() == KeyEvent.VK_F3)
                cur = Color.blue;
            if (e.getKeyCode() == KeyEvent.VK_F5)
                cur = Color.black;

            // and we manually call paint() again to redraw
            repaint();
        }
    }

    public boolean isFocusable() {
        return true;
    }
}