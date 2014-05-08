package net.gerosyab.Guitaroid.activity;

import net.gerosyab.Guitaroid.R;
import net.gerosyab.Guitaroid.data.ChordData;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GuitaroidMain extends SuperActivity {
	ImageView metronomeImage, rhythmGuideImage, virtualGuitarImage, songPlayImage, earTestImage, chordBookImage;
	LinearLayout metronomeLinear, rhythmGuideLinear, virtualGuitarLinear, songPlayLinear, earTestLinear, chordBookLinear;
	int metronomeLinearWidth, rhythmGuideLinearWidth, virtualGuitarLinearWidth, songPlayLinearWidth, earTestLinearWidth, chordBookLinearWidth;
	int metronomeLinearHeight, rhythmGuideLinearHeight, virtualGuitarLinearHeight, songPlayLinearHeight, earTestLinearHeight, chordBookLinearHeight;
	
	private boolean mBackKeyFlag = false;
	
	public static final ChordData chordData = new ChordData();
	public static final SoundPool metronomeSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
	public static final SoundPool guitarSoundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);
	
	public static boolean isMetronomeLoadedCompletely = false;
	public static boolean isGuitarLoadedCompletely = true;
	
	public static int[] metronomeSoundArray;
	public static int[] guitarSoundArray;
	
	public static final int metronomeSoundCategoryNum = 6;
	
	private Handler mHandler = new Handler(){
		public void handleMessage(Message msg){
			if(msg.what == 0){
				mBackKeyFlag = false;
			}
		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        loadMetronomeSound();
        
        metronomeImage = (ImageView)findViewById(R.id.mainIconImage1);
        rhythmGuideImage = (ImageView)findViewById(R.id.mainIconImage2);
        virtualGuitarImage = (ImageView)findViewById(R.id.mainIconImage3);
        songPlayImage = (ImageView)findViewById(R.id.mainIconImage4);
        earTestImage = (ImageView)findViewById(R.id.mainIconImage5);
        
        chordBookImage = (ImageView)findViewById(R.id.mainIconImage6);
        
    	metronomeLinear = (LinearLayout)findViewById(R.id.mainIconLinear1);
    	rhythmGuideLinear = (LinearLayout)findViewById(R.id.mainIconLinear2);
    	virtualGuitarLinear = (LinearLayout)findViewById(R.id.mainIconLinear3);
    	songPlayLinear = (LinearLayout)findViewById(R.id.mainIconLinear4);
    	earTestLinear = (LinearLayout)findViewById(R.id.mainIconLinear5);
    	chordBookLinear = (LinearLayout)findViewById(R.id.mainIconLinear6);
    	
    	metronomeLinear.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				
				switch(action){
				case MotionEvent.ACTION_DOWN:
					metronomeImage.setImageResource(R.drawable.metronome_icon_pressed);
					break;
				case MotionEvent.ACTION_UP:
					int x = (int)event.getX();
					int y = (int)event.getY();
					
					metronomeImage.setImageResource(R.drawable.metronome_icon_default);
					
					if(0 <= x && x <= metronomeLinearWidth && 0 <= y && y <= metronomeLinearHeight){
						if(isMetronomeLoadedCompletely){
							Intent i = new Intent(context, MetronomeActivity.class);
							startActivity(i);
						}
					}
					break;
				}
				return true;
			}
		});
    	
    	
    	rhythmGuideLinear.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				
				switch(action){
				case MotionEvent.ACTION_DOWN:
					rhythmGuideImage.setImageResource(R.drawable.rhythmguide_icon_pressed);
					break;
				case MotionEvent.ACTION_UP:
					int x = (int)event.getX();
					int y = (int)event.getY();
					
					rhythmGuideImage.setImageResource(R.drawable.rhythmguide_icon_default);
					
					if(0 <= x && x <= rhythmGuideLinearWidth &&	0 <= y && y <= rhythmGuideLinearHeight){
						Intent i = new Intent(context, RhythmGuideActivity.class);
						startActivity(i);
					}
					break;
				}
				return true;
			}
		});
    	
    	virtualGuitarLinear.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				
				switch(action){
				case MotionEvent.ACTION_DOWN:
					virtualGuitarImage.setImageResource(R.drawable.virtualguitar_icon_pressed);
					break;
				case MotionEvent.ACTION_UP:
					int x = (int)event.getX();
					int y = (int)event.getY();
					
					virtualGuitarImage.setImageResource(R.drawable.virtualguitar_icon_default);
					
					if(0 <= x && x <= virtualGuitarLinearWidth && 0 <= y && y <= virtualGuitarLinearHeight){
//						Intent i = new Intent(context, VirtualGuitarChordLibraryActivity2.class);
						if(isGuitarLoadedCompletely){
							Intent i = new Intent(context, VirtualGuitarChordLibraryActivity.class);
							startActivity(i);
						}
						else{
							//로딩 다이얼로그
						}
					}
					break;
				}
				return true;
			}
		});
    	
    	songPlayLinear.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				
				switch(action){
				case MotionEvent.ACTION_DOWN:
					songPlayImage.setImageResource(R.drawable.songplay_icon_pressed);
					break;
				case MotionEvent.ACTION_UP:
					int x = (int)event.getX();
					int y = (int)event.getY();
					
					songPlayImage.setImageResource(R.drawable.songplay_icon_default);
					
					if(0 <= x && x <= songPlayLinearWidth && 0 <= y && y <= songPlayLinearHeight){
						if(isGuitarLoadedCompletely){
							Intent i = new Intent(context, SongSelect.class);
							startActivity(i);
						}
						else{
							
						}
					}
					break;
				}
				return true;
			}
		});
    	
    	earTestLinear.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				
				switch(action){
				case MotionEvent.ACTION_DOWN:
					earTestImage.setImageResource(R.drawable.ear_test_icon_pressed);
					break;
				case MotionEvent.ACTION_UP:
					int x = (int)event.getX();
					int y = (int)event.getY();
					
					earTestImage.setImageResource(R.drawable.ear_test_icon_default);
					
					if(0 <= x && x <= earTestLinearWidth && 0 <= y && y <= earTestLinearHeight){
						if(isGuitarLoadedCompletely){
							Intent i = new Intent(context, EarTestSelect.class);
							startActivity(i);
						}
					}
					break;
				}
				return true;
			}
		});
    	
    	chordBookLinear.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				
				switch(action){
				case MotionEvent.ACTION_DOWN:
					chordBookImage.setImageResource(R.drawable.chordbook_icon_pressed);
					break;
				case MotionEvent.ACTION_UP:
					int x = (int)event.getX();
					int y = (int)event.getY();
					
					chordBookImage.setImageResource(R.drawable.chordbook_icon_default);
					
					if(0 <= x && x <= chordBookLinearWidth && 0 <= y && y <= chordBookLinearHeight){
						if(isGuitarLoadedCompletely){
							Intent i = new Intent(context, ChordBookActivity.class);
							startActivity(i);
						}
						else{
							
						}
					}
					break;
				}
				return true;
			}
		});
    	
    }
    
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
    	super.onWindowFocusChanged(hasFocus);
    	
		metronomeLinearWidth = metronomeLinear.getWidth();
		metronomeLinearHeight = metronomeLinear.getHeight();
		
		rhythmGuideLinearWidth = rhythmGuideLinear.getWidth();
		rhythmGuideLinearHeight = rhythmGuideLinear.getHeight();
		
		virtualGuitarLinearWidth = virtualGuitarLinear.getWidth();
		virtualGuitarLinearHeight = virtualGuitarLinear.getHeight();
		
		songPlayLinearWidth = songPlayLinear.getWidth();
		songPlayLinearHeight = songPlayLinear.getHeight();
		
		earTestLinearWidth = earTestLinear.getWidth();
		earTestLinearHeight = earTestLinear.getHeight();
		
		chordBookLinearWidth = chordBookLinear.getWidth();
		chordBookLinearHeight = chordBookLinear.getHeight();
    }
    
	@Override
	public void onBackPressed() {
		if (!mBackKeyFlag) {
			sendToastMessage("Touch Back key again to exit");
			mBackKeyFlag = true;
			mHandler.sendEmptyMessageDelayed(0, 2000);
			// 2초 후에 handleMessage에 메시지를 전달한다.
		}
		else {
			super.onBackPressed();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_menu, menu);
	    return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.mainmenu_information:
			Intent i = new Intent(context, Information.class);
			startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	
	@Override
	protected void onDestroy() {
		if(metronomeSoundPool != null){
			metronomeSoundPool.release();
		}
		if(guitarSoundPool != null){
			guitarSoundPool.release();
		}
		
		super.onDestroy();
	}
	
	private boolean loadGuitarSound(){
		
		return false;
	}
	
	private boolean loadMetronomeSound(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int[] sound_resource = {R.raw.beep1, R.raw.beep2, R.raw.cowbell1, R.raw.cowbell2, R.raw.hihat1, R.raw.hihat2,
						  R.raw.stick1, R.raw.stick2, R.raw.rim1, R.raw.rim2, R.raw.ridebell1, R.raw.ridebell2};
				
				metronomeSoundArray = new int[sound_resource.length];
				
				for(int i = 0; i < sound_resource.length; i++){
					metronomeSoundArray[i] = metronomeSoundPool.load(context, sound_resource[i], 0);
				}
				
				isMetronomeLoadedCompletely = true;
			}
		}).start();
				
		return true;
	}
    
	
    
}