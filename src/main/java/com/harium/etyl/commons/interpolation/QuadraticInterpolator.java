package com.harium.etyl.commons.interpolation;

public class QuadraticInterpolator implements Interpolator {

    public double interpolate(double startValue, double endValue, double factor) {
        double value = (endValue - startValue) * factor * factor;
        value += startValue;
        return value;
    }

}
