package org.icatproject.ids.plugin;

import java.io.InputStream;
import java.util.List;

/**
 * This is a partial implementation of a MainStorageInterface providing dummy implementations of
 * those operations not needed when no archive storage is being used.
 */
public abstract class MainStorageWithoutArchive implements MainStorageInterface {

	/**
	 * This is a dummy implementation
	 */
	@Override
	public void delete(DsInfo dsInfo) {
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public boolean exists(DsInfo dsInfo) {
		return false;
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public List<String> getLocations(DsInfo dsInfo) {
		return null;
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public void putUnchecked(DsInfo dsInfo, String dfName, InputStream is) {
	}

}