/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    CalculationErrorException
*/

package org.filelogmanagment.exceptions;

public class CalculationErrorException extends BasicException {
	private static final long serialVersionUID = 3L;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public CalculationErrorException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public CalculationErrorException(String pLocation, String pMessage) {
		super(pLocation, pMessage);
	}

}
