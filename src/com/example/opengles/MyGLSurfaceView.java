package com.example.opengles;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {

	public MyGLSurfaceView(Context context) {
		super(context);

		// Create an OpenGL ES 2.0 context
		setEGLContextClientVersion(2);
		
		// Render the view only when there is a change in the drawing data
		//setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
		
		//Set the Renderer for drawning on the GLSurfaceView
		setRenderer(new MyGLRenderer());		
	}
}
