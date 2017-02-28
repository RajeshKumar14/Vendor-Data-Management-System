package com.app.services;

import java.util.List;

import com.app.model.Location;

public interface ILocationService {

	public int saveLocation(Location loc);
	public List<Location> getAllLocations();
	public void deleteLocById(int locId);
	public Location getLocationById(int locId);
	public void updateLoc(Location loc);
	/***
	 * Get count based on location Type
	 */
	public List<Object[]> getLocationwiseCount();
	public boolean isLocNameExist(String locName);
	
}
