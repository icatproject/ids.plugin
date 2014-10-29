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
	 * A dummy implementation can be provided if no archive storage is configured with storageUnit =
	 * DATASET
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
	 * A dummy may be provided if the readOnly flag is set and no archive storage has been
	 * configured with storageUnit = DATAFILE
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

	/**
	 * Return the list of DsInfos which should be archived to reduce the used storage to between
	 * lowArchivingLevel and highArchivingLevel.
	 * 
	 * A dummy implementation can be provided if no archive storage is configured with storageUnit
	 * set to dataset
	 * 
	 * The implementaion is free to do this however it chooses. Use might be made of the information
	 * available from the java.nio.file.FileStore (obtainable by Files.getFileStore(path) for any
	 * file to see whether or not any action is required.
	 * 
	 * @param lowArchivingLevel
	 *            don't try to reduce space below this level
	 * @param highArchivingLevel
	 *            if storage used is less than this return an empty list. Otherwise identify the
	 *            list of DsInfos to get the space down to lowArchivingLevel
	 * 
	 * @return
	 * 
	 * @throws IOException
	 */
	public List<DsInfo> getDatasetsToArchive(long lowArchivingLevel, long highArchivingLevel)
			throws IOException;

	/**
	 * Return the list of DfInfos which should be archived to reduce the used storage to between
	 * lowArchivingLevel and highArchivingLevel.
	 * 
	 * A dummy implementation can be provided if no archive storage is configured with storageUnit
	 * set to datafile
	 * 
	 * The implementaion is free to do this however it chooses. Use might be made of the information
	 * available from the java.nio.file.FileStore (obtainable by Files.getFileStore(path) for any
	 * file to see whether or not any action is required.
	 * 
	 * @param lowArchivingLevel
	 *            don't try to reduce space below this level
	 * @param highArchivingLevel
	 *            if storage used is less than this return an empty list. Otherwise identify the
	 *            list of DsInfos to get the space down to lowArchivingLevel
	 * 
	 * @return
	 * 
	 * @throws IOException
	 */
	public List<DfInfo> getDatafilesToArchive(long lowArchivingLevel, long highArchivingLevel)
			throws IOException;

}
