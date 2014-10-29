package org.icatproject.ids.plugin;

public interface DfInfo {

	/**
	 * Return the id of whoever created the data file
	 * 
	 * @return the data file creator
	 */
	String getCreateId();

	/**
	 * Return the data file id
	 * 
	 * @return the data file id
	 */
	Long getDfId();

	/**
	 * Return the data file location
	 * 
	 * @return the data file location
	 */
	String getDfLocation();

	/**
	 * Return the data file name
	 * 
	 * @return the data file name
	 */
	String getDfName();

	/**
	 * Return the id of whoever modified the data file last
	 * 
	 * @return the data file modifier
	 */
	String getModId();

}
