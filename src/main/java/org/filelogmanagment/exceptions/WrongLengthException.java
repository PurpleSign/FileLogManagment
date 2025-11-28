/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    WrongLengthException
*/

package org.filelogmanagment.exceptions;

public class WrongLengthException extends BasicException {
	private static final long serialVersionUID = 1L;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public WrongLengthException(String pLocation) {
		this(pLocation, "");
	}
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public WrongLengthException(String pLocation, String pMessage) {
		super(pLocation, pMessage);
	}
	
}
