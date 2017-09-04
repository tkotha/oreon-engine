package org.oreon.core.gl.shaders.water;

import org.oreon.core.shaders.Shader;
import org.oreon.core.utils.ResourceLoader;

public class Tilde_hktShader extends Shader{

	private static Tilde_hktShader instance = null;
	
	public static Tilde_hktShader getInstance() 
	{
	    if(instance == null) 
	    {
	    	instance = new Tilde_hktShader();
	    }
	    return instance;
	}
	
	protected Tilde_hktShader()
	{
		super();
		
		addComputeShader(ResourceLoader.loadShader("shaders/ocean/fft/~h(k,t).glsl"));
		compileShader();
		
		addUniform("N");
		addUniform("L");
		addUniform("t");
	}
	
	public void updateUniforms(int L, int N, float t)
	{
		setUniformi("N", N);
		setUniformi("L", L);
		setUniformf("t", t);
	}
}
