/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    FileManagmentException
*/

package org.filelogmanagment.exceptions;

public abstract class FileManagmentException extends BasicException {
	private static final long serialVersionUID = -100L;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public FileManagmentException(String pLocation) {
		super(pLocation);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public FileManagmentException(String pLocation, String pMessage) {
		super();
		
		location = pLocation;
		message  = pMessage;
	}
	
}
