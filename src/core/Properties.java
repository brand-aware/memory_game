/**
 * @author wontzer
 * @version 1.0 - 2/26/2013
 * 
 * brand-aware
 */
package core;

import java.net.URL;

public class Properties {
	
	private String rootDir;

	public Properties(String root){
		rootDir = root;
	}
	
	public String getRootDir(){
		return rootDir;
	}
	
	//game uses images for "light up" animations
	public URL getRedPath(){
		return getClass().getResource("/img/red.png");
	}
	public URL getYellowPath(){
		return getClass().getResource("/imgyellow.png");
	}
	public URL getGreenPath(){
		return getClass().getResource("/img/green.png");
	}
	public URL getBluePath(){
		return getClass().getResource("/img/blue.png");
	}
	public URL getBlackPath(){
		return getClass().getResource("/img/black.png");
	}
	public URL getOrangePath(){
		return getClass().getResource("/img/orange.png");
	}
	
}
