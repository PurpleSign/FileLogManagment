/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    FileManagmentException
 *    	WrongRightsExceptions
*/

package org.filelogmanagment.exceptions;

public class WrongRightsException extends FileManagmentException {
	private static final long serialVersionUID = 101L;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public WrongRightsException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public WrongRightsException(String pLocation, String pMessage) {
		super(pLocation, pMessage);
	}
	
}
