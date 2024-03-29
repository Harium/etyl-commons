package com.harium.etyl.commons.graphics.stroke;

import com.harium.etyl.commons.graphics.Graphics;

public class BasicStroke extends BaseStroke {

    public BasicStroke() {
        super();
    }

    public BasicStroke(int width) {
        super(width);
    }

    @Override
    protected int plot(Graphics g, int x, int y, int count) {
        g.putPixel(x, y);
        return count;
    }

}
