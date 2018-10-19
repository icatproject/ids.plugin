package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

/* Shows the methods that must be implemented */
public class MainStorageWithoutArchiveReadOnlyImpl extends MainStorageWithoutArchiveReadOnly {

	@Override
	public InputStream get(String location, String createId, String modId) throws IOException {
		return null;
	}

	@Override
	public Path getPath(String location, String createId, String modId) throws IOException {
		return null;
	}

	@Override
	public AutoCloseable lock(DsInfo dsInfo, boolean shared) throws AlreadyLockedException, IOException {
		return null;
	}

}