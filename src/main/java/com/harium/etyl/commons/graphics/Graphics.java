package com.harium.etyl.commons.graphics;

import com.harium.etyl.commons.layer.GeometricLayer;
import com.harium.etyl.commons.layer.Layer;
import com.harium.etyl.geometry.Line2;
import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.math.Vector2i;

public interface Graphics {

	void setFps(float fps);

	float getFps();

	void resetImage();

	int getWidth();
	
	int getHeight();

    /**
     * Method to draw a single pixel
     * @param x
     * @param y
     */
	void putPixel(int x, int y);

	/**
	 * 
	 * @param layer
	 */
	void drawRect(GeometricLayer layer);

	/**
	 * 
	 * @param layer
	 */
	void drawRect(Layer layer);

	/**
	 * 
	 * @param layer
	 */
	void fillOval(GeometricLayer layer);

	/**
	 * 
	 * @param layer
	 * @param startAngle
	 * @param arcAngle
	 */
	void fillArc(GeometricLayer layer, int startAngle, int arcAngle);

	void resetTransform();

	/**
	 * 
	 * @param color
	 */
	void setColor(int color) ;

	void setColor(Color color);

	/**
	 * 
	 * @param percent
	 */
	void setAlpha(int percent);
	
	void resetAlpha();

	void setClearAlpha(int percent);

	/**
	 * 
	 * @param opacity
	 */
	void setOpacity(int opacity);

	void resetOpacity();

	/**
	 * Method to prepare graphics to draw images ONLY
	 */
	void beginImageBatch();
	
	/**
	 * Method to end images ONLY mode
	 */
	void endImageBatch();

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param startAngle
	 * @param arcAngle
	 */
	void drawArc(int x, int y, int w, int h, int startAngle, int arcAngle);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param startAngle
	 * @param arcAngle
	 */
	void drawArc(float x, float y, float w, float h, int startAngle, int arcAngle);

	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	void drawLine(int x1, int y1, int x2, int y2);

	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	void drawLine(float x1, float y1, float x2, float y2);

	/**
	 * 
	 * @param p
	 * @param q
	 */
	void drawLine(Point2D p, Point2D q);
	
	/**
	 * 
	 * @param line
	 */
	void drawLine(Line2 line);

	/**
	 * @param xPoints
	 * @param yPoints
	 * @param nPoints
	 */
	void drawPolygon(int[] xPoints, int[] yPoints, int nPoints);

	/**
	 * 
	 * @param layer
	 */
	void fillRect(GeometricLayer layer);

	void fillRect(Layer layer);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void fillRect(int x, int y, int w, int h);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void fillRect(float x, float y, float w, float h);


	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param raised
	 */
	void fill3DRect(int x, int y, int w, int h, boolean raised);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param raised
	 */
	void fill3DRect(float x, float y, float w, float h, boolean raised);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param startAngle
	 * @param arcAngle
	 */
	void fillArc(int x, int y, int w, int h, int startAngle, int arcAngle);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param startAngle
	 * @param arcAngle
	 */
	void fillArc(float x, float y, float w, float h, int startAngle, int arcAngle);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void drawRect(int x, int y, int w, int h);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void drawRect(double x, double y, double w, double h);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param arcWidth
	 * @param arcHeight
	 */
	void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param arcWidth
	 * @param arcHeight
	 */
	void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void drawOval(int x, int y, int w, int h);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void drawOval(float x, float y, float w, float h);

	/**
	 * 
	 * @param cx
	 * @param cy
	 * @param radius
	 */
	void drawCircle(int cx, int cy, int radius);

	/**
	 * 
	 * @param cx
	 * @param cy
	 * @param radius
	 */
	void drawCircle(float cx, float cy, float radius);

	/**
	 * 
	 * @param cx
	 * @param cy
	 * @param radius
	 */
	void drawCircle(double cx, double cy, double radius);

	/**
	 * 
	 * @param point
	 * @param radius
	 */
	void drawCircle(Point2D point, int radius);

	/**
	 * 
	 * @param cx
	 * @param cy
	 * @param radius
	 */
	void fillCircle(int cx, int cy, int radius);

	/**
	 * 
	 * @param cx
	 * @param cy
	 * @param radius
	 */
	void fillCircle(float cx, float cy, float radius);

	/**
	 * 
	 * @param cx
	 * @param cy
	 * @param radius
	 */
	void fillCircle(double cx, double cy, double radius);

	/**
	 * 
	 * @param point
	 * @param radius
	 */
	void fillCircle(Point2D point, int radius);
	
	/**
	 * 
	 * @param point
	 * @param radius
	 */
	void fillCircle(Vector2i point, int radius);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void fillOval(int x, int y, int w, int h);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void fillOval(float x, float y, float w, float h);

	/**
	 * @param xPoints
	 * @param yPoints
	 * @param nPoints
	 */
	void fillPolygon(int[] xPoints, int[] yPoints, int nPoints);

	/**
	 * 
	 * @param x
	 * @param y
	 */
	void translate(int x, int y);

	/**
	 * 
	 * @param x
	 * @param y
	 */
	void translate(double x, double y);

	void rotate(double angle);

	void setBackground(Color color);

	void clearRect(int x, int y, int width, int height);
	
	void setShadowColor(Color shadowColor);
	
	void dispose();

	void drawArrow(Point2D p, Point2D q, int arrowSize);
	
	void drawArrow(Point2D p, Point2D q);

	void setClip(int x, int y, int w, int h);
	
	void resetClip();

}