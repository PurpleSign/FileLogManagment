/** FileLogManagment v0.0	Dh	04.08.2024
 *  
 *  exceptions
 *  BasicException
 *    FileManagmentException
 *    	FileNotExistingException
*/

package org.filelogmanagment.exceptions;

public class FileNotExistingException extends FileManagmentException {
	private static final long serialVersionUID = 102L;
	protected String filePath;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 */
	public FileNotExistingException(String pLocation) {
		this(pLocation, "");
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 */
	public FileNotExistingException(String pLocation, String pMessage) {
		this(pLocation, pMessage, null);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pLocation
	 * @param pMessage
	 * @param pFilePath
	 */
	public FileNotExistingException(String pLocation, String pMessage, String pFilePath) {
		super(pLocation, pMessage);
		
		filePath = pFilePath;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public String getFilePath() {
		return filePath;
	}
	
}
