package net.gerosyab.Guitaroid.activity;

import net.gerosyab.Guitaroid.R;
import net.gerosyab.Guitaroid.data.ChordData.Chord;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;


public class VirtualGuitarChordLibraryActivity extends Activity{
	private final String PREFERENCE_NAME = "VirtualGuitarChordLibrary";
	private final String INSTRUMENT_KEY = "Instrument";
	
	protected static final String DEBUG_TAG = "VirtualGuitar";

//	protected static final int INSTRUMENT_TYPE_ACOUTSTIC = 0;
//	protected static final int INSTRUMENT_TYPE_ELECTRIC = 1;

	protected static final int INVALID_POINTER_ID = -1;
	protected static final int STRING6 = 0;
	protected static final int STRING5 = 1;
	protected static final int STRING4 = 2;
	protected static final int STRING3 = 3;
	protected static final int STRING2 = 4;
	protected static final int STRING1 = 5;

	protected LinearLayout[] mStringLinear = { null, null, null, null, null,
			null };
	protected ImageView[] mStringImage = { null, null, null, null, null, null };

//	protected int[] stringWidth = { 0, 0, 0, 0, 0, 0 };
//	protected int[] stringHeight = { 0, 0, 0, 0, 0, 0 };
	protected int stringWidth = 0;
	protected int stringHeight = 0;
	protected int[] stringStartX = { 0, 0, 0, 0, 0, 0 };
	protected int[] stringStartY = { 0, 0, 0, 0, 0, 0 };
	
	protected int buttonWidth = 0;
	protected int buttonHeight = 0;
	protected int[] buttonStartX = { 0, 0, 0, 0, 0, 0, 0, 0 };
	protected int[] buttonStartY = { 0, 0, 0, 0, 0, 0, 0, 0 };

	protected float mPosX, mPosY, mLastTouchX, mLastTouchY;
	protected int mActivePointerId;

	protected boolean[] isStringTouched = { false, false, false, false, false, false };

	protected Context context;
	protected SoundPool soundPool;
	protected static int[] rawResIds = {
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0
	};
	
	boolean chordSelectFlag = false;
	boolean isDialogDismiss;
	
	protected static int curString;

	protected int[][] soundResourceTable;
	protected int instrument_type;

	protected boolean [] mute = {
			false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false,
			false, false, false, false,	false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false
	};
	
	protected boolean [] loading = new boolean[6];
	
	public final static int REQUEST_CHORD_LIBRARY = 1;
	
	int clickedButtonIndex;
	int longClickedButtonIndex;
	
	String [] chordLibrary = {
			"", "", "", "",
			"", "", "", ""
	};		
	
	ToggleButton[] button = {null, null, null, null, null, null, null, null};

	Chord chord;
	
	ProgressDialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//각각 레이아웃 적용하기 위해 onCreate 만 super.onCreate() 하지말고 다해주자고
		
		setContentView(R.layout.virtual_guitar_chord_library2);
		this.context = this;
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		soundResourceTable = SoundResourceTable.ACOUSTIC_RESOURCE_TABLE;
		
		//Dialog Starts
		SharedPreferences pref = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
		isDialogDismiss = pref.getBoolean("isDialogDismiss", false);
		if(!isDialogDismiss){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("You can change presetted chord by Long Click the Chord Button")
			       .setCancelable(false)
			       .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                isDialogDismiss = true;
			                SharedPreferences pref = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
			        		SharedPreferences.Editor edit = pref.edit();
			        		edit.putBoolean("isDialogDismiss", isDialogDismiss);
			        		edit.commit();
			                dialog.cancel();
			           }
			       })
			       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			           }
			       });
			AlertDialog alert = builder.create();
			alert.setTitle("Tip");
			alert.show();
			
		}
		//Dialog Ends
		
//		soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);
//		
//		readPreference();
//		setChord();
		
		mStringLinear[0] = (LinearLayout)findViewById(R.id.chord_library_6th_string_linear);
		mStringLinear[1] = (LinearLayout)findViewById(R.id.chord_library_5th_string_linear);
		mStringLinear[2] = (LinearLayout)findViewById(R.id.chord_library_4th_string_linear);
		mStringLinear[3] = (LinearLayout)findViewById(R.id.chord_library_3rd_string_linear);
		mStringLinear[4] = (LinearLayout)findViewById(R.id.chord_library_2nd_string_linear);
		mStringLinear[5] = (LinearLayout)findViewById(R.id.chord_library_1st_string_linear);

		mStringImage[0] = (ImageView)findViewById(R.id.chord_library_6th_string_img);
		mStringImage[1] = (ImageView)findViewById(R.id.chord_library_5th_string_img);
		mStringImage[2] = (ImageView)findViewById(R.id.chord_library_4th_string_img);
		mStringImage[3] = (ImageView)findViewById(R.id.chord_library_3rd_string_img);
		mStringImage[4] = (ImageView)findViewById(R.id.chord_library_2nd_string_img);
		mStringImage[5] = (ImageView)findViewById(R.id.chord_library_1st_string_img);
		
		mStringImage[0].setImageResource(R.drawable.acoustic_6);
		mStringImage[1].setImageResource(R.drawable.acoustic_5);
		mStringImage[2].setImageResource(R.drawable.acoustic_4);
		mStringImage[3].setImageResource(R.drawable.acoustic_3);
		mStringImage[4].setImageResource(R.drawable.acoustic_2);
		mStringImage[5].setImageResource(R.drawable.acoustic_1);
		
		button[0] = (ToggleButton)findViewById(R.id.chord_library_button_1);
		button[1] = (ToggleButton)findViewById(R.id.chord_library_button_2);
		button[2] = (ToggleButton)findViewById(R.id.chord_library_button_3);
		button[3] = (ToggleButton)findViewById(R.id.chord_library_button_4);
		
		button[4] = (ToggleButton)findViewById(R.id.chord_library_button_5);
		button[5] = (ToggleButton)findViewById(R.id.chord_library_button_6);
		button[6] = (ToggleButton)findViewById(R.id.chord_library_button_7);
		button[7] = (ToggleButton)findViewById(R.id.chord_library_button_8);
		
//		button[0].setText(chordLibrary[0]);
//		button[1].setText(chordLibrary[1]);
//		button[2].setText(chordLibrary[2]);
//		button[3].setText(chordLibrary[3]);
//		
//		button[4].setText(chordLibrary[4]);
//		button[5].setText(chordLibrary[5]);
//		button[6].setText(chordLibrary[6]);
//		button[7].setText(chordLibrary[7]);
		
		button[0].setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				clickedButtonIndex = 0;
				button[0].setChecked(true);
				button[0].setText(chordLibrary[0]);
				for(int i = 0; i < 8; i++){
					if(i != 0){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		});
		
//		button[0].setOnTouchListener(new View.OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				int action = event.getAction();
//				
//				switch (action & event.ACTION_MASK) {
//					case MotionEvent.ACTION_DOWN: {
//						button[0].setPressed(true);
//						break;
//					}
//					case MotionEvent.ACTION_MOVE: {
//						button[0].setPressed(true);
//						break;
//					}
//					case MotionEvent.ACTION_UP: {
//						clickedButtonIndex = 0;
//						if(button[0].isPressed()){
//							button[0].setPressed(false);
//						}
//						button[0].setChecked(true);
//						button[0].setText(chordLibrary[0]);
//						for(int i = 0; i < 8; i++){
//							if(i != 0){
//								button[i].setChecked(false);
//								button[i].setText(chordLibrary[i]);
//							}
//						}
//						break;
//					}
//					case MotionEvent.ACTION_OUTSIDE: {
//						button[0].setPressed(false);
//						break;
//					}
//					case MotionEvent.ACTION_CANCEL: {
//						button[0].setPressed(false);
//						break;
//					}
//				}
//				return true;
//			}
//		});
		
		button[0].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				chordSelectFlag = true;
				longClickedButtonIndex = 0;
				Intent intent = new Intent(context, ChordSelector.class);
				startActivityForResult(intent, REQUEST_CHORD_LIBRARY);
//				chordSelectFlag = false;
				return true;
			}
		});
		
		button[1].setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				clickedButtonIndex = 1;
				button[1].setChecked(true);
				button[1].setText(chordLibrary[1]);
				for(int i = 0; i < 8; i++){
					if(i != 1){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		});
		
		button[1].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				chordSelectFlag = true;
				longClickedButtonIndex = 1;
				Intent intent = new Intent(context, ChordSelector.class);
				startActivityForResult(intent, REQUEST_CHORD_LIBRARY);
//				chordSelectFlag = false;
				return true;
			}
		});
		
		button[2].setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				clickedButtonIndex = 2;
				button[2].setChecked(true);
				button[2].setText(chordLibrary[2]);
				for(int i = 0; i < 8; i++){
					if(i != 2){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		});
		
		button[2].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				chordSelectFlag = true;
				longClickedButtonIndex = 2;
				Intent intent = new Intent(context, ChordSelector.class);
				startActivityForResult(intent, REQUEST_CHORD_LIBRARY);
//				chordSelectFlag = false;
				return true;
			}
		});
		
		button[3].setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				clickedButtonIndex = 3;
				button[3].setChecked(true);
				button[3].setText(chordLibrary[3]);
				for(int i = 0; i < 8; i++){
					if(i != 3){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		});
		
		button[3].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				chordSelectFlag = true;
				longClickedButtonIndex = 3;
				Intent intent = new Intent(context, ChordSelector.class);
				startActivityForResult(intent, REQUEST_CHORD_LIBRARY);
//				chordSelectFlag = false;
				return true;
			}
		});
		
		button[4].setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				clickedButtonIndex = 4;
				button[4].setChecked(true);
				button[4].setText(chordLibrary[4]);
				for(int i = 0; i < 8; i++){
					if(i != 4){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		});
		
		button[4].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				chordSelectFlag = true;
				longClickedButtonIndex = 4;
				Intent intent = new Intent(context, ChordSelector.class);
				startActivityForResult(intent, REQUEST_CHORD_LIBRARY);
//				chordSelectFlag = false;
				return true;
			}
		});
		
		button[5].setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				clickedButtonIndex = 5;
				button[5].setChecked(true);
				button[5].setText(chordLibrary[5]);
				for(int i = 0; i < 8; i++){
					if(i != 5){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		});
		
		button[5].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				chordSelectFlag = true;
				longClickedButtonIndex = 5;
				Intent intent = new Intent(context, ChordSelector.class);
				startActivityForResult(intent, REQUEST_CHORD_LIBRARY);
//				chordSelectFlag = false;
				return true;
			}
		});
		
		button[6].setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				clickedButtonIndex = 6;
				button[6].setChecked(true);
				button[6].setText(chordLibrary[6]);
				for(int i = 0; i < 8; i++){
					if(i != 6){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		});
		
		button[6].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				chordSelectFlag = true;
				longClickedButtonIndex = 6;
				Intent intent = new Intent(context, ChordSelector.class);
				startActivityForResult(intent, REQUEST_CHORD_LIBRARY);
//				chordSelectFlag = false;
				return true;
			}
		});
		
		button[7].setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				clickedButtonIndex = 7;
				button[7].setChecked(true);
				button[7].setText(chordLibrary[7]);
				for(int i = 0; i < 8; i++){
					if(i != 7){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		});
		
		button[7].setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				chordSelectFlag = true;
				longClickedButtonIndex = 7;
				Intent intent = new Intent(context, ChordSelector.class);
				startActivityForResult(intent, REQUEST_CHORD_LIBRARY);
//				chordSelectFlag = false;
				return true;
			}
		});
		
		clickedButtonIndex = 0;
		button[0].setChecked(true);
//		pref = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);	
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUEST_CHORD_LIBRARY){
			if(resultCode == RESULT_OK){
				String resultStr = data.getStringExtra(ChordSelector.RESULT);
				chordLibrary[longClickedButtonIndex] = resultStr;
				button[longClickedButtonIndex].setChecked(true);
				button[longClickedButtonIndex].setText(chordLibrary[longClickedButtonIndex]);
				clickedButtonIndex = longClickedButtonIndex;
				
				chord = GuitaroidMain.chordData.getChord(chordLibrary[longClickedButtonIndex]);
				
				int tempIndexCount = longClickedButtonIndex * 6;
				for(int i = 0; i < 6; i++){
					if(chord.position[i] != -1){
						soundPool.unload(rawResIds[tempIndexCount + i]);
						rawResIds[tempIndexCount + i] = soundPool.load(context, soundResourceTable[i][chord.position[i]], 1);
						mute[tempIndexCount + i] = false;
					}
					else{
						mute[tempIndexCount + i] = true;
					}
				}
				
				for(int i = 0; i < 8; i++){
					if(i != longClickedButtonIndex){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
					else{
					}
				}
			}
			else{
				button[clickedButtonIndex].setChecked(true);
				button[clickedButtonIndex].setText(chordLibrary[clickedButtonIndex]);
				for(int i = 0; i < 8; i++){
					if(i != clickedButtonIndex){
						button[i].setChecked(false);
						button[i].setText(chordLibrary[i]);
					}
				}
			}
		}
	}
	
	void setChord(){
		Chord chord;
		dialog = ProgressDialog.show(context, "", "Loading... Please wait...", true);
		LoadingThread lt = new LoadingThread();
		lt.start();
		
	}
	
	private class LoadingThread extends Thread{
		public void run() {
			for(int i = 0; i < 8; i++){
				chord = GuitaroidMain.chordData.getChord(chordLibrary[i]);
				int tempIndexCount = i * 6;
				for(int j = 0; j < 6; j++){
					if(chord.position[j] != -1){
		//				soundPool.unload(rawResIds[i]);
						
						rawResIds[tempIndexCount + j] = soundPool.load(context, soundResourceTable[j][chord.position[j]], 1);
						mute[tempIndexCount + j] = false;
					}
					else{
						mute[tempIndexCount + j] = true;
					}
				}
			}
			
			dialog.dismiss();
		}
	}
	
	@Override
	protected void onDestroy() {
		if(soundPool != null) {
			soundPool.release();
			soundPool = null;
		}
		super.onDestroy();
	}
	
	@Override
	protected void onPause() {
		writePreference();
		
		if (!chordSelectFlag){
			if(soundPool != null) {
				soundPool.release();
				soundPool = null;
			}
		}
		
		super.onPause();

		//마지막 코드 값도 저장
	}

	@Override
	protected void onResume() {
		//onCreate에 있던거 복사//////////////////////////////////////////////////
		
		if(!chordSelectFlag){
			readPreference();
			
			button[0].setText(chordLibrary[0]);
			button[1].setText(chordLibrary[1]);
			button[2].setText(chordLibrary[2]);
			button[3].setText(chordLibrary[3]);
			
			button[4].setText(chordLibrary[4]);
			button[5].setText(chordLibrary[5]);
			button[6].setText(chordLibrary[6]);
			button[7].setText(chordLibrary[7]);
			
			if(soundPool == null) {
				soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);
				setChord();
			}
			
		}
		else{
			chordSelectFlag = false;
		}
		
		///////////////////////////////////////////////////////////////////////
		
//		if (!chordSelectFlag){
//			if(soundPool == null) {
//				soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);
//				
//				Chord chord;
//				
////				loading = true;
//				for(int i = 0; i < 8; i++){
//					chord = GuitaroidMain.chordData.getChord(chordLibrary[i]);
//					for(int j = 0; j < 6; j++){
//						if(chord.position[j] != -1){
//			//				soundPool.unload(rawResIds[i]);
//							
//							rawResIds[i * 6 + j] = soundPool.load(context, soundResourceTable[j][chord.position[j]], 1);
//							mute[i * 6 + j] = false;
//						}
//						else{
//							mute[i * 6 + j] = true;
//						}
//					}
//				}
//				
//			}
//		}
		
		super.onResume();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		final int action = event.getAction();

		// 최초 터치점만 연주여부 true, false 주어서
		// move 때 계속 갱신되면 연주되지 않게 함
		// 따라서 멀티 터치점으로는 move 판별 안되게 함

		switch (action & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN: {
				final float x = event.getX();
				final float y = event.getY();
				mLastTouchX = x;
				mLastTouchX = y;
	
				// Pointer ID 저장
				mActivePointerId = event.getPointerId(0);
				int index = checkTouchArea(x, y);
				if (index != -1) {
					for (int i = 0; i < 6; i++) {
						if (i != index) {
							isStringTouched[i] = false;
						}
					}
					isStringTouched[index] = true;
					playString(index);
				}
				break;
			}
			case MotionEvent.ACTION_MOVE: {
				// 현재 활성화된 포인터의 인덱스를 찾아 위치를 받아온다.
				final int pointerIndex = event.findPointerIndex(mActivePointerId);
				final float x = event.getX(mActivePointerId);
				final float y = event.getY(mActivePointerId);
				final float dx = x - mLastTouchX;
				final float dy = y - mLastTouchY;
	
				mPosX += dx;
				mPosY += dy;
	
				mLastTouchX = x;
				mLastTouchY = y;
	
				int index = checkTouchArea(x, y);
				if (index != -1) {
					if (isStringTouched[index] == false) {
						for (int i = 0; i < 6; i++) {
							if (i != index) {
								isStringTouched[i] = false;
							}
						}
						isStringTouched[index] = true;
						playString(index);
					}
				}
				break;
			}
	
			case MotionEvent.ACTION_POINTER_DOWN: {
				// 남아있는 멀티터치 포인터의 인덱스를 추출한다
				final int pointerIndex = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
				final int pointerId = event.getPointerId(pointerIndex);
	
				final float x = event.getX(pointerId);
				final float y = event.getY(pointerId);
				mLastTouchX = x;
				mLastTouchX = y;
	
				int index = checkTouchArea(x, y);
				if (index != -1) {
					playString(index);
				}
				break;
			}
			
			case MotionEvent.ACTION_POINTER_UP: {
				final int pointerIndex = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
				final int pointerId = event.getPointerId(pointerIndex);
	
				final float x = event.getX(pointerId);
				final float y = event.getY(pointerId);
				
				Log.d("actionup", "pointerIndex = " + pointerIndex + ", pointerId = " + pointerId + ", x = " + x + ", y = " + y);
				
				int index = checkTouchAreaInChordButton(x, y);
				if(index != -1){
					clickedButtonIndex = index;
					for(int i = 0; i < 8; i++){
						if(i != index){
							button[i].setChecked(false);
							button[i].setText(chordLibrary[i]);
						}
					}
					button[index].setChecked(true);
					button[index].setText(chordLibrary[index]);
				}
				break;
			}
			
			//멀티터치로 코드 버튼 눌린거 이미지 변환?
		}
		
//		super.onTouchEvent(event);

		//이러면 어떻게 되지
		//return super.onTouchEvent(event);
		
		return true;
	}

	protected void playString(int index) {
		soundPool.play(rawResIds[clickedButtonIndex * 6 + index], 1, 1, 0, 0, 1);
	}

	protected int checkTouchArea(float x, float y) {

		for (int i = 0; i < 6; i++) {
			if (stringStartX[i] <= x && (x <= (stringStartX[i] + stringWidth)) && stringStartY[i] <= y && (y <= stringStartY[i] + stringHeight)) {
				return i;
			}
		}
		
		return -1;
	}
	
	protected int checkTouchAreaInChordButton(float x, float y) {
		
		for(int i = 0; i < 8; i++){
			if (buttonStartX[i] <= x && (x <= (buttonStartX[i] + buttonWidth)) && buttonStartY[i] <= y && (y <= buttonStartY[i] + buttonHeight)) {
				return i;
			}
		}
		
		return -1;
	}
	

	// 레이아웃 width, height 얻어오기 위함
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
//		int [][][] coordinates = new int[6][2][2];
		int [] coordinate = new int[2];
		
		stringWidth = mStringLinear[0].getWidth();
		stringHeight = mStringLinear[0].getHeight();
		
		for (int i = 0; i < 6; i++) {
			mStringLinear[i].getLocationOnScreen(coordinate);

			stringStartX[i] = coordinate[0];
			stringStartY[i] = coordinate[1];
		}
		
		buttonWidth = button[0].getWidth();
		buttonHeight = button[0].getHeight();
		
		for(int i = 0; i < 8; i++){
			button[i].getLocationOnScreen(coordinate);
			
			buttonStartX[i] = coordinate[0];
			buttonStartY[i] = coordinate[1];
		}

		super.onWindowFocusChanged(hasFocus);
	}
	
//	void changeInstrument(int type){
//		instrument_type = type;
//		
//		if(instrument_type == INSTRUMENT_TYPE_ACOUTSTIC){
//			soundResourceTable = SoundResourceTable.ACOUSTIC_RESOURCE_TABLE;
//			
//			mStringImage[0].setImageResource(R.drawable.acoustic_6);
//			mStringImage[1].setImageResource(R.drawable.acoustic_5);
//			mStringImage[2].setImageResource(R.drawable.acoustic_4);
//			mStringImage[3].setImageResource(R.drawable.acoustic_3);
//			mStringImage[4].setImageResource(R.drawable.acoustic_2);
//			mStringImage[5].setImageResource(R.drawable.acoustic_1);
//			
////			rawResIds[0] = soundPool.load(context, R.raw.acoustic_6_0, 1);
////			rawResIds[1] = soundPool.load(context, R.raw.acoustic_5_0, 1);
////			rawResIds[2] = soundPool.load(context, R.raw.acoustic_4_0, 1);
////			rawResIds[3] = soundPool.load(context, R.raw.acoustic_3_0, 1);
////			rawResIds[4] = soundPool.load(context, R.raw.acoustic_2_0, 1);
////			rawResIds[5] = soundPool.load(context, R.raw.acoustic_1_0, 1);
//		}
//		else if(instrument_type == INSTRUMENT_TYPE_ELECTRIC){
//			soundResourceTable = SoundResourceTable.STRAT_RESOURCE_TABLE;
//			
//			mStringImage[0].setImageResource(R.drawable.elec_6);
//			mStringImage[1].setImageResource(R.drawable.elec_5);
//			mStringImage[2].setImageResource(R.drawable.elec_4);
//			mStringImage[3].setImageResource(R.drawable.elec_3);
//			mStringImage[4].setImageResource(R.drawable.elec_2);
//			mStringImage[5].setImageResource(R.drawable.elec_1);
//			
////			rawResIds[0] = soundPool.load(context, R.raw.strat_6_0, 1);
////			rawResIds[1] = soundPool.load(context, R.raw.strat_5_0, 1);
////			rawResIds[2] = soundPool.load(context, R.raw.strat_4_0, 1);
////			rawResIds[3] = soundPool.load(context, R.raw.strat_3_0, 1);
////			rawResIds[4] = soundPool.load(context, R.raw.strat_2_0, 1);
////			rawResIds[5] = soundPool.load(context, R.raw.strat_1_0, 1);
//			
//		}
//	}
	
	void writePreference(){
		SharedPreferences pref = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
		SharedPreferences.Editor edit = pref.edit();

		edit.putString("Chord1", chordLibrary[0]);
		edit.putString("Chord2", chordLibrary[1]);
		edit.putString("Chord3", chordLibrary[2]);
		edit.putString("Chord4", chordLibrary[3]);
		edit.putString("Chord5", chordLibrary[4]);
		edit.putString("Chord6", chordLibrary[5]);
		edit.putString("Chord7", chordLibrary[6]);
		edit.putString("Chord8", chordLibrary[7]);

		edit.commit();
	}
	
	void readPreference(){
		SharedPreferences pref = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
		chordLibrary[0] = pref.getString("Chord1", "CMajor");
		chordLibrary[1] = pref.getString("Chord2", "D7");
		chordLibrary[2] = pref.getString("Chord3", "Bm");
		chordLibrary[3] = pref.getString("Chord4", "Em");
		chordLibrary[4] = pref.getString("Chord5", "Em");
		chordLibrary[5] = pref.getString("Chord6", "Am");
		chordLibrary[6] = pref.getString("Chord7", "DMajor");
		chordLibrary[7] = pref.getString("Chord8", "GMajor");
	}
	
}
