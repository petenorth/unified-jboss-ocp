package com.redhat.ukiservices.model.common;

import java.util.ArrayList;

public interface IDarwinData {

	/**
	 * The type identifier of the data
	 * 
	 * @return
	 */
	public DarwinDataType getDarwinDataType();

	public void setDarwinDataType(DarwinDataType ddType);

	/**
	 * The id associated with the data
	 * 
	 * @return List<String>
	 */
	public String getId();

	public void setId(String id);

	/**
	 * Any message associated with the data
	 * 
	 * @return List<String>
	 */
	public String getMessage();

	public void setMessage(String message);

	/**
	 * Any location information associated with the data
	 * 
	 * @return List<String>
	 */
	public ArrayList<String> getLocations();

	public void setLocations(ArrayList<String> locations);

}
