package com.harium.etyl.commons.interpolation;

public interface Interpolator {
	
	Interpolator LINEAR = new LinearInterpolator();
	Interpolator QUADRATIC = new QuadraticInterpolator();
	Interpolator REVERSE_QUADRATIC = new ReverseQuadraticInterpolator();
	Interpolator RADIAL = new RadialInterpolator();
	
	double interpolate(double startValue, double endValue, double factor);
	
}
