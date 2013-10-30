package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;

public interface ArchiveStorageInterface {

	public void delete(DsInfo dsInfo) throws IOException;

	public void put(DsInfo dsInfo, InputStream inputStream) throws IOException;

}
