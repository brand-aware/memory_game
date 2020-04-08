/**
 * @author mike802
 * @version 1.0 - 2/26/2013
 */
package core;

import java.io.File;

public class Properties {
	
	private String imageDir;
	private String rootDir;

	public Properties(String root){
		rootDir = root;
		imageDir = rootDir + File.separator + "img";
	}
	
	public String getImageDir(){
		return imageDir;
	}
	public String getRootDir(){
		return rootDir;
	}
	
	public String getRedPath(){
		return imageDir + File.separator + "red.png";
	}
	public String getYellowPath(){
		return imageDir + File.separator + "yellow.png";
	}
	public String getGreenPath(){
		return imageDir + File.separator + "green.png";
	}
	public String getBluePath(){
		return imageDir + File.separator + "blue.png";
	}
	public String getBlackPath(){
		return imageDir + File.separator + "black.png";
	}
	public String getOrangePath(){
		return imageDir + File.separator + "orange.png";
	}
	
}
