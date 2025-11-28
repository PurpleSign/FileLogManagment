/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    NullpointerException
*/

package org.filelogmanagment.exceptions;

public class NullpointerException extends BasicException {
	private static final long serialVersionUID = 4L;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public NullpointerException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public NullpointerException(String pLocation, String pMessage) {
		super(pLocation, pMessage);
	}
	
}
