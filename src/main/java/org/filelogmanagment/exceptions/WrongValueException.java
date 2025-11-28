/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    WrongValueException
*/

package org.filelogmanagment.exceptions;

public class WrongValueException extends BasicException {
	private static final long serialVersionUID = 2L;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public WrongValueException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public WrongValueException(String pLocation, String pMessage) {
		super(pLocation, pMessage);
	}
	
}
