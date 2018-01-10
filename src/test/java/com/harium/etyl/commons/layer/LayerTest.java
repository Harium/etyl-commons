package com.harium.etyl.commons.layer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LayerTest {

    private Layer layer;

    @Before
    public void setUp() {
        layer = new Layer(0, 1, 31, 32);
        layer.setOpacity(22);
        layer.setOrigin(33,34);
        layer.setVisible(false);
    }

    @Test
    public void testGetSrcMeasures() {
        Assert.assertEquals(31, layer.getW());
        Assert.assertEquals(32, layer.getH());

        layer.setW(200);
        Assert.assertEquals(200, layer.getW());
    }

    @Test
    public void testSwapVisible() {
        layer.setVisible(false);
        layer.swapVisible();

        Assert.assertTrue(layer.isVisible());
    }

    @Test
    public void testRotatedCollision() {
        Layer rotatedLayer = new Layer(20, 60, 400, 100);
        rotatedLayer.setAngle(45);

        int cx = rotatedLayer.getX() + rotatedLayer.getW() / 2;
        int cy = rotatedLayer.getY() + rotatedLayer.getH() / 2;

        Assert.assertTrue(rotatedLayer.colideRectPoint(cx, cy));
        Assert.assertTrue(rotatedLayer.colideRectPoint(220, 80));

        Assert.assertFalse(rotatedLayer.colideRectPoint(0, 0));
        Assert.assertFalse(rotatedLayer.colideRectPoint(20, 60));
        Assert.assertFalse(rotatedLayer.colideRectPoint(19, 60));
    }

    @Test
    public void testCopyLayer() {
        Layer l = new Layer();
        l.copy(layer);

        Assert.assertEquals(0, l.getX());
        Assert.assertEquals(1, l.getY());
        Assert.assertEquals(31, l.getW());
        Assert.assertEquals(32, l.getH());
        Assert.assertEquals(33, l.getOriginX(), 0);
        Assert.assertEquals(34, l.getOriginY(), 0);
        Assert.assertEquals(22, l.getOpacity());

    }

}
