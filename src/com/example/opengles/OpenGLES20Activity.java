package com.example.opengles;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class OpenGLES20Activity extends Activity {

	private GLSurfaceView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_open_gles20);
		
		//Create a GLSurfaceView instance and set it
		// as the ContentView for this Activity
		
		view = new MyGLSurfaceView(this);
		setContentView(view);
	}
}
