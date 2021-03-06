/** 
 * This class stores all the relevant information about a company
 * 
 * @author Hannah Wilder 
 * @version 1.0
 */
package com.database;

import java.util.ArrayList;
import java.util.HashMap;

public class Company {
	private String name = null;
	private String website = null;
	private String tableNum = null;
	private String room = null;

	private ArrayList<Major> majors;
	private ArrayList<String> majorNames;
	private ArrayList<String> majorAbbrevs;
	private ArrayList<String> positions;
	private ArrayList<String> workAuths;

	private HashMap<String, String> majorHashMap;

	/**
	 * Company constructor
	 * 
	 * @param aName
	 *            - the name of the company
	 * @param aWebsite
	 *            - the name of the website
	 * @param aTableNum
	 *            - the number of the table (in a string)
	 * @param aRoom
	 *            - the room name (hall/multipurpose/wood)
	 * @param aMajors
	 *            - an ArrayList of the majors this company is looking for
	 * @param aPositions
	 *            - an ArrayList of the positions a company is hiring
	 * @param aWorkAuths
	 *            - an ArrayList of work authorizations a company is looking for
	 */
	public Company(String aName, String aWebsite, String aTableNum,
			String aRoom, ArrayList<Major> aMajors,
			ArrayList<String> aPositions, ArrayList<String> aWorkAuths) {
		name = aName;
		website = aWebsite;
		tableNum = aTableNum;
		room = aRoom;

		majors = aMajors;
		majorNames = new ArrayList<String>();
		majorAbbrevs = new ArrayList<String>();
		for (Major major : majors) {
			majorNames.add(major.getName());
			majorAbbrevs.add(major.getAbbrev());
		}
		positions = aPositions;
		workAuths = aWorkAuths;

		// key = full name value = abbreviation
		majorHashMap = new HashMap<String, String>();
		for (Major major : majors) {
			majorHashMap.put(major.getName(), major.getAbbrev());
		}
	}

	

	/**
	 * getMajors
	 * 
	 * @return returns a copy the ArrayList of majors
	 */
	public ArrayList<Major> getMajors() {
		return (ArrayList<Major>) majors.clone();
	}

	/**
	 * getMajorNames
	 * 
	 * @return returns a copy the ArrayList of major names
	 */
	public ArrayList<String> getMajorNames() {
		return (ArrayList<String>) majorNames.clone();
	}

	/**
	 * getMajorAbbrevs
	 * 
	 * @return returns a copy the ArrayList of major abbrevs
	 */
	public ArrayList<String> getMajorAbbrevs() {
		return (ArrayList<String>) majorAbbrevs.clone();
	}

	/**
	 * getMajorHashMap
	 * 
	 * @return a copy of the major hash map (keyed with full name as per
	 *         request)
	 */
	public HashMap<String, String> getMajorHashMap() {
		return (HashMap<String, String>) majorHashMap.clone();
	}

	/**
	 * getPositions
	 * 
	 * @return returns a copy of the ArrayList of positions
	 */
	public ArrayList<String> getPositions() {
		return (ArrayList<String>) positions.clone();
	}

	/**
	 * getWorkAuth
	 * 
	 * @return returns a copy of the ArrayList of work authorizations
	 */
	public ArrayList<String> getWorkAuth() {
		return (ArrayList<String>) workAuths.clone();
	}

	/**
	 * getName
	 * 
	 * @return the name of the company
	 */
	public String getName() {
		return name;
	}

	/**
	 * getWebsite
	 * 
	 * @return the company's website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * getTableNum
	 * 
	 * @return the company's assigned table number (as a string)
	 */
	public String getTableNum() {
		return tableNum;
	}

	/**
	 * getRoom
	 * 
	 * @return the room assignment (hall/multipurpose/wood)
	 */
	public String getRoom() {
		return room;
	}

}
