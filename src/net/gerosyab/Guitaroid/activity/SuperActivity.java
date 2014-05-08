package net.gerosyab.Guitaroid.activity;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class SuperActivity extends Activity {
	Context context;
	Toast toast;
	TextView toastTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;

		//Set Hardware volume button to control Audio volume
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		//initialize toast instance
		toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
		
		toastTextView = (TextView)toast.getView().findViewById(android.R.id.message);
		
		if(toastTextView!= null){
			toastTextView.setGravity(Gravity.CENTER);
		}
	}
	
	protected void sendToastMessage(String message){
		toast.setText(message);
		toast.show();
	}
}
