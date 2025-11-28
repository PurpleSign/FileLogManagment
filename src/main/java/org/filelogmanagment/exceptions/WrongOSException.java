/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    FileManagmentException
 *    	WrongOSException
*/

package org.filelogmanagment.exceptions;

public class WrongOSException extends FileManagmentException {
	private static final long serialVersionUID = 100L;
	protected String os;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public WrongOSException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public WrongOSException(String pLocation, String pMessage) {
		this(pLocation, pMessage, null);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 * @param pOS
	 */
	public WrongOSException(String pLocation, String pMessage, String pOS) {
		super(pLocation, pMessage);
		
		os = pOS;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public String getOS() {
		return os;
	}
	
}
