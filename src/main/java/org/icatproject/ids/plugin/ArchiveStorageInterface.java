package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

/**
 * An IDS interface which for which an implementation must be provided for an
 * IDS deployment with archive storage.
 */
public interface ArchiveStorageInterface {

	/**
	 * Delete the specified data set.
	 * 
	 * Implementations must not throw an error if the data set does
	 * not exist in the storage.
	 * 
	 * @param dsInfo
	 *            describes the data set
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public void delete(DsInfo dsInfo) throws IOException;

	/**
	 * Remove the data file from the specified location.
	 * 
	 * Implementations must not throw an error if the data file does
	 * not exist in the storage.
	 * 
	 * @param location
	 *            where to store the file
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public void delete(String location) throws IOException;

	/**
	 * Get the specified data set.
	 * 
	 * @param dsInfo
	 *            describes the data set
	 * 
	 * @param path
	 *            path of the file to write to (it will be overwritten if it
	 *            already exists)
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public void get(DsInfo dsInfo, Path path) throws IOException;

	/**
	 * Store the specified data set.
	 * 
	 * @param dsInfo
	 *            describes the data set
	 * 
	 * @param inputStream
	 *            stream of data to store
	 * 
	 * @throws IOException
	 *             to indicate failure
	 */
	public void put(DsInfo dsInfo, InputStream inputStream) throws IOException;

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

	/**
	 * Restore the datafiles from archive to main storage. Note that this is not
	 * expected to throw any exceptions but will return a set of failed DfInfo
	 * objects. The  implementation is expected to make use of @see
	 * {@link MainStorageInterface#put(InputStream,String location)} to store
	 * the datafiles into main storage.
	 * 
	 * @param mainStorageInterface
	 *            the main storage interface to write restored files to
	 * 
	 * @param dfInfos
	 *            list of DfInfo objects
	 * 
	 * @return setof DfInfo objects which could not be restored
	 */
	public Set<DfInfo> restore(MainStorageInterface mainStorageInterface, List<DfInfo> dfInfos);

}
