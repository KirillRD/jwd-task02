package com.epam.task2.service;

import com.epam.task2.service.impl.ApplianceServiceImpl;

/**
 * Class factory of {@link ApplianceService}
 * This class can't be extended
 * @author Kirill Ryabov
 */
public final class ServiceFactory {
	/**
	 * Object {@link ServiceFactory}
	 */
	private static final ServiceFactory instance = new ServiceFactory();

	/**
	 * Object {@link ApplianceServiceImpl} that implements interface {@link ApplianceService} behaviors
	 */
	private final ApplianceService applianceService = new ApplianceServiceImpl();

	/**
	 * Restricting access to the creation of objects of this class
	 */
	private ServiceFactory() {}

	/**
	 * Method returns object {@link ApplianceServiceImpl} of interface {@link ApplianceService}
	 * @return object {@link ApplianceServiceImpl} of interface {@link ApplianceService}
	 */
	public ApplianceService getApplianceService() {
		return applianceService;
	}

	/**
	 * Method returns object {@link ServiceFactory}
	 * @return object {@link ServiceFactory}
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}
}
