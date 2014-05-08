package net.gerosyab.Guitaroid.activity;

import net.gerosyab.Guitaroid.R;
import net.gerosyab.Guitaroid.data.BpmToSec;
import net.gerosyab.Guitaroid.service.MetronomeService;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.NumericWheelAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

@SuppressLint("NewApi")
public class MetronomeActivity extends SuperActivity {
	public static final String DEBUG_TAG = "metronome";
	public static final int VIB_TIME = 50;
	private final static int MIN_BPM = 1;
	private final static int MAX_BPM = 255;
	private final static int ANIMATION_DURATION = 200;
	
	public static int beatCount;
	public static int signature = 0;
	public static int signatureSoundSrcIdx = 0;
	public static int soundSrcCategoryIndex;
	public static int soundSrcIndex;
	public static int beatIndex;
	
	private final String[] SOUND_SRC_TEXT = {"Beep", "Cow Bell", "Hi-Hat", "Stick", "Rim", "Ride Bell"};
	private final String[] BEAT = {"None", "2", "3", "4", "5", "6"};
	private final int BEAT_NUM = 6;
	
	public static boolean isVibOn, isMuteOn;
//	, isVisualOn;
	
	public static int bpm;
	private boolean isTapClicked;
	public static boolean isPlay;
	private long tapStartTime;
	private long tapEndTime;
	private TextView srcText, beatText;
	
	private Button tapTempoBtn, srcPrevBtn, srcNextBtn, sigPrevBtn, sigNextBtn;
	private ToggleButton startStopBtn, vibBtn, muteBtn;
//	, visualBtn;
	
	//index 0 : 기본음원, index 1 : beat 표현용 음원 
	public static int [] rawResIds = {0, 0};

	public SoundThread thread;
	
	public static Vibrator vibrator;

	WheelView wheel;
	boolean wheelScrolled;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.metronome);
		this.context = getApplicationContext();
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		srcText = (TextView)findViewById(R.id.metronomeSourceText);
		beatText = (TextView)findViewById(R.id.metronomeSignatureText);
		
		startStopBtn = (ToggleButton)findViewById(R.id.metronomeStartStopBtn);
		tapTempoBtn = (Button)findViewById(R.id.metronome_tapTempoBtn);
		
		srcPrevBtn = (Button)findViewById(R.id.metronomeSourcePrevBtn);
		srcNextBtn = (Button)findViewById(R.id.metronomeSourceNextBtn);
		sigPrevBtn = (Button)findViewById(R.id.metronomeSignaturePrevBtn);
		sigNextBtn = (Button)findViewById(R.id.metronomeSignatureNextBtn);
		vibBtn = (ToggleButton)findViewById(R.id.metronomeVibBtn);
		muteBtn = (ToggleButton)findViewById(R.id.metronomeMuteBtn);
//		visualBtn = (ToggleButton)findViewById(R.id.metronomeVisualBtn);
		
		vibBtn.setText("VIBRATION");
		muteBtn.setText("MUTE");
//		visualBtn.setText("INDICATOR");
		startStopBtn.setText("START");
		tapTempoBtn.setText("Tap Tempo");
		
		
		isPlay = false;
		isTapClicked = false;
		isVibOn = false;
		isMuteOn = false;
//		isVisualOn = false;
		
		soundSrcCategoryIndex = soundSrcIndex = beatIndex = 0;
		signature = 0;
		signatureSoundSrcIdx = 0;
		
		srcText.setText(SOUND_SRC_TEXT[soundSrcCategoryIndex]);
		beatText.setText(BEAT[beatIndex]);
		
		bpm = 120;
		
        wheel = (WheelView)findViewById(R.id.metronome_bpmWheel);
        wheel.setViewAdapter(new NumericWheelAdapter(context, 1, MAX_BPM));
        wheel.setVisibleItems(5);
        wheel.setCurrentItem(bpm - 1);
        
        wheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
	            if (!wheelScrolled) {
	                bpm = wheel.getCurrentItem() + 1;
	            }
			}
		});
        
        wheel.addScrollingListener(new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				wheelScrolled = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				wheelScrolled = false;
				bpm = wheel.getCurrentItem() + 1;
			}
		});
		
		wheel.setCurrentItem(bpm - 1);
		
		startStopBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isPlay){
					isPlay = true;
					startStopBtn.setChecked(true);
					startStopBtn.setText("STOP");
					thread = new SoundThread();
					thread.setPriority(Thread.MAX_PRIORITY);
					thread.start();
				}
				else{
					isPlay = false;
					startStopBtn.setChecked(false);
					startStopBtn.setText("START");
					thread.interrupt();
					thread = null;
				}
				
//				if(!isPlay){
//					startService(new Intent(context, MetronomeService.class));
//					isPlay = true;
//				}
//				else{
//					stopService(new Intent(context, MetronomeService.class));
//					isPlay = false;
//				}
				
//				if(!isPlay){
//					isPlay = true;
//					startStopBtn.setChecked(true);
//					startStopBtn.setText("STOP");
//					doBindService();
//				}
//				else{
//					isPlay = false;
//					startStopBtn.setChecked(false);
//					startStopBtn.setText("START");
//					doUnbindService();
//				}
			}
		});
		
		tapTempoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isTapClicked){
					isTapClicked = true;
					tapTempoBtn.setText("Tap once again!!");
//					tapStartTime = SystemClock.uptimeMillis();
//					tapStartTime = SystemClock.elapsedRealtimeNanos();
					tapStartTime = System.nanoTime();
				}
				else{
//					tapEndTime = SystemClock.uptimeMillis();
//					tapEndTime = SystemClock.elapsedRealtimeNanos();
					tapEndTime = System.nanoTime();
					isTapClicked = false;
					tapTempoBtn.setText("Tap Tempo");
//					bpm = Math.round(60000 / (tapEndTime - tapStartTime));
					bpm = (int) ((int) 60000000000L / (tapEndTime - tapStartTime));
					if(bpm > MAX_BPM){
						bpm = MAX_BPM;
					}
					else if(bpm < 1){
						bpm = 1;
					}
					//bpm 254 인데 wheel은 255? 나중에 체크
					wheel.setCurrentItem(bpm - 1);
				}
			}
		});
		
		srcPrevBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(--soundSrcCategoryIndex < 0){
					soundSrcCategoryIndex = GuitaroidMain.metronomeSoundCategoryNum - 1;
				}
				srcText.setText(SOUND_SRC_TEXT[soundSrcCategoryIndex]);
				soundSrcIndex = soundSrcCategoryIndex * 2;
			}
		});
		
		srcNextBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(++soundSrcCategoryIndex > GuitaroidMain.metronomeSoundCategoryNum - 1){
					soundSrcCategoryIndex = 0;
				}
				srcText.setText(SOUND_SRC_TEXT[soundSrcCategoryIndex]);
				soundSrcIndex = soundSrcCategoryIndex * 2;
				}
		});
		
		sigPrevBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(--beatIndex < 0){
					beatIndex = BEAT_NUM - 1;
				}
				beatText.setText(BEAT[beatIndex]);
				if(BEAT[beatIndex].equals("None")){
					signature = 0;
					signatureSoundSrcIdx = 0;
				}
				else{
					signature = Integer.valueOf(BEAT[beatIndex]);
					signatureSoundSrcIdx = 1;
				}
			}
		});
		
		sigNextBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(++beatIndex > BEAT_NUM - 1){
					beatIndex = 0;
				}
				beatText.setText(BEAT[beatIndex]);
				if(BEAT[beatIndex].equals("None")){
					signature = 0;
					signatureSoundSrcIdx = 0;
				}
				else{
					signature = Integer.valueOf(BEAT[beatIndex]);
					signatureSoundSrcIdx = 1;
				}
			}
		});
		
		vibBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isVibOn){
					isVibOn = false;
				}
				else{
					isVibOn = true;
				}
				vibBtn.setChecked(isVibOn);
				vibBtn.setText("VIBRATION");
			}
		});
		
		muteBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isMuteOn){
					isMuteOn = false;
				}
				else{
					isMuteOn = true;
				}
				muteBtn.setChecked(isMuteOn);
				muteBtn.setText("MUTE");
			}
		});
		
	}
	
	private class SoundThread extends Thread{
		public void run(){
			long curTime, nextTime = 0;
			beatCount = 1;
			//시작버튼 누르면 바로 플레이되도록 맨처음 비트만 따로 작성
//			curTime = SystemClock.uptimeMillis();
//			curTime = SystemClock.elapsedRealtimeNanos();
			curTime = System.nanoTime();
//			nextTime = curTime + BpmToSec.MilliSecTable[bpm - 1];
			nextTime = curTime + BpmToSec.NanoSecTable[bpm - 1];
			
			if(!isMuteOn){
				GuitaroidMain.metronomeSoundPool.play(GuitaroidMain.metronomeSoundArray[soundSrcIndex + signatureSoundSrcIdx], 1, 1, 0, 0, 1);
			}
			if(isVibOn){
				vibrator.vibrate(VIB_TIME);
			}
			
//			if(isVisualOn){
//				runOnUiThread(new Runnable() {
//					@Override
//					public void run() {
////						Log.d(DEBUG_TAG, "animation");
//					}
//				});
//			}
			
			while(isPlay){
//				curTime = SystemClock.uptimeMillis();
//				curTime = SystemClock.elapsedRealtimeNanos();
				curTime = System.nanoTime();
				
				if(curTime == nextTime){
					Log.d("metronome", "O - current : " + curTime + ", next : " + nextTime);
					
					beatCount++;

					if(!isMuteOn){
						if(signature != 0 && beatCount % signature == 1){
							GuitaroidMain.metronomeSoundPool.play(GuitaroidMain.metronomeSoundArray[soundSrcIndex + 1], 1, 1, 0, 0, 1);
							beatCount = 1;
						}
						else{
							GuitaroidMain.metronomeSoundPool.play(GuitaroidMain.metronomeSoundArray[soundSrcIndex], 1, 1, 0, 0, 1);
						}
					}
					
					if(isVibOn){
						vibrator.vibrate(VIB_TIME);
					}
					
//					if(isVisualOn){
//						runOnUiThread(new Runnable() {
//							@Override
//							public void run() {
////								Log.d(DEBUG_TAG, "animation");
//							}
//						});
//					}
					
//					nextTime += BpmToSec.MilliSecTable[bpm - 1];
					nextTime += BpmToSec.NanoSecTable[bpm - 1];
					
				}
				
				else if(curTime > nextTime){
					Log.d("metronome", "X - current : " + curTime + ", next : " + nextTime + ", diff : " + Math.abs(curTime - nextTime));
					
					beatCount++;

					if(!isMuteOn){
						if(signature != 0 && beatCount % signature == 1){
							GuitaroidMain.metronomeSoundPool.play(GuitaroidMain.metronomeSoundArray[soundSrcIndex + 1], 1, 1, 0, 0, 1);
							beatCount = 1;
						}
						else{
							GuitaroidMain.metronomeSoundPool.play(GuitaroidMain.metronomeSoundArray[soundSrcIndex], 1, 1, 0, 0, 1);
						}
					}
					
					if(isVibOn){
						vibrator.vibrate(VIB_TIME);
					}
					
//					if(isVisualOn){
//						runOnUiThread(new Runnable() {
//							@Override
//							public void run() {
////								Log.d(DEBUG_TAG, "animation");
//							}
//						});
//					}
//					nextTime = curTime + BpmToSec.MilliSecTable[bpm - 1];
					nextTime = curTime + BpmToSec.NanoSecTable[bpm - 1];
					
					
				}
			}
		}
	}

	@Override
	protected void onPause() {
		if(thread != null){
			GuitaroidMain.metronomeSoundPool.autoPause();
			thread = null;
		}
		isPlay = false;
		isTapClicked = false;
		startStopBtn.setChecked(false);
		startStopBtn.setText("START");
		tapTempoBtn.setText("Tap Tempo");
		super.onPause();
	}

	@Override
	protected void onResume() {
		isPlay = false;
		isTapClicked = false;
		startStopBtn.setChecked(false);
		startStopBtn.setText("START");
		tapTempoBtn.setText("Tap Tempo");
		super.onResume();
	}
	
	//Shared Preference 로 bpm, sound src, time signature 저장?
	
	private boolean mIsBound;
	
	private MetronomeService mBoundService;
	
	private ServiceConnection mConnection = new ServiceConnection() {
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mBoundService = ((MetronomeService.MetronomeBinder)service).getService();
			sendToastMessage("onServiceConnected");
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mBoundService = null;
			sendToastMessage("onServiceDisconnected");
		}
	};
	
	void doBindService(){
		bindService(new Intent(context, MetronomeService.class), mConnection, Context.BIND_AUTO_CREATE);
		mIsBound = true;
	}
	
	void doUnbindService(){
		if(mIsBound){
			unbindService(mConnection);
			mIsBound = false;
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		doUnbindService();
	}
	
	void user(){
		
	}
}
