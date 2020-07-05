/* Author: Hunter Barnard
 * 
 * This class just simply loads in textures given a path to the texture
 * 
 */

package com.dalphin.engine.loaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.dalphin.engine.debug.DebugUtil;

public class TextureLoader {
	
	private DebugUtil debug;
	
	public TextureLoader(DebugUtil debug) {
		this.debug = debug;
	}
	
	public Texture loadTexture(String path) {
		try {
			if(debug.isEnabled()) {
				Texture texture = new Texture(path);
				debug.printAssetLoading(texture);
				return texture;
			}else {
				return new Texture(path);
			}
			
		}catch(GdxRuntimeException e) {
			if(debug.isEnabled()) {
				Texture texture = new Texture("MissingTexture.png");
				debug.printAssetLoading(texture);
				return texture;
			}else {
				return new Texture("MissingTexture.png");
			}
		}
	}
}
