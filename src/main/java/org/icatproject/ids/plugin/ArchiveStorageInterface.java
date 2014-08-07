package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

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
	 * Get the specified data set.
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

}
