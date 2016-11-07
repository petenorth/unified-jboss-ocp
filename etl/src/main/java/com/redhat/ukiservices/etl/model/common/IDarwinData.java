package com.redhat.ukiservices.etl.model.common;

import java.util.List;

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
	public List<String> getLocations();

	public void setLocations(List<String> locations);

}
