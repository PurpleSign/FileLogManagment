/** FileLogManagment v0.1	Dh	02.09.2024
 *  
 *  FileManager
*/

package org.filelogmanagment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import org.filelogmanagment.exceptions.FileNotExistingException;
import org.filelogmanagment.exceptions.NoFileLoadedException;
import org.filelogmanagment.exceptions.NullpointerException;
import org.filelogmanagment.exceptions.WrongOSException;
import org.filelogmanagment.exceptions.WrongRightsException;
import org.filelogmanagment.exceptions.WrongValueException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public abstract class FileManager {
	protected String appPath;
	protected String settingPath = "/settings",
					 logPath     = "/logs";
	protected String appSettingPath;
	
	protected File systemFile;
	protected File settingDirectory, logDirectory;
	
	/**	Dh	04.08.2024
	 * 
	 * @param pAppPath
	 */
	public FileManager(String pAppPath) {
		appPath = pAppPath;
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	04.08.2024
	 * 
	 */
	protected void initSettingPaths() {
		appSettingPath = settingDirectory.getAbsolutePath() + "/Settings.xml";
	}
	
	/**	Dh	02.09.2024
	 * 
	 * @throws WrongOSException
	 */
	public void init() throws WrongOSException{
		systemFile = getFileSystem();
		
		settingDirectory = new File(systemFile.getAbsolutePath() + settingPath);
		logDirectory     = new File(systemFile.getAbsolutePath() + logPath);
		
		initSettingPaths();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	02.09.2024
	 * 
	 * @return
	 * @throws WrongOSException
	 */
	private File getFileSystem() throws WrongOSException {
		String vOS, vArch, vHome;
		File vHomeFile;
		
		vOS = System.getProperty("os.name");
		vArch = System.getProperty("os.arch");
		vHome = System.getProperty("user.home");
		
		if (vOS.contains("Windows")) vHome = vHome+ "/AppData/Roaming"+appPath;
		else if (vOS.contains("Linux")) {
			if (!vArch.contains("aarch64")) vHome = vHome+"/.local"+appPath;
			
		} else throw new WrongOSException("gFS,FiM", vHome, vOS); 
		
		vHomeFile = new File(vHome);
		proofFileSystem(vOS, vHomeFile);
		
		return vHomeFile;
	}
	/**	Dh	02.09.2024
	 * 
	 * @param vOS
	 * @param vHomeFile
	 * @throws WrongOSException
	 */
	private void proofFileSystem(String pOS, File pHomeFile) throws WrongOSException {
		File vTemp;
		
		ArrayList<String> vDirectoryPaths = new ArrayList<String>(Arrays.asList( settingPath, logPath));
		
		if (pOS.contains("Windows") || pOS.contains("Linux")) {
			if (!pHomeFile.exists()) pHomeFile.mkdir();
			
			for (String vDirectoryPath : vDirectoryPaths) {
				vTemp = new File(pHomeFile.getAbsolutePath() + vDirectoryPath);
				
				if (!vTemp.exists()) vTemp.mkdir();
			}
		} else throw new WrongOSException("mFS,FiM", "", pOS); 
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	04.08.2024
	 * 
	 * @return
	 */
	public String getCurrentDirectoryFilePath() {
		return new File("").getAbsolutePath();
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	02.09.2024
	 * 
	 * @param pLogFile
	 * @param pLogEntrie
	 * @throws NullpointerException
	 * @throws WrongRightsException
	 * @throws IOException
	 */
	public void writeLogFile(String pLogFile, String pLogEntrie) throws NullpointerException, WrongRightsException, IOException {
		File vLogFile;
		FileWriter vFileWriter;
		BufferedWriter vBufferedWriter;
		
		if (logDirectory != null) {
			vLogFile = new File(logDirectory.getAbsolutePath()+"/"+pLogFile);
			
			if (!vLogFile.exists()) vLogFile.createNewFile(); 
			
			if (vLogFile.canWrite()) {
				vFileWriter = new FileWriter(vLogFile, true);
				vBufferedWriter = new BufferedWriter(vFileWriter);
				
				vBufferedWriter.append(pLogEntrie);
				vBufferedWriter.newLine();
				vBufferedWriter.close();
			} else throw new WrongRightsException("wLF,FiM");
		}else throw new NullpointerException("wLF,FiM");
	}
	

//--------------------------------------------------------------------------------------------------------

	/**	Dh	02.09.2024
	 * 
	 * @param pFilePath
	 * @param pObject
	 * @throws NullpointerException
	 * @throws WrongValueException
	 * @throws IOException
	 */
	protected <T extends Object> void saveObjectAsXML(String pFilePath, T pObject) throws NullpointerException, WrongValueException, IOException{
		String vXMLText;
		File vFile;
		ObjectMapper vObjectMapper;
		
		if (pObject != null) {
			if (!pFilePath.equals("")) {
				LogManager.createLogEntry("Start saving File to: " + pFilePath);
				vFile = new File(pFilePath);
				
				vObjectMapper = new XmlMapper();
				
				vXMLText = vObjectMapper.writeValueAsString(pObject);
				
				if (!vFile.exists()) vFile.createNewFile();
				
				Files.write(vFile.toPath(), vXMLText.getBytes("UTF-8"));
				LogManager.createLogEntry("Object saved.");
			} else throw new WrongValueException("sOaXML,FiM");
		} else throw new NullpointerException("sOaXML,FiM");
	}
	/**	Dh	02.09.2024
	 * 
	 * @param pFilePath
	 * @param pClass
	 * @return
	 * @throws NoFileLoadedException
	 * @throws IOException
	 */
	protected <T extends Object> T loadObjectFromXML(String pFilePath, Class<T> pClass) throws NoFileLoadedException, IOException {
		T vRet = null;
		String vXMLText;
		File vFile;
		ObjectMapper vObjectMapper;
		
		vFile = new File(pFilePath);
				
		if (vFile.exists()) {
			LogManager.createLogEntry("Start Loading File: " + pFilePath);
			vXMLText = Files.readString(vFile.toPath(), Charset.forName("UTF-8"));  // ISO-8859-1 UTF-8
			vObjectMapper = new XmlMapper();
			
			try {
				vRet = vObjectMapper.readValue(vXMLText, pClass);
			}catch(Exception ex) {throw new NoFileLoadedException("lOfXMFFiM", ex.getMessage());} 
			if (vRet == null) throw new NoFileLoadedException("lOfXML,FiM", "", new NullpointerException("lOfXML,FiM"));
			
			LogManager.createLogEntry("Loading File finished");
		} else throw new NoFileLoadedException("lOfXML,FiM", "", new FileNotExistingException("lOfXML,FiM", "", vFile.getAbsolutePath()));
		
		return vRet;
	}
	
	/**	Dh	02.09.2024
	 * 
	 * @param pFilePath
	 * @throws WrongRightsException
	 */
	protected void removeFile(String pFilePath) throws WrongRightsException {
		File vTemp;
		
		if (pFilePath != null) {
			LogManager.createLogEntry("Start deleting file: " + pFilePath);
			vTemp = new File(pFilePath);
			
			if ((vTemp != null) && (vTemp.exists())) {
				if (vTemp.canWrite()) vTemp.delete();
				else throw new  WrongRightsException("reF,FiM");
				
				LogManager.createLogEntry("Deleting File was successfull.");
			}
		}
	}

}
