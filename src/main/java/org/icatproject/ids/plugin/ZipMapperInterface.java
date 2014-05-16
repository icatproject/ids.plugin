package org.icatproject.ids.plugin;

import java.io.IOException;

/**
 * 
 * Handle the generation of the full entry name for a zip file entry and derive the Datafile.name
 * from it.
 * 
 */
public interface ZipMapperInterface {

	/**
	 * Derive full entry name for the file specified by the dsInfo and dfInfo
	 * 
	 * @param dsInfo
	 *            describes the dataset for which the name must be defined
	 * 
	 * @param dfInfo
	 *            describes the datafile for which the name must be defined
	 * 
	 * @return full entry name
	 * 
	 * @throws IOException
	 *             if unable to do the job
	 */
	public String getFullEntryName(DsInfo dsInfo, DfInfo dfInfo) throws IOException;

	/**
	 * Derive Datafile.name as known in ICAT for the zip file entry fullEntryName
	 * 
	 * @param fullEntryName
	 *            is the full entry name in the zip file from which the information must be
	 *            extracted
	 * 
	 * @return Datafile.name
	 * 
	 * @throws IOException
	 *             if unable to do the job
	 */
	public String getFileName(String fullEntryName) throws IOException;

}