package com.harium.etyl.commons.interpolation;

import com.harium.etyl.commons.interpolation.Interpolator;
import com.harium.etyl.commons.interpolation.QuadraticInterpolator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuadraticInterpolatorTest {

	Interpolator interpolator;
	
	private static final int START = 100;
	private static final int END = 200;
	
	@Before
	public void setUp() {
		interpolator = new QuadraticInterpolator();
	}
	
	@Test
	public void testStart() {
		double value = interpolator.interpolate(START, END, 0);
		Assert.assertEquals(START, value, 0);
	}
	
	@Test
	public void testMiddle() {
		double value = interpolator.interpolate(START, END, 0.5);
		Assert.assertEquals(START + 25, value, 0);		
	}
	
	@Test
	public void testEnd() {
		double value = interpolator.interpolate(START, END, 1);
		Assert.assertEquals(END, value, 0);
	}
	
}
