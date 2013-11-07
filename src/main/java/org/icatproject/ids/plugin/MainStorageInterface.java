package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * An IDS interface which for which an implementation must be provided for any IDS deployment.
 */
public interface MainStorageInterface {
	/**
	 * Holds information to be returned about a data file
	 */
	public class DfInfo {

		private long checksum;
		private String location;
		private long size;

		/**
		 * Create a DfInfo to hold information about a data file
		 * 
		 * @param location
		 *            the location of the file
		 * @param size
		 *            the size of the file in bytes
		 * @param checksum
		 *            the CRC32 checksum of the file
		 */
		public DfInfo(String location, long size, long checksum) {
			this.location = location;
			this.size = size;
			this.checksum = checksum;
		}

		/**
		 * Returns the CRC32 checksum of the file
		 * 
		 * @return the CRC32 checksum of the file
		 */
		public long getChecksum() {
			return checksum;
		}

		/**
		 * Returns the location of the file
		 * 
		 * @return the location of the file
		 */
		public String getLocation() {
			return location;
		}

		/**
		 * Returns the file size
		 * 
		 * @return the size of the file in bytes
		 */
		public long getSize() {
			return size;
		}

	}

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
	 * @return a object with information about the stored data file
	 * 
	 * @throws IOException
	 */
	public DfInfo put(DsInfo dsInfo, String name, InputStream inputStream) throws IOException;

	/**
	 * Store the specified data file.
	 * 
	 * A dummy implementation can be provided if no archive storage is configured.
	 * 
	 * @param dsInfo
	 *            describes the data set to which the data file should be added
	 * @param name
	 *            name of file within data set
	 * @param inputStream
	 *            stream of data to store
	 * 
	 * @throws IOException
	 */
	public void putUnchecked(DsInfo dsInfo, String name, InputStream inputStream) throws IOException;

}
