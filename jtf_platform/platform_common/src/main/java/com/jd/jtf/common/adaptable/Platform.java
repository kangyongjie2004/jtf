/**
 * kangyongjie@jd.com
 */
package com.jd.jtf.common.adaptable;

public final class Platform {

	private Platform() {
		super();
	}

	/**
	 * Returns the adapter manager used for extending
	 * <code>IAdaptable</code> objects.
	 *
	 * @return the adapter manager for this platform
	 * @see IAdapterManager
	 */
	public static IAdapterManager getAdapterManager() {
		return AdapterManager.getDefault();
	}
}
