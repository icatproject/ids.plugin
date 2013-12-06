package org.icatproject.ids.plugin;

import java.io.IOException;

/**
 * This is a partial implementation of a MainStorageInterface providing dummy implementations of
 * those operations not needed when no archive storage is being used.
 */
public abstract class MainStorageWithoutArchive implements MainStorageInterface {

	/**
	 * This is a dummy implementation
	 * 
	 * @throws IOException
	 */
	@Override
	public void delete(DsInfo dsInfo) throws IOException {
		throw new IOException("Please do not request an archive plugin in the ids.properties file");
	}

	/**
	 * This is a dummy implementation
	 * 
	 * @throws IOException
	 */
	@Override
	public boolean exists(DsInfo dsInfo) throws IOException {
		throw new IOException("Please do not request an archive plugin in the ids.properties file");
	}

}