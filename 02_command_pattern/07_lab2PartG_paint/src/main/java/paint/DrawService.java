package paint;

import javax.swing.*;
import java.awt.*;

public class DrawService extends JFrame {

    public void drawLine(Graphics g, int k, int l, int m, int n){
        g.drawLine(k, l, m, n);
    }

    public void drawRectangle(Graphics g, int k, int l, int m, int n){
        g.fillRect(k, l, m, n);
    }

    public void drawCircle(Graphics g, int k, int l, int m, int n){
        g.fillOval(k, l, m, n);
    }

}
