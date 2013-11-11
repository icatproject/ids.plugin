package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * An IDS interface which for which an implementation must be provided for any IDS deployment.
 */
public interface MainStorageInterface {

	/**
	 * Deletes the files of the specified data set.
	 * 
	 * A dummy implementation can be provided if no archive storage is configured.
	 * 
	 * @param dsInfo
	 *            describes the data set with the files to be deleted
	 * 
	 * @throws IOException
	 */
	public void delete(DsInfo dsInfo) throws IOException;

	/**
	 * Deletes the specified file
	 * 
	 * @param location
	 *            location of the data file to be deleted
	 * 
	 * @throws IOException
	 */
	public void delete(String location) throws IOException;

	/**
	 * See if the data set exists.
	 * 
	 * A dummy implementation can be provided if no archive storage is configured.
	 * 
	 * @param dsInfo
	 *            describes the data set being queried
	 * 
	 * @return true if the data set exists
	 * 
	 * @throws IOException
	 */
	public boolean exists(DsInfo dsInfo) throws IOException;

	/**
	 * Return a stream of data from the specified data file
	 * 
	 * @param location
	 *            location of the data file to be returned
	 * 
	 * @return input stream of data
	 * 
	 * @throws IOException
	 */
	public InputStream get(String location) throws IOException;

	/**
	 * Returns a list of locations of the files of the specified data set.
	 * 
	 * A dummy implementation can be provided if no archive storage is configured.
	 * 
	 * @param dsInfo
	 *            describes the data set with the files to be deleted
	 * 
	 * @return list of locations
	 * 
	 * @throws IOException
	 */
	public List<String> getLocations(DsInfo dsInfo) throws IOException;

	/**
	 * Store the specified data file and return information about the file
	 * 
	 * @param dsInfo
	 *            describes the data set to which the data file should be added
	 * @param name
	 *            name of file within data set
	 * @param inputStream
	 *            stream of data to store
	 * 
	 * @return the location of the stored data file
	 * 
	 * @throws IOException
	 */
	public String put(DsInfo dsInfo, String name, InputStream inputStream) throws IOException;

}
