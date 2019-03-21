package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

/**
 * An IDS interface which for which an implementation must be provided for any
 * IDS deployment.
 */
public interface MainStorageInterface {

	/**
	 * Deletes the files of the specified data set.
	 * 
	 * Implementations must not throw an error if the data set does
	 * not exist in the storage.
	 * 
	 * @param dsInfo
	 *            describes the data set with the files to be deleted
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public void delete(DsInfo dsInfo) throws IOException;

	/**
	 * Deletes the specified file
	 * 
	 * Implementations must not throw an error if the file does
	 * not exist in the storage.
	 * 
	 * @param location
	 *            location of the data file to be deleted
	 * @param createId
	 *            the icat user name of the creator of this datafile. This is
	 *            provided so that the implementation can choose whether or not
	 *            to trust the ICAT datafile object which holds this location
	 *            field.
	 * @param modId
	 *            the icat user name of the modifier of this datafile. This is
	 *            provided so that the implementation can choose whether or not
	 *            to trust the ICAT datafile object which holds this location
	 *            field.
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public void delete(String location, String createId, String modId) throws IOException;

	/**
	 * See if the data set exists.
	 * 
	 * @param dsInfo
	 *            describes the data set being queried
	 * 
	 * @return true if the data set exists
	 */
	public boolean exists(DsInfo dsInfo);

	/**
	 * See if the data file exists.
	 * 
	 * @param location
	 *            the value from datafile.location
	 * 
	 * @return true if the data file exists
	 */
	public boolean exists(String location);

	/**
	 * Return a stream of data from the specified data file
	 * 
	 * @param location
	 *            the value from datafile.location
	 * @param createId
	 *            the icat user name of the creator of this datafile. This is
	 *            provided so that the implementation can choose whether or not
	 *            to trust the ICAT datafile object which holds this location
	 *            field.
	 * @param modId
	 *            the icat user name of the modifier of this datafile. This is
	 *            provided so that the implementation can choose whether or not
	 *            to trust the ICAT datafile object which holds this location
	 *            field.
	 * 
	 * @return input stream of data
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public InputStream get(String location, String createId, String modId) throws IOException;

	/**
	 * Return the list of DfInfos which should be archived to reduce the used
	 * storage to between lowArchivingLevel and highArchivingLevel.
	 * 
	 * The implementaion is free to do this however it chooses. Use might be
	 * made of the information available from the java.nio.file.FileStore
	 * (obtainable by Files.getFileStore(path) for any file to see whether or
	 * not any action is required. For each DfInfo returned the IDS will find
	 * all datafiles which match all the fields that are not null in the DfInfo.
	 * 
	 * @param lowArchivingLevel
	 *            don't try to reduce space below this level
	 * @param highArchivingLevel
	 *            if storage used is less than this return an empty list.
	 *            Otherwise identify the list of DsInfos to get the space down
	 *            to lowArchivingLevel
	 * 
	 * @return list of DfInfos
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public List<DfInfo> getDatafilesToArchive(long lowArchivingLevel, long highArchivingLevel) throws IOException;

	/**
	 * Return the list of DsInfos which should be archived to reduce the used
	 * storage to between lowArchivingLevel and highArchivingLevel.
	 * 
	 * The implementaion is free to do this however it chooses. Use might be
	 * made of the information available from the java.nio.file.FileStore
	 * (obtainable by Files.getFileStore(path) for any file to see whether or
	 * not any action is required. For each DsInfo returned the IDS will find
	 * all datasets which match all the fields that are not null in the DsInfo.
	 * 
	 * @param lowArchivingLevel
	 *            don't try to reduce space below this level
	 * @param highArchivingLevel
	 *            if storage used is less than this return an empty list.
	 *            Otherwise identify the list of DsInfos to get the space down
	 *            to lowArchivingLevel
	 * 
	 * @return list of DsInfos
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public List<DsInfo> getDatasetsToArchive(long lowArchivingLevel, long highArchivingLevel) throws IOException;

	/**
	 * Return the physical path corresponding to a location for a datafile.
	 * 
	 * This is only useful if the file system is available to the user. In this
	 * case all files on the file system should only be readable by the user
	 * running the ids server.
	 * 
	 * @param location
	 *            the value from datafile.location
	 * @param createId
	 *            the icat user name of the creator of this datafile. This is
	 *            provided so that the implementation can choose whether or not
	 *            to trust the ICAT datafile object which holds this location
	 *            field.
	 * @param modId
	 *            the icat user name of the modifier of this datafile. This is
	 *            provided so that the implementation can choose whether or not
	 *            to trust the ICAT datafile object which holds this location
	 *            field.
	 * 
	 * @return physical path
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public Path getPath(String location, String createId, String modId) throws IOException;

	/**
	 * Store the specified data file and return the chosen location of the file
	 * to allow it to be retrieved.
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
	 * @throws IllegalArgumentException
	 *            if the creation of the file has been refused because either
	 *            the name or any attribute of dsinfo is not acceptable.
	 * @throws IOException
	 *            to indicate failure
	 */
	public String put(DsInfo dsInfo, String name, InputStream inputStream)
		throws IllegalArgumentException, IOException;

	/**
	 * Store the data file at the specified location.
	 * 
	 * @param inputStream
	 *            stream of data to store
	 * @param location
	 *            where to store the file
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public void put(InputStream inputStream, String location) throws IOException;

}
