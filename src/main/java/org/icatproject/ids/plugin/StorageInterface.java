package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;

public interface StorageInterface {
	public boolean datafileExists(String location) throws IOException;

	public boolean datasetExists(String location) throws IOException;

	public void deleteDatafile(String location) throws IOException;

	public void deleteDataset(String location) throws IOException;

	public InputStream getDatafile(String location) throws IOException;

	public InputStream getDataset(String location) throws IOException;

	public InputStream getPreparedZip(String zipName, long offset) throws IOException;

	/** Write to datafile file at location */
	public long putDatafile(String location, InputStream is) throws IOException;

	/** Write to dataset file at location */
	public void putDataset(String location, InputStream is) throws IOException;

	/** Write to zip file at location */
	public void putPreparedZip(String zipName, InputStream is) throws IOException;
}
