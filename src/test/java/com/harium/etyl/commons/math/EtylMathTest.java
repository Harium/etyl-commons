package com.harium.etyl.commons.math;

import org.junit.Assert;
import org.junit.Test;

import com.harium.etyl.commons.math.EtylMath;

public class EtylMathTest {

	@Test
	public void testDiffMod() {
		int a = 50;
		int b = 80;
		
		Assert.assertEquals(30, EtylMath.diffMod(a, b), 0);
	}
	
	@Test
	public void testSqr() {
		Assert.assertEquals(4, EtylMath.sqr(2), 0);
		Assert.assertEquals(9, EtylMath.sqr(3), 0);
		Assert.assertEquals(16, EtylMath.sqr(4), 0);
		Assert.assertEquals(25, EtylMath.sqr(5), 0);
	}
	
	@Test
	public void testMax() {
		
		int a = 2;
		int b = 9028391;
		
		Assert.assertEquals(b, EtylMath.max(a, b));
	}
	
	@Test
	public void testMaxWithThreeParams() {
		
		int a = 2;
		int b = 9028391;
		int c = 90283910;
		
		Assert.assertEquals(c, EtylMath.max(a, b, c));
	}
	
	@Test
	public void testMin() {
		
		int a = 2;
		int b = 9028391;
		
		Assert.assertEquals(a, EtylMath.min(a, b));
	}
	
	@Test
	public void testMinWithThreeParams() {
		
		int a = 2;
		int b = 9028391;
		int c = 1;
		
		Assert.assertEquals(c, EtylMath.min(a, b, c));
	}
}
