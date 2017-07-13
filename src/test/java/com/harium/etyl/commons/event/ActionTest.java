package com.harium.etyl.commons.event;

import com.harium.etyl.commons.layer.Layer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionTest {

	private Layer layer;
	
	private Action action; 
	
	@Before
	public void setUp(){
		layer = new Layer(0, 0, 32, 32);
		layer.setVisible(false);
		action = new Action(layer, "setVisible", true);
	}
	
	@Test
	public void testExecuteAction() {
		action.executeAction();
		
		Assert.assertTrue(layer.isVisible());
	}

}
