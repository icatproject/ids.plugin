package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is a partial implementation of an ArchiveStorageInterface providing dummy implementations of
 * those operations not needed when the readOnly flag has been set in the ids.properties file
 *
 * This class is deprecated, use AbstractArchiveStorage instead.
 */
@Deprecated
public abstract class ArchiveStorageReadOnly implements ArchiveStorageInterface {

	/**
	 * This is a dummy implementation
	 */
	@Override
	public void delete(DsInfo dsInfo) throws IOException {
		throw new IllegalStateException("Please add \"readOnly\" to the ids.properties file");
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public void put(DsInfo dsInfo, InputStream inputStream) throws IOException {
		throw new IllegalStateException("Please add \"readOnly\" to the ids.properties file");
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public void delete(String location) throws IOException {
		throw new IllegalStateException("Please add \"readOnly\" to the ids.properties file");
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public void put(InputStream is, String location) throws IOException {
		throw new IllegalStateException("Please add \"readOnly\" to the ids.properties file");
	}

}