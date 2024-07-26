package paint;

import java.awt.*;

public class CircleCommand implements ICommand{
    DrawService drawService;
    Graphics g;
    int k;
    int l;
    int m;
    int n;

    public CircleCommand(DrawService drawService, Graphics g, int k, int l, int m, int n) {
        this.drawService = drawService;
        this.g = g;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
    }

    @Override
    public void execute(){
        drawService.drawCircle(g,k,l,m,n);
    }

    @Override
    public void unExecute(){
    }
}
