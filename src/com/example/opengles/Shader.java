package com.example.opengles;

import android.opengl.GLES20;

public class Shader {

	private final static String 
	vertexShaderCode =
		"attribute vec4 vPosition;" +
		"void main() { " +
		"	gl_Position = vPosition;" +
		"}",
	fragmentShaderCode =
		"precistion mediump float;" +
		"uniform vec4 vColor;" +
		"void main() {" +
		"	gl_FragColor = vColor;" +
		"}";
	
	public static int load(int type, String shaderCode) {
		// create vertex shader type (GLES20.GL_VERTEX_SHADER)
		// or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
		int shader = GLES20.glCreateShader(type);
		
		//add the source code to the shader and compile it
		GLES20.glShaderSource(shader, shaderCode);
		GLES20.glCompileShader(shader);
		
		return shader;
	}
	
	public static int vertexShader() {
		return load(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
	}
	
	public static int fragmentShader() {
		return load(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
	}
}
