package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is a partial implementation of a MainStorageInterface providing dummy implementations of
 * those operations not needed when no archive storage is being used and when the readOnly flag has
 * been set in the ids.properties file.
 *
 * This class is deprecated, use AbstractMainStorage instead.
 */
@Deprecated
public abstract class MainStorageWithoutArchiveReadOnly extends MainStorageWithoutArchive {

	/**
	 * This is a dummy implementation
	 */
	@Override
	public void delete(String location, String createId, String modId) throws IOException {
		throw new IOException("Please add \"readOnly\" to the ids.properties file");
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public boolean exists(String location) throws IOException {
		throw new IOException("Please add \"readOnly\" to the ids.properties file");
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public String put(DsInfo dsInfo, String name, InputStream inputStream) throws IOException {
		throw new IOException("Please add \"readOnly\" to the ids.properties file");
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public AutoCloseable lock(DsInfo dsInfo, boolean shared) throws AlreadyLockedException, IOException {
		return null;
	}

}