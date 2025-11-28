/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    WrongTypeException
*/

package org.filelogmanagment.exceptions;

public class WrongTypeException extends BasicException {
	private static final long serialVersionUID = 6L;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public WrongTypeException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public WrongTypeException(String pLocation, String pMessage) {
		super(pLocation, pMessage);
	}
	
}
