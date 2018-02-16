package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

/**
 * This is a partial implementation of an ArchiveStorageInterface providing
 * dummy implementations of those operations not needed for certain IDS
 * deployments.
 */
public abstract class AbstractArchiveStorage implements ArchiveStorageInterface {

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATASET with readOnly set to false.
	 */
	@Override
	public void delete(DsInfo dsInfo) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATASET and write enabled");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATAFILE with readOnly set to false.
	 */
	@Override
	public void delete(String location) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATAFILE and write enabled");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATASET.
	 */
	@Override
	public void get(DsInfo dsInfo, Path path) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATASET");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATASET with readOnly set to false.
	 */
	@Override
	public void put(DsInfo dsInfo, InputStream inputStream) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATASET and write enabled");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATAFILE with readOnly set to false.
	 */
	@Override
	public void put(InputStream inputStream, String location) throws IOException {
		throw new IllegalStateException("This plugin does not support StorageUnit DATAFILE and write enabled");
	}

	/**
	 * This is a dummy implementation.  You need to override it if you
	 * want to support StorageUnit DATAFILE.
	 */
	@Override
	public Set<DfInfo> restore(MainStorageInterface mainStorageInterface, List<DfInfo> dfInfos) {
		throw new IllegalStateException("This plugin does not support StorageUnit DATAFILE");
	}


}
