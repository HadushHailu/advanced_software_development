package paint;

import java.awt.*;

public class LineCommand implements ICommand{
    DrawService drawService;
    Graphics g;
    int k;
    int l;
    int m;
    int n;

    public LineCommand(DrawService drawService, Graphics g, int k, int l, int m, int n) {
        this.drawService = drawService;
        this.g = g;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
    }

    @Override
    public void execute(){
        drawService.drawLine(g,k,l,m,n);
    }

    @Override
    public void unExecute(){
    }
}
