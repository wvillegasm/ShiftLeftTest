package com.itsoft.slt.ejb;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.itsoft.slt.ejb.DemoEJB;

/**
 * 
 * @author wilfredo
 *
 * Due this start a embedded glassfish WAS then no WAS must be running.
 * Remember stop all WAS.
 */
public class DemoEJBTest {

	private static EJBContainer container;
	private static Context context;
	private static DemoEJB demoEjb;
	
	
	@Before
	public void init() throws Exception{
		
		container = EJBContainerSinglenton.getInstance(); //EJBContainer.createEJBContainer();
		context = container.getContext();
		demoEjb = (DemoEJB) context.lookup("java:global/classes/DemoEJB!com.itsoft.slt.ejb.DemoEJB");
		
		
	}
	
	
	@Test
	public void sum_two_number_demoejb() {
		Integer result = demoEjb.sumInt();
		Integer expected = 5;
		assertEquals(result, expected);
	}

}
