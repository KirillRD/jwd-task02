package com.epam.task2.entity.criteria;

/**
 * Class contains enums with criteria for search
 * @author Kirill Ryabov
 */
public final class SearchCriteria {
	/**
	 * Enum contains the name of the fields for the Oven
	 */
	public enum Oven {
		POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH, HEIGHT, WIDTH
	}

	/**
	 * Enum contains the name of the fields for the Laptop
	 */
	public enum Laptop {
		BATTERY_CAPACITY, OS, MEMORY_ROM, SYSTEM_MEMORY, CPU, DISPLAY_INCHES
	}

	/**
	 * Enum contains the name of the fields for the Refrigerator
	 */
	public enum Refrigerator {
		POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY, OVERALL_CAPACITY, HEIGHT, WIDTH
	}

	/**
	 * Enum contains the name of the fields for the VacuumCleaner
	 */
	public enum VacuumCleaner {
		POWER_CONSUMPTION, FILTER_TYPE, BAG_TYPE, WAND_TYPE, MOTOR_SPEED_REGULATION, CLEANING_WIDTH
	}

	/**
	 * Enum contains the name of the fields for the TabletPC
	 */
	public enum TabletPC {
		BATTERY_CAPACITY, DISPLAY_INCHES, MEMORY_ROM, FLASH_MEMORY_CAPACITY, COLOR		
	}

	/**
	 * Enum contains the name of the fields for the Speakers
	 */
	public enum Speakers {
		POWER_CONSUMPTION, NUMBER_OF_SPEAKERS, FREQUENCY_RANGE, CORD_LENGTH
	}

	/**
	 * Restricting access to the creation of objects of this class
	 */
	private SearchCriteria() {}
}
