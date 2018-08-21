package com.harium.etyl.commons.layer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeometricLayerTest {

    private GeometricLayer layer;

    @Before
    public void setUp() {
        layer = new GeometricLayer(0, 0, 32, 32);
    }

    @Test
    public void testRectPointColision() {
        Assert.assertTrue(layer.collideRectPoint(20, 20));
        Assert.assertTrue(layer.collideRectPoint(0, 31));
        Assert.assertTrue(layer.collideRectPoint(0, 32));

        Assert.assertFalse(layer.collideRectPoint(0, 33));
    }

    @Test
    public void testCirclePointColision() {
        Assert.assertTrue(layer.collideCirclePoint(layer.getW() / 2, layer.getH() / 2));
        Assert.assertFalse(layer.collideCirclePoint(layer.getX() + layer.getW(), layer.getY()));
    }

}
