/** FileLogManagment v0.0	Dh	13.08.2024
 *  
 *  LogManager
*/

package org.filelogmanagment;

import java.time.LocalDate;
import java.time.LocalTime;

import org.filelogmanagment.exceptions.BasicException;

public class LogManager {
	protected static boolean consolOutprint;
	protected static double version = 0.0;
	protected static String logfile;
	
	protected static MainAppClass mainApp;
	protected static FileManager fileManager;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pMainApp
	 */
	public static void initMainApp(MainAppClass pMainApp) {
		initMainApp(pMainApp, 0.0);
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pMainApp
	 */
	public static void initMainApp(MainAppClass pMainApp, double pVersion) {
		LocalDate vNow = LocalDate.now();
		LocalTime vCurTime = LocalTime.now();
		
		consolOutprint = false;
		
		mainApp = pMainApp;
		version = pVersion;
		fileManager = null;
		
		logfile = vNow.toString() +"_"+ vCurTime.getHour() +"-"+ vCurTime.getMinute() +"_logfile.txt";
	}
	
	/**	Dh	04.08.2024
	 * 
	 * @param pFileManager
	 */
	public static void setFileManager(FileManager pFileManager) {
		fileManager = pFileManager;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public static boolean getConsolOutprint() {
		return consolOutprint;
	}
	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public static double getVersion() {
		return version;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @param pConsolOutprint
	 */
	public static void setConsolOutprint(boolean pConsolOutprint) {
		consolOutprint = pConsolOutprint;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 */
	public static void closeApp() {
		if (mainApp != null) mainApp.closeApp();
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @param pLogEntry
	 */
	public static void createLogEntry(String pLogEntry) {
		LocalTime vNow;
		
		if (logfile != null) {
			vNow = LocalTime.now();
			try {
				if (fileManager != null) {
					System.out.println("[Log] "+vNow.toString() +" "+ pLogEntry);
					fileManager.writeLogFile(logfile, "[Log] "+vNow.toString() +" "+ pLogEntry);
				}
			}catch(Exception ex) {LogManager.handleException(ex);}
		}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	13.08.2024
	 * 
	 * @param ex
	 */
	public static void handleException(Exception ex) {
		if (consolOutprint)	System.out.println(ex.getMessage());
		if (ex instanceof BasicException) createLogEntry(((BasicException)ex).getExceptionMessage());
		else                              createLogEntry("[Error] " + ex.getMessage() +"\n"+ ex.getCause() + "\n"+ ex.getStackTrace());		
	}
	/**	Dh	04.08.2024
	 * 
	 * @param pMessage
	 */
	public static void handleMessage(String pMessage) {
		if (consolOutprint) System.out.println(pMessage);
		createLogEntry("[Message] " + pMessage);
	}
}
