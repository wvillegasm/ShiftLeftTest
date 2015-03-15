package com.itsoft.slt.ejb.testremote;

import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.itsoft.slt.ejb.domain.User;
import com.itsoft.slt.ejb.service.impl.UserServiceRemoteImpl;

/**
 * 
 * @author wilfredo
 *
 * Testing EJB. The EJB must be deployed into the WAS
 * 
 */
public class UserServiceTest {
	
	public static void main(String... args){
		
		System.out.println("");
		
		//Using Simplified API of glassfish
		try {
			
			Context ctx = new InitialContext();
			UserServiceRemoteImpl serviceRemoteImpl = (UserServiceRemoteImpl) ctx.lookup("java:global/ShiftLeftTest/UserServiceRemote!com.itsoft.slt.ejb.service.UserServiceRemote");
			List<User> users = serviceRemoteImpl.findAll();
			
			for (User user : users) {
				System.out.println(user);
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
