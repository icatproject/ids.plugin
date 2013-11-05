package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface MainStorageInterface {
	public class DfInfo {

		private String location;
		private long size;
		private long checksum;

		public DfInfo(String location, long size, long checksum) {
			this.location = location;
			this.size = size;
			this.checksum = checksum;
		}

		public String getLocation() {
			return location;
		}

		public long getSize() {
			return size;
		}

		public long getChecksum() {
			return checksum;
		}

	}

	/**
	 * Store the specified data file
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
	 * See if the data set exists
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
	 * Deletes the specified file
	 * 
	 * @param location
	 *            location of the data file to be deleted
	 * 
	 * @throws IOException
	 */
	public void delete(String location) throws IOException;

	/**
	 * Deletes the files of the specified data set
	 * 
	 * @param dsInfo
	 *            describes the data set with the files to be deleted
	 * 
	 * @throws IOException
	 */
	public void delete(DsInfo dsInfo) throws IOException;

	/**
	 * Returns a list of locations of the files of the specified data set
	 * 
	 * @param dsInfo
	 *            describes the data set with the files to be deleted
	 * 
	 * @return list of locations
	 * 
	 * @throws IOException
	 */
	public List<String> getLocations(DsInfo dsInfo) throws IOException;

}
