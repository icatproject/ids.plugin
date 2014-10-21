package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

/* Shows the methods that must be implemented */
public class MainStorageReadOnlyImpl extends MainStorageReadOnly {

	@Override
	public void delete(DsInfo dsInfo) throws IOException {
	}

	@Override
	public boolean exists(DsInfo dsInfo) throws IOException {
		return false;
	}

	@Override
	public boolean exists(String location) throws IOException {
		return false;
	}

	@Override
	public InputStream get(String location, String createId, String modId) throws IOException {
		return null;
	}

	@Override
	public List<Long> getDatasets(long invId) throws IOException {
		return null;
	}

	@Override
	public List<Long> getInvestigations() throws IOException {
		return null;
	}

	@Override
	public Path getPath(String location, String createId, String modId) throws IOException {
		return null;
	}

	@Override
	public long getUsedSpace() throws IOException {
		return 0;
	}

	@Override
	public void put(InputStream inputStream, String location) throws IOException {
	}

}