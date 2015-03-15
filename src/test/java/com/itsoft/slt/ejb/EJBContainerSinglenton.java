package com.itsoft.slt.ejb;

import javax.ejb.embeddable.EJBContainer;

public class EJBContainerSinglenton {

	private static EJBContainer instance = null;

	protected EJBContainerSinglenton() {
	}

	public static EJBContainer getInstance() {
		// Lazy initialization(If require only)
		if (instance == null) {
			synchronized (EJBContainerSinglenton.class) {
				if (instance == null) {
					instance = EJBContainer.createEJBContainer();
				}
			}
		}
		return instance;

	}

}
