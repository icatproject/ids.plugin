package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
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
	 * A dummy implementation can be provided if no archive storage is configured with storageUnit
	 * set to dataset
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
	 * See if the data file exists.
	 * 
	 * A dummy implementation can be provided if no archive storage is configured with storageUnit
	 * set to datafile
	 * 
	 * @param location
	 *            the value from datafile.location
	 * 
	 * @return true if the data file exists
	 * 
	 * @throws IOException
	 */
	public boolean exists(String location) throws IOException;

	/**
	 * Return a stream of data from the specified data file
	 * 
	 * @param location
	 *            the value from datafile.location
	 * @param createId
	 *            the icat user name of the creator of this datafile. This is provided so that the
	 *            implementation can choose whether or not to trust the ICAT datafile object which
	 *            holds this location field.
	 * @param modId
	 *            the icat user name of the modifier of this datafile. This is provided so that the
	 *            implementation can choose whether or not to trust the ICAT datafile object which
	 *            holds this location field.
	 * 
	 * @return input stream of data
	 * 
	 * @throws IOException
	 */
	public InputStream get(String location, String createId, String modId) throws IOException;

	/**
	 * Return a list of dataset ids for an investigation ordered by date with the oldest first
	 * 
	 * A dummy implementation can be provided if no archive storage is configured.
	 * 
	 * The implementer can choose exactly what the date represents. Old datasets will be archived
	 * first if space is low. Ideally the date would be the date when the dataset was last retrieved
	 * from main storage.
	 * 
	 * @param invId
	 *            The id of the investigation
	 * 
	 * @return list of dataset ids
	 * 
	 * @throws IOException
	 */
	public List<Long> getDatasets(long invId) throws IOException;

	/**
	 * Return a list of investigation ids ordered by date with the oldest first
	 * 
	 * A dummy implementation can be provided if no archive storage is configured.
	 * 
	 * The implementer can choose exactly what the date represents. Old investigations will be
	 * archived first if space is low. Ideally the date would be the date when the investigation was
	 * last retrieved from main storage.
	 * 
	 * @return list of investigation ids
	 * 
	 * @throws IOException
	 */
	public List<Long> getInvestigations() throws IOException;

	/**
	 * Return the number of bytes of main storage used
	 * 
	 * A dummy implementation may be provided if no archive storage is configured. This operation is
	 * invoked by the server to determine when to to request that datasets are archived. The value
	 * returned should be a reasonable estimate of the occupied space or zero if it is clear that no
	 * cleanup is necessary. For example Files.getFileStore(path).getUseableSpace will tell you how
	 * much space you have left on the partition holding "path".
	 * 
	 * @return the number of bytes of main storage used
	 * 
	 * @throws IOException
	 */
	public long getUsedSpace() throws IOException;

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

	/**
	 * Store the data file at the specified location
	 * 
	 * @param inputStream
	 *            stream of data to store
	 * @param location
	 *            where to store the file
	 * 
	 * @throws IOException
	 */
	public void put(InputStream inputStream, String location) throws IOException;

	/**
	 * Return the physical path corresponding to a location for a datafile.
	 * 
	 * This is only useful if the file system is available to the user. In this case all files on
	 * the file system should only be readable by the user running the ids server.
	 * 
	 * If the file system is not available to the user a dummy implementation may be provided.
	 * 
	 * @param location
	 *            the value from datafile.location
	 * @param createId
	 *            the icat user name of the creator of this datafile. This is provided so that the
	 *            implementation can choose whether or not to trust the ICAT datafile object which
	 *            holds this location field.
	 * @param modId
	 *            the icat user name of the modifier of this datafile. This is provided so that the
	 *            implementation can choose whether or not to trust the ICAT datafile object which
	 *            holds this location field.
	 * 
	 * @return physical path
	 * 
	 * @throws IOException
	 */
	public Path getPath(String location, String createId, String modId) throws IOException;

}
