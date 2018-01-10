package com.harium.etyl.commons.collision;

import org.junit.Assert;
import org.junit.Test;

public class CollisionDetectorTest {

    @Test
    public void collideCirclePoint() {
        int cx = 32;
        int cy = 32;
        int radius = 32;

        Assert.assertTrue(CollisionDetector.colideCirclePoint(cx, cy, radius, 20, 32));
        Assert.assertTrue(CollisionDetector.colideCirclePoint(cx, cy, radius, 32, 20));

        Assert.assertFalse(CollisionDetector.colideCirclePoint(cx, cy, radius, 2, 2));
    }

}
