package com.itsoft.slt.ejb.jpa;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.itsoft.slt.ejb.domain.User;

public class UserEntityTest {

	static EntityManager em;
	static EntityManagerFactory emf;
	static EntityTransaction et;
	
	Logger log = Logger.getLogger(UserEntityTest.class);
	
	@BeforeClass
	public static void init() throws Exception{
		emf = Persistence.createEntityManagerFactory("SLTPu");
	}
	
	@Before
	public void septup() throws Exception{
		em = emf.createEntityManager();
	}
	
	@Test
	public void verify_persistence_of_user_entity_in_database() {
		log.info("Starting Persistence of User Entity");
		assertNotNull(em);
		assertNotNull(emf);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		User u = new User("alicem","Alice", "Doe");
		
		assertNull(u.getUserId());
		em.persist(u);
		
		tx.commit();
		
		assertNotNull(u.getUserId());
		
	}

}
