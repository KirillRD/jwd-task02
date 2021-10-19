package com.epam.task2.main;

import com.epam.task2.entity.Appliance;

import java.util.HashSet;

public class PrintApplianceInfo {
	
	public static void print(HashSet<Appliance> appliances) {
		for (Appliance appliance : appliances) {
			System.out.println(appliance.toString());
		}
	}
}
