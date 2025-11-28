/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    FileManagmentException
 *    	NoFileLoadedException
*/

package org.filelogmanagment.exceptions;

public class NoFileLoadedException extends FileManagmentException {
	private static final long serialVersionUID = 110L;
	protected BasicException causedException;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public NoFileLoadedException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public NoFileLoadedException(String pLocation, String pMessage) {
		this(pLocation, pMessage, null);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 * @param pCausedException
	 */
	public NoFileLoadedException(String pLocation, String pMessage, BasicException pCausedException) {
		super(pLocation, pMessage);
		
		causedException = pCausedException;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public BasicException getCausedException(){
		return causedException;
	}
	
}
