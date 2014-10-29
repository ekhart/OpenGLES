package com.example.opengles;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

public class MyGLRenderer implements GLSurfaceView.Renderer {

	Triangle triangle;
	Square square;
	private final float[] mViewMatrix = new float[16];
	private final float[] mMVPMatrix = new float[16];
	private final float[] mProjectionMatrix = new float[16];
	
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
		
		float ratio = (float) width / height;
		
		// this projection matrix is applied to object coordinates
		// in the onDrawFrame() method
		Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// Called for each redraw of the view.
		// Redraw background color
		//GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
		
		// set the camera position (view matrix)
		Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0);
		
		// calculate the projection and view transformation
		Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
		
		// draw shape
		triangle.draw(mMVPMatrix);
	}

}
