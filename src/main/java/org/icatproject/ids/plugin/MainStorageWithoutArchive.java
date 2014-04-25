package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;

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

	/**
	 * This is a dummy implementation - only used when a file is restored from archive so the
	 * Datafile.location field in ICAT is already known.
	 * 
	 * @throws IOException
	 */
	public void put(InputStream inputStream, String location) throws IOException {
		throw new IOException("Please do not request an archive plugin in the ids.properties file");
	}

}