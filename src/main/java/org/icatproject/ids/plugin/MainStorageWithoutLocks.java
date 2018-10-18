package org.icatproject.ids.plugin;

import java.io.IOException;

/**
 * This is a partial implementation of a MainStorageInterface providing dummy implementations of
 * those operations not needed when the plugin does not support locking
 */
public abstract class MainStorageWithoutLocks implements MainStorageInterface {

	/**
	 * This is a dummy implementation
	 */
	@Override
	public AutoCloseable lock(DsInfo dsInfo, boolean shared) throws AlreadyLockedException, IOException {
		return null;
	}

}