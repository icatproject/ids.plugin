package org.icatproject.ids.plugin;

/**
 * 
 * Handle the generation and of the full entry name for a zip file entry and derive the
 * Datafile.name from it.
 * 
 */
public interface ZipMapperInterface {

	/**
	 * Derive full entry name for the file specified by the dsInfo and dfInfo
	 * 
	 * @param dsInfo
	 * 
	 * @param dfInfo
	 * 
	 * @return full entry name
	 */
	public String getFullEntryName(DsInfo dsInfo, DfInfo dfInfo);

	/**
	 * Derive Datafile.name as known in ICAT for the zip file entry fullEntryName
	 * 
	 * @param fullEntryName
	 * 
	 * @return Datafile.name or null if not possible
	 */
	public String getFileName(String fullEntryName);

}