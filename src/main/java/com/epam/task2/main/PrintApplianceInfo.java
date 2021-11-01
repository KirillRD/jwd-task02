package com.epam.task2.main;

import com.epam.task2.entity.Appliance;

import java.util.HashSet;

/**
 * Class for print properties of appliances
 * @author Kirill Ryabov
 */
public class PrintApplianceInfo {
	/**
	 * Method prints appliances with their properties such as appliance type, fields and fields values
	 * @param appliances HashSet of appliances which should be printed out
	 */
	public static void print(HashSet<Appliance> appliances) {
		for (Appliance appliance : appliances) {
			System.out.println(appliance.toString());
		}
	}
}
