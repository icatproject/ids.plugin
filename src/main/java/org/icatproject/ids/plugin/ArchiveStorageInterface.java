package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

/**
 * An IDS interface which for which an implementation must be provided for an IDS deployment with
 * archive storage.
 */
public interface ArchiveStorageInterface {

	/**
	 * Delete the specified data set. A non-dummy version is needed if StorageUnit is DATASET.
	 * 
	 * @param dsInfo
	 *            describes the data set
	 * 
	 * @throws IOException
	 */
	public void delete(DsInfo dsInfo) throws IOException;

	/**
	 * Remove the data file from the specified location. A non-dummy version is needed if
	 * StorageUnit is DATAFILE.
	 * 
	 * @param location
	 *            where to store the file
	 * 
	 * @throws IOException
	 */
	public void delete(String location) throws IOException;

	/**
	 * Get the specified data set. A non-dummy version is needed if StorageUnit is DATASET.
	 * 
	 * @param dsInfo
	 *            describes the data set
	 * 
	 * @param path
	 *            path of the file to write to (it will be overwritten if it already exists)
	 * 
	 * @throws IOException
	 */
	public void get(DsInfo dsInfo, Path path) throws IOException;

	/**
	 * Store the specified data set. A non-dummy version is needed if StorageUnit is DATASET.
	 * 
	 * @param dsInfo
	 *            describes the data set
	 * 
	 * @param inputStream
	 * 
	 * @throws IOException
	 */
	public void put(DsInfo dsInfo, InputStream inputStream) throws IOException;

	/**
	 * Store the data file at the specified location. A non-dummy version is needed if StorageUnit
	 * is DATAFILE.
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
	 * Restore the datafiles from archive to main storage. Note that this does no throw any
	 * exceptions but will return a set of failed DfInfo objects. A non-dummy version is needed if
	 * StorageUnit is DATAFILE.
	 * 
	 * @param mainStorageInterface
	 *            the main storage interface to write restored files to
	 * 
	 * @param dfInfos
	 *            list of DfInfo objects
	 * 
	 * @return setof DfInfo objects which could not be restored
	 * 
	 * @throws IOException
	 */
	public Set<DfInfo> restore(MainStorageInterface mainStorageInterface, List<DfInfo> dfInfos)
			throws IOException;

}
