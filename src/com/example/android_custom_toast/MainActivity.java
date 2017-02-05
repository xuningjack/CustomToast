package com.example.android_custom_toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button mButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mButton = (Button)findViewById(R.id.button);
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				CustomToast.getNewInstance(getApplicationContext());
				CustomToast.show("Hello world!", Toast.LENGTH_LONG);
			}
		});
		
		mButton.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {

				CustomToast.show("aaaa", Toast.LENGTH_SHORT);
				return false;
			}
		});

	}
}
