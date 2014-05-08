package net.gerosyab.Guitaroid.service;

import net.gerosyab.Guitaroid.R;
import net.gerosyab.Guitaroid.activity.MetronomeActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MetronomeService extends Service {
	
	private NotificationManager mNM;
	
	private int NOTIFICATION = R.string.metronome_service_started;
	
	private final IBinder mBinder = new MetronomeBinder();
	
	Context context;
	
	public static SoundPool soundPool;
	public static int[] metronomeSoundArray;
	public static final int[] sound_resource = {R.raw.beep1, R.raw.beep2, R.raw.cowbell1, R.raw.cowbell2, R.raw.hihat1, R.raw.hihat2,
			  R.raw.stick1, R.raw.stick2, R.raw.rim1, R.raw.rim2, R.raw.ridebell1, R.raw.ridebell2};
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	
	public class MetronomeBinder extends Binder {
		public MetronomeService getService() {
			return MetronomeService.this;
		}
	}

	@Override
	public void onCreate() {
		mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
		context = this;
		
		soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
		metronomeSoundArray = new int[sound_resource.length];
		for(int i = 0; i < sound_resource.length; i++){
			metronomeSoundArray[i] = soundPool.load(context, sound_resource[i], 0);
		}
		
		showNotification();
		
		super.onCreate();
	}



	@Override
	public void onDestroy() {
		mNM.cancel(NOTIFICATION);

        Toast.makeText(context, "Metronome is stoped", Toast.LENGTH_SHORT).show();
        
        Log.i("LocalService", "service onDestroy");
        
		soundPool.release();
		soundPool = null;
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("LocalService", "Received start id " + startId + ": " + intent);
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
//		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		super.onRebind(intent);
	}



	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}



	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}


	public boolean isPlaying(){
		
		return false;
	}
	
	public int getCurrentBPM(){
		
		return 0;
	}
	
	public int getCurrentSoundSource(){
		
		return 0;
	}
	
	public int getCurrentSoundSignature(){
		
		return 0;
	}

	public void startMetronome(){
		
	}
	
	public void stopMetronome(){
		
	}
	
	public void changeRPM(){
		
	}
	
	public void changeTickSound(){
		
	}
	
	public void changeBeat(){
		
	}

	private void showNotification() {
        CharSequence text = getText(R.string.metronome_service_started);

        Notification notification = new Notification(R.drawable.metronome_icon_default, text,
                System.currentTimeMillis());

        Intent intent = new Intent(this, MetronomeActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
        

        notification.setLatestEventInfo(this, "contens?",
                       text, contentIntent);

        mNM.notify(NOTIFICATION, notification);
    }
	
	public static final int[] MILLS_TABLE = {60000, 30000, 20000, 15000, 12000,
		10000, 8571, 7500, 6667, 6000, 5455, 5000, 4615, 4286, 4000, 3750,
		3529, 3333, 3158, 3000, 2857, 2727, 2609, 2500, 2400, 2308, 2222,
		2143, 2069, 2000, 1935, 1875, 1818, 1765, 1714, 1667, 1622, 1579,
		1538, 1500, 1463, 1429, 1395, 1364, 1333, 1304, 1277, 1250, 1224,
		1200, 1176, 1154, 1132, 1111, 1091, 1071, 1053, 1034, 1017, 1000,
		984, 968, 952, 938, 923, 909, 896, 882, 870, 857, 845, 833, 822,
		811, 800, 789, 779, 769, 759, 750, 741, 732, 723, 714, 706, 698,
		690, 682, 674, 667, 659, 652, 645, 638, 632, 625, 619, 612, 606,
		600, 594, 588, 583, 577, 571, 566, 561, 556, 550, 545, 541, 536,
		531, 526, 522, 517, 513, 508, 504, 500, 496, 492, 488, 484, 480,
		476, 472, 469, 465, 462, 458, 455, 451, 448, 444, 441, 438, 435,
		432, 429, 426, 423, 420, 417, 414, 411, 408, 405, 403, 400, 397,
		395, 392, 390, 387, 385, 382, 380, 377, 375, 373, 370, 368, 366,
		364, 361, 359, 357, 355, 353, 351, 349, 347, 345, 343, 341, 339,
		337, 335, 333, 331, 330, 328, 326, 324, 323, 321, 319, 317, 316,
		314, 313, 311, 309, 308, 306, 305, 303, 302, 300, 299, 297, 296,
		294, 293, 291, 290, 288, 287, 286, 284, 283, 282, 280, 279, 278,
		276, 275, 274, 273, 271, 270, 269, 268, 267, 265, 264, 263, 262,
		261, 260, 259, 258, 256, 255, 254, 253, 252, 251, 250, 249, 248,
		247, 246, 245, 244, 243, 242, 241, 240, 239, 238, 237, 236, 235,
		234, 233, 233, 232, 231, 230, 229, 228, 227, 226, 226, 225, 224,
		223, 222, 221, 221, 220, 219, 218, 217, 217, 216, 215, 214, 214,
		213, 212, 211, 211, 210, 209, 208, 208, 207, 206, 205, 205, 204,
		203, 203, 202, 201, 201, 200 };
}
