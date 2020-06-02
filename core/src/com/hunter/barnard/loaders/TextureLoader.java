/* Author: Hunter Barnard
 * 
 * This class just simply loads in textures given a path to the texture
 * 
 */

package com.hunter.barnard.loaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class TextureLoader {
	
	public Texture loadTexture(String path) {
		try {
			return new Texture(path);	
		}catch(GdxRuntimeException e) {
			return new Texture("MissingTexture.png");
		}
		
	}

}
