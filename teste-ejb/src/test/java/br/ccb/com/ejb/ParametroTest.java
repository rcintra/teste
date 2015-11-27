package br.ccb.com.ejb;

import org.junit.Test;

public class ParametroTest {

	private ParametroService service;
	
	@Test
	public void testService() {
		service.sayHello("rafael");
	}
}
