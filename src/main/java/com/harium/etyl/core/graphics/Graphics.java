package com.harium.etyl.core.graphics;

import com.harium.etyl.commons.graphics.Color;

// Place Holder Class
public interface Graphics {

    void setColor(Color backgroundColor);

    void fillRect(int x, int y, int w, int h);

    void drawRect(int rectX, int rectY, int rectW, int rectH);
}
