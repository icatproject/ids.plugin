package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;

/**
 * An IDS interface which for which an implementation must be provided for an IDS deployment with
 * archive storage.
 */
public interface ArchiveStorageInterface {

	/**
	 * Delete the specified data set.
	 * 
	 * @param dsInfo
	 *            describes the data set
	 * 
	 * @throws IOException
	 */
	public void delete(DsInfo dsInfo) throws IOException;

	/**
	 * Store the specified data set.
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
	 * Deletes the specified data set.
	 * 
	 * @param dsInfo
	 *            describes the data set
	 * 
	 * @return a stream of data from the specified data set
	 * 
	 * @throws IOException
	 */
	public InputStream get(DsInfo dsInfo) throws IOException;

}
