package com.dalphin.engine.debug;

import com.dalphin.engine.debug.framework.ConsoleUtil;

public class DebugUtil {
	
	private ConsoleUtil consoleUtil;
	private boolean debugging = false;
	public void Debug() {
		if(debugging) {
			consoleUtil = new ConsoleUtil();
			System.out.println("[Debugging is Enabled]");
		}else {
			System.out.println("[Debugging is Disabled]");
		}
	}
	/**
	 * 
	 * @param enableDebugging
	 */
	public void enableDebugging(boolean enableDebugging) {
		this.debugging = enableDebugging;
	}
	/**
	 * 
	 * @return debugging
	 */
	public boolean isEnabled() {
		return debugging;
	}
	/**
	 * 
	 * @param ObjectType
	 */
	public void printAssetLoading(Object ObjectType) {
		consoleUtil.printLoadingAsset(ObjectType);
	}
	
}
