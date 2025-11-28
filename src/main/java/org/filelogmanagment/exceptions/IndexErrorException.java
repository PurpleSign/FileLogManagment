/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    IndexErrorException
*/

package org.filelogmanagment.exceptions;

public class IndexErrorException extends BasicException {
	private static final long serialVersionUID = 7L;
	protected Number indexNumber;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public IndexErrorException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public IndexErrorException(String pLocation, String pMessage) {
		this(pLocation, pMessage, null);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 * @param pIndexNumber
	 */
	public IndexErrorException(String pLocation, String pMessage, Number pIndexNumber) {
		super(pLocation, pMessage);
		
		indexNumber = pIndexNumber;
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public Number getIndexNumber() {
		return indexNumber;
	}
	
}
