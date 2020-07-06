package com.dalphin.engine.debug.framework;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.item.Item2D;

public class ConsoleUtil {
	
	public void printError() {
		
	}

	public void printError(int errorCode) {
		System.out.println("[Error] Code " + errorCode);
	}
	
	public void printError(int errorCode, String error) {
		System.out.println("[Error] " + error + " Code " + errorCode);
	}
	
	public void printError(String error) {
		System.out.println("[Error] " + error);
	}
	
	public void printLoading() {
		
	}

	public void printLoadingAsset(Object objectType) {
		if(objectType instanceof Texture) {
			System.out.println("[Asset Loading] Loading Texture " + ((FileTextureData)((Texture)objectType).getTextureData()).getFileHandle().path());
		}else if(objectType instanceof Item2D) {
			System.out.println("[Asset Loading] Loading Item " + ((Item2D) objectType).getName());
		}else if(objectType instanceof Block2D) {
			System.out.println("[Asset Loading] Loading Block " + ((Block2D) objectType).getName());
		}
	}
	
	public void printWarning() {

	}
	
	public void printWarning(int warningCode) {
		System.out.println("[Warning] Code " + warningCode);
	}
	
	public void printWarning(int warningCode, String warning) {
		System.out.println("[Error] " + warning + " Code " + warningCode);
	}
	
	public void printWarning(String warning) {
		System.out.println("[Warning] " + warning);
	}
	

}
