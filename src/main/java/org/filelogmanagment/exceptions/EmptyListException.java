/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    EmptyListException
*/

package org.filelogmanagment.exceptions;

public class EmptyListException extends BasicException {
	private static final long serialVersionUID = 5L;
	protected Object listObject;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public EmptyListException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public EmptyListException(String pLocation, String pMessage) {
		this(pLocation, pMessage, null);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 * @param pListObject
	 */
	public EmptyListException(String pLocation, String pMessage, Object pListObject) {
		super(pLocation, pMessage);
		
		listObject = pListObject;
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public Object getListObject() {
		return listObject;
	}
	
}
