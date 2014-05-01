package org.icatproject.ids.plugin;

public interface DfInfo {

	/**
	 * Return the data file name
	 * 
	 * @return the data file name
	 */
	String getDfName();

	/**
	 * Return the data file id
	 * 
	 * @return the data file id
	 */
	long getDfId();

	/**
	 * Return the data file location
	 * 
	 * @return the data file location
	 */
	String getDfLocation();

	/**
	 * Return the data file creator - the createId field
	 * 
	 * @return the data file creator
	 */
	String getCreator();

}
