package com.harium.etyl.commons.graphics;

import com.harium.etyl.commons.layer.GeometricLayer;

public interface TextGraphics {

    void setFontSize(float size);

    void setFontStyle(int fontStyle);

    int textWidth(String text);

    void drawString(String text, int x, int y);

    void drawString(String text, float x, float y);

    void drawString(String text, int x, int y, int w, int h);

    void drawString(String text, GeometricLayer layer);

    void drawString(String text, GeometricLayer layer, int offsetX, int offsetY);

    void drawString(String text, float x, float y, float w, float h);

    void drawStringExponent(String text, String exponent, int x, int y);

    void drawStringExponentShadow(String text, String exponent, int x, int y);

    void drawStringShadow(String text, int x, int y, int w, int h);

    void drawStringShadow(String text, int x, int y, int w, int h, Color shadowColor);

    void drawStringShadow(String text, float x, float y, float w, float h, Color shadowColor);

    void drawStringBorder(String text, float x, float y);

    void drawStringBorder(String text, int x, int y, int w, int h);

    void drawStringBorderX(String text, float y);

    void drawStringShadow(String text, int x, int y);

    void drawStringShadow(String text, float x, float y);

    void drawStringShadow(String text, GeometricLayer layer);

    void drawStringShadow(String text, int x, int y, Color shadowColor);

    void drawStringShadow(String text, float x, float y, Color shadowColor);

    void drawStringShadowX(String text, int y);

    void drawStringShadowX(String text, float y);

    void drawStringX(String text, float offsetX, float y);

    void drawStringX(String text, int y);

    void drawStringX(String text, float y);

}
