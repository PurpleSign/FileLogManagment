/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
*/

package org.filelogmanagment.exceptions;

public abstract class BasicException extends Exception {
	private static final long serialVersionUID = -1L;
	protected String location, message;
	
	/**	Dh	04.08.2024
	 * 
	 */
	public BasicException() {
		super();
		
		location = "";
		message  = "";
	}
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public BasicException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public BasicException(String pLocation, String pMessage) {
		super();
		
		location = pLocation;
		message  = pMessage;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public String getExceptionMessage() {
		return "" + location + ((message != null) && (!message.equals("")) ? ":" + message : "" );
	}
	
}
