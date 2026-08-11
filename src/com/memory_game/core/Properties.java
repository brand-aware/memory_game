/**
 * @author wontzer
 * @version 1.0 - 2/26/2013
 * 
 * brand-aware
 */
package com.memory_game.core;

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
		return getClass().getResource("/com/memory_game/img/red.png");
	}
	public URL getYellowPath(){
		return getClass().getResource("/com/memory_game/img/yellow.png");
	}
	public URL getGreenPath(){
		return getClass().getResource("/com/memory_game/img/green.png");
	}
	public URL getBluePath(){
		return getClass().getResource("/com/memory_game/img/blue.png");
	}
	public URL getBlackPath(){
		return getClass().getResource("/com/memory_game/img/black.png");
	}
	public URL getOrangePath(){
		return getClass().getResource("/com/memory_game/img/orange.png");
	}
	
}
