/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    FileManagmentException
 *    	NoDirectoryException
*/

package org.filelogmanagment.exceptions;

public class NoDirectoryException extends FileManagmentException {
	private static final long serialVersionUID = 103L;
	protected String directoryPath;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public NoDirectoryException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public NoDirectoryException(String pLocation, String pMessage) {
		this(pLocation, pMessage, null);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 * @param pDirectoryPath
	 */
	public NoDirectoryException(String pLocation, String pMessage, String pDirectoryPath) {
		super(pLocation, pMessage);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public String getDirectoryPath() {
		return directoryPath;
	}
	
}
