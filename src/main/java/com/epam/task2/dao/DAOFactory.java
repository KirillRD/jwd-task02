package com.epam.task2.dao;

import com.epam.task2.dao.impl.ApplianceDAOImpl;

/**
 * Class factory of {@link ApplianceDAO}
 * This class can't be extended
 * @author Kirill Ryabov
 */
public final class DAOFactory {
	/**
	 * Object {@link DAOFactory}
	 */
	private static final DAOFactory instance = new DAOFactory();

	/**
	 * Object {@link ApplianceDAOImpl} that implements interface {@link ApplianceDAO} behaviors
	 */
	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

	/**
	 * Restricting access to the creation of objects of this class
	 */
	private DAOFactory() {}

	/**
	 * Method returns object {@link ApplianceDAOImpl} of interface {@link ApplianceDAO}
	 * @return object {@link ApplianceDAOImpl} of interface {@link ApplianceDAO}
	 */
	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	/**
	 * Method returns object {@link DAOFactory}
	 * @return object {@link DAOFactory}
	 */
	public static DAOFactory getInstance() {
		return instance;
	}
}
