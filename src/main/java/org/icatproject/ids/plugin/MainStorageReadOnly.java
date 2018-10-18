package org.icatproject.ids.plugin;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is a partial implementation of a MainStorageInterface providing dummy
 * implementations of those operations not needed when the readOnly flag has
 * been set in the ids.properties file
 *
 * This class is deprecated, use AbstractMainStorage instead.
 */
@Deprecated
public abstract class MainStorageReadOnly implements MainStorageInterface {

	/**
	 * This is a dummy implementation
	 */
	@Override
	public String put(DsInfo dsInfo, String name, InputStream inputStream) throws IOException {
		throw new IOException("Please add \"readOnly\" to the ids.properties file");
	}

}