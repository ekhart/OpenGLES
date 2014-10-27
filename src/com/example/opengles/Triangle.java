package com.example.opengles;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import android.opengl.GLES20;


public class Triangle {
	private FloatBuffer vertexBuffer;
	int program;
	
	// number of coordinates per vertex in this array
	static final int COORDS_PER_VERTEX = 3;
	static float triangleCoords[] = {	//in counterclockwise order:
		0.0f,  0.622008459f, 0.0f, 		// top
        -0.5f, -0.311004243f, 0.0f, 	// bottom left
         0.5f, -0.311004243f, 0.0f  	// bottom right
	};
	private final int vertexCount = triangleCoords.length / COORDS_PER_VERTEX;
	private final int vertexStride = COORDS_PER_VERTEX * 4; // 4 bytes per vertex

	// Set color with red, green, blue and aplha (opacity) values
	float color[] = { 0.63671875f, 0.76953125f, 0.22265625f, 1.0f };
	
	public Triangle() {
		// initialize vertex byte buffer for shape coordinates
		ByteBuffer bb = ByteBuffer.allocateDirect(
				//number of oordinate values * 4 bytes per float
				triangleCoords.length * 4);
		// use the device hardware's native byt order
		bb.order(ByteOrder.nativeOrder());
		
		// create a floating point buffer from the ByteBuffer
		vertexBuffer = bb.asFloatBuffer();
		// add the coordinates to the FloatBuffer
		vertexBuffer.put(triangleCoords);
		// set the buffer to read the first coordinate
		vertexBuffer.position(0);
		
		int vertexShader = Shader.vertexShader();
		int fragmentShader = Shader.fragmentShader();
	
		program = GLES20.glCreateProgram();			
		GLES20.glAttachShader(program, vertexShader);
		GLES20.glAttachShader(program, fragmentShader);
		GLES20.glLinkProgram(program);	// create opengl es program executables
	}
	
	public void draw() {
		// add program to opengl es enviroment
		GLES20.glUseProgram(program);
		
		//get handle to vertex shader's vPosition memer
		int positionHandle = GLES20.glGetAttribLocation(program, "vPosition");
		
		//enalge a handle to the triangle vertices
		GLES20.glEnableVertexAttribArray(positionHandle);
		
		//preper the triangle coordintate data
		GLES20.glVertexAttribPointer(positionHandle, 
				COORDS_PER_VERTEX, 
				GLES20.GL_FLOAT, 
				false, 
				vertexStride, 
				vertexBuffer);
		
		//get handle to fragment shader's vColor member
		int colorHandle = GLES20.glGetUniformLocation(program, "vColor");
		
		//set color for drawing the triangle
		GLES20.glUniform4fv(colorHandle, 1, color, 0);
		
		//draw the triangle
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);
		
		//disable vertex array
		GLES20.glDisableVertexAttribArray(positionHandle);
	}
}
