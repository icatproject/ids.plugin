package org.icatproject.ids.plugin;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

/* Shows the methods that must be implemented */
public class ArchiveStorageReadOnlyImpl extends ArchiveStorageReadOnly {

	@Override
	public void get(DsInfo dsInfo, Path path) throws IOException {
	}

	@Override
	public Set<DfInfo> restore(MainStorageInterface mainStorageInterface, List<DfInfo> dfInfos) {
		return null;
	}

}