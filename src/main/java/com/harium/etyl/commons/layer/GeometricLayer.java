package com.harium.etyl.commons.layer;

import com.harium.etyl.commons.Movable;
import com.harium.etyl.geometry.collision.CollisionDetector;

public class GeometricLayer implements Movable {

    /**
     * Layer's x
     */
    protected int x = 0;

    /**
     * Layer's y
     */
    protected int y = 0;

    /**
     * Layer's width
     */
    protected int w = 0;

    /**
     * Layer's height
     */
    protected int h = 0;

    public GeometricLayer() {
        super();
    }

    public GeometricLayer(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public GeometricLayer(int x, int y, int w, int h) {
        super();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setLocation(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setBounds(int x, int y, int w, int h) {
        setLocation(x, y);
        setSize(w, h);
    }

    /**
     * @param offsetX
     */
    public void offsetX(int offsetX) {
        setX(this.x + offsetX);
    }

    /**
     * @param offsetY
     */
    public void offsetY(int offsetY) {
        setY(this.y + offsetY);
    }

    /**
     * @param offsetX
     * @param offsetY
     */
    public void offset(int offsetX, int offsetY) {
        offsetX(offsetX);
        offsetY(offsetY);
    }

    /**
     * @param w
     * @param h
     */
    public void setSize(int w, int h) {
        setW(w);
        setH(h);
    }

	/*
     * Centralization Methods
	 */

    /**
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public void centralize(int x, int y, int w, int h) {
        centralizeX(x, x + w);
        centralizeY(y, y + h);
    }

    /**
     * @param layer
     */
    public void centralize(GeometricLayer layer) {
        centralizeX(layer);
        centralizeY(layer);
    }

    /**
     * @param layer
     */
    public void centralizeX(GeometricLayer layer) {
        centralizeX(layer.getX(), layer.getX() + layer.getW());
    }

    /**
     * @param startX
     * @param endX
     * @return
     */
    public int centralizeX(int startX, int endX) {
        int x = (((startX + endX) / 2) - (getW() / 2));
        setX(x);

        return x;
    }

    /**
     * @param layer
     */
    public void centralizeY(GeometricLayer layer) {
        centralizeY(layer.getY(), layer.getY() + layer.getH());
    }

    /**
     * @param startY
     * @param endY
     * @return
     */
    public int centralizeY(int startY, int endY) {
        int y = (((startY + endY) / 2) - (getH() / 2));
        setY(y);

        return y;
    }

    public void copy(GeometricLayer layer) {
        setX(layer.getX());
        setY(layer.getY());
        setW(layer.getW());
        setH(layer.getH());
    }

	/*
	 * Collision Methods
	 */

    public boolean collideRectRect(GeometricLayer b) {
        return collideRectRect(b.getX(), b.getY(), b.getW(), b.getH());
    }

    /**
     * @param bx
     * @param by
     * @param bw
     * @param bh
     * @return
     */
    public boolean collideRectRect(int bx, int by, int bw, int bh) {
        return CollisionDetector.collideRectRect(getX(), getY(), getW(), getH(), bx, by, bw, bh);
    }

    public boolean collideRectPoint(int bx, int by) {
        return CollisionDetector.collideRectPoint(getX(), getY(), getW(), getH(), bx, by);
    }

    /**
     * @param bx
     * @param by
     * @param bw
     * @param bh
     * @return
     */
    public boolean collideCircleCircle(int bx, int by, int bw, int bh) {
        return CollisionDetector.collideCircleCircle(getX(), getY(), getW(), getH(), bx, by, bw, bh);
    }

    public boolean collideCircleCircle(GeometricLayer layer) {
        return collideCircleCircle(layer.getX(), layer.getY(), layer.getW(), layer.getH());
    }

    /**
     * @param px
     * @param py
     * @return
     */
    public boolean collideCirclePoint(int px, int py) {
        int radius = getW() / 2;
        int cx = getX() + radius;
        int cy = getY() + radius;
        return CollisionDetector.collideCirclePoint(cx, cy, radius, px, py);
    }

}