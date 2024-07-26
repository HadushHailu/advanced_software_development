package paint;

import java.awt.*;

public class RectangleCommand implements ICommand{
    DrawService drawService;
    Graphics g;
    int k;
    int l;
    int m;
    int n;

    public RectangleCommand(DrawService drawService, Graphics g, int k, int l, int m, int n) {
        this.drawService = drawService;
        this.g = g;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
    }

    @Override
    public void execute(){
        drawService.drawRectangle(g,k,l,m,n);
    }

    @Override
    public void unExecute(){
    }
}
