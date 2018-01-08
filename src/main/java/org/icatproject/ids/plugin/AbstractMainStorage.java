package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

/**
 * This is a partial implementation of an MainStorageInterface providing
 * dummy implementations of those operations not needed for certain IDS
 * deployments.
 */
public abstract class AbstractMainStorage implements MainStorageInterface {

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATASET.
	 */
	public void delete(DsInfo dsInfo) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATASET");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATAFILE or readOnly set to false.
	 */
	public void delete(String location, String createId, String modId) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATAFILE or write enabled");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATASET.
	 */
	public boolean exists(DsInfo dsInfo) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATASET");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATAFILE or readOnly set to false.
	 */
	public boolean exists(String location) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATAFILE or write enabled");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATAFILE.
	 */
	public List<DfInfo> getDatafilesToArchive(long lowArchivingLevel, long highArchivingLevel) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATAFILE");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATASET.
	 */
	public List<DsInfo> getDatasetsToArchive(long lowArchivingLevel, long highArchivingLevel) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATASET");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support the getLink call.
	 */
	public Path getPath(String location, String createId, String modId) throws IOException {
		throw new IllegalStateException("This plugin does not support the getLink call");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support readOnly set to false.
	 */
	public String put(DsInfo dsInfo, String name, InputStream inputStream) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATAFILE or write enabled");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support a two level storage.
	 */
	public void put(InputStream inputStream, String location) throws IOException {
		throw new IllegalStateException("This plugin does not a two level storage");
	}

}
