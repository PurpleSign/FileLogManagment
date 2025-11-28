/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    EqualObjectException
*/

package org.filelogmanagment.exceptions;

public class EqualObjectException extends BasicException {
	private static final long serialVersionUID = 8L;
	protected Object equalObject;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public EqualObjectException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public EqualObjectException(String pLocation, String pMessage) {
		this(pLocation, pMessage, null);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 * @param pEqualObject
	 */
	public EqualObjectException(String pLocation, String pMessage, Object pEqualObject) {
		super(pLocation, pMessage);
		
		equalObject = pEqualObject;
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public Object getEqualObject() {
		return equalObject;
	}
	
}
