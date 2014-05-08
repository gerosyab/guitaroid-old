package net.gerosyab.Guitaroid.activity;

import net.gerosyab.Guitaroid.R;
import net.gerosyab.Guitaroid.data.SongData;
import net.gerosyab.Guitaroid.data.Song;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class SongPlayActivity extends Activity{
	private final boolean isDebug = false;
	
	private final String DEBUG_TAG = "SongPlay";
	public static final String EXTRA_SONG_INDEX = "SONG_INDEX";
	private final int PROGRESSBAR_MAXIMUM = 100;
	private final int SOUNDPOOL_SWITCH_THRESHOLD = 50;
	
	private final int CURRENT_STRING_COLOR = Color.argb(230, 220, 15, 25);
	private final int NEXT_STRING_COLOR = Color.argb(40, 220, 15, 25);
	private final int EMPTY_STRING_COLOR = Color.argb(0, 0, 0, 0);
	
	protected static final int INVALID_POINTER_ID = -1;
	protected static final int STRING6 = 0;
	protected static final int STRING5 = 1;
	protected static final int STRING4 = 2;
	protected static final int STRING3 = 3;
	protected static final int STRING2 = 4;
	protected static final int STRING1 = 5;
	
	protected LinearLayout mStringColorLinear[] = {null, null, null, null, null, null};
	protected LinearLayout mStringLinear[] = {null, null, null, null, null, null};
	protected ImageView[] mStringImage = { null, null, null, null, null, null };
	
	protected int[] stringWidth = { 0, 0, 0, 0, 0, 0 };
	protected int[] stringHeight = { 0, 0, 0, 0, 0, 0 };
	protected int[] stringStartX = { 0, 0, 0, 0, 0, 0 };
	protected int[] stringStartY = { 0, 0, 0, 0, 0, 0 };

	protected float mPosX, mPosY, mLastTouchX, mLastTouchY;
	protected int mActivePointerId;

	protected boolean[] isStringTouched = { false, false, false, false, false, false };
	protected boolean[] isPlayed = { false, false, false, false, false, false };
	protected boolean[] isProcessed = { false, false, false, false, false, false };

	protected Context context;
	protected SoundPool soundPool;
	protected SoundPool[] soundPoolArray = {null, null};
	protected static int[] rawResIds = { 0, 0, 0, 0, 0, 0 };
	protected static int curString;

	protected SharedPreferences pref;
	protected int[][] soundResourceTable;
	protected int instrument_type;

	protected boolean [] isMute = { false, false, false, false, false, false };
	
	TextView titleText, lyricText, progressText;
	TextView mFretNum[] = {null, null, null, null, null, null};
	
	Button playBtn, backwardBtn, forwardBtn;
	LinearLayout btnMotherLinear;
	int songProgress;
	int lyricProgress;
	int progressPercentage;
	
	boolean isTouchComplete = false;
	boolean isPlay = false;
	boolean isEnd = false;
	
	
	Song song;
	SoundPool tempSoundPool;
	
	private int curSoundPoolIndex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//각각 레이아웃 적용하기 위해 onCreate 만 super.onCreate() 하지말고 다해주자고
		soundResourceTable = SoundResourceTable.ACOUSTIC_RESOURCE_TABLE;

		this.context = getApplicationContext();
		
		Intent i = getIntent();
		int songIndex = i.getIntExtra(EXTRA_SONG_INDEX, 0);

		song = SongData.loadSong(songIndex);
		
		if(song.bLyric){
			setContentView(R.layout.song_play_with_lyric);
			lyricText = (TextView)findViewById(R.id.song_play_lyric_text);
			lyricText.setText("");
			lyricProgress = 0;
		}
		else{
			setContentView(R.layout.song_play_without_lyric);
		}
		
		playBtn = (Button)findViewById(R.id.song_play_button_play);
		backwardBtn = (Button)findViewById(R.id.song_play_button_backward);
		forwardBtn = (Button)findViewById(R.id.song_play_button_forward);
		btnMotherLinear = (LinearLayout)findViewById(R.id.song_play_backward_forward_progress_linear);
		
		titleText = (TextView)findViewById(R.id.song_play_artist_title_text);
		titleText.setText(song.title);
		
		progressText = (TextView)findViewById(R.id.song_play_progress_text);
		progressText.setText("0%");
		
		songProgress = 0;
		progressPercentage = 0;
		
		mStringLinear[0] = (LinearLayout)findViewById(R.id.song_play_6th_string_linear);
		mStringLinear[1] = (LinearLayout)findViewById(R.id.song_play_5th_string_linear);
		mStringLinear[2] = (LinearLayout)findViewById(R.id.song_play_4th_string_linear);
		mStringLinear[3] = (LinearLayout)findViewById(R.id.song_play_3rd_string_linear);
		mStringLinear[4] = (LinearLayout)findViewById(R.id.song_play_2nd_string_linear);
		mStringLinear[5] = (LinearLayout)findViewById(R.id.song_play_1st_string_linear);

		mStringColorLinear[0] = (LinearLayout)findViewById(R.id.song_play_6th_color_change_area);
		mStringColorLinear[1] = (LinearLayout)findViewById(R.id.song_play_5th_color_change_area);
		mStringColorLinear[2] = (LinearLayout)findViewById(R.id.song_play_4th_color_change_area);
		mStringColorLinear[3] = (LinearLayout)findViewById(R.id.song_play_3rd_color_change_area);
		mStringColorLinear[4] = (LinearLayout)findViewById(R.id.song_play_2nd_color_change_area);
		mStringColorLinear[5] = (LinearLayout)findViewById(R.id.song_play_1st_color_change_area);
		
		mFretNum[0] = (TextView)findViewById(R.id.song_play_6th_string_fret_num);
		mFretNum[1] = (TextView)findViewById(R.id.song_play_5th_string_fret_num);
		mFretNum[2] = (TextView)findViewById(R.id.song_play_4th_string_fret_num);
		mFretNum[3] = (TextView)findViewById(R.id.song_play_3rd_string_fret_num);
		mFretNum[4] = (TextView)findViewById(R.id.song_play_2nd_string_fret_num);
		mFretNum[5] = (TextView)findViewById(R.id.song_play_1st_string_fret_num);
		
		mStringImage[0] = (ImageView)findViewById(R.id.song_play_6th_string_img);
		mStringImage[1] = (ImageView)findViewById(R.id.song_play_5th_string_img);
		mStringImage[2] = (ImageView)findViewById(R.id.song_play_4th_string_img);
		mStringImage[3] = (ImageView)findViewById(R.id.song_play_3rd_string_img);
		mStringImage[4] = (ImageView)findViewById(R.id.song_play_2nd_string_img);
		mStringImage[5] = (ImageView)findViewById(R.id.song_play_1st_string_img);
		
		mStringImage[0].setImageResource(R.drawable.acoustic_6);
		mStringImage[1].setImageResource(R.drawable.acoustic_5);
		mStringImage[2].setImageResource(R.drawable.acoustic_4);
		mStringImage[3].setImageResource(R.drawable.acoustic_3);
		mStringImage[4].setImageResource(R.drawable.acoustic_2);
		mStringImage[5].setImageResource(R.drawable.acoustic_1);
		
		playBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!isPlay){
					isPlay = true;
					
					playBtn.setVisibility(View.INVISIBLE);
					btnMotherLinear.setVisibility(View.VISIBLE);
					progressText.setVisibility(View.VISIBLE);
					backwardBtn.setVisibility(View.VISIBLE);
					forwardBtn.setVisibility(View.VISIBLE);
					stepForward();
				}
			}
		});
		
		backwardBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(isPlay){
					stepBackward();
				}
			}
		});
		
		forwardBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(isPlay){
					stepForward();
				}
			}
		});
		
	}
	
	private void stepBackward(){
		if(songProgress >= 2){
			if(isEnd){
				isEnd = false;
			}
			if(!isPlay){
				isPlay = true;
			}
			
			if(song.bLyric){
				if(lyricProgress < song.lyricLength){
					if(lyricProgress == song.lyricLength + 1){
						lyricProgress--;
					}
					
					else if(song.lyricIndex[lyricProgress] >= songProgress){
						lyricProgress--;
					}
				}
				
			}
			
			songProgress -= 2;
			stepForward();
		}
		
	}

	private void stepForward(){
		if(songProgress == 0){
			backwardBtn.setClickable(false);
		}
		else{
			backwardBtn.setClickable(true);
		}
		
		if(songProgress >= song.songLength){
			forwardBtn.setClickable(false);
			Toast.makeText(context, "Song Play Done!!", Toast.LENGTH_SHORT).show();
			progressText.setText(100 + "%");
			if(song.bLyric){
				lyricText.setText("Well Done!!");
			}
			isEnd = true;
			isPlay = false;
			for(int i = 0; i < 6; i++){
				mStringLinear[i].setBackgroundColor(EMPTY_STRING_COLOR);
				mStringColorLinear[i].setBackgroundColor(EMPTY_STRING_COLOR);
			}
			return;
		}
		else{
			forwardBtn.setClickable(true);
		}
		
		if(song.bLyric){
			if(lyricProgress < song.lyricLength){
				if(song.lyricIndex[lyricProgress] <= songProgress){
					lyricText.setText(song.lyric[lyricProgress]);
					lyricProgress++;
				}
			}
		}
		
		if(songProgress % SOUNDPOOL_SWITCH_THRESHOLD == 0){
			rawResIds[0] = rawResIds[1] = rawResIds[2] = rawResIds[3] = rawResIds[4] = rawResIds[5] = 0;
			
			if(curSoundPoolIndex == 0){
				soundPool = soundPoolArray[1];
				curSoundPoolIndex = 1;
			}
			else if(curSoundPoolIndex == 1){
				soundPool = soundPoolArray[0];
				curSoundPoolIndex = 0;
			}
		}
		
		if(songProgress % SOUNDPOOL_SWITCH_THRESHOLD == 10){
			if(curSoundPoolIndex == 0){
				soundPoolArray[1].release();
				soundPoolArray[1] = null;
				soundPoolArray[1] = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
			}
			else if(curSoundPoolIndex == 1){
				soundPoolArray[0].release();
				soundPoolArray[0] = null;
				soundPoolArray[0] = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
			}
		}
		
		for(int i = 0; i < 6; i++){
			if(song.position[songProgress][i] == - 1){
				mStringColorLinear[i].setBackgroundColor(EMPTY_STRING_COLOR);
				if(songProgress + 1 != song.songLength){
					if(song.position[songProgress + 1][i] != -1){
						mStringLinear[i].setBackgroundColor(NEXT_STRING_COLOR);
					}
					else{
						mStringLinear[i].setBackgroundColor(EMPTY_STRING_COLOR);
					}
				}
				else{
					mStringLinear[i].setBackgroundColor(EMPTY_STRING_COLOR);
				}
				mFretNum[i].setText("X");
				isMute[i] = true;
				isProcessed[i] = true;
			}
			else{
				soundPool.unload(rawResIds[i]);	
				rawResIds[i] = soundPool.load(context, soundResourceTable[i][song.position[songProgress][i]], 1);
				if(songProgress + 1 != song.songLength){
					if(song.position[songProgress + 1][i] != -1){
						mStringLinear[i].setBackgroundColor(NEXT_STRING_COLOR);
					}
					else{
						mStringLinear[i].setBackgroundColor(EMPTY_STRING_COLOR);
					}
				}
				else{
					mStringLinear[i].setBackgroundColor(EMPTY_STRING_COLOR);
				}
				mStringColorLinear[i].setBackgroundColor(CURRENT_STRING_COLOR);
				mFretNum[i].setText(Integer.toString(song.position[songProgress][i]));
	
				isMute[i] = false;
				isPlayed[i] = false;
				isProcessed[i] = false;
			}
		}
		
		progressPercentage = (int)((double)songProgress / (double)song.songLength * 100);
		progressText.setText(progressPercentage + "%");
		
		songProgress++;
		
		if(isDebug){
			Log.d(DEBUG_TAG, "songProgress : " + songProgress);
		}
	}
	
	private boolean checkString(int index){
		if(!isMute[index] && !isPlayed[index]){
			isMute[index] = isPlayed[index] = isProcessed[index] = true;
			soundPool.play(rawResIds[index], 1, 1, 0, 0, 1);
			mStringColorLinear[index].setBackgroundColor(Color.argb(0, 0, 0, 0));
			
			int processedNum = 0;
			
			for(int i = 0; i < 6; i++){
				if(isProcessed[i]){
					processedNum++;
				}
			}
			
			if(processedNum == 6){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(isPlay){
			
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
	//					playString(index);
						if(checkString(index)){
							if(!isEnd){
								stepForward();
							}
						}
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
	//						playString(index);
							if(checkString(index)){
								if(!isEnd){
									stepForward();
								}
							}
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
	//					playString(index);
						if(checkString(index)){
							if(!isEnd){
								stepForward();
							}
						}
					}
					break;
				}
			}
		}

		return true;
	}

	protected int checkTouchArea(float x, float y) {

		for (int i = 0; i < 6; i++) {
			if (stringStartX[i] <= x && (x <= (stringStartX[i] + stringWidth[i])) && stringStartY[i] <= y && (y <= stringStartY[i] + stringHeight[i])) {
				return i;
			}
		}
		return -1;
	}

	// 레이아웃 width, height 얻어오기 위함
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		int [][][] coordinates = new int[6][2][2];
		int [] coordinate = new int[2];
		for (int i = 0; i < 6; i++) {
			mStringLinear[i].getLocationOnScreen(coordinate);
			stringWidth[i] = mStringLinear[i].getWidth();
			stringHeight[i] = mStringLinear[i].getHeight();
			stringStartX[i] = coordinate[0];
			stringStartY[i] = coordinate[1];
			mStringLinear[i].getLocationInWindow(coordinates[i][0]);
			mStringLinear[i].getLocationOnScreen(coordinates[i][1]);
		}

		super.onWindowFocusChanged(hasFocus);
	}

	@Override
	protected void onPause() {
		if (soundPoolArray[0] != null) {
			soundPoolArray[0].release();
			soundPoolArray[0] = null;
		}
		if (soundPoolArray[1] != null) {
			soundPoolArray[1].release();
			soundPoolArray[1] = null;
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		if (soundPoolArray[0] == null) {
			soundPoolArray[0] = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
		}
		if (soundPoolArray[1] == null) {
			soundPoolArray[1] = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
		}

		if(isPlay){
			rawResIds[0] = rawResIds[1] = rawResIds[2] = rawResIds[3] = rawResIds[4] = rawResIds[5] = 0;
			
			soundPool = soundPoolArray[curSoundPoolIndex];
			
			for(int i = 0; i < 6; i++){
				if(songProgress > 0){
					if(song.position[songProgress - 1][i] != - 1){
						rawResIds[i] = soundPool.load(context, soundResourceTable[i][song.position[songProgress - 1][i]], 1);
					}
				}
				
			}
		}
		
		super.onResume();
	}
}
