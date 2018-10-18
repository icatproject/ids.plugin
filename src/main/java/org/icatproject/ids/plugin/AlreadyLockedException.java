package org.icatproject.ids.plugin;

public class AlreadyLockedException extends Exception {
	public AlreadyLockedException() {
		super("Resource is already locked.");
	}
}

