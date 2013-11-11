package org.icatproject.ids.plugin;

/**
 * Information about an ICAT data set
 * 
 */
public interface DsInfo {

	/**
	 * Return the data set id
	 * 
	 * @return the data set id
	 */
	long getDsId();

	/**
	 * Return the data set name
	 * 
	 * @return the data set name
	 */
	String getDsName();

	/**
	 * Return the facility id
	 * 
	 * @return the facility id
	 */
	long getFacilityId();

	/**
	 * Return the facility name
	 * 
	 * @return the facility name
	 */
	String getFacilityName();

	/**
	 * Return the investigation id
	 * 
	 * @return the investigation id
	 */
	long getInvId();

	/**
	 * Return the investigation name
	 * 
	 * @return the investigation name
	 */
	String getInvName();

	/**
	 * Return the investigation visitId
	 * 
	 * @return the investigation visitId
	 */
	String getVisitId();
}
