package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * This is a partial implementation of a MainStorageInterface providing dummy
 * implementations of those operations not needed when no archive storage is
 * being used.
 *
 * This class is deprecated, use AbstractMainStorage instead.
 */
@Deprecated
public abstract class MainStorageWithoutArchive implements MainStorageInterface {

	/**
	 * This is a dummy implementation
	 */
	@Override
	public void delete(DsInfo dsInfo) throws IOException {
		throw new IOException("Please do not request an archive plugin in the ids.properties file");
	}

	/**
	 * This is a dummy implementation
	 */
	@Override
	public boolean exists(DsInfo dsInfo) throws IOException {
		throw new IOException("Please do not request an archive plugin in the ids.properties file");
	}

	/**
	 * This is a dummy implementation - only used when a file is restored from
	 * archive so the Datafile.location field in ICAT is already known.
	 */
	@Override
	public void put(InputStream inputStream, String location) throws IOException {
		throw new IOException("Please do not request an archive plugin in the ids.properties file");
	}

	@Override
	public List<DsInfo> getDatasetsToArchive(long lowArchivingLevel, long highArchivingLevel) throws IOException {
		throw new IOException("Please do not request an archive plugin in the ids.properties file");
	}

	@Override
	public List<DfInfo> getDatafilesToArchive(long lowArchivingLevel, long highArchivingLevel) throws IOException {
		throw new IOException("Please do not request an archive plugin in the ids.properties file");
	}

}