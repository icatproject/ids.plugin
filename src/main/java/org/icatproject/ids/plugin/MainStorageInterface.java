package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;

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
	 * Return a stream of the zipped data for the specified data set
	 * 
	 * @param dsInfo
	 *            describes the data set being returned
	 * 
	 * @return input stram of zipped data
	 * 
	 * @throws IOException
	 */
	public InputStream get(DsInfo dsInfo) throws IOException;

}
