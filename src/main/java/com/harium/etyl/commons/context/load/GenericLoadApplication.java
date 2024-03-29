package com.harium.etyl.commons.context.load;

import com.harium.etyl.commons.graphics.Color;
import com.harium.etyl.commons.graphics.Graphics;

public class GenericLoadApplication extends DefaultLoadApplication {

    protected float fill = 0;

    public GenericLoadApplication(int w, int h) {
        super(w, h);
    }

    public GenericLoadApplication(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    private int rectW = w * 2 / 3;
    private int rectX = w / 2 - rectW / 2;
    private int rectY = h / 2 + 100;
    private int rectH = 32;

    private Color backgroundColor = Color.WHITE;
    private Color foregroundColor = Color.GREEN_ETYL;

    @Override
    public void load() {

    }

    @Override
    public void onChangeText(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public void onChangeLoad(float load) {
        this.percent = Integer.toString((int) load) + "%";
        this.fill = load;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(x, y, w, h);

        g.setColor(foregroundColor);

        g.drawRect(rectX, rectY, rectW, rectH);
        g.fillRect(rectX + 2, rectY + 2, (int) ((rectW * fill) / 100) - 3, rectH - 3);
    }

}