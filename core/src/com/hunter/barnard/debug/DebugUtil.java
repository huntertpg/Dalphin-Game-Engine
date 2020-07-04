package com.hunter.barnard.debug;

import com.hunter.barnard.debug.framework.ConsoleUtil;

public class DebugUtil {
	
	private boolean debugging = false;
	private ConsoleUtil consoleUtil;
	
	public void Debug() {
		if(debugging) {
			consoleUtil = new ConsoleUtil();
			System.out.println("[Debugging is Enabled]");
		}else {
			System.out.println("[Debugging is Disabled]");
		}
	}
	
	public void enableDebugging(boolean enableDebugging) {
		this.debugging = enableDebugging;
	}
	
	public boolean isEnabled() {
		return debugging;
	}
	
	public void printAssetLoading(Object ObjectType) {
		consoleUtil.printLoadingAsset(ObjectType);
	}
	
}
