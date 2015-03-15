package com.itsoft.slt.ejb;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.itsoft.slt.ejb.domain.User;
import com.itsoft.slt.ejb.service.IServiceLocal;

public class UserEBJTest {

	EJBContainer container;
	private IServiceLocal<User> userService;

	@Before
	public void init() throws Exception {
		container = EJBContainerSinglenton.getInstance(); // EJBContainer.createEJBContainer();
		userService = (IServiceLocal) container
				.getContext()
				.lookup("java:global/classes/UserServiceImpl!com.itsoft.slt.ejb.service.IServiceLocal");

	}

	@Test
	public void verify_find_all_users() {

		assertNotNull(userService);

		List<User> users = (List<User>) userService.findAll();
		assertNotNull(users);

		assertTrue(users.size() == 2);

	}

}
