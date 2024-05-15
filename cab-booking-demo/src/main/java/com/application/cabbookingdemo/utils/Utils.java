package com.application.cabbookingdemo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.cabbookingdemo.entity.Location;

public class Utils {
	
	public static Logger log = LoggerFactory.getLogger(Utils.class);
	
    /*
     * Distance between two points
     *  d=√((x2 – x1)² + (y2 – y1)²)
     */
	public static double calculateDistance(Location sourceLocation, Location driverLocation) {
		double sourceLat = sourceLocation.getLatitude();
		double sourceLon = sourceLocation.getLongitude();
		double driverLat = driverLocation.getLatitude();
		double driverLon = driverLocation.getLongitude();
		
		double squaredDistance = Math.pow(driverLat - sourceLat, 2) + Math.pow(driverLon - sourceLon, 2);
		log.info("Squared distance - " + squaredDistance);
		return Math.sqrt(squaredDistance);
	}

	public static Location parseLocation(String input) {
		
		String location = removeBracesRegex(input);
		//location.replaceAll("[\\\\[\\\\](){}]", "");
		log.info("Location after replacement - {}", location);
		String[] loc = location.split(",");
		
		double latitude = Double.parseDouble(loc[0]);
		double longitude = Double.parseDouble(loc[1]);
		return new Location(latitude, longitude);
	}
	
    public static String removeBracesRegex(String input) {
        Pattern pattern = Pattern.compile("^\\((.*?)\\)$"); // Matches "(.*)" pattern
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1); // Extract the captured group (content inside parentheses)
        } else {
            return input; // Return the original string if no match
        }
    }
}
