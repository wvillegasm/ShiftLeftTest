package com.itsoft.slt.ejb.eis.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.itsoft.slt.ejb.domain.User;
import com.itsoft.slt.ejb.eis.UserDAO;

@Stateless
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext(unitName="SLTPu")
	EntityManager em;

	@Override
	public List<User> findAll() {
		return em.createNamedQuery("User.findAll").getResultList();
		/*List<User> users = new ArrayList<User>();
		users.add(new User("alicem", "Alice", "Doe"));
		users.add(new User("alicem", "Alice", "Doe"));
		return users;*/
	}

	@Override
	public User findById(User t) {
		Query q = em.createNamedQuery("User.findById");
		q.setParameter("id", t.getUserId());
		return (User)q.getSingleResult();
	}

	@Override
	public void save(User t) {
		em.persist(t);		
	}

	@Override
	public void update(User t) {
		em.merge(t);		
	}

	@Override
	public void delete(User t) {
		em.merge(t);
		em.remove(t);
	}

}
