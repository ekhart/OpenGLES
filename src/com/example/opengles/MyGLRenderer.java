package com.example.opengles;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

public class MyGLRenderer implements GLSurfaceView.Renderer {

	Triangle triangle;
	Square square;
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// Called once to set up the view's OpenGL ES environment.
		// set the background frame color
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		triangle = new Triangle();
		square = new Square();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		//Called if the geometry of the view changes, for example when 
		//the device's screen orientation changes.
		GLES20.glViewport(0, 0, width, height);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// Called for each redraw of the view.
		// Redraw background color
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
	}

}
