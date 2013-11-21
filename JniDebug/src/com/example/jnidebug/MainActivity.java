package com.example.jnidebug;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements android.view.View.OnClickListener{
	TextView t = null;
	static int mCounter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		t = (TextView)findViewById(R.id.textView1);
		Button b = (Button)findViewById(R.id.button1);
		t.setText("No button has been pressed");
		b.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (t == null) {
			t = (TextView)findViewById(R.id.textView1);
		}
		t.setText(getButtonString(mCounter++));
	}
	
    // when adding a JNI, i do the following steps:
	// 1. add  the native call
	// 2. add the load library
	// 3. build clean -- don't run... you don't have a JNI yet
	// 4. create the header file for JNI:
	//		cd bin/classes
	//		javah -jni com.example.jnidebug.MainActivity
    // 		mv com_example_jnidebug_MainActivity.h ../../jni/
    // 		implement JNI

	private native String getButtonString(int i);

    static {
        try {
            System.loadLibrary("jniDebug");
            Log.i( "loading JNI...", "jniDebug.so library is successfully loaded!");
        }
        catch (UnsatisfiedLinkError e){
        	Log.i( "loading JNI...", "something is wrong");
        }
    }



}
